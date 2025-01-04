package com.sany.dp;

public class 抬手就能做的dp题 {

    /**
     * 53 最大子数组和
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (last < 0) {
                last = nums[i];
            } else {
                last += nums[i];
            }
            max = Math.max(max, last);
        }
        return max;
    }

    /**
     * 70题 和费波齐拉一模一样
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int prePre = 1;
        int pre = 1;
        int num = 0;
        for (int i = 2; i <= n; i++) {
            num = pre + prePre;
            prePre = pre;
            pre = num;
        }
        return num;
    }

    /**
     * 509 斐波那契数列
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 1;
        return fibRe(n, cache);
    }

    private int fibRe(int n, int[] cache) {
        if (cache[n] > 0) {
            return cache[n];
        }
        int fib = fibRe(n - 1, cache) + fibRe(n - 2, cache);
        cache[n] = fib;
        return fib;
    }

    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int prePre = 0;
        int pre = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    /**
     * 674
     */
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            while (i + 1 < nums.length && nums[i + 1] > nums[i]) {
                len++; i++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
    public int findLengthOfLCIS1(int[] nums) {
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
        }
        return max;
    }
}
