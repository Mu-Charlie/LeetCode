package com.zju.leetcode;

public class MinPatches_330 {
    public int minPatches(int[] nums, int n) {
        int patches=0;
        long cur=1;
        int index=0;
        while (cur<=n)
        {
            if(index<nums.length&&nums[index]<=cur)
            {
                cur+=nums[index];
                index++;
            }
            else
            {
                cur*=2;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        int[] nums={1,2,2};
        int n=5;
        System.out.println(new MinPatches_330().minPatches(nums, n));
    }
}
