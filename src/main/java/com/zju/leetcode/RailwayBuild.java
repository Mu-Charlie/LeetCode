package com.zju.leetcode;

public class RailwayBuild {
    public static int work (int n, int[] a) {
        // write code here
        int num=n;
        for (int i = 0; i < n-1; i++) {
            int dist=a[i+1]-a[i];
            if(!isZhiNum(dist))
            {
                if(dist%2==0)
                {
                    num++;
                }
                else
                {
                    if(isZhiNum(dist-2))
                    {
                        num++;
                    }
                    else{
                        num+=2;
                    }
                }
            }
        }
        return num;
    }
    public static boolean isZhiNum(int n)
    {
        if(n==1||n==2)
        {
            return true;
        }
        for (int i = 2; i < Math.sqrt(n)+1; i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n=3;
        int[] nums={0,7,11};
        System.out.println(work(n,nums));
    }
}
