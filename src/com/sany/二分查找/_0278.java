package com.sany.二分查找;

/**
 * 找到第一个出错得版本
 */
public class _0278 {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = 0;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            boolean flag = isBadVersion(mid);
            if (flag) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
