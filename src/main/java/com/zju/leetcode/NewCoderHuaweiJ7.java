package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ7 {
    public static int solve(float n)
    {
        if((int)(n*10)%10>=5)
        {
            return (int)n+1;
        }
        else
        {
            return (int)n;
        }
    }

    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        float n=sin.nextFloat();
        System.out.println(solve(n));
    }
}
