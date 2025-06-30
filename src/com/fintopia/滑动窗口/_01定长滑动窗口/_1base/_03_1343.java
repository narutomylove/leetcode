package com.fintopia.滑动窗口._01定长滑动窗口._1base;

/**
 * 这题我拿到手的第一想法，这不是个回溯问题吗？怎么会归类到滑动窗口了。
 */
public class _03_1343 {

  // 回溯写法
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int ans = 0;
    int s = 0; // 维护窗口元素和
    for (int i = 0; i < arr.length; i++) {
      // 1. 进入窗口
      s += arr[i];
      if (i < k - 1) { // 窗口大小不足 k
        continue;
      }
      // 2. 更新答案
      if (s >= k * threshold) {
        ans++;
      }
      // 3. 离开窗口
      s -= arr[i - k + 1];
    }
    return ans;

  }
}
