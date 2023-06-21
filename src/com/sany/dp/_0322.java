package com.sany.dp;

import java.util.Arrays;

public class _0322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int subAmount = i - coin;
                if (subAmount < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[subAmount] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
