package com.sany.dp;

import java.util.Collections;
import java.util.List;

/**
 * 回文串问题都放在这里
 * dp经典题了，最长回文子串
 */
public class _0005 {

    /**
     * 5：最长回文串
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        boolean[][] flag = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (chars[i] != chars[j]) {
                    flag[i][j] = false;
                    continue;
                }
                int len = j - i;
                if (len < 3) {
                    flag[i][j] = true;
                    continue;
                }
                flag[i][j] = flag[i + 1][j - 1];
            }
        }
        int max = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (flag[i][j]) {
                    int len = j - i + 1;
                    if (len > max) {
                        start = i;
                        max = len;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }

    /**
     * 131：分割回文字符串使子串都是回文串，求可能的分割方案
     * leetcode.5 的dp 加一段回溯算法解决
     */
    public List<List<String>> partition(String s) {
        return Collections.emptyList();
    }

    /**
     * 132：分割字符串使子串都是回文串,求最小分割次数。
     * 这题就是在第5题基础上，多了一次dp。
     */
    public int minCut(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] != chars[j]) {
                    continue;
                }
                if (j - i < 3) {
                    dp[i][j] = Boolean.TRUE;
                    continue;
                }
                dp[i][j] = dp[i + 1][j - 1];
            }
        }
        // 上面代码和 leetcode.5 一模一样。
        // 下面进行二次dp，求最小分割次数
        int[] cutTimeDp = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (dp[0][i]) {
                continue;
            }
            cutTimeDp[i] = i;
            for (int j = 1; j <= i; j++) {
                if (dp[j][i]) {
                    cutTimeDp[i] = Math.min(cutTimeDp[i], cutTimeDp[j - 1] + 1);
                }
            }
        }
        return cutTimeDp[chars.length - 1];
    }

    public static void main(String[] args) {
        _0005 object = new _0005();
        System.out.println(object.minCut("aab"));
    }
}
