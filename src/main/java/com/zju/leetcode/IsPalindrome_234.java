package com.zju.leetcode;

import com.zju.leetcode.utils.ListNode;

public class IsPalindrome_234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
        {
            return true;
        }
        int num=0;
        ListNode temp=head;
        while (temp!=null)
        {
            num++;
            temp=temp.next;
        }
        ListNode last=null;
        temp=head;
        for (int i = 0; i <= (num-1)/2; i++) {
            ListNode temp2=temp.next;
            temp.next=last;
            last=temp;
            temp=temp2;
        }
        if(num%2!=0)
            last=last.next;
        while (last!=null&&temp!=null)
        {
            if(last.val!=temp.val)
                return false;
            last=last.next;
            temp=temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
//        head.next.next=new ListNode(2);
//        head.next.next.next=new ListNode(1);
        System.out.println(new IsPalindrome_234().isPalindrome(head));
    }
}
