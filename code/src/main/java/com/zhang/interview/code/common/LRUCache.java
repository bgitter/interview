package com.zhang.interview.code.common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: LRUCache
 * @Author: zxb
 * @Date: 2020/9/21 10:45
 * @Description: 基于LinkedHashMap实现LRU缓存
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

  private static final int MAX_ENTRIES = 3;

  @Override
  protected boolean removeEldestEntry(Map.Entry eldest) {
    return size() > MAX_ENTRIES;
  }

  LRUCache() {
    super(MAX_ENTRIES, 0.75F, true);
  }

  public static void main(String[] args) {
    LRUCache<Integer, String> cache = new LRUCache<>();
    cache.put(1, "a");
    cache.put(2, "b");
    cache.put(3, "c");
    cache.get(1);
    cache.put(4, "d");
    System.out.println(cache.keySet());
  }
}
