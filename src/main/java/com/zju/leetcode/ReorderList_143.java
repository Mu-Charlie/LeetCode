package com.zju.leetcode;

import com.zju.leetcode.utils.ListNode;

public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if(head==null)
        {
            return;
        }
        int num=0;
        ListNode temp=head;
        while (temp!=null)
        {
            num++;
            temp=temp.next;
        }
        ListNode[] nodes=new ListNode[num];
        temp=head;
        for (int i = 0; i < num; i++) {
            nodes[i]=temp;
            temp=temp.next;
        }
        for (int i = 0; i < num/2; i++) {
            nodes[num-i-1].next=nodes[i].next;
            nodes[i].next=nodes[num-i-1];
        }
        nodes[num/2].next=null;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode temp=head;
        for (int i = 0; i < 6; i++) {
            temp.next=new ListNode(i+2);
            temp=temp.next;
        }
        new ReorderList_143().reorderList(head);
        temp=head;
        while (temp!=null)
        {
            System.out.printf(temp.val+" ");
            temp=temp.next;
        }
    }
}
