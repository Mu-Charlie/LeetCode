package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderMeiTuan_05 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        while (sin.hasNext())
        {
            String s1=sin.next();
            String s2=sin.next();
            StringBuilder sb1=new StringBuilder(s1);
            StringBuilder sb2=new StringBuilder(s2);
            int len1=sin.nextInt();
            int len2=sin.nextInt();

            while (sb1.length()<len2)
            {
                sb1.append('a'-1);
            }
            while(sb2.length()<len2)
            {
                sb2.append('z');
            }
            int[] k=new int[sb1.length()];
            for (int i = 0; i < sb1.length(); i++) {
                k[i]=sb2.charAt(i)-sb1.charAt(i);
            }
            long result=0;
            for (int i = len1; i <= len2; i++) {
                for (int j = 0; j < i; j++) {
                    result=result+k[j]*(long)Math.pow(26,i-j-1);
                }
            }
            System.out.println(result-1);
        }
    }
}
