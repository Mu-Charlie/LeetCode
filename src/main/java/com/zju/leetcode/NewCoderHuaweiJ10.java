package com.zju.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class NewCoderHuaweiJ10 {
    public static void main(String[] args) {
        boolean flag[]=new boolean[128];
        Scanner sin=new Scanner(System.in);
        String s=sin.next();
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(!flag[s.charAt(i)])
            {
                count++;
                flag[s.charAt(i)]=true;
            }
        }
        System.out.println(count);
    }
}
