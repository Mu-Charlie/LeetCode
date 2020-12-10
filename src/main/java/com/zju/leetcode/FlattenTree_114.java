package com.zju.leetcode;

public class FlattenTree_114 {
    public void flatten(TreeNode root) {
        if(root==null||root.left==null&&root.right==null)
        {
            return;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        flatten(left);
        flatten(right);
        root.left=null;
        if(left!=null)
        {
            root.right=left;
            while (left.right!=null)
                left=left.right;
            left.right=right;

        }
        else
        {
            root.right=right;
        }
    }
}
