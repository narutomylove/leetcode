package com.fintopia.滑动窗口._02不定长滑动窗口.part1求最长最大;

public class _08_2024 {

  public static int maxConsecutiveAnswers(String answerKey, int k) {
    char[] keyChar = answerKey.toCharArray();
    // 先全部把T翻转成F，求最长连续F的长度
    int maxT = getMaxLength('T', keyChar, k);
    // 先全部把F翻转成T，求最长连续F的长度
    int maxF = getMaxLength('F', keyChar, k);
    return Math.max(maxT, maxF);
  }

  private static int getMaxLength(char t, char[] keyChar, int k) {
    int left = 0, right = 0, max = 0;
    int sum = 0;
    for (; right < keyChar.length; right++) {
      if (keyChar[right] == t) {
        if (sum < k) {
          sum++;
        } else {
          while (keyChar[left++] != t);
          continue;
        }
      }
      max = Math.max(max, right - left + 1);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(maxConsecutiveAnswers("FFFTTFTTFT", 3));
  }
}
