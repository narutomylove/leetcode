package com.sany.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _0062 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    /**
     * 空间优化版本
     */
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * 64题 62题的进阶版本
     */
    public int minPathSum(int[][] grid) {
        return dfs(grid.length - 1, grid[0].length - 1, grid, new int[grid.length][grid[0].length]);
    }

    private int dfs(int m, int n, int[][] grid, int[][] cache) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (cache[m][n] > 0) {
            return cache[m][n];
        }
        int num = grid[m][n] + Math.min(dfs(m -1, n, grid, cache), dfs(m, n - 1, grid, cache));
        cache[m][n] = num;
        return num;
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
}
