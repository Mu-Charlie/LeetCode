package com.zju.leetcode;

public class CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>Math.max(p.val,q.val))
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val<Math.min(p.val,q.val))
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else
        {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(6);
        root.left=new TreeNode(2);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(3);
        root.left.right.right=new TreeNode(5);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(9);
        System.out.println(new CommonAncestor().lowestCommonAncestor(root, root.left, root.right));
    }
}
