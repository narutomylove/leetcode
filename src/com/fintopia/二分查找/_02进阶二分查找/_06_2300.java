package com.fintopia.二分查找._02进阶二分查找;

import java.util.Arrays;

public class _06_2300 {

  public static int[] successfulPairs(int[] spells, int[] potions, long success) {
    int[] result = new int[spells.length];
    Arrays.sort(potions);
    for (int i = 0; i < spells.length; i++) {
      result[i] = getNum(spells[i], potions, success);
    }
    return result;
  }

  private static int getNum(int spell, int[] potions, long success) {
    long min = success / spell;
    if (min > Integer.MAX_VALUE) {
      return 0;
    }
    boolean equal = min * spell == success ? true : false;
    int left = 0;
    int right = potions.length - 1;
    int pos = -1;
    int intMin = (int) min;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (potions[mid] < intMin) {
        left = mid + 1;
        continue;
      }
      if (mid == 0 || potions[mid - 1] < intMin) {
        if (!equal) {
          while (mid < potions.length && potions[mid] == intMin) {
            mid++;
          }
        }
        pos = mid;
        break;
      }
      right = mid - 1;
    }
    if (pos == -1) {
      return 0;
    }
    return potions.length - pos;
  }
}
