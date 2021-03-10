package com.zhang.interview.code.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: DateTimeUtils
 * @Author: zxb
 * @Date: 2020/11/11 9:45
 * @Description: 日期时间工具类
 */
public class DateTimeUtils {

  public static final String DEFAULT = "yyyy-MM-dd HH:mm:ss";

  /**
   * 字符串日期格式转换为LocalDateTime对象
   *
   * @param dateTime 字符串日期格式
   * @return LocalDateTime
   */
  public static LocalDateTime parse(String dateTime) {
    return parse(dateTime, DEFAULT);
  }

  /**
   * 字符串日期格式转换为LocalDateTime对象
   *
   * @param dateTime 字符串日期格式
   * @param pattern  日期格式
   * @return LocalDateTime
   */
  public static LocalDateTime parse(String dateTime, String pattern) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return LocalDateTime.parse(dateTime, formatter);
  }

  /**
   * 计算两个字符串格式日期相差小时数
   * 字符串格式：yyyy-MM-dd HH:mm:ss
   *
   * @param dateTime1 字符串格式日期
   * @param dateTime2 字符串格式日期
   * @return 相差小时数
   */
  public static long diffHours(String dateTime1, String dateTime2) {
    return diffHours(parse(dateTime1), parse(dateTime2));
  }

  /**
   * 计算两个日期相差小时数
   *
   * @param date1 日期
   * @param date2 日期
   * @return 相差小时数
   */
  public static long diffHours(LocalDateTime date1, LocalDateTime date2) {
    return Duration.between(date1, date2).toHours();
  }
}
