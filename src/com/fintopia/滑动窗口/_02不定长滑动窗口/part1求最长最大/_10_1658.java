package com.fintopia.滑动窗口._02不定长滑动窗口.part1求最长最大;

import java.util.Arrays;

/**
 * 结合2134题
 */
public class _10_1658 {

  // 重点：正向思维。前缀 + 后缀
  // 超时了
  public static int minOperations(int[] nums, int x) {
    int min = Integer.MAX_VALUE;
    int rightSum = 0;
    for (int right = -1; right < nums.length; right++) {
      if (right > -1) {
        rightSum += nums[right];
      }
      if (rightSum == x) {
        min = Math.min(min, right + 1);
        break;
      }
      if (rightSum > x) {
        break;
      }
      int leftTarget = x - rightSum;
      int leftSum = 0;
      for (int left = nums.length - 1; left > right; left--) {
        leftSum += nums[left];
        if (leftSum < leftTarget) {
          continue;
        }
        if (leftSum > leftTarget) {
          break;
        }
        if (leftSum == leftTarget) {
          min = Math.min(min, right + nums.length - left + 1);
          break;
        }
      }
    }
    if (min == Integer.MAX_VALUE) {
      return -1;
    }
    return min;
  }

  // 灵神的标准答案
  public int minOperations1(int[] nums, int x) {
    int n = nums.length;
    int sum = 0;
    int right = n;
    while (right > 0 && sum + nums[right - 1] <= x) { // 计算最长后缀
      right--;
      sum += nums[right];
    }
    if (right == 0 && sum < x) {
      return -1; // 全部移除也无法满足要求
    }

    int ans = sum == x ? n - right : n + 1;
    for (int left = 0; left < n; left++) {
      sum += nums[left];
      while (right < n && sum > x) {
        sum -= nums[right];
        right++; // 缩小后缀长度
      }
      if (sum > x) {
        break; // 缩小失败，说明前缀过长
      }
      if (sum == x) {
        ans = Math.min(ans, left + 1 + n - right); // 前缀+后缀长度
      }
    }
    return ans > n ? -1 : ans;
  }

  // 反向思维
  public static int minOperations2(int[] nums, int x) {
    int sum = Arrays.stream(nums).sum();
    int target = sum - x;
    int tempSum = 0;
    int left = 0;
    int max = -1;
    for (int right = 0; right < nums.length; right++) {
      tempSum += nums[right];
      if (tempSum < target) {
        continue;
      }
      if (tempSum == target) {
        max = Math.max(max, right - left + 1);
        continue;
      }
      while (tempSum > target && left <=right) {
        tempSum -= nums[left];
        left++;
        if (tempSum == target) {
          max = Math.max(max, right - left + 1);
        }
      }
    }
    if (max < nums.length && max > -1) {
      return nums.length - max;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {5,2,3,1,1};
    System.out.println(minOperations(nums, 5));
    int sum = 0;
    for (int i = 402; i <= 473; i++) {
      sum += nums[i];
    }
    System.out.println(sum);
  }
}
