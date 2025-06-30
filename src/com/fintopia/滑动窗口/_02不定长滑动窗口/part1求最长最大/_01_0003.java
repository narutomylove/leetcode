package com.fintopia.滑动窗口._02不定长滑动窗口.part1求最长最大;

import java.util.HashMap;
import java.util.Map;

/**
 * 好题
 */
public class _01_0003 {

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() < 1) {
      return 0;
    }
    char[] sChar = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    map.put(sChar[0], 0);
    int left = 0;
    int right = 1;
    int max = 1;
    for (; right < sChar.length; right++) {
      Integer index = map.get(sChar[right]);
      map.put(sChar[right], right);
      if (index == null || index < left) {
        max = Math.max(right - left + 1, max);
        continue;
      }
      left = index + 1;
    }
    return max;
  }
}
