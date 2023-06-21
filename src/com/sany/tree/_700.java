package com.sany.tree;

/**
 * 二叉搜索树搜索
 */
public class _700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null && root.val != val) {
            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
        return root;
    }
}
