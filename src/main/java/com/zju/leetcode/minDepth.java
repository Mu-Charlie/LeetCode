package com.zju.leetcode;

import java.util.LinkedList;

public class minDepth {
    public int minDepth(TreeNode root) {
        //采用bfs来搜索最小的深度
        int depth=0;
        if (root==null)
        {
            return 0;
        }
        //队列记录节点
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.addFirst(root);
        while (queue.size()>0)
        {
            depth+=1;
            int length=queue.size();
            boolean flag=false;
            for (int i = 0; i < length; i++) {
                TreeNode cur=queue.removeLast();
                if(cur.left==null&&cur.right==null)
                {
                    flag=true;
                    break;
                }
                if(cur.left!=null)//左子节点入栈
                {
                    queue.addFirst(cur.left);
                }
                if(cur.right!=null)//右子节点入栈
                {
                    queue.addFirst(cur.right);
                }
            }
            if(flag)
            {
                break;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);

        System.out.println(new minDepth().minDepth(root));
    }
}
