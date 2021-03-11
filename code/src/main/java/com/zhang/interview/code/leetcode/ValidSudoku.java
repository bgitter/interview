package com.zhang.interview.code.leetcode;

import java.util.HashMap;

/**
 * @Copyright (C), 2018-2021, 北京数知科技股份有限公司
 * @FileName: ValidSudoku
 * @Author: zxb
 * @Date: 2021/3/11 10:33
 * @Description: 有效的数独
 * <p>
 * leetcode：https://leetcode-cn.com/problems/valid-sudoku/
 */
public class ValidSudoku {

  static final char[][] SUDOKU = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
  };

  public static void main(String[] args) {
    boolean flag = isValidSudoku(SUDOKU);
    System.out.println("数独是否有效：" + flag);
  }

  /**
   * 时间复杂度：O(1)，因为我们只对 81 个单元格进行了一次迭代。
   * 空间复杂度：O(1)。
   *
   * @param board
   * @return
   */
  public static boolean isValidSudoku(char[][] board) {
    // init data
    HashMap<Integer, Integer>[] rows = new HashMap[9];
    HashMap<Integer, Integer>[] columns = new HashMap[9];
    HashMap<Integer, Integer>[] boxes = new HashMap[9];
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashMap<>();
      columns[i] = new HashMap<>();
      boxes[i] = new HashMap<>();
    }

    // validate a board
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char c = board[i][j];
        if (c != '.') {
          int n = (int) c;
          int box_idx = (i / 3) * 3 + j / 3;

          // keep the current cell value
          rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
          columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
          boxes[box_idx].put(n, boxes[box_idx].getOrDefault(n, 0) + 1);

          // check if this value has been already seen before
          if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_idx].get(n) > 1) {
            return false;
          }
        }
      }
    }
    return true;
  }

}
