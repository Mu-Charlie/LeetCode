package com.zju.leetcode;

import java.util.LinkedList;

public class RecoverTree_99 {
    TreeNode last=null;
    LinkedList<TreeNode> fault_list=new LinkedList<>();
    public void recoverTree(TreeNode root) {
//        LinkedList<TreeNode> stack=new LinkedList<>();
//        stack.addFirst(root);
//        while (!stack.isEmpty())
//        {
//            if(stack.getFirst().left!=null)
//            {
//                stack.addFirst(stack.getFirst().left);
//                continue;
//            }
//            else
//            {
//                cur = stack.removeFirst();
//                if(last!=null)
//                {
//                    if(last.val>cur.val)
//                    {
//                        break;
//                    }
//                    else
//                    {
//                        last=cur;
//                    }
//                }
//                else {
//                    last=cur;
//                }
//            }
//            if(cur.right!=null)
//            {
//                stack.addFirst(cur.right);
//            }
//        }
        find_fault(root);
        int temp;
        temp=fault_list.getFirst().val;
        fault_list.getFirst().val=fault_list.getLast().val;
        fault_list.getLast().val=temp;
    }
    public void find_fault(TreeNode root)
    {
        if(root!=null)
        {
            find_fault(root.left);
            if(last!=null)
            {
                if(last.val>root.val)
                {
                    if(!fault_list.isEmpty())
                    {
                        fault_list.removeFirst();
                        fault_list.addFirst(root);
                    }
                    else
                    {
                        fault_list.addFirst(last);
                        fault_list.addFirst(root);
                    }
                }
            }
            last=root;
            find_fault(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(2);
        System.out.println(root.left.val+"->"+root.val+"->"+root.right.left.val+"->"+root.right.val);
        new RecoverTree_99().recoverTree(root);
        System.out.println(root.left.val+"->"+root.val+"->"+root.right.left.val+"->"+root.right.val);
    }
}
