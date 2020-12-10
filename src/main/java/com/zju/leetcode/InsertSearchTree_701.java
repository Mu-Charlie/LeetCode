package com.zju.leetcode;

public class InsertSearchTree_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
        {
            return new TreeNode(val);
        }
        TreeNode cur=root;
        TreeNode last=root;
        while (cur!=null)
        {
            last=cur;
            if(val<cur.val)
            {
                cur=cur.left;
            }
            else
            {
                cur=cur.right;
            }
        }
        if(val<last.val)
        {
            last.left=new TreeNode(val);
        }
        else
        {
            last.right=new TreeNode(val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right=new TreeNode(7);
        TreeNode treeNode = new InsertSearchTree_701().insertIntoBST(root, 8);
        System.out.println(treeNode);
    }
}
