package com.sany.栈;

/**
 * 二叉树按照先序遍历顺序展开为链表
 */
public class _114 {

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            }
            TreeNode next = root.left;
            root.left = null;
            TreeNode tmp = root.right;
            root.right = next;
            while (root.right != null) {
                root = root.right;
            }
            root.right = tmp;
            root = next;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
         this.right = right;
    }
}