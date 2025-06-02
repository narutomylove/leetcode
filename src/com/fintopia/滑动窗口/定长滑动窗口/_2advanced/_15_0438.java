package com.fintopia.滑动窗口.定长滑动窗口._2advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class _15_0438 {
  public List<Integer> findAnagrams(String s, String p) {
    int[] check = new int[26];
    int[] compare = new int[26];
    char[] sChar = s.toCharArray();
    char[] pChar = p.toCharArray();
    char baseChar = 'a';
    int k = p.length();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < p.length(); i++) {
      compare[pChar[i] - baseChar]++;
    }
    for (int i = 0; i < s.length(); i++) {
      check[sChar[i] - baseChar]++;
      if (i < k - 1) {
        continue;
      }
      if (compare(check, compare)) {
        result.add(i - k + 1);
      }
      check[sChar[i - k + 1] - baseChar]--;
    }
    return result;
  }

  private boolean compare(int[] check, int[] compare) {
    for (int i = 0; i < check.length; i++) {
      if (check[i] != compare[i]) {
        return false;
      }
    }
    return true;
  }
}
