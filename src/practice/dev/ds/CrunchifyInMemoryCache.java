package practice.dev.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Crunchify.com
 * 
 * 
 *         ==========Test1: crunchifyTestAddRemoveObjects ========== 6 Cache
 *         Object Added.. cache.size(): 6 One object removed.. cache.size(): 5
 *         Two objects Added but reached maxItems.. cache.size(): 6
 * 
 *         ==========Test2: crunchifyTestExpiredCacheObjects ========== Two
 *         objects are added but reached timeToLive. cache.size(): 0
 * 
 *         ==========Test3: crunchifyTestObjectsCleanupTime ========== Cleanup
 *         times for 500000 objects are 0.025 s
 * 
 * 
 */

public class CrunchifyInMemoryCache<K, T> {

	private long timeToLive;
	private LRUMap<K, T> crunchifyCacheMap;

	protected class CrunchifyCacheObject {
		public long lastAccessed = System.currentTimeMillis();
		public T value;

		protected CrunchifyCacheObject(T value) {
			this.value = value;
		}
	}

	public CrunchifyInMemoryCache(long crunchifyTimeToLive,
			final long crunchifyTimerInterval, int maxItems) {
		this.timeToLive = crunchifyTimeToLive * 1000;

		crunchifyCacheMap = new LRUMap<>(maxItems);

		if (timeToLive > 0 && crunchifyTimerInterval > 0) {

			Thread t = new Thread(new Runnable() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(crunchifyTimerInterval * 1000);
						} catch (InterruptedException ex) {
						}
						cleanup();
					}
				}
			});

			t.setDaemon(true);
			t.start();
		}
	}

	public void put(K key, T value) {
		synchronized (crunchifyCacheMap) {
			crunchifyCacheMap.put(key, (T) new CrunchifyCacheObject(value));
		}
	}

	public T get(K key) {
		synchronized (crunchifyCacheMap) {
			CrunchifyCacheObject c = (CrunchifyCacheObject) ((List<K>) crunchifyCacheMap)
					.get((Integer) key);

			if (c == null)
				return null;
			else {
				c.lastAccessed = System.currentTimeMillis();
				return c.value;
			}
		}
	}

	public void remove(K key) {
		synchronized (crunchifyCacheMap) {
			((List<K>) crunchifyCacheMap).remove(key);
		}
	}

	public int size() {
		synchronized (crunchifyCacheMap) {
			return crunchifyCacheMap.size();
		}
	}

	@SuppressWarnings("unchecked")
	public void cleanup() {

		long now = System.currentTimeMillis();
		ArrayList<K> deleteKey = null;

		synchronized (crunchifyCacheMap) {
			MapIterator itr = crunchifyCacheMap.mapIterator();

			deleteKey = new ArrayList<K>((crunchifyCacheMap.size() / 2) + 1);
			K key = null;
			CrunchifyCacheObject c = null;

			while (itr.hasNext()) {
				key = (K) itr.next();
				c = (CrunchifyCacheObject) itr.getValue();

				if (c != null && (now > (timeToLive + c.lastAccessed))) {
					deleteKey.add(key);
				}
			}
		}

		for (K key : deleteKey) {
			synchronized (crunchifyCacheMap) {
				crunchifyCacheMap.remove(key);
			}

			Thread.yield();
		}
	}
}
