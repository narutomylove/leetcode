package com.fintopia.滑动窗口._02不定长滑动窗口.part2求最短最小;

import java.util.HashMap;
import java.util.Map;

public class _05_0076 {

  public static String minWindow(String s, String t) {
    char[] tChar = t.toCharArray();
    Map<Character, Integer> tMap = new HashMap<>();
    for (char item : tChar) {
      tMap.put(item, tMap.getOrDefault(item, 0) + 1);
    }
    char[] sChar = s.toCharArray();
    Map<Character, Integer> sMap = new HashMap<>();

    int left = 0;
    int min = Integer.MAX_VALUE;
    String subString = "";
    for (int right = 0; right < sChar.length; right++) {
      if (!tMap.containsKey(sChar[right])) {
        if (left == right) {
          left++;
        }
        continue;
      }
      sMap.put(sChar[right], sMap.getOrDefault(sChar[right], 0) + 1);
      if (!match(sMap, tMap)) {
        continue;
      }
      // 左移指针关键
      for (; left < right; left++) {
        if (!tMap.containsKey(sChar[left])) {
          continue;
        }
        int tNum = tMap.get(sChar[left]);
        int sNum = sMap.get(sChar[left]);
        if (sNum == tNum) {
          break;
        }
        sMap.put(sChar[left], sNum - 1);
      }
      int tempLen = right - left + 1;
      if (tempLen < min) {
        subString = s.substring(left, right + 1);
        min = tempLen;
      }
      // 左移指针，移动到字串不完全包含t为止，且左指针的位置是t的元素之一
      while (left < sChar.length && (match(sMap, tMap) || !tMap.containsKey(sChar[left]))) {
        if (sMap.containsKey(sChar[left])) {
          sMap.put(sChar[left], sMap.get(sChar[left]) - 1);
        }
        left++;
      }
    }
    return subString;
  }

  private static boolean match(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
    for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
      if (sMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    System.out.println(minWindow("bba", "ba"));
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }
}
