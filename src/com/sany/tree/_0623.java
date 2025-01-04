package com.sany.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0623 {

    /**
     * BFS 解法
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int curDepth = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (curDepth == depth - 1) {
                    TreeNode nLeft = new TreeNode(val);
                    TreeNode nRight = new TreeNode(val);
                    nLeft.left = node.left;
                    nRight.right = node.right;
                    node.left = nLeft;
                    node.right = nRight;
                    continue;
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }

            }
            curDepth++;
        }
        return root;
    }

    /**
     * DFS 解法
     */
    public TreeNode addOneRowDFS(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        dfs(depth, 1, val, root);
        return root;
    }

    private void dfs(int depth, int curDepth, int val, TreeNode node) {
        if (node == null) {
            return;
        }
        if (curDepth == depth - 1) {
            TreeNode nLeft = new TreeNode(val);
            TreeNode nRight = new TreeNode(val);
            nLeft.left = node.left;
            nRight.right = node.right;
            node.left = nLeft;
            node.right = nRight;
            return;
        }
        dfs(depth, curDepth + 1, val, node.left);
        dfs(depth, curDepth + 1, val, node.right);
    }

    public static void main(String[] args) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        deque.add(node1);
        deque.add(node2);
        deque.add(node3);

        System.out.println(deque.pollFirst().val);
        System.out.println(deque.poll().val);
    }

}
