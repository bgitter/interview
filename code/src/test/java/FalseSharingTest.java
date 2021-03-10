import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @Copyright (C), 2018-2021, 北京数知科技股份有限公司
 * @FileName: FalseSharingTest
 * @Author: zxb
 * @Date: 2021/1/20 11:11
 * @Description: 伪共享
 */
public class FalseSharingTest {

  public static void main(String[] args) throws InterruptedException {
    testPointer(new Pointer());
  }

  private static void testPointer(Pointer pointer) throws InterruptedException {
    StopWatch watch = StopWatch.createStarted();
    Thread t1 = new Thread(() -> {
      for (int i = 0; i < 100000000; i++) {
        pointer.x++;
      }
    });
    Thread t2 = new Thread(() -> {
      for (int i = 0; i < 100000000; i++) {
        pointer.y++;
      }
    });

    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println("耗时：" + watch.getTime(TimeUnit.MILLISECONDS));
    System.out.println(pointer);
  }

  static class Pointer {

    volatile long x;
    long p1, p2, p3, p4, p5, p6, p7;
    volatile long y;
  }
}
