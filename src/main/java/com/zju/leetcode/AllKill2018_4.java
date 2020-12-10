package com.zju.leetcode;

import java.util.Scanner;

public class AllKill2018_4 {
    public static void main(String[] args) {
        int n;
        String s1,s2;
        int a=0,b=0;
        Scanner sin=new Scanner(System.in);
        n = sin.nextInt();
        s1=sin.next();

        s2=sin.next();
        for (int i = 0; i < n; i++) {
            a=a*2+(s1.charAt(i)-'0');
            b=b*2+(s2.charAt(i)-'0');
        }
        System.out.println(a^b);
    }
}
