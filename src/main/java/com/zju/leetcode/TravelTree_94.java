package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TravelTree_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        travel(root,list);
        return list;
    }
    public void travel(TreeNode root,List<Integer> list)
    {
        if(root!=null)
        {
            travel(root.left,list);
            list.add(root.val);
            travel(root.right,list);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        List<Integer> integers = new TravelTree_94().inorderTraversal(root);
        System.out.println(Arrays.toString(integers.toArray()));
    }
}
