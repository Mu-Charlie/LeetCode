package com.zju.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int max_nums[]=new int[3];
        int min_nums[]=new int[2];
        Arrays.fill(max_nums,Integer.MIN_VALUE);
        Arrays.fill(min_nums,Integer.MAX_VALUE);
        int n;
        Scanner sin=new Scanner(System.in);
        n=sin.nextInt();
        for (int i = 0; i < n; i++) {
            int cur=sin.nextInt();
            if(cur>max_nums[0])
            {
                max_nums[2]=max_nums[1];
                max_nums[1]=max_nums[0];
                max_nums[0]=cur;
            }
            else if(cur>max_nums[1])
            {
                max_nums[2]=max_nums[1];
                max_nums[1]=cur;
            }
            else if(cur>max_nums[2])
            {
                max_nums[2]=cur;
            }
            if(cur<min_nums[0])
            {
                min_nums[1]=min_nums[0];
                min_nums[0]=cur;
            }
            else if(cur<min_nums[1])
            {
                min_nums[1]=cur;
            }
        }
        System.out.println(Math.max(max_nums[0]*max_nums[1]*max_nums[2],max_nums[0]*min_nums[0]*min_nums[1]));
    }
}
