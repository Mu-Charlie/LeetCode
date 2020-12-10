package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ2 {
    public static int solve(String s,char c)
    {
        int counts=0;
        c=Character.toLowerCase(c);
        for (int i = 0; i < s.length(); i++) {
            if(Character.toLowerCase(s.charAt(i))==c)
            {
                counts++;
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        String s;
        char c;
        Scanner sin=new Scanner(System.in);
        s=sin.next();
        c= sin.next().charAt(0);
        System.out.println(solve(s,c));
    }
}
