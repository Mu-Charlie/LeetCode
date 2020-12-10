package com.zju.leetcode;

import java.awt.*;
import java.util.Scanner;

public class NewCoderHuaweiJ6 {
    public static void solve(long n)
    {
        long cur_prime=2;
        while (n>1)
        {
            if(n%cur_prime==0)
            {
                System.out.printf(cur_prime+" ");
            }
            else
            {
                cur_prime=nextPrime(cur_prime+1);
                continue;
            }
            n/=cur_prime;
        }
    }
    public static long nextPrime(long n)
    {
        while (!isPrim(n))
            n++;
        return n;
    }
    public static boolean isPrim(long n)
    {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        long n=sin.nextLong();
        solve(n);
    }
}
