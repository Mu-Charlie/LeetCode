package com.zju.leetcode;

import java.util.Arrays;

public class MaximumProduct_628 {
    public int maximumProduct(int[] nums) {
        //没有考虑负数的情况
        if(nums.length<4)
        {
            return nums[0]*nums[1]*nums[2];
        }
        int[] maxes=new int[4];
        Arrays.fill(maxes,Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            maxes[3]=nums[i];
            for (int j = 3; j > 0; j--) {
                if(maxes[j]>maxes[j-1])
                {
                    int temp=maxes[j];
                    maxes[j]=maxes[j-1];
                    maxes[j-1]=temp;
                }
                else
                {
                    break;
                }
            }
        }
        return maxes[0]*maxes[1]*maxes[2];
    }
    public int maximumProduct2(int[] nums)
    {
        int max1,max2,max3,min1,min2;
        max1=max2=max3=Integer.MIN_VALUE;
        min1=min2=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max1)
            {
                max3=max2;
                max2=max1;
                max1=nums[i];
            }
            else if(nums[i]>max2)
            {
                max3=max2;
                max2=nums[i];
            }
            else if(nums[i]>max3)
            {
                max3=nums[i];
            }
            if(nums[i]<min1)
            {
                min2=min1;
                min1=nums[i];
            }
            else if(nums[i]<min2)
            {
                min2=nums[i];
            }
        }
        return Math.max(max1*max2*max3,min1*min2*max1);
    }

    public static void main(String[] args) {
        int[] nums={5,7,6,4,3,2};
        System.out.println(new MaximumProduct_628().maximumProduct2(nums));
    }
}
