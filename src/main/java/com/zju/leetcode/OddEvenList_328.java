package com.zju.leetcode;

import com.zju.leetcode.utils.ListNode;

public class OddEvenList_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        while (even!=null&&even.next!=null)
        {
            ListNode e_start= odd.next;
            odd.next= even.next;
            even.next=even.next.next;
            even=even.next;
            odd=odd.next;
            odd.next=e_start;
        }
        return head;
    }

    public static void main(String[] args) {
        int num[]={2,1,3,5,6,4,7};

        ListNode head=new ListNode(num[0]);
        ListNode temp=head;
        for (int i = 1; i < num.length; i++) {
            temp.next=new ListNode(num[i]);
            temp=temp.next;
        }
        new OddEvenList_328().oddEvenList(head);
        while (head!=null)
        {
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
}
