package com.zju.leetcode;
import com.zju.leetcode.temp.Node;
public class Connect_116 {

    public Node connect(Node root) {
        if(root!=null&&root.left!=null)
        {
            Node temp=root;
            while (temp.left!=null)
            {
                Node f=temp;
                while (f.next!=null)
                {
                    f.left.next=f.right;
                    f.right.next=f.next.left;
                    f=f.next;
                }
                f.left.next=f.right;
                temp=temp.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        Node connect = new Connect_116().connect(root);
        System.out.println("done.");
        String a="abc"+"d";
    }
}
