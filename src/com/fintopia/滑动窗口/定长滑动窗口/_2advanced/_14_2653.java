package com.fintopia.滑动窗口.定长滑动窗口._2advanced;

/**
 * 给你一个长度为 n 的整数数组 nums ，请你求出每个长度为 k 的子数组的 美丽值 。
 *
 * 一个子数组的 美丽值 定义为：如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。
 *
 * 请你返回一个包含 n - k + 1 个整数的数组，依次 表示数组中从第一个下标开始，每个长度为 k 的子数组的 美丽值 。
 *
 * 子数组指的是数组中一段连续 非空 的元素序列。
 */
public class _14_2653 {

  //-50 <= nums[i] <= 50 题目给了这么一个关键条件，所以可以使用基数排序
  public int[] getSubarrayBeauty(int[] nums, int k, int x) {
    int[] sortNums = new int[101];
    int[] result = new int[nums.length - k + 1];

    for (int i = 0; i < nums.length; i++) {
      sortNums[nums[i] + 50]++;
      if (i < k - 1) {
        continue;
      }
      //  找到第k小的数
      int index = i - k + 1;
      int sum = 0;
      for (int j = 0; j < 50; j++) {
        if (sortNums[j] == 0) {
          continue;
        }
        sum += sortNums[j];
        if (sum < x) {
          continue;
        }
        result[index] = j - 50;
        break;
      }
      sortNums[nums[index] + 50]--;
    }
    return result;
  }
}
