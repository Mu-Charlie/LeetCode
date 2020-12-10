package com.zju.leetcode;

public class ReverseBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root!=null)
        {
           TreeNode l=root.left;
           root.left=invertTree(root.right);
           root.right=invertTree(l);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(9);
        TreeNode new_root=new ReverseBinaryTree_226().invertTree(root);
        System.out.println("done..");
    }
}
