package com.sany.dfs和bfs;

import com.sany.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 合并二叉树
 */
public class _617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        dfs(root1, root2);
        return root1;
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return root1;
        }
        if (root1 == null) {
            return root2;
        }
        root1.val += root2.val;
        root1.left = dfs(root1.left, root2.left);
        root1.right = dfs(root1.right, root2.right);
        return root1;
    }
}
