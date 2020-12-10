package com.zju.leetcode;

public class MagicCar {
    public int Holy (int n, int m, int[] x) {
        // write code here
        long max=0;
        for (int i = 0; i < m; i++) {
            n-=x[i];
            if(n<=0)
                break;
            max=Math.max(max,x[i]);
        }
        if(n<=0)
        {
            return 0;
        }
        int time=0;
        long left=n;
        while (left>0)
        {
            left-=max;
            max*=2;
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        int x[]={2};
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new MagicCar().Holy(4, 1, x));
    }
}
