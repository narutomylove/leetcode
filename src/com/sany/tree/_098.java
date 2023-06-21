package com.sany.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉搜索树
 */
public class _098 {

    /**
     * 个人心目中最佳方法，中序遍历
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        double pre = -Double.MAX_VALUE;
        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                deque.addFirst(node);
                node = node.left;
            }
            node = deque.removeFirst();
            if (node.val <= pre) {
                return false;
            }
            pre = node.val;
            node = node.right;
        }
        return true;
    }

    /**
     * 递归方法
     */
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST2(root.right);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
        }
        return root;
    }
}
