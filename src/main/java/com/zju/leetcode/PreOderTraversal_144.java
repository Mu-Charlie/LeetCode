package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PreOderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result=new LinkedList<>();
        if(root==null)
        {
            return result;
        }
        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.addLast(root);
        while(!stack.isEmpty())
        {
            TreeNode cur=stack.removeLast();
            result.add(cur.val);
            if(cur.right!=null)
            {
                stack.addLast(cur.right);
            }
            if(cur.left!=null)
            {
                stack.addLast(cur.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
//        root.right=new TreeNode(2);
//        root.right.left=new TreeNode(3);
        root=null;
        System.out.println(Arrays.toString(new PreOderTraversal_144().preorderTraversal(root).toArray()));
    }
}
