package com.sany.dfs和bfs;

import com.sany.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 二叉树的堂兄弟节点
 */
public class _0993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        return dfs(root, x, y);
    }

    private boolean dfs(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(null, root, 1);
        if (xLen > 0 && xLen == yLen && xPar != yPar) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private int x;
    private int y;
    private int xLen;
    private int yLen;
    private TreeNode xPar;
    private TreeNode yPar;

    private void dfs(TreeNode parent, TreeNode node, int len) {
        if (node.val == x) {
            xLen = len;
            xPar = parent;
        }
        if (node.val == y) {
            yLen = len;
            yPar = parent;
        }
        if (node.left != null) {
            dfs(node, node.left, len + 1);
        }
        if (node.right != null) {
            dfs(node, node.right, len + 1);
        }
    }
}
