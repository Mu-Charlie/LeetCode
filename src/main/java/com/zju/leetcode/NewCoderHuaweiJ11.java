package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ11 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int n=sin.nextInt();
        StringBuilder sb=new StringBuilder();
        while (n>0)
        {
            sb.append(n%10);
            n/=10;
        }
        System.out.println(sb.toString());
    }
}
