package com.sany.dfs和bfs;

import java.util.Arrays;

public class _0091 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] map = new int[chars.length];
        Arrays.fill(map, -1);
        return dfs(chars, 0, map);
    }

    private int dfs(char[] chars, int index, int[] map) {
        if (index == chars.length) {
            return 1;
        }
        if (map[index] != -1) {
            return map[index];
        }
        if (chars[index] == '0') {
            map[index] = 0;
            return 0;
        }
        int res = dfs(chars, index + 1, map);
        if (index < chars.length - 1 &&
                (chars[index] == '1' || (chars[index] == '2' && chars[index + 1] < '7'))) {
            res += dfs(chars, index + 2, map);
        }
        map[index] = res;
        return res;
    }
}
