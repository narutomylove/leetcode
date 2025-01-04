package com.sany.二分查找;

/**
 * 寻找大于目标值的最小的那一个
 */
public class _0744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (letters[mid] <= target) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }
        if (letters[left] > target) {
            return letters[left];
        }
        return letters[left];
    }

    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'b', 'c'};
        char result = nextGreatestLetter(letters, 'b');
        System.out.println(result);
    }
}
