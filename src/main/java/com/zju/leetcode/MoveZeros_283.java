package com.zju.leetcode;

import java.util.Arrays;

public class MoveZeros_283 {
    public void moveZeroes(int[] nums) {
        int empty=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0)
            {
                nums[empty]=nums[i];
                empty++;
            }
        }
        while (empty<nums.length)
        {
            nums[empty]=0;
            empty++;
        }
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        new MoveZeros_283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
