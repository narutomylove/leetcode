package com.sany.栈;

/**
 * 脉脉热题：接雨水
 */
public class _042 {

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int result = 0;
        int left = 1;
        int maxLeft = height[0];
        int right = height.length - 2;
        int maxRight = height[height.length - 1];
        for (int i = 1; i < height.length - 1; i++) {
            if (maxLeft < maxRight) {
                if (maxLeft > height[left]) {
                    result = result + maxLeft - height[left];
                }
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
                continue;
            }
            if (maxRight > height[right]) {
                result = result + maxRight - height[right];
            }
            maxRight = Math.max(maxRight, height[right]);
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
