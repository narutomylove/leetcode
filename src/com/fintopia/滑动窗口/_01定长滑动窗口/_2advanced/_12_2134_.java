package com.fintopia.滑动窗口._01定长滑动窗口._2advanced;

/**
 * 交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
 *
 * 环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
 *
 * 给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
 */
public class _12_2134_ {
  // 注意，题目描述是环形数组
  // 环形数组还能这么做
  public int minSwaps(int[] nums) {
    int k = 0;
    for (int num : nums) {
      if (num == 1) {
        k++;
      }
    }
    int sum = 0;
    int max = 0;
    for (int i = 0; i < nums.length + k - 1; i++) {
      int index = i % nums.length;
      if (nums[index] == 1) {
        sum += nums[index];
      }
      if (i < k - 1) {
        continue;
      }
      max = Math.max(max, sum);
      if (nums[i - k + 1] == 1) {
        sum--;
      }
    }
    return k - max;
  }
}
