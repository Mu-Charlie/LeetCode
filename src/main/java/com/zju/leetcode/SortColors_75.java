package com.zju.leetcode;

import java.util.Arrays;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        if(nums.length<=1)
        {
            return;
        }
        int left=0;
        int right=nums.length-1;
        while (left<nums.length&&nums[left]==0)
        {
            left++;
        }
        while (right>=0&&nums[right]==2)
        {
            right--;
        }
        for (int i = left; i <= right&&left<right; i++) {
            if(nums[i]==0)
            {
                int temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
                left++;
            }
            else if(nums[i]==2)
            {
                int temp=nums[i];
                nums[i]=nums[right];
                nums[right]=temp;
                right--;
            }
            if(nums[i]!=1&&left<i)
            {
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={2,2};
        new SortColors_75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
