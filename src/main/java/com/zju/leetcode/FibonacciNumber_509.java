package com.zju.leetcode;

public class FibonacciNumber_509 {
    public static int fibs[]=new int[31];
    static {
        recursive_fib();
    }
    public int fib(int n) {
        return fibs[n];
    }
    public static void recursive_fib()
    {
        fibs[0]=0;
        fibs[1]=1;
        for (int i = 2; i < fibs.length; i++) {
            fibs[i]=fibs[i-1]+fibs[i-2];
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 31; i++) {
            System.out.println(new FibonacciNumber_509().fib(i));
        }
    }
}
