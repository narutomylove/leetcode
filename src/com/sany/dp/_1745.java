package com.sany.dp;

public class _1745 {

    public boolean checkPartitioning(String s) {
        if (s == null || s.length() < 3) {
            return false;
        }
        for (int j = 2; j < s.length(); j++) {
            for (int i = 1; i < j; i++) {
                String start = s.substring(0, i);
                String mid = s.substring(i, j);
                String end = s.substring(i, s.length());
                if (checkPalindrome(start) && checkPalindrome(mid) && checkPalindrome(end)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int step = s.length() >> 1;
        boolean result = true;
        for (int i = 0; i < step; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i -1)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
