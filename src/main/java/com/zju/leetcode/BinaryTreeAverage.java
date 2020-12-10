package com.zju.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeAverage {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<Double> result=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            double average=0;
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur=queue.remove();
                average+=cur.val;
                if(cur.left!=null)
                {
                    queue.add(cur.left);
                }
                if(cur.right!=null)
                {
                    queue.add(cur.right);
                }
            }
            result.add(average/size);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(1);
//        root.right=new TreeNode(20);
//        root.right.left=new TreeNode(15);
//        root.right.right=new TreeNode(7);
        List<Double> doubles = new BinaryTreeAverage().averageOfLevels(root);
        System.out.println(Arrays.toString(doubles.toArray()));
    }
}
