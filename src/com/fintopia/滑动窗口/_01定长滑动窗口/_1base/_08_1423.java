package com.fintopia.滑动窗口._01定长滑动窗口._1base;

/**
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 *
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 */
public class _08_1423 {

  public int maxScore(int[] cardPoints, int k) {
    int max = 0;
    for (int i = 0; i < k; i++) {
      max += cardPoints[i];
    }
    int sum = max;
    for (int i = 0; i < k; i++) {
      sum += cardPoints[cardPoints.length - 1 - i];
      sum -= cardPoints[k - 1 - i];
      max = Math.max(max, sum);
    }
    return max;
  }
}
