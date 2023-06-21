package com.sany.dp;

/**
 * 最长递增子序列
 */
public class _0674 {

    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                length = 1;
                continue;
            }
            length++;
            if (length > max) {
                max = length;
            }
            continue;
        }
        return max;
    }
}
