package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm_989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans=new LinkedList<>();
        int up=0;
        int index=0;
        while (index<A.length&&K!=0)
        {
            int cur = A[A.length - 1 - index] + K%10+up;
            up=cur/10;
            cur=cur%10;
            K=K/10;
            index++;
            ans.add(0,cur);
        }
        while(index<A.length)
        {
            int cur=A[A.length-1-index]+up;
            up=cur/10;
            cur=cur%10;
            index++;
            ans.add(0,cur);
        }
        while(K!=0)
        {
            int cur=K%10+up;
            up=cur/10;
            cur=cur%10;
            K=K/10;
            ans.add(0,cur);
        }
        if(up!=0)
        {
            ans.add(0,up);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A={1,2,0,0};
        int K=34;
        System.out.println(Arrays.toString(new AddToArrayForm_989().addToArrayForm(A,K).toArray()));
    }
}
