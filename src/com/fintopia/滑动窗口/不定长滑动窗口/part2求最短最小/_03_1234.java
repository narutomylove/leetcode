package com.fintopia.滑动窗口.不定长滑动窗口.part2求最短最小;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _03_1234 {

  public static int balancedString(String S) {
    char[] chars = S.toCharArray();
    int[] cnt = new int['X']; // 也可以用哈希表，不过数组更快一些
    for (char c : chars) {
      cnt[c]++;
    }

    int n = chars.length;
    int m = n / 4;
    if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
      return 0; // 已经符合要求啦
    }

    int ans = n;
    int left = 0;
    for (int right = 0; right < n; right++) { // 枚举子串右端点
      cnt[chars[right]]--;
      while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
        ans = Math.min(ans, right - left + 1);
        cnt[chars[left]]++; // 缩小子串
        left++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(balancedString("WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE"));
  }
}
