package com.zju.leetcode;

public class NewCoderArrayStatistic {
    public int countLR (int[] a, int[] b) {
        // write code here
        int[] sum_a=new int[a.length+1];
        for (int i = 0; i < a.length; i++) {
            sum_a[i+1]=sum_a[i]+a[i];
        }
        int counts=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if(sum_a[j+1]-sum_a[i]==b[i]+b[j])
                {
                    counts++;
                }
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        int a[]={0,0,1,1,1};
        int b[]={2,0,4,3,3};
        System.out.println(new NewCoderArrayStatistic().countLR(a, b));
    }
}
