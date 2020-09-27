package com.zhang.interview.code.leetcode;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: UniquePaths
 * @Author: zxb
 * @Date: 2020/9/26 20:05
 * @Description: 路径解算法
 * 描述：机器人从起点到终点有多少条不同的路径，只能向右或者向下走，
 * 请问一共同拥有多少种唯一的路径。
 * 注意：格子大小最大为 100*100
 * <p>
 * 解题思路：
 * DFS方式：这个思路比较简单，就类似于图的遍历算法，用递归来解。
 * 递归的基线条件是到达目的地或者是走到了边界。递归的条件是机器人从一个点只能往下走或者往右走，
 * 即x = x + 1或者y = y+1。到达某一格的路径数量等于它的上面和左边的路径数之和。
 * <p>
 * DP方式：
 * 采用动态规划思路需要维护一个二维数组dp[][]， dp[i][j] 表示到当前位置不同的走法的个数，
 * 然后可以得到状态转移方程为: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，
 * 注意在初始化的时候，要把二维数组的两个边全部初始化为1，如下
 */
public class UniquePaths {

  public static void main(String[] args) {
    int m = 100, n = 100;
//    int paths = DFS(1, 1, m, n);
    long paths = DP(m, n);
    System.out.println("可走路径：" + paths);
  }

  /**
   * DFS方式解题
   *
   * @param x x
   * @param y y
   * @param m m
   * @param n n
   * @return 路径
   */
  private static long DFS(int x, int y, int m, int n) {
    if (x > m || y > n) {
      return 0;
    }
    if (x == m && y == n) {
      return 1;
    }
    return DFS(x + 1, y, m, n) + DFS(x, y + 1, m, n);
  }

  /**
   * 动态扩容方式
   *
   * @param m m
   * @param n n
   * @return 路径
   */
  private static long DP(int m, int n) {
    long[][] result = new long[m][n];
    // 每行第一列的解，只有一条路径可走
    for (int x = 0; x < m; x++) {
      result[x][0] = 1;
    }
    // 第一行每列的解，只有一条路径可走
    for (int y = 0; y < n; y++) {
      result[0][y] = 1;
    }
    // 其他坐标点（格子）的解
    for (int x = 1; x < m; x++) {
      for (int y = 1; y < n; y++) {
        result[x][y] = result[x - 1][y] + result[x][y - 1];
      }
    }

    return result[m - 1][n - 1];
  }
}
