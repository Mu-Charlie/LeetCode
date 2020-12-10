package com.zju.leetcode;

import com.zju.leetcode.utils.ListNode;

import java.util.List;

public class SwapList_24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode first=head;
        ListNode second=head.next;
        //头指向第二个元素
        head=second;
        //交换第一和第二个元素
        first.next=second.next;
        second.next=first;
        ListNode last=first;
        first=first.next;
        while(first!=null&&first.next!=null)
        {
            second=first.next;
            first.next=second.next;
            second.next=first;
            last.next=second;
            last=first;
            first=first.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums={2,5,3,4,6,2,2};
        ListNode head=new ListNode(nums[0]);
        ListNode first=head;
        for (int i = 1; i < nums.length; i++) {
            first.next=new ListNode(nums[i]);
            first=first.next;
        }
        ListNode nhead = new SwapList_24().swapPairs(head);
        while (nhead!=null)
        {
            System.out.printf(nhead.val+" ");
            nhead=nhead.next;
        }
    }
}
