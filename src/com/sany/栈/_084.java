package com.sany.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 一道很经典的单调栈：求最大的矩形
 */
public class _084 {

    /**
     * 暴力解法，明确思路（每一个高度的柱子，往两边延伸）
     */
    public static int largestRectangleArea1(int[] heights) {
        int left = 0;
        int right = 0;
        int max = 0;
        for (int index = 0; index < heights.length; index++) {
            left = index;
            right = index;
            while (left > 0 && heights[left - 1] >= heights[index]) {
                left--;
            }
            while(right < heights.length - 1 && heights[right + 1] >= heights[index]) {
                right++;
            }
            max = Math.max(max, heights[index] * (right - left + 1));
        }
        return max;
    }

    /**
     * 引入单调栈
     */
    public static int largestRectangleArea2(int[] heights) {
        if (heights == null) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int max = 0;
        int width = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i];
            while (!queue.isEmpty() && heights[queue.peek()] > cur) {
                int high = heights[queue.poll()];
                while (!queue.isEmpty() && heights[queue.peek()] == high) {
                    queue.poll();
                }
                width = queue.isEmpty() ? i : i - queue.peek() - 1;
                max = Math.max(max, high * width);
            }
            queue.addFirst(i);
        }
        while (!queue.isEmpty()) {
            int curHigh = heights[queue.poll()];
            while (!queue.isEmpty() && heights[queue.peek()] == curHigh) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                width = heights.length;
            } else {
                width = heights.length - queue.peek() - 1;
            }
            max = Math.max(max, curHigh * width);
        }
        return max;
    }

    //System.arraycopy(heights, 0, newHeights, 1, len);

    /**
     * 单调栈：引入哨兵优化
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int len = heights.length;
        int[] senHi = new int[len + 2];
        System.arraycopy(heights, 0, senHi, 1, len);
        len +=2;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        int curHeight = 0;
        int curWidth = 0;
        int max = 0;
        for (int i = 1; i < len; i++) {
            while (senHi[deque.peek()] > senHi[i]) {
                curHeight = senHi[deque.poll()];
                curWidth = i - deque.peek() - 1;
                max = Math.max(max, curHeight * curWidth);
            }
            deque.addFirst(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int result = largestRectangleArea(heights);
        System.out.println(result);
    }
}
