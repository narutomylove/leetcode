package com.sany.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 非常好的题目，值得反复做
 */
public class _0368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int[] hist = new int[nums.length];
        hist[0] = 0;

        int maxLen = 1, index = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = 0, last = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && max < dp[j]) {
                    max = dp[j];
                    last = j;
                }
            }
            dp[i] =  max + 1;
            hist[i] = last;
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                index = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            result.add(nums[index]);
            index = hist[index];
        }
        return result;
    }

    public static void main(String[] args) {
        _0368 object = new _0368();
        List<Integer> result = object.largestDivisibleSubset(new int[]{1,2,3,4,5,6,7,8});
        System.out.println(1);
    }
}
