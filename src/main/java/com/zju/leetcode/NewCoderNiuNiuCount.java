package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class NewCoderNiuNiuCount {
    public long solve (int n, int c, int[] a) {
        // write code here
        if(n==1)
        {
            return (long)c*a[0];
        }
        Arrays.sort(a);
        LinkedList<Long> sorted_list=new LinkedList<>();
        for (int i : a) {
            sorted_list.add((long)i);
        }
        long counts=0;
        while (sorted_list.size()>2)
        {
            long first=sorted_list.removeFirst();
            first+=sorted_list.removeFirst();
            counts+=(first);
            int l=0,r=sorted_list.size()-1;
            while (l<r)
            {
                int mid=(l+r)/2;
                if(sorted_list.get(mid)<=first)
                {
                    l=mid+1;
                }
                else
                {
                    r=mid-1;
                }
            }
            if(sorted_list.get(l)<=first)
            {
                l++;
            }
            sorted_list.add(l,first);
        }
        counts+=(sorted_list.get(0)+sorted_list.get(1));
        counts*=c;
        return counts;
    }

    public static void main(String[] args) {
        int a[]={1,2,3,3};
        System.out.println(new NewCoderNiuNiuCount().solve(4, 70, a));
    }
}
