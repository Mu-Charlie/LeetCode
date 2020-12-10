package com.zju.leetcode;
import com.zju.leetcode.utils.Node;

import java.util.LinkedList;

public class Connect_Layer_117 {
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(7);
        System.out.println(new Connect_Layer_117().connect(root).toString());
        System.out.println("done.");
    }
    public Node connect(Node root) {
        if(root!=null)
        {
            LinkedList<Node> queue=new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty())
            {
                int size=queue.size();
                Node last=queue.removeFirst();
                if(last.left!=null)
                {
                    queue.addLast(last.left);
                }
                if(last.right!=null)
                {
                    queue.addLast(last.right);
                }
                for (int i = 0; i < size - 1; i++) {
                    last.next=queue.removeFirst();
                    last=last.next;
                    if(last.left!=null)
                    {
                        queue.addLast(last.left);
                    }
                    if(last.right!=null)
                    {
                        queue.addLast(last.right);
                    }
                }
            }
        }
        return root;
    }
}
