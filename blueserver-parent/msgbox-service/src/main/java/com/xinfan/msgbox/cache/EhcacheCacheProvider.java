package com.xinfan.msgbox.cache;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import net.sf.ehcache.constructs.blocking.BlockingCache;
import net.sf.ehcache.constructs.blocking.CacheEntryFactory;
import net.sf.ehcache.constructs.blocking.SelfPopulatingCache;
import net.sf.ehcache.constructs.blocking.UpdatingCacheEntryFactory;
import net.sf.ehcache.constructs.blocking.UpdatingSelfPopulatingCache;
import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.util.Assert;

/**
 * 
 * 本地缓存实现类
 * 
 * @author cyp
 * 
 */
public class EhcacheCacheProvider implements CacheProvider, BeanNameAware, InitializingBean {

	protected final Logger logger = LoggerFactory.getLogger(EhcacheCacheProvider.class);

	private CacheManager cacheManager;

	private String cacheName;

	private int maxElementsInMemory = 10000;

	private int maxElementsOnDisk = 10000000;

	private MemoryStoreEvictionPolicy memoryStoreEvictionPolicy = MemoryStoreEvictionPolicy.LRU;

	private boolean overflowToDisk = true;

	private boolean eternal = false;

	private int timeToLive = 120;

	private int timeToIdle = 120;

	private boolean diskPersistent = false;

	private int diskExpiryThreadIntervalSeconds = 120;

	private int diskSpoolBufferSize = 0;

	private boolean clearOnFlush = true;

	private boolean blocking = false;

	private CacheEntryFactory cacheEntryFactory;

	private BootstrapCacheLoader bootstrapCacheLoader;

	private Set<CacheEventListener> cacheEventListeners;

	private boolean statisticsEnabled = false;

	private boolean sampledStatisticsEnabled = false;

	private boolean disabled = false;

	private String beanName;

	private Ehcache cache;

	/**
	 * Set a CacheManager from which to retrieve a named Cache instance. By
	 * default, <code>CacheManager.getInstance()</code> will be called.
	 * <p>
	 * Note that in particular for persistent caches, it is advisable to
	 * properly handle the shutdown of the CacheManager: Set up a separate
	 * EhCacheManagerFactoryBean and pass a reference to this bean property.
	 * <p>
	 * A separate EhCacheManagerFactoryBean is also necessary for loading
	 * EHCache configuration from a non-default config location.
	 * 
	 * @see EhCacheManagerFactoryBean
	 * @see net.sf.ehcache.CacheManager#getInstance
	 */
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	/**
	 * Set a name for which to retrieve or create a cache instance. Default is
	 * the bean name of this EhCacheFactoryBean.
	 */
	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	/**
	 * Specify the maximum number of cached objects in memory. Default is 10000
	 * elements.
	 */
	public void setMaxElementsInMemory(int maxElementsInMemory) {
		this.maxElementsInMemory = maxElementsInMemory;
	}

	/**
	 * Specify the maximum number of cached objects on disk. Default is 10000000
	 * elements.
	 */
	public void setMaxElementsOnDisk(int maxElementsOnDisk) {
		this.maxElementsOnDisk = maxElementsOnDisk;
	}

	/**
	 * Set the memory style eviction policy for this cache.
	 * <p>
	 * Supported values are "LRU", "LFU" and "FIFO", according to the constants
	 * defined in EHCache's MemoryStoreEvictionPolicy class. Default is "LRU".
	 */
	public void setMemoryStoreEvictionPolicy(MemoryStoreEvictionPolicy memoryStoreEvictionPolicy) {
		Assert.notNull(memoryStoreEvictionPolicy, "memoryStoreEvictionPolicy must not be null");
		this.memoryStoreEvictionPolicy = memoryStoreEvictionPolicy;
	}

	/**
	 * Set whether elements can overflow to disk when the in-memory cache has
	 * reached the maximum size limit. Default is "true".
	 */
	public void setOverflowToDisk(boolean overflowToDisk) {
		this.overflowToDisk = overflowToDisk;
	}

	/**
	 * Set whether elements are considered as eternal. If "true", timeouts are
	 * ignored and the element is never expired. Default is "false".
	 */
	public void setEternal(boolean eternal) {
		this.eternal = eternal;
	}

	/**
	 * Set the time in seconds to live for an element before it expires, i.e.
	 * the maximum time between creation time and when an element expires.
	 * <p>
	 * This is only used if the element is not eternal. Default is 120 seconds.
	 */
	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}

	/**
	 * Set the time in seconds to idle for an element before it expires, that
	 * is, the maximum amount of time between accesses before an element
	 * expires.
	 * <p>
	 * This is only used if the element is not eternal. Default is 120 seconds.
	 */
	public void setTimeToIdle(int timeToIdle) {
		this.timeToIdle = timeToIdle;
	}

	/**
	 * Set whether the disk store persists between restarts of the Virtual
	 * Machine. Default is "false".
	 */
	public void setDiskPersistent(boolean diskPersistent) {
		this.diskPersistent = diskPersistent;
	}

	/**
	 * Set the number of seconds between runs of the disk expiry thread. Default
	 * is 120 seconds.
	 */
	public void setDiskExpiryThreadIntervalSeconds(int diskExpiryThreadIntervalSeconds) {
		this.diskExpiryThreadIntervalSeconds = diskExpiryThreadIntervalSeconds;
	}

	/**
	 * Set the amount of memory to allocate the write buffer for puts to the
	 * disk store. Default is 0.
	 */
	public void setDiskSpoolBufferSize(int diskSpoolBufferSize) {
		this.diskSpoolBufferSize = diskSpoolBufferSize;
	}

	/**
	 * Set whether the memory store should be cleared when flush is called on
	 * the cache. Default is "true".
	 */
	public void setClearOnFlush(boolean clearOnFlush) {
		this.clearOnFlush = clearOnFlush;
	}

	/**
	 * Set whether to use a blocking cache that lets read attempts block until
	 * the requested element is created.
	 * <p>
	 * If you intend to build a self-populating blocking cache, consider
	 * specifying a {@link #setCacheEntryFactory CacheEntryFactory}.
	 * 
	 * @see net.sf.ehcache.constructs.blocking.BlockingCache
	 * @see #setCacheEntryFactory
	 */
	public void setBlocking(boolean blocking) {
		this.blocking = blocking;
	}

	/**
	 * Set an EHCache
	 * {@link net.sf.ehcache.constructs.blocking.CacheEntryFactory} to use for a
	 * self-populating cache. If such a factory is specified, the cache will be
	 * decorated with EHCache's
	 * {@link net.sf.ehcache.constructs.blocking.SelfPopulatingCache}.
	 * <p>
	 * The specified factory can be of type
	 * {@link net.sf.ehcache.constructs.blocking.UpdatingCacheEntryFactory},
	 * which will lead to the use of an
	 * {@link net.sf.ehcache.constructs.blocking.UpdatingSelfPopulatingCache}.
	 * <p>
	 * Note: Any such self-populating cache is automatically a blocking cache.
	 * 
	 * @see net.sf.ehcache.constructs.blocking.SelfPopulatingCache
	 * @see net.sf.ehcache.constructs.blocking.UpdatingSelfPopulatingCache
	 * @see net.sf.ehcache.constructs.blocking.UpdatingCacheEntryFactory
	 */
	public void setCacheEntryFactory(CacheEntryFactory cacheEntryFactory) {
		this.cacheEntryFactory = cacheEntryFactory;
	}

	/**
	 * Set an EHCache {@link net.sf.ehcache.bootstrap.BootstrapCacheLoader} for
	 * this cache, if any.
	 */
	public void setBootstrapCacheLoader(BootstrapCacheLoader bootstrapCacheLoader) {
		this.bootstrapCacheLoader = bootstrapCacheLoader;
	}

	/**
	 * Specify EHCache {@link net.sf.ehcache.event.CacheEventListener cache
	 * event listeners} to registered with this cache.
	 */
	public void setCacheEventListeners(Set<CacheEventListener> cacheEventListeners) {
		this.cacheEventListeners = cacheEventListeners;
	}

	/**
	 * Set whether to enable EhCache statistics on this cache.
	 * 
	 * @see net.sf.ehcache.Cache#setStatisticsEnabled
	 */
	public void setStatisticsEnabled(boolean statisticsEnabled) {
		this.statisticsEnabled = statisticsEnabled;
	}

	/**
	 * Set whether to enable EhCache's sampled statistics on this cache.
	 * 
	 * @see net.sf.ehcache.Cache#setSampledStatisticsEnabled
	 */
	public void setSampledStatisticsEnabled(boolean sampledStatisticsEnabled) {
		this.sampledStatisticsEnabled = sampledStatisticsEnabled;
	}

	/**
	 * Set whether this cache should be marked as disabled.
	 * 
	 * @see net.sf.ehcache.Cache#setDisabled
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public void setBeanName(String name) {
		this.beanName = name;
	}

	public void afterPropertiesSet() throws CacheException, IOException {
		// If no CacheManager given, fetch the default.
		if (this.cacheManager == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Using default EHCache CacheManager for cache region '" + this.cacheName + "'");
			}
			this.cacheManager = CacheManager.getInstance();
		}

		// If no cache name given, use bean name as cache name.
		if (this.cacheName == null) {
			this.cacheName = this.beanName;
		}

		// Fetch cache region: If none with the given name exists,
		// create one on the fly.
		Ehcache rawCache;
		if (this.cacheManager.cacheExists(this.cacheName)) {
			if (logger.isDebugEnabled()) {
				logger.debug("Using existing EHCache cache region '" + this.cacheName + "'");
			}
			rawCache = this.cacheManager.getEhcache(this.cacheName);
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("Creating new EHCache cache region '" + this.cacheName + "'");
			}
			rawCache = createCache();
			this.cacheManager.addCache(rawCache);
		}

		if (this.cacheEventListeners != null) {
			for (CacheEventListener listener : this.cacheEventListeners) {
				rawCache.getCacheEventNotificationService().registerListener(listener);
			}
		}
		if (this.statisticsEnabled) {
			rawCache.setStatisticsEnabled(true);
		}
		if (this.sampledStatisticsEnabled) {
			rawCache.setSampledStatisticsEnabled(true);
		}
		if (this.disabled) {
			rawCache.setDisabled(true);
		}

		// Decorate cache if necessary.
		Ehcache decoratedCache = decorateCache(rawCache);
		if (decoratedCache != rawCache) {
			this.cacheManager.replaceCacheWithDecoratedCache(rawCache, decoratedCache);
		}
		this.cache = decoratedCache;

		CacheHolder.getInstance().addCacheProvider(cacheName, this);
	}

	/**
	 * Create a raw Cache object based on the configuration of this FactoryBean.
	 */
	protected Cache createCache() {
		// Only call EHCache 1.6 constructor if actually necessary (for
		// compatibility with EHCache 1.3+)
		return (!this.clearOnFlush) ? new Cache(this.cacheName, this.maxElementsInMemory, this.memoryStoreEvictionPolicy,
				this.overflowToDisk, null, this.eternal, this.timeToLive, this.timeToIdle, this.diskPersistent,
				this.diskExpiryThreadIntervalSeconds, null, this.bootstrapCacheLoader, this.maxElementsOnDisk, this.diskSpoolBufferSize,
				this.clearOnFlush) : new Cache(this.cacheName, this.maxElementsInMemory, this.memoryStoreEvictionPolicy,
				this.overflowToDisk, null, this.eternal, this.timeToLive, this.timeToIdle, this.diskPersistent,
				this.diskExpiryThreadIntervalSeconds, null, this.bootstrapCacheLoader, this.maxElementsOnDisk, this.diskSpoolBufferSize);
	}

	/**
	 * Decorate the given Cache, if necessary.
	 * 
	 * @param cache
	 *            the raw Cache object, based on the configuration of this
	 *            FactoryBean
	 * @return the (potentially decorated) cache object to be registered with
	 *         the CacheManager
	 */
	protected Ehcache decorateCache(Ehcache cache) {
		if (this.cacheEntryFactory != null) {
			if (this.cacheEntryFactory instanceof UpdatingCacheEntryFactory) {
				return new UpdatingSelfPopulatingCache(cache, (UpdatingCacheEntryFactory) this.cacheEntryFactory);
			} else {
				return new SelfPopulatingCache(cache, this.cacheEntryFactory);
			}
		}
		if (this.blocking) {
			return new BlockingCache(cache);
		}
		return cache;
	}

	public CacheProvider getObject() {
		return this;
	}

	public Class<? extends CacheProvider> getObjectType() {
		return CacheProvider.class;
	}

	public Object getAttribute(String root) {
		Element e = cache.get(root);
		return e != null ? e.getObjectValue() : null;
	}

	public void setAttribute(String root, Serializable session, int exp) {
		Element element = new Element(root, session);
		if (exp <= 0) {
			element.setEternal(true);
		} else {
			element.setTimeToLive(exp * 60);
			element.setTimeToIdle(exp * 60);
		}
		cache.put(element);
	}

	public Object getAttribute(String root, String name) {
		Map<String, Serializable> session = (Map<String, Serializable>) getAttribute(root);
		return session != null ? session.get(name) : null;
	}

	public void setAttribute(String root, String name, Serializable value, int exp) {
		Map<String, Serializable> session = (Map<String, Serializable>) getAttribute(root);
		if (session == null) {
			session = new HashMap<String, Serializable>();
		}
		session.put(name, value);

		Element element = new Element(root, session);
		if (exp <= 0) {
			element.setEternal(true);
		} else {
			element.setTimeToLive(exp * 60);
			element.setTimeToIdle(exp * 60);
		}
		cache.put(element);

	}

	public void clear(String root) {
		cache.remove(root);
	}

	public boolean exist(String root) {
		return cache.isKeyInCache(root);
	}

	public Object getTouchAttribute(String root, String name, int exp) {

		HashMap<String, Serializable> session = (HashMap<String, Serializable>) getAttribute(root, name);
		if (session != null) {
			setAttribute(root, name, session, exp);
			return session.get(name);
		}

		return null;
	}

	public Object getTouchAttribute(String root, int exp) {
		Object session = getAttribute(root);
		if (session != null) {
			setAttribute(root, (Serializable) session, exp);
			return session;
		}
		return null;
	}

	public void touch(String root, String name, int exp) {
		getTouchAttribute(root, name, exp);
	}

	public void touch(String root, int exp) {
		getTouchAttribute(root, exp);
	}

}
