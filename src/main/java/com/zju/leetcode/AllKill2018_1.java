package com.zju.leetcode;

public class AllKill2018_1 {
    public static int max_yinshu(int sum,int n)
    {
        while(sum % n!=0)
        {
            int temp=sum%n;
            sum=n;
            n=temp;
        }
        return n;
    }
    public static void solution(int n)
    {
        int mean=0;
        int nums=n-2;
        for (int i = 2; i < n ; i++) {
            mean+=BitSum(n,i);
        }
        int max=max_yinshu(mean,nums);
        System.out.println(mean/max+"/"+nums/max);
    }
    public static int BitSum(int n,int k)
    {
        int sum=0;
        while(n>0)
        {
            sum+=n%k;
            n/=k;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n=5;
        solution(n);
    }
}
