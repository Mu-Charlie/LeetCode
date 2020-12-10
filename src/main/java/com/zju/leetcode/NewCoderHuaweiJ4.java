package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ4 {
    public static void solve(String s)
    {
        for (int i = 0; i < s.length(); i++) {
            System.out.printf(s.charAt(i)+"");
            if((i+1)%8==0)
            {
                System.out.print('\n');
            }
        }
        if((s.length())%8!=0)
        {
            int zero_num=8-s.length()%8;
            while (zero_num>0)
            {
                System.out.printf("0");
                zero_num--;
                if(zero_num==0)
                {
                    System.out.print('\n');
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        while (sin.hasNext())
        {
            String s=sin.next();
            solve(s);
        }
    }
}
