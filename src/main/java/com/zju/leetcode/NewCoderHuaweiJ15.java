package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ15 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int n=sin.nextInt();
        int flag=1;
        int counts=0;
        for (int i = 0; i < 32; i++) {
            if((n&flag)==flag)
            {
                counts++;
            }
            flag=flag<<1;
        }
        System.out.println(counts)  ;
    }
}
