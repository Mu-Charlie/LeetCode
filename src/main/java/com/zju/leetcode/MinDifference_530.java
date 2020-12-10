package com.zju.leetcode;

public class MinDifference_530 {
    public int getMinimumDifference(TreeNode root) {
        int cur_min=Integer.MAX_VALUE;
        if(root.left!=null)
        {
            TreeNode p=root.left;
            while (p.right!=null)
            {
                p=p.right;
            }
            cur_min=Math.min(cur_min,root.val-p.val);
            int l_min=getMinimumDifference(root.left);
            cur_min=Math.min(cur_min,l_min);
        }
        if(root.right!=null)
        {
            TreeNode p=root.right;
            while (p.left!=null)
            {
                p=p.left;
            }
            cur_min=Math.min(cur_min,p.val-root.val);
            int r_min=getMinimumDifference(root.right);
            cur_min=Math.min(cur_min,r_min);
        }
        return cur_min;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(2);
        System.out.println(new MinDifference_530().getMinimumDifference(root));
    }
}
