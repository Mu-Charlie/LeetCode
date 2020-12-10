package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderHuawei01 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        while(sin.hasNext())
        {
            int n=sin.nextInt();
            if(n==0)
            {
                break;
            }
            new NewCoderHuawei01().solution(n);
        }
    }
    public void solution(int n)
    {
        int counts=0;
        while (n/3>0)
        {
            counts+=n/3;
            n=n/3+n%3;
        }
        if(n==2)
        {
            counts+=1;
        }
        System.out.println(counts);
    }
}
