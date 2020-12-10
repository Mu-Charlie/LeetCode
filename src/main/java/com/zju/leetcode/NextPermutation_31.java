package com.zju.leetcode;

import java.util.Arrays;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1)
        {
            return;
        }
        int target=-1;
        for (int i = nums.length-1; i >0; i--) {
            if(nums[i]>nums[i-1])
            {
                target=i-1;
                break;
            }
        }
        if(target!=-1)
        {
            for (int i = nums.length-1; i > 0; i--) {
                if(nums[i]>nums[target])
                {
                    int temp=nums[i];
                    nums[i]=nums[target];
                    nums[target]=temp;
                    break;
                }
            }
        }
        for (int i = 0; i < (nums.length-target-1)/2; i++) {
            int temp=nums[target+1+i];
            nums[target+1+i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=temp;
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        new NextPermutation_31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
