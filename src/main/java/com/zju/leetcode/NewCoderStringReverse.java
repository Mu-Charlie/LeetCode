package com.zju.leetcode;

public class NewCoderStringReverse {
    int solve(int n, int k) {
        // write code here
        k=k%n;
        if(k==0||n==1)
        {
            return 0;
        }
        if(n==2)
        {
            return 1;
        }
        if(k<=2||n-k<=2)
        {
            return 2;
        }
        else {
            return 3;
        }
    }
}
