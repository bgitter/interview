package com.zhang.interview.code.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.TimeUnit;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: GuavaLocalCache
 * @Author: zxb
 * @Date: 2020/9/26 16:03
 * @Description: Guava本地缓存示例
 */
public class GuavaLocalCache {

  static CacheLoader<String, String> loader = new CacheLoader<String, String>() {
    @Override
    public String load(String key) throws Exception {
      Thread.sleep(1000);
      if ("key".equals(key)) {
        return null;
      }
      System.out.println(String.format("%s is loaded from cacheLoader!", key));
      return key + "'s value";
    }
  };

  static RemovalListener<String, String> listener = new RemovalListener<String, String>() {
    @Override
    public void onRemoval(RemovalNotification<String, String> removal) {
      System.out.println("[" + removal.getKey() + ":" + removal.getValue() + "] is evicted!");
    }
  };

  static LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(7)
      .expireAfterWrite(10, TimeUnit.SECONDS)
      .removalListener(listener)
      .recordStats()
      .build(loader);

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      String key = "key" + i;
      String value = "value" + i;
      cache.put(key, value);
      System.out.println("[" + key + ":" + value + "] is put into cache!");
    }
    System.out.println(cache.getIfPresent("key6"));
    System.out.println("缓存统计信息：\n" + cache.stats());
    try {
      System.out.println(cache.get("key15"));
      System.out.println(cache.get("key"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
