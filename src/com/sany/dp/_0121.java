package com.sany.dp;

/**
 * 股票问题大合集
 * leetcode.121 基础股票问题，这题没必要dp
 */
public class _0121 {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxIncome = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
                continue;
            }
            int income = price - minPrice;
            if (income > maxIncome) {
                maxIncome = income;
            }
        }
        return maxIncome;
    }

    public static void main(String[] args) {
        _0121 object = new _0121();
        int[] prices = new int[]{7,1,5,3,6,4};
        object.maxProfit(prices);
    }
}
