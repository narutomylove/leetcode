package com.sany.回溯.子集划分问题;

import java.util.*;

/**
 * leetcode.698/473
 * 子集划分问题
 * 回溯二阶段学习过程：
 * 写了十几题回溯题了，自以为完全掌握了回溯算法，遇到了698题发现完全不会。回溯的递归路径画不出来。
 * 这一题狠狠学习
 *
 * leetcode自动在698题下面推荐的416提，分割两个等和子集问题，虽然也可以用这个算法框架来写，但是“动态规划”是更简单的方式
 */
public class _0698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        if (total % k != 0) {
            return Boolean.FALSE;
        }
        int target = total / k;
        //Arrays.sort(nums, Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        return Boolean.TRUE;
    }

    private void backTrack(int k, int target) {}

    /**
     * leetcode.473 火柴盒组成正方形问题，本质是 leetcode.698的简化题。一模一样
     */
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return Boolean.FALSE;
        }
        int total = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            total += matchsticks[i];
        }
        if (total % 4 > 0) {
            return Boolean.FALSE;
        }
        int target = total >> 2;
        // 排序一下（逆序）
        for (int i = 0; i < matchsticks.length - 1; i++) {
            for (int j = i + 1; j < matchsticks.length; j++) {
                if (matchsticks[i] < matchsticks[j]) {
                    int tmp = matchsticks[i];
                    matchsticks[i] = matchsticks[j];
                    matchsticks[j] = tmp;
                }
            }
        }
        return backTrack2(matchsticks, 0, new int[4], target);
    }

    private boolean backTrack2(int[] matchsticks, int index, int[] bucket, int target) {
        if (index == matchsticks.length) {
            return Boolean.TRUE;
        }
        for (int i = 0; i < 4; i++) {
            if (i > 0 && bucket[i] == bucket[i - 1]) {
                continue;
            }
            if (bucket[i] + matchsticks[index] > target) {
                continue;
            }
            bucket[i] += matchsticks[index];
            if (backTrack2(matchsticks, index + 1, bucket, target)) {
                return Boolean.TRUE;
            }
            bucket[i] -= matchsticks[index];
        }
        return Boolean.FALSE;
    }
}
