package com.xinfan.msgbox.core.listener;

public interface ThreadPool {

	boolean runInThread(Runnable runnable);

	int blockForAvailableThreads();

	void initialize();

	void shutdown(boolean waitForJobsToComplete);

	int getPoolSize();

	void setInstanceId(String schedInstId);

}
