package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new LinkedList<>();
        LinkedList<TreeNode> temp=new LinkedList<>();
        if(root==null)
        {
            return result;
        }
        temp.add(root);
        int flag=0;
        while (!temp.isEmpty())
        {
            int size=temp.size();
            List<Integer> cur=new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n;
                if(flag==0)
                {
                    n=temp.get(i);
                }
                else
                {
                    n=temp.get(temp.size()-1-i);
                }
                cur.add(n.val);
            }
            result.add(cur);
            for (int i = 0; i < size; i++) {
                TreeNode node = temp.removeFirst();
                if(node.left!=null)
                {
                    temp.addLast(node.left);
                }
                if(node.right!=null)
                {
                    temp.addLast(node.right);
                }
            }
            flag=1-flag;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.left.left.left=new TreeNode(8);
        root.left.left.right=new TreeNode(9);
//        root.left.right.left=new TreeNode(10);
//        root.left.right.right=new TreeNode(11);
//        root.right.left.left=new TreeNode(12);
//        root.right.left.right=new TreeNode(13);
        root.right.right.left=new TreeNode(14);
        root.right.right.right=new TreeNode(15);
        List<List<Integer>> lists = new ZigzagLevelOrder_103().zigzagLevelOrder(null);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
