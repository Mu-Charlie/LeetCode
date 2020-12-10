package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ1 {
    public static int solve(String s)
    {
        int counts=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                counts=0;
                continue;
            }
            counts++;
        }
        return counts;
    }
    public static void main(String[] args)
    {
        Scanner sin=new Scanner(System.in);
        String s=sin.nextLine();
        System.out.println(solve(s));
    }
}
