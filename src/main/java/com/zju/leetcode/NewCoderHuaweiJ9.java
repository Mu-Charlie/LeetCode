package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuaweiJ9 {
    public static void main(String[] args)
    {
        Scanner sin=new Scanner(System.in);
        int flag[]=new int[10];
        int n=sin.nextInt();
        int last=-1;
        while(n>0)
        {
            int cur=n%10;
            if(flag[cur]==0)
            {
                System.out.print(cur);
                flag[cur]=1;
            }
            n/=10;
        }
    }
}
