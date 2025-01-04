package com.sany.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 经典题：最长递增子序列
 */
public class _0300 {

    /**
     * 300题，统计最长递增子序列的个数。
     * 经典必须掌握的dp题
     * 以下解法是最简单的容易理解的解法，还有一个二分查找的解法属于是不看答案这辈子想不出来的方法
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 最长递增子序列，二分查找优化版本（死记硬背也要学会）
     * 这是自己根据思想写出来的二分，但是和题解区的二分答案比还是有很大的差距
     */
    public int lengthOfLISOptimize(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (list.get(list.size() - 1) < num) {
                list.add(num);
                continue;
            }
            // 开始二分查找
            int left = 0, right = list.size() - 1;
            while (left < right) {
                int tmp = left + right >> 1;
                if (list.get(tmp) == num) {
                    left = tmp;
                    break;
                }
                if (list.get(tmp) > num) {
                    right = tmp;
                } else {
                    left = tmp + 1;
                }
            }
            list.set(left, num);
        }
        return list.size();
    }

    /**
     * 673题：300的变种，统计最长递增子序列的个数
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length], count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 遇到更长的序列
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                        continue;
                    }
                    if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int num = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                num += count[i];
            }
        }
        return num;
    }

    /**
     * 354：300题的2D版本（放弃，属于是做不出来的题目）
     */
    // 方法一，直接是300题的复刻版本,会报超时
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] arr1, int[] arr2) -> {
            if (arr1[0] != arr2[0]) {
                return arr1[0] - arr2[0];
            }
            return arr1[1] - arr2[1];
        });
        int max = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    /**
     * 优化版本感觉是个脑筋急转弯
     */
    public int maxEnvelopes0(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] arr1, int[] arr2) -> {
            if (arr1[0] != arr2[0]) {
                return arr1[0] - arr2[0];
            }
            return arr2[1] - arr1[1];
        });
        int max = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _0300 object = new _0300();
        int[] env = new int[]{10,9,2,5,3,4};
        object.lengthOfLISOptimize(env);
    }
}
