package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderDIDI_01 {
    public static void main(String[] args) {
        int n;
        Scanner sin=new Scanner(System.in);
        n=sin.nextInt();
        int[] nums=new int[n];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp=sin.nextInt();
            if(i==0||nums[i-1]<=0)
            {
                nums[i]=temp;
            }
            else
            {
                nums[i]=nums[i-1]+temp;
            }
            if(nums[i]>max)
            {
                max=nums[i];
            }
        }
        System.out.println(max);
    }
}
