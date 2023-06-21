package com.sany.贪心;

import java.util.Arrays;

public class _179 {

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        String[] numsStr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(numsStr, (a, b) -> {
            String ab = a + b, ba = b + a;
            return ba.compareTo(ab);
        });
        StringBuilder sb = new StringBuilder();
        Arrays.stream(numsStr).forEach(v -> sb.append(v));
        int k = 0;
        int len = sb.length();
        while (k < len - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }

    public static void main(String[] args) {
        int[] nums = {10, 2};
        largestNumber(nums);
    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int nums = 0;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] > coins) {
                return nums;
            }
            nums++;
            coins -= costs[i];
        }
        return nums;
    }
}
