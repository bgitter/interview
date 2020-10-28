package com.zhang.interview.code.leetcode;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @Copyright (C), 2018-2020, 北京数知科技股份有限公司
 * @FileName: ThreeSum
 * @Author: zxb
 * @Date: 2020/9/25 18:02
 * @Description: 三数之和 <br>
 * <p>
 * 题目描述：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 *a，b，c ，*，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * </p>
 * 注意：答案中不可包含重复的三元组。
 *
 * <p>
 * 解题思路：
 * 首先是求解：因为要求3个数，如果我们固定其中1个数，再用求“和为某值的2个数的组合”的解法，就能把
 * 剩下的2个数求出来。因此，先对数组进行排序（升序），这样整个数组的数就由小到大排列。i的取值由0
 * 至n-1，对每一个i，我们求当num[i]是解当中的其中一个数时，其他的2个数。设有指针p指向数组头（实际
 * 只要p从i+1开始），q指向数组尾，sum = num[i] + num[p] + num[q]，因为num[i]是一定在解中的，所以
 * 如果 sum < 0，因为num[q]已经不能再增大了，所以说明num[p]太小了，这时p需要向后移动，找一个更大
 * 的数。同理，sum > 0，说明num[q]太大了，需要q向前移动。当sum == 0时，说明找到了一个解。但找到
 * 了一个解，并不是说明解中有num[i]的所有解都找到了，因此 p或q还需要继续移动寻找其他的解，直到
 * p == q 为止。
 * 去重思路：
 * 去重就在于和之前的解进行比较，但我们不需要比较所有的解，这里有一个技巧。
 * 1.如果 num[i] = num[i - 1]，说明刚才 i-1 时求的解在这次肯定也会求出一样的，所以直接跳过不求；
 * 2.其实指针p不需要从数组头开始，因为如果num[i]所在的解中如果有i之前的数，设其位置为j，那么我们
 * 求num[j]时，肯定把num[i]也找出来放到和num[i]一起的解里了，所以指针p其实应该从j+1开始，即初始时
 * p = i + 1, q = num.length - 1;
 * 3.当sum==0，我们保存了当前解以后，需要num[i]在解中的其他2个数组合，这个时候，肯定是p往后或者q往
 * 前，如果++p，发现其实 num[p] == num[p-1],说明这个解肯定和刚才重复了，再继续++p。同理，如果--q后
 * 发现num[q] == num[q+1]，继续 --q。
 * 这个去重操作主要针对这种有多个同值的数组，如：-3,1,1,1,2,2,3,4.
 * </p>
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(N)
 */
public class ThreeSum {

  public static void main(String[] args) {
    StopWatch watch = StopWatch.createStarted();
    int[] nums = {-1, 0, 1, -1, 2, -4};
    List<List<Integer>> list = new ThreeSum().threeSum(nums);
    System.out.println(JSONObject.toJSONString(list));
    System.out.println(String.format("耗时：%dms", watch.getTime(TimeUnit.MILLISECONDS)));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    // 排序
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      // 数组已排序，因此该值为三个数内最小值，大于0时，跳出
      if (nums[i] > 0) {
        break;
      }
      // 当前值与前一个值相同时，跳过
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int sum = 0;
      int p = i + 1, q = n - 1;
      while (p < q) {
        sum = nums[i] + nums[p] + nums[q];
        if (sum == 0) {
          // 求出一个解
          List<Integer> item = new ArrayList<>();
          item.add(nums[i]);
          item.add(nums[p]);
          item.add(nums[q]);
          list.add(item);
          // 执行p+1后判断新的p与前一个p是否对应相同的值，若是，则跳过
          while (++p < q && nums[p - 1] == nums[p]) {
          }
          // 执行q-1后判断新的q与后一个p是否对应相同的值，若是，则跳过
          while (--q > p && nums[q + 1] == nums[q]) {
          }
        } else if (sum > 0) {
          // q 太大了， q--
          q--;
        } else {
          // p 太小了，p++
          p++;
        }
      }
    }
    return list;
  }
}
