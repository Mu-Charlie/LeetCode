package com.zju.leetcode;

import com.zju.leetcode.utils.ListNode;

public class RemoveNthFromList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode fast=temp;
        ListNode slow=temp;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        while (fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
//        root.next=new ListNode(2);
//        root.next.next=new ListNode(3);
//        root.next.next.next=new ListNode(4);
//        root.next.next.next.next=new ListNode(5);
        ListNode test = new RemoveNthFromList_19().removeNthFromEnd(root, 1);
        while (test!=null)
        {
            System.out.print(test.val+" ");
            test=test.next;
        }
    }
}
