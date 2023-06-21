package com.sany.dfs和bfs;

import com.sany.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1609 {

    public boolean isEvenOddTree(TreeNode root) {
        return false;
    }

    private boolean bfs(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int len = deque.size();
            int remain = 1 - level % 2;
            Integer first = remain == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            Integer flag = remain == 1 ? 1 : -1;
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                if (node.val % 2 != remain) {
                    return false;
                }
                if (Integer.valueOf(node.val).compareTo(first) != flag) {
                    return false;
                }
                first = node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque.poll());
    }

}
