package com.zju.leetcode;

import com.zju.leetcode.utils.ListNode;

public class CircleList_II_142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
        {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null)
        {
            slow=slow.next;
            if(fast.next!=null)
            {
                fast=fast.next.next;
            }
            else
            {
                return null;
            }
            if(fast==slow)
            {
                ListNode curr=head;
                while (curr!=slow)
                {
                    curr=curr.next;
                    slow=slow.next;
                }
                return curr;
            }
        }
        return null;
    }
}
