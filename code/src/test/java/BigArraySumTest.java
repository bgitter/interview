import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @Copyright (C), 2018-2021, 北京数知科技股份有限公司
 * @FileName: BigArraySumTest
 * @Author: zxb
 * @Date: 2021/1/19 17:38
 * @Description: 超大数组求和
 */
public class BigArraySumTest {

  public static void main(String[] args) throws Exception {
    int length = 10000000;
    long[] arr = new long[length];
    for (int i = 0; i < length; i++) {
      arr[i] = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
    }
    // 单线程
    singleThreadSum(arr);
    // 线程池
    poolThreadSum(arr);
    // ForkJoinPool
    forkJoinSum(arr);
  }

  private static void singleThreadSum(long[] arr) {
    StopWatch watch = StopWatch.createStarted();
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += (arr[i] / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3);
    }
    System.err.println("sum: " + sum);
    System.err.println("单线程执行耗时：" + watch.getTime(TimeUnit.MILLISECONDS));
  }

  private static void poolThreadSum(long[] arr) throws ExecutionException, InterruptedException {
    StopWatch watch = StopWatch.createStarted();
    int count = 8;
    ExecutorService executorService = Executors.newFixedThreadPool(count);
    List<Future<Long>> list = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      int num = i;
      // 分段提交任务
      Future<Long> future = executorService.submit(() -> {
        long sum = 0;
        for (int j = arr.length / count * num; j < (arr.length / count * (num + 1)); j++) {
          sum += (arr[j] / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3);
        }
        return sum;
      });
      list.add(future);
    }

    // 每个段结果相加
    long sum = 0;
    for (Future<Long> future : list) {
      sum += future.get();
    }
    System.err.println("sum: " + sum);
    System.err.println("线程池执行耗时：" + watch.getTime(TimeUnit.MILLISECONDS));
  }

  private static void forkJoinSum(long[] arr) throws ExecutionException, InterruptedException {
    StopWatch watch = StopWatch.createStarted();
    ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    // 提交任务
    ForkJoinTask<Long> task = forkJoinPool.submit(new SumTask(arr, 0, arr.length));
    // 获取结果
    Long sum = task.get();
    forkJoinPool.shutdown();
    System.err.println("sum: " + sum);
    System.err.println("ForkJoin执行耗时：" + watch.getTime(TimeUnit.MILLISECONDS));
  }

  private static class SumTask extends RecursiveTask<Long> {

    private long[] arr;
    private int from;
    private int to;

    public SumTask(long[] arr, int from, int to) {
      this.arr = arr;
      this.from = from;
      this.to = to;
    }

    @Override
    protected Long compute() {
      // 小于1000的时候直接相加，可灵活调整
      if (to - from <= 1000) {
        long sum = 0;
        for (int i = from; i < to; i++) {
          sum += (arr[i] / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3);
        }
        return sum;
      }
      // 分成两段任务
      int mid = (from + to) / 2;
      SumTask left = new SumTask(arr, from, mid);
      SumTask right = new SumTask(arr, mid, to);

      // 提交左边的任务
      left.fork();
      // 右边的任务直接利用当前线程计算，节约开销
      long rightResult = right.compute();
      // 等待左边计算完毕
      long leftResult = left.join();
      // 返回结果
      return leftResult + rightResult;
    }
  }
}
