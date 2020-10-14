package com.zhang.interview.code.design.behavioral.state.s1;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: State
 * @Author: zxb
 * @Date: 2020/10/14 14:06
 * @Description: 状态模式-接口
 */
public interface State {

  /**
   * doAction
   *
   * @param context 上下文
   */
  void doAction(Context context);

}
