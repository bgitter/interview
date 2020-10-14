package com.zhang.interview.code.design.behavioral.state.s1;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: StatePatternDemo
 * @Author: zxb
 * @Date: 2020/10/14 14:11
 * @Description: 状态模式-入口
 * 示例代码：https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 */
public class StatePatternDemo {

  public static void main(String[] args) {
    Context context = new Context();
    StartState startState = new StartState();
    startState.doAction(context);
    System.out.println(context.getState().toString());

    StopState stopState = new StopState();
    stopState.doAction(context);
    System.out.println(context.getState().toString());
  }

}
