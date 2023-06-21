package com.sany.dp;

public class _1140 {

    public int stoneGameII(int[] piles) {
        int length = piles.length;
        int[][] dp = new int [length][length + 1];
        int sum = 0;
        for (int i = length - 1; i >= 0; i--) {
            sum += piles[i];
            for (int j = 1; j <= length; j++) {
                int doubleStep = j << 1;
                int subLen = i + doubleStep - 1;
                if (subLen >= length) {
                    dp[i][j] = sum;
                    continue;
                }
                for (int x = 1; x <= doubleStep; x++) {
                    int competitor = dp[i + x][Math.max(x, j)];
                    dp[i][j] = Math.max(dp[i][j], sum - competitor);
                }
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        System.out.println(2 << 1);
    }
}
