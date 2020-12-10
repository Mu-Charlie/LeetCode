package com.zju.leetcode;

public class CountPrimes_204 {
    public int countPrimes(int n) {
        int counts=0;
        if(n<=1)
        {
            return counts;
        }
        int[] flag=new int[n];
        for (int i = 2; i < n; i++) {
            if(flag[i]==0)
            {
                counts++;
                long temp=(long)i*i;
                while (temp<n)
                {
                    flag[(int)temp]=1;
                    temp+=i;
                }
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            System.out.printf(i+" ");
            System.out.println(new CountPrimes_204().countPrimes(499999));
            break;
        }
    }
}
