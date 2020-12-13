package com.zju.leetcode;

import java.util.HashMap;

public class ContainDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        boolean[] flag=new boolean[10];
        HashMap<Integer,Boolean> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.getOrDefault(nums[i],false))
            {
                map.put(nums[i],true);
            }
            else
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,5,-2,-4,1};
        System.out.println(new ContainDuplicate_217().containsDuplicate(nums));
    }
}
