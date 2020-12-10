package com.zju.leetcode;

import java.util.Scanner;

public class NewCoderMeiTuan_01 {
    public static void main(String[] args) {
        int n;
        Scanner sin=new Scanner(System.in);
        n=7;
        int[] nums= {10,11,9,12,4,15,1};
        System.out.println(new NewCoderMeiTuan_01().getDis(nums,n));
    }
    public int getDis(int[] A, int n) {
        // write code here
        if(n<2)
        {
            return 0;
        }
        int left=0;
        int right=n-1;
        int cur_min=A[0];
        int max=0;
        for (int i = 0; i < n; i++) {//前缀最小值
            if(A[i]<cur_min)
            {
                cur_min=A[i];
                continue;
            }
            else if(A[i]-cur_min>max)
            {
                max=A[i]-cur_min;
            }
        }
        return max;
    }
}
