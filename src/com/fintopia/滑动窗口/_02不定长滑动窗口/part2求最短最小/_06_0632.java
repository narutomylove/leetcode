package com.fintopia.滑动窗口._02不定长滑动窗口.part2求最短最小;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _06_0632 {

  // [[1,2,3],[1,2,3],[1,2,3]]
  // 1,1,1,2,2,2,3,3,3
  // 1,2,3,1,2,3,1,2,3
  public static int[] smallestRange(List<List<Integer>> nums) {
    int totalLen = nums.stream().mapToInt(List::size).sum();
    int[][] allNums = new int[totalLen][2];
    int pi = 0;
    for (int i = 0; i < nums.size(); i++) {
      for (int j : nums.get(i)) {
        allNums[pi][0] = j;
        allNums[pi++][1] = i;
      }
    }
    Arrays.sort(allNums, (a, b) -> a[0] - b[0]);

    int left = 0;
    int min  = Integer.MAX_VALUE;
    int start = 0;
    int end = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    for (int right = 0; right < totalLen; right++) {
      map.put(allNums[right][1], map.getOrDefault(allNums[right][1], 0) + 1);
      if (map.size() < nums.size()) {
        continue;
      }
      while (map.get(allNums[left][1]) > 1) {
        map.put(allNums[left][1], map.get(allNums[left][1]) - 1);
        left++;
      }
      int tempStart = allNums[left][0];
      int tempEnd = allNums[right][0];
      if (min > tempEnd - tempStart) {
        min = tempEnd - tempStart;
        start = tempStart;
        end = tempEnd;
      }
      map.remove(allNums[left++][1]);
    }
    return new int[]{start, end};
  }

  public static void main(String[] args) {
    //[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
    List<List<Integer>> nums = Arrays.asList(Arrays.asList(4,10,15,24,26), Arrays.asList(0,9,12,20), Arrays.asList(5,18,22,30));
    int[] num = smallestRange(nums);
    System.out.println();
  }
}
