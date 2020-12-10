package com.zju.leetcode;


import java.util.Scanner;

public class NewCoderHuawei02 {
    public static void main(String[] args) {
        int n;

        Scanner in=new Scanner(System.in);
        while (in.hasNext())
        {
            n=in.nextInt();
            int[] nums=new int[1001];
            for (int i = 0; i < n; i++) {
                int number=in.nextInt();
                nums[number]=1;
            }
            int counts=0;
            for (int i = 0; i < 1001; i++) {
                if(nums[i]==1)
                {
                    System.out.println(i);
                    counts++;
                }
                if(counts==n)
                {
                    break;
                }
            }
        }
    }
}
