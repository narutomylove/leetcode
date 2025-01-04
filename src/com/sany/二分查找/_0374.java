package com.sany.二分查找;

public class _0374 {

    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        int mid = 0;
        int gus = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            gus = guess(mid);
            if (gus == 0) {
                return mid;
            }
            if (gus == -1) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }

    private int guess(int num) {
        return 0;
    }
}
