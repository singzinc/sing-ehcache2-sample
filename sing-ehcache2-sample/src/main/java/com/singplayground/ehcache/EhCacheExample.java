package com.singplayground.ehcache;

import java.util.concurrent.TimeUnit;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheExample {

	public static void main(String[] args) {

		//1. Create a cache manager

		CacheManager cm = CacheManager.getInstance();
		try {
			//2. Create a cache called "cache1"

			//cm.addCache("cache1");

			//3. Get a cache called "cache1"
			Cache cache = cm.getCache("cache1");
			System.out.println("the size of the cache : " + cache.getSize());
			System.out.println("the off heap store size :" + cache.getOffHeapStoreSize());
			System.out.println("status : " + cache.getStatus().toString());
			//4. Put few elements in cache
			cache.put(new Element("1", "Apple"));
			cache.put(new Element("2", "Google"));
			cache.put(new Element("3", "Yahoo"));

			//5. Get element from cache
			Element ele = cache.get("1");

			//6. Print out the element
			String output = (ele == null ? null : ele.getObjectValue().toString());
			System.out.println(output);

			//7. Is key in cache?
			System.out.println(cache.isKeyInCache("1"));
			System.out.println(cache.isKeyInCache("5"));

			System.out.println("the size of the cache : " + cache.getSize());
			System.out.println("the off heap store size :" + cache.getOffHeapStoreSize());
			System.out.println("status : " + cache.getStatus().toString());
			TimeUnit.MINUTES.sleep(1);
			//8. clear all the cache
			//cm.clearAll();
			//cm.removeAllCaches();
			System.out.println("the size of the cache : " + cache.getSize());
			System.out.println("the off heap store size :" + cache.getOffHeapStoreSize());
			System.out.println("status : " + cache.getStatus().toString());
		} catch (Exception e) {
			System.out.println("-------- exception : " + e);
		} finally {
			//cm.shutdown();
		}

	}

}
