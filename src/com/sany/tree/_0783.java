package com.sany.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 求树中任意两个节点的差值的最小值
 * easy题目，刚一拿到手竟然毫无思路。发现是读题不仔细，原题说的是二叉搜索树
 */
public class _0783 {

    public int minDiffInBST(TreeNode root) {
        return dfs(root);
    }

    private TreeNode pre;
    int min = Integer.MAX_VALUE;

    /**
     * 二叉搜索树，不多bb，直接中序遍历（递归的中序遍历）
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        dfs(node.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(pre.val - node.val));
        }
        pre = node;
        dfs(node.right);
        return min;
    }

    /**
     * 非递归的中序遍历
     */
    public int minDiffInBST2(TreeNode root) {
        // 栈模拟
        Deque<TreeNode> d = new ArrayDeque<>();
        while (root != null || !d.isEmpty()) {
            while (root != null) {
                d.addLast(root);
                root = root.left;
            }
            root = d.pollLast();
            if (pre != null) {
                min = Math.min(min, Math.abs(pre.val - root.val));
            }
            pre = root;
            root = root.right;
        }
        return min;
    }

}
