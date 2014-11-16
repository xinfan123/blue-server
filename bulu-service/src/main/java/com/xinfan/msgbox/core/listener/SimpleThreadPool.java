package com.xinfan.msgbox.core.listener;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleThreadPool implements ThreadPool {

	private int count = -1;

	private int prio = Thread.NORM_PRIORITY;

	private boolean isShutdown = false;
	private boolean handoffPending = false;

	private boolean inheritLoader = false;

	private boolean inheritGroup = true;

	private boolean makeThreadsDaemons = false;

	private ThreadGroup threadGroup;

	private final Object nextRunnableLock = new Object();

	private List<WorkerThread> workers;
	private LinkedList<WorkerThread> availWorkers = new LinkedList<WorkerThread>();
	private LinkedList<WorkerThread> busyWorkers = new LinkedList<WorkerThread>();

	private String threadNamePrefix;

	private final Logger log = LoggerFactory.getLogger(getClass());

	private String instanceName;

	public SimpleThreadPool() {
	}

	public SimpleThreadPool(int threadCount, int threadPriority) {
		setThreadCount(threadCount);
		setThreadPriority(threadPriority);
	}

	public Logger getLog() {
		return log;
	}

	public int getPoolSize() {
		return getThreadCount();
	}

	public void setThreadCount(int count) {
		this.count = count;
	}

	public int getThreadCount() {
		return count;
	}

	public void setThreadPriority(int prio) {
		this.prio = prio;
	}

	public int getThreadPriority() {
		return prio;
	}

	public void setThreadNamePrefix(String prfx) {
		this.threadNamePrefix = prfx;
	}

	public String getThreadNamePrefix() {
		return threadNamePrefix;
	}

	public boolean isThreadsInheritContextClassLoaderOfInitializingThread() {
		return inheritLoader;
	}

	public void setThreadsInheritContextClassLoaderOfInitializingThread(boolean inheritLoader) {
		this.inheritLoader = inheritLoader;
	}

	public boolean isThreadsInheritGroupOfInitializingThread() {
		return inheritGroup;
	}

	public void setThreadsInheritGroupOfInitializingThread(boolean inheritGroup) {
		this.inheritGroup = inheritGroup;
	}

	public boolean isMakeThreadsDaemons() {
		return makeThreadsDaemons;
	}

	public void setMakeThreadsDaemons(boolean makeThreadsDaemons) {
		this.makeThreadsDaemons = makeThreadsDaemons;
	}

	public void setInstanceId(String schedInstId) {
	}

	public void setInstanceName(String schedName) {
		instanceName = schedName;
	}

	public void initialize() {

		if (workers != null && workers.size() > 0) // already initialized...
			return;

		if (count <= 0) {
			throw new RuntimeException("Thread count must be > 0");
		}
		if (prio <= 0 || prio > 9) {
			throw new RuntimeException("Thread priority must be > 0 and <= 9");
		}

		if (isThreadsInheritGroupOfInitializingThread()) {
			threadGroup = Thread.currentThread().getThreadGroup();
		} else {
			threadGroup = Thread.currentThread().getThreadGroup();
			ThreadGroup parent = threadGroup;
			while (!parent.getName().equals("main")) {
				threadGroup = parent;
				parent = threadGroup.getParent();
			}
			threadGroup = new ThreadGroup(parent, instanceName + "-SimpleThreadPool");
			if (isMakeThreadsDaemons()) {
				threadGroup.setDaemon(true);
			}
		}

		if (isThreadsInheritContextClassLoaderOfInitializingThread()) {
			getLog().info("execution threads will use class loader of thread: " + Thread.currentThread().getName());
		}

		// create the worker threads and start them
		Iterator<WorkerThread> workerThreads = createWorkerThreads(count).iterator();
		while (workerThreads.hasNext()) {
			WorkerThread wt = workerThreads.next();
			wt.start();
			availWorkers.add(wt);
		}
	}

	protected List<WorkerThread> createWorkerThreads(int createCount) {
		workers = new LinkedList<WorkerThread>();
		for (int i = 1; i <= createCount; ++i) {
			String threadPrefix = getThreadNamePrefix();
			if (threadPrefix == null) {
				threadPrefix = instanceName + "_Worker";
			}
			WorkerThread wt = new WorkerThread(this, threadGroup, threadPrefix + "-" + i, getThreadPriority(), isMakeThreadsDaemons());
			if (isThreadsInheritContextClassLoaderOfInitializingThread()) {
				wt.setContextClassLoader(Thread.currentThread().getContextClassLoader());
			}
			workers.add(wt);
		}

		return workers;
	}
	
	public void shutdown() {
		shutdown(true);
	}


	public void shutdown(boolean waitForJobsToComplete) {

		synchronized (nextRunnableLock) {
			getLog().debug("Shutting down threadpool...");

			isShutdown = true;

			if (workers == null) // case where the pool wasn't even
									// initialize()ed
				return;

			Iterator<WorkerThread> workerThreads = workers.iterator();
			while (workerThreads.hasNext()) {
				WorkerThread wt = workerThreads.next();
				wt.shutdown();
				availWorkers.remove(wt);
			}


			nextRunnableLock.notifyAll();

			if (waitForJobsToComplete == true) {

				boolean interrupted = false;
				try {
					// wait for hand-off in runInThread to complete...
					while (handoffPending) {
						try {
							nextRunnableLock.wait(100);
						} catch (InterruptedException _) {
							interrupted = true;
						}
					}

					// Wait until all worker threads are shut down
					while (busyWorkers.size() > 0) {
						WorkerThread wt = (WorkerThread) busyWorkers.getFirst();
						try {
							getLog().debug("Waiting for thread " + wt.getName() + " to shut down");

							// note: with waiting infinite time the
							// application may appear to 'hang'.
							nextRunnableLock.wait(2000);
						} catch (InterruptedException _) {
							interrupted = true;
						}
					}

					workerThreads = workers.iterator();
					while (workerThreads.hasNext()) {
						WorkerThread wt = (WorkerThread) workerThreads.next();
						try {
							wt.join();
							workerThreads.remove();
						} catch (InterruptedException _) {
							interrupted = true;
						}
					}
				} finally {
					if (interrupted) {
						Thread.currentThread().interrupt();
					}
				}

				getLog().debug("No executing  remaining, all threads stopped.");
			}
			getLog().debug("Shutdown of threadpool complete.");
		}
	}


	public boolean runInThread(Runnable runnable) {
		if (runnable == null) {
			return false;
		}

		synchronized (nextRunnableLock) {

			handoffPending = true;

			while ((availWorkers.size() < 1) && !isShutdown) {
				try {
					nextRunnableLock.wait(500);
				} catch (InterruptedException ignore) {
				}
			}

			if (!isShutdown) {
				WorkerThread wt = (WorkerThread) availWorkers.removeFirst();
				busyWorkers.add(wt);
				wt.run(runnable);
			} else {

				WorkerThread wt = new WorkerThread(this, threadGroup, "WorkerThread-LastJob", prio, isMakeThreadsDaemons(), runnable);
				busyWorkers.add(wt);
				workers.add(wt);
				wt.start();
			}
			nextRunnableLock.notifyAll();
			handoffPending = false;
		}

		return true;
	}

	public int blockForAvailableThreads() {
		synchronized (nextRunnableLock) {

			while ((availWorkers.size() < 1 || handoffPending) && !isShutdown) {
				try {
					nextRunnableLock.wait(500);
				} catch (InterruptedException ignore) {
				}
			}

			return availWorkers.size();
		}
	}

	protected void makeAvailable(WorkerThread wt) {
		synchronized (nextRunnableLock) {
			if (!isShutdown) {
				availWorkers.add(wt);
			}
			busyWorkers.remove(wt);
			nextRunnableLock.notifyAll();
		}
	}

	protected void clearFromBusyWorkersList(WorkerThread wt) {
		synchronized (nextRunnableLock) {
			busyWorkers.remove(wt);
			nextRunnableLock.notifyAll();
		}
	}


	class WorkerThread extends Thread {

		private final Object lock = new Object();

		private AtomicBoolean run = new AtomicBoolean(true);

		private SimpleThreadPool tp;

		private Runnable runnable = null;

		private boolean runOnce = false;

		WorkerThread(SimpleThreadPool tp, ThreadGroup threadGroup, String name, int prio, boolean isDaemon) {

			this(tp, threadGroup, name, prio, isDaemon, null);
		}


		WorkerThread(SimpleThreadPool tp, ThreadGroup threadGroup, String name, int prio, boolean isDaemon, Runnable runnable) {

			super(threadGroup, name);
			this.tp = tp;
			this.runnable = runnable;
			if (runnable != null)
				runOnce = true;
			setPriority(prio);
			setDaemon(isDaemon);
		}


		void shutdown() {
			run.set(false);
		}

		public void run(Runnable newRunnable) {
			synchronized (lock) {
				if (runnable != null) {
					throw new IllegalStateException("Already running a Runnable!");
				}

				runnable = newRunnable;
				lock.notifyAll();
			}
		}


		@Override
		public void run() {
			boolean ran = false;

			while (run.get()) {
				try {
					synchronized (lock) {
						while (runnable == null && run.get()) {
							lock.wait(500);
						}

						if (runnable != null) {
							ran = true;
							runnable.run();
						}
					}
				} catch (InterruptedException unblock) {
					try {
						getLog().error("Worker thread was interrupt()'ed.", unblock);
					} catch (Exception e) {
					}
				} catch (Throwable exceptionInRunnable) {
					try {
						getLog().error("Error while executing the Runnable: ", exceptionInRunnable);
					} catch (Exception e) {
					}
				} finally {
					synchronized (lock) {
						runnable = null;
					}
					if (getPriority() != tp.getThreadPriority()) {
						setPriority(tp.getThreadPriority());
					}

					if (runOnce) {
						run.set(false);
						clearFromBusyWorkersList(this);
					} else if (ran) {
						ran = false;
						makeAvailable(this);
					}

				}
			}

			try {
				getLog().debug("WorkerThread is shut down.");
			} catch (Exception e) {
			}
		}
	}
}
