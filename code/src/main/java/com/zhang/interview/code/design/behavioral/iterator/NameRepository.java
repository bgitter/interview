package com.zhang.interview.code.design.behavioral.iterator;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: NameRepository
 * @Author: zxb
 * @Date: 2020/10/14 10:57
 * @Description: 迭代器模式-容器实现类
 */
public class NameRepository implements Container {

  public String[] names = {"Robert", "John", "Julie", "Lora"};

  @Override
  public Iterator getIterator() {
    return new NameIterator();
  }

  private class NameIterator implements Iterator {

    int index;

    @Override
    public boolean hasNext() {
      if (index < names.length) {
        return true;
      }
      return false;
    }

    @Override
    public Object next() {
      if (this.hasNext()) {
        return names[index++];
      }
      return null;
    }
  }
}
