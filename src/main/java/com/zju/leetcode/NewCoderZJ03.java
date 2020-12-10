package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderZJ03 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int n=sin.nextInt();
        int m=sin.nextInt();
        String str=sin.next();
//        System.out.println(str);
        //处理连续的a 也即将b替换成a
        int max_a=solve(str,'b',m,n);
        int max_b=solve(str,'a',m,n);
        System.out.println(Math.max(max_a,max_b));
    }
    public static int solve(String str,char t,int m,int n)
    {
        int max_a=0;
        int count=0;
        int first_index=0;
        int end=0;
        while (end<n)
        {
            if(str.charAt(end)==t)
                count++;
            if(count==m)
            {
                while (end+1<n&&str.charAt(end+1)!=t)
                    end++;
                int length=end-first_index+1;
                if(length>max_a)
                {
                    max_a=length;
                }
                while (str.charAt(first_index)!=t)
                    first_index++;
                first_index++;
                count--;
            }
            end++;
        }
//        for ( i = 0; i < n; i++) {
//            if(str.charAt(i)==t)
//                count++;
//            if(count==m)
//            {
//                if(str.charAt(i)==t)
//                {
//                    int length=i-first_index;
//                    if(length>max_a)
//                    {
//                        max_a=length;
//                    }
//                    while (str.charAt(first_index)!=t)
//                        first_index++;
//                    first_index++;
//                    count--;
//                }
//                if(i+1<n&&str.charAt(i+1)==t)
//                {
//                    int length=i-first_index+1;
//                    if(length>max_a)
//                    {
//                        max_a=length;
//                    }
//                    while (str.charAt(first_index)!=t)
//                        first_index++;
//                    first_index++;
//                    count--;
//                }
//            }
//        }
        if(n-first_index>max_a)
        {
            max_a=n-first_index;
        }
        return max_a;
    }
}
