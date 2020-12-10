package com.zju.leetcode;

public class MaxSubArraySum53 {
    public static int maxSubArray(int[] nums) {
        int max_sum=Integer.MIN_VALUE;
        int pre=0;
        for (int i = 0; i < nums.length; i++) {
            pre=Math.max(pre+nums[i],nums[i]);
            max_sum=Math.max(pre,max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
