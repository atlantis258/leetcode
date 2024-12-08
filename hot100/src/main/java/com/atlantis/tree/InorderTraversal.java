package com.atlantis.tree;

import java.util.ArrayList;
import java.util.List;

// 94.二叉树的中序遍历
// https://leetcode.cn/problems/binary-tree-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked
public class InorderTraversal {

    // 二叉树的中序遍历：按照访问左子树——根节点——右子树的方式遍历这棵树，而在访问左子树或者右子树的时候我们按照同样的方式遍历，直到遍历完整棵树。
    // 因此整个遍历过程天然具有递归的性质，可以直接用递归函数来模拟这一过程。

    // 递归调用 inorder(root.left) 来遍历 root 节点的左子树，
    // 然后将 root 节点的值加入答案，再递归调用inorder(root.right) 来遍历 root 节点的右子树即可，
    // 递归终止的条件为碰到空节点。
    // 方法一：递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
