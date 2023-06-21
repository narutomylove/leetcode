package com.sany.贪心;

public class _1221 {

    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                left++;
            }
            if (s.charAt(i) == 'R') {
                right++;
            }
            if (left == right) {
                left = 0;
                right = 0;
                count++;
            }
        }
        return count;
    }
}
