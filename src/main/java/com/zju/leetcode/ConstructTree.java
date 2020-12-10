package com.zju.leetcode;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class ConstructTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder,int[] postorder,int s1,int e1,int s2,int e2)
    {
        if(s2>e2||s1>e1)
        {
            return null;
        }

        else
        {
            int root_val=postorder[e2];
            TreeNode root=new TreeNode(root_val);
            int i = s1;
            int ns1,ne1,ne2;
            ne1=s1;
            for (; ne1 <= e1; ne1++) {
                if(inorder[ne1]==root_val)
                    break;
            }
            ne1--;
            ns1=ne1+2;
            ne2=s2;
            for (; ne2 < ne1-s1+1+s2; ne2++);
            ne2--;
            root.left=build(inorder,postorder,s1,ne1,s2,ne2);
            root.right=build(inorder,postorder,ns1,e1,ne2+1,e2-1);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] inorder={9,3,15,20,7};
        int[] postorder={9,15,7,20,3};
        TreeNode treeNode = new ConstructTree().buildTree(inorder, postorder);
        System.out.println(treeNode);

    }
}
