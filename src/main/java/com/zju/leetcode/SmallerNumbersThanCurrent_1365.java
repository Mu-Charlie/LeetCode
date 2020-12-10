package com.zju.leetcode;

import java.util.Arrays;

public class SmallerNumbersThanCurrent_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counts=new int[102];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]+1]+=1;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i]+=counts[i-1];
        }
        int[] result=new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i]=counts[nums[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={7,7,7,7};
        System.out.println(Arrays.toString(new SmallerNumbersThanCurrent_1365().smallerNumbersThanCurrent(nums)));
    }
}
