package com.zju.leetcode;

import java.util.PriorityQueue;

public class NewCoderNiuNiuCount_P_Queue_Vers {
    public long solve (int n, int c, int[] a) {
        // write code here
        if(n==1)
        {
            return (long)a[0]*c;
        }
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for (int i : a) {
            pq.add((long)i);
        }
        long counts=0;
        while (pq.size()>2)
        {
            long temp=pq.poll();
            temp+=pq.poll();
            counts+=temp;
            pq.add(temp);
        }
        counts+=pq.poll()+pq.poll();
        return counts*c;
    }

    public static void main(String[] args) {
        int a[]={1,2,3,3};
        System.out.println(new NewCoderNiuNiuCount_P_Queue_Vers().solve(4, 70, a));
    }
}
