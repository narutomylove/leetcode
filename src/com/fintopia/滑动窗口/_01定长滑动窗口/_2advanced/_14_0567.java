package com.fintopia.滑动窗口._01定长滑动窗口._2advanced;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的 排列。如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class _14_0567 {

  public boolean checkInclusion(String s1, String s2) {
    char a = 'a';
    char[] s1char = s1.toCharArray();
    int[] arr1 = new int[26];
    for (int i = 0; i < s1char.length; i++) {
      arr1[s1char[i] - a]++;
    }
    char[] s2char = s2.toCharArray();
    int[] arr = new int[26];
    int k = s1.length();
    for (int i = 0; i < s2char.length; i++) {
      arr[s2char[i] - a]++;
      if (i < k - 1) {
        continue;
      }
      if (compare(arr1, arr)) {
        return true;
      }
      arr[s2char[i - k + 1] - a]--;
    }
    return false;
  }

  private boolean compare(int[] arr1, int[] arr) {
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr[i]) {
        return false;
      }
    }
    return true;
  }
}
