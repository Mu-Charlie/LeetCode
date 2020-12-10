package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderZJ02 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int t=sin.nextInt();
        for (int i = 0; i < t; i++) {
            long n=sin.nextLong();
            long k=sin.nextLong();
            long d1=sin.nextLong();
            long d2=sin.nextLong();
            long left=n-k;

            long a1=(k-2*d1-d2);
            if(a1>=0&&a1%3==0)
            {

                if(left-(d1+2*d2)>=0&&(left-(d1+2*d2))%3==0)
                {
                    System.out.println("yes");
                    continue;
                }
            }
            a1=(k-2*d1+d2);
            if(a1>=0&&a1%3==0)
            {
                if(left-(d1+d2)>=0&&(left-(d1+d2))%3==0)
                {
                    System.out.println("yes");
                    continue;
                }
            }
            a1=(k+2*d1-d2);
            if(a1>=0&&a1%3==0)
            {
                if(d1>=d2&&left-(2*d1-d2)>=0&&(left-(2*d1-d2))%3==0)
                {
                    System.out.println("yes");
                    continue;
                }
                if(d1<d2&&left-(2*d2-d1)>=0&&(left-(2*d2-d1))%3==0)
                {
                    System.out.println("yes");
                    continue;
                }
            }
            a1=(k+2*d1+d2);
            if(a1>=0&&a1%3==0)
            {

                if(left-(2*d1+d2)>=0&&(left-(2*d1+d2))%3==0)
                {
                    System.out.println("yes");
                    continue;
                }
            }
            System.out.println("no");
        }
    }
}
