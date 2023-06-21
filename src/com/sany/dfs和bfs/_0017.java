package com.sany.dfs和bfs;

import java.util.*;

public class _0017 {

    private Map<Character, List<Character>> maps;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        maps = new HashMap<>();
        maps.put('2', Arrays.asList('a', 'b', 'c'));
        maps.put('3', Arrays.asList('d', 'e', 'f'));
        maps.put('4', Arrays.asList('g', 'h', 'i'));
        maps.put('5', Arrays.asList('j', 'k', 'l'));
        maps.put('6', Arrays.asList('m', 'n', 'o'));
        maps.put('7', Arrays.asList('p', 'q', 'r', 's'));
        maps.put('8', Arrays.asList('t', 'u', 'v'));
        maps.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        List<String> result = new ArrayList<>();
        dfs(digits.toCharArray(), 0, "", result);
        return result;
    }

    private void dfs(char[] chars, int index, String s, List<String> list) {
        if (index == chars.length) {
            list.add(s);
            return;
        }
        List<Character> characterList = maps.get(chars[index]);
        int next = index + 1;
        for (int i = 0; i < characterList.size(); i++) {
            dfs(chars, next, s + characterList.get(i), list);
        }
    }

    public static void main(String[] args) {
        _0017 object = new _0017();
        List<String> list = object.letterCombinations("23");
        System.out.println(1);
    }
}
