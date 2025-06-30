package com.fintopia.滑动窗口._02不定长滑动窗口.part1求最长最大;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _05_0904 {

  public int totalFruit(int[] fruits) {
    int max = 0;
    int left = 0;
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> type = new HashSet<>();
    for (int right = 0; right < fruits.length; right++) {
      type.add(fruits[right]);
      map.put(fruits[right], map.containsKey(fruits[right]) ? map.get(fruits[right]) + 1 : 1);
      while (type.size() > 2) {
        int num = map.get(fruits[left]) - 1;
        map.put(fruits[left], num);
        if (num == 0) {
          type.remove(fruits[left]);
        }
        left++;
      }
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
}
