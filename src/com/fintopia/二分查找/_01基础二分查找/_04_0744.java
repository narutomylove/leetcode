package com.fintopia.二分查找._01基础二分查找;

public class _04_0744 {

  /**
   * 寻找比目标字母大的最小字母
   * 看和35题的区别。35题"大于等于"，这题是大于。
   */
  public static char nextGreatestLetter(char[] letters, char target) {
    int left = 0;
    int right = letters.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (letters[mid] <= target) {
        left = mid + 1;
        continue;
      }
      if (mid == 0 || letters[mid - 1] <= target) {
        return letters[mid];
      }
      right = mid - 1;
    }
    return letters[0];
  }

  public static void main(String[] args) {
    char[] letters = new char[]{'c','f','j'};
    nextGreatestLetter(letters, 'c');
  }
}
