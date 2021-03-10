import com.zhang.interview.code.utils.DateTimeUtils;
import org.junit.jupiter.api.Test;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: DateTimeTest
 * @Author: zxb
 * @Date: 2020/11/11 10:07
 * @Description: 测试时间
 */
public class DateTimeTest {

  @Test
  public void testDiffHours() {
    String dateTime2 = "2020-11-11 16:00:00";
    String dateTime1 = "2020-04-17 19:21:31";
    long hours = DateTimeUtils.diffHours(dateTime1, dateTime2);
    System.out.println("相差[" + hours + "]小时");
  }

}
