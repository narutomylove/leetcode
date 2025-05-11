package com.fintopia.滑动窗口.定长滑动窗口;

public class _02_2269 {

  public int divisorSubstrings(int num, int k) {
    String numStr = String.valueOf(num);
    int sum = 0;
    for (int i = 0; i <= numStr.length() - k; i++) {
      String subNumStr = numStr.substring(i, i + k);
      int subNum = Integer.valueOf(subNumStr);
      if (subNum == 0) {
        continue;
      }
      if (num % subNum == 0) {
        sum++;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    _02_2269 test = new _02_2269();
    System.out.println(test.divisorSubstrings(430043, 2));
  }
}
