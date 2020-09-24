package com.zhang.interview.code.common;

/**
 * @ClassName: SwapNums <br>
 * @Description: 交换两个数字 <br>
 * @Date: 2020/9/24 下午11:20 <br>
 * @Author: zxb <br>
 * @Version: 1.0 <br>
 */
public class SwapNums {

    public static void main(String[] args) {
        int a = 30, b = 50;
        normal(a, b);
        plus(a, b);
        shift(a, b);
    }

    /**
     * 使用中间变量方式交换两个变量
     *
     * @param a a
     * @param b b
     */
    private static void normal(int a, int b) {
        System.out.println(String.format("使用中间变量交换前 a: %d, b: %d", a, b));
        int temp = a;
        a = b;
        b = temp;
        System.out.println(String.format("使用中间变量交换后 a: %d, b: %d", a, b));
    }

    /**
     * 使用加法方式交换两个变量（当两个数值超大时，可能存在溢出）
     *
     * @param a a
     * @param b b
     */
    private static void plus(int a, int b) {
        System.out.println(String.format("使用加法方式交换前 a: %d, b: %d", a, b));
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(String.format("使用加法方式交换后 a: %d, b: %d", a, b));
    }

    /**
     * 使用位移操作交换两个变量 <br>
     * 利用异或运算的性质：一个数和两个相同的数异或，值不变。
     *
     * @param a a
     * @param b b
     */
    private static void shift(int a, int b) {
        System.out.println(String.format("使用异或操作交换前 a: %d, b: %d", a, b));
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(String.format("使用异或操作交换后 a: %d, b: %d", a, b));
    }


}

