package com.sany.贪心;

/**
 * 盛水最多的容器
 */
public class _011 {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int tmp = Math.min(height[left], height[right]) * (right - left);
            max = tmp > max ? tmp : max;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
