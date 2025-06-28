package com.fintopia.滑动窗口.不定长滑动窗口.part2求最短最小;

public class _02_2904 {

  public static String shortestBeautifulSubstring(String s, int k) {
    char[] numChar = s.toCharArray();
    int minLength = Integer.MAX_VALUE;
    String subStr = "";
    int left = 0;
    int oneNum = 0;
    for (int right = 0; right < numChar.length; right++) {
      if (numChar[right] == '0') {
        if (left == right) {
          left++;
        }
        continue;
      }
      if (oneNum + 1 < k) {
        oneNum++;
        continue;
      }
      int temp = right - left + 1;
      if (temp < minLength) {
        minLength = temp;
        subStr = s.substring(left, right + 1);
      } else if (temp == minLength) {
        String tempSTr = s.substring(left, right + 1);
        if (subStr.compareTo(tempSTr) > 0) {
          subStr = tempSTr;
        }
      }
      while (++left < numChar.length && numChar[left] != '1');
    }
    return subStr;
  }
}
