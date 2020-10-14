package com.zhang.interview.code.design.behavioral.interpreter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: InterpreterPatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 10:24
 * @Description: 解释器模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/interpreter_pattern.htm
 */
public class InterpreterPatternDemo {

  /**
   * Rule: Robert and John are male
   *
   * @return Expression Object
   */
  public static Expression getMaleExpression() {
    Expression robert = new TerminalExpression("Robert");
    Expression john = new TerminalExpression("John");
    return new OrExpression(robert, john);
  }

  /**
   * Rule: Julie is a married women
   *
   * @return Expression Object
   */
  public static Expression getMarriedWomanExpression() {
    Expression julie = new TerminalExpression("Julie");
    Expression married = new TerminalExpression("Married");
    return new AndExpression(julie, married);
  }

  public static void main(String[] args) {
    Expression isMale = getMaleExpression();
    Expression isMarriedWoman = getMarriedWomanExpression();
    System.out.println("John is male? " + isMale.interpret("John"));
    System.out.println("Julie is a married women? " + isMarriedWoman.interpret("Married Julie"));
  }

}
