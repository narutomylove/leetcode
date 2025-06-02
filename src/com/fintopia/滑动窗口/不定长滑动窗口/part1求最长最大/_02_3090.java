package com.fintopia.滑动窗口.不定长滑动窗口.part1求最长最大;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _02_3090 {

  public static int maximumLengthSubstring(String s) {
    if (s == null) {
      return 0;
    }
    if (s.length() < 3) {
      return s.length();
    }
    char[] sChar = s.toCharArray();
    int left = 0;
    int right = 2;
    int max = 2;
    Map<Character, List<Integer>> map = new HashMap<>();
    if (sChar[0] == sChar[1]) {
      List<Integer> list = new ArrayList<>();
      list.add(0);
      list.add(1);
      map.put(sChar[0], list);
    } else {
      List<Integer> list1 = new ArrayList<>();
      list1.add(0);
      map.put(sChar[0], list1);
      List<Integer> list2 = new ArrayList<>();
      list2.add(1);
      map.put(sChar[1], list2);
    }
    for (; right < sChar.length; right++) {
      List<Integer> indexes = map.get(sChar[right]);
      if (indexes == null) {
        indexes = new ArrayList<>();
        indexes.add(right);
        map.put(sChar[right], indexes);
        max = Math.max(right - left + 1, max);
        continue;
      }
      indexes.add(right);
      int temp = left;
      int sum = (int) indexes.stream().filter(v -> v >= temp).count();
      if (sum > 2) {
        left = indexes.get(indexes.size() - 3) + 1;
        continue;
      }
      max = Math.max(right - left + 1, max);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(maximumLengthSubstring("aadaad"));
  }
}
