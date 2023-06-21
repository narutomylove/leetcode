package com.sany.dp;

import java.util.Arrays;

/**
 * 最长回文子序列
 */
public class _0516 {

    public static void main(String[] args) {
        String s = "abc";
        _0516 object = new _0516();
        object.longestPalindromeSubseq(s);

        int[][] envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Arrays.sort(envelopes, (int[] arr1, int[] arr2) -> {
            if (arr1[0] == arr2[0])
                return arr1[1] - arr2[1];
            else
                return arr1[0] - arr2[0];
        });

        System.out.println(111);
    }

    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j <= length - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
