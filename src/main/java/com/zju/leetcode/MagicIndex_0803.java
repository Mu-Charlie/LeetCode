package com.zju.leetcode;

public class MagicIndex_0803 {
    public int findMagicIndex(int[] nums) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==i)
            {
                index=i;
                break;
            }
        }
        return index;
    }
}
