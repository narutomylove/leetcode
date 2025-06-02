package com.fintopia.滑动窗口.定长滑动窗口._1base;

/**
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 *
 * 在某些分钟内，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 *
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 *
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 *
 *
 * 示例 1：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * 输出：16
 * 解释：书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * 示例 2：
 *
 * 输入：customers = [1], grumpy = [0], minutes = 1
 * 输出：1
 */
public class _09_1052 {

  public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int max = 0;
    int sum = 0;
    int total = 0;
    for (int i = 0; i < customers.length; i++) {
      if (grumpy[i] == 1) {
        sum += customers[i];
      } else {
        total += customers[i];
      }
      max = Math.max(max, sum);
      if (i < minutes - 1) {
        continue;
      }
      if (grumpy[i - minutes + 1] == 1) {
        sum -= customers[i - minutes + 1];
      }
    }
    return total + max;
  }
}
