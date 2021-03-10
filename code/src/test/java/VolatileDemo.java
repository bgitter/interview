/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: VolatileDemo
 * @Author: zxb
 * @Date: 2020/9/27 16:40
 * @Description: 演示Volatile
 */
public class VolatileDemo {

  static volatile int num;

  public static void main(String[] args) {
    int n = (int) Math.ceil(5 / 2);
    System.out.println(n);
    String a = " -19abc";
    for (char c : a.toCharArray()) {
      System.out.println(c + ", is digit: " + (c > 9));
    }
    System.out.println(3295 % 10 / 10);
  }

}
