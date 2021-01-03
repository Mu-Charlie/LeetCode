package com.zju.leetcode;

import com.zju.leetcode.utils.ListNode;

import java.util.List;

public class Partition_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode pre=new ListNode(0);
        ListNode preHead=pre;
        ListNode tail=new ListNode(0);
        ListNode tailHead=tail;
        while (head!=null)
        {
            if(head.val<x)
            {
                pre.next=head;
                pre=pre.next;
            }
            else
            {
                tail.next=head;
                tail=tail.next;
            }
            head=head.next;
        }
        tail.next=null;
        pre.next=tailHead.next;
        return preHead.next;
    }

    public static void main(String[] args) {
        int nums[]={1,4,3,2,5,2};
        ListNode head=new ListNode(nums[0]);
        ListNode cur=head;
        for (int i = 1; i < nums.length; i++) {
            cur.next=new ListNode(nums[i]);
            cur=cur.next;
        }
        ListNode newhead=new Partition_86().partition(head, 3);
        while (newhead!=null)
        {
            System.out.printf(newhead.val+" ");
            newhead=newhead.next;
        }
    }
}
