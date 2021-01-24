package com.zju.leetcode;

public class FindLengthOfLCIS_674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<=1)
        {
            return nums.length;
        }
        int ans=1;
        int final_ans=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1])
            {
                ans++;
            }
            else
            {
                ans=1;
            }
            final_ans=ans>final_ans ? ans:final_ans;
        }
        return final_ans;
    }

    public static void main(String[] args) {
        int[] nums={2,2,2,2};
        System.out.println(new FindLengthOfLCIS_674().findLengthOfLCIS(nums));
    }
}
