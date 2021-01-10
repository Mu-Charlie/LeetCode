package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new LinkedList<>();
        int start_index=0;
        int end_index=0;
        for (int i = 0; i < nums.length; i++) {
            if(i<nums.length-1&&nums[i+1]==nums[i]+1)
            {
                end_index=i+1;
            }
            else
            {
                if(end_index==start_index)
                {
                    ans.add(String.valueOf(nums[start_index]));
                }
                else
                {
                    ans.add(String.valueOf(nums[start_index])+"->"+String.valueOf(nums[end_index]));
                }
                start_index=end_index=i+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,0,3,2,5,4,6};
        System.out.println(Arrays.toString(new SummaryRanges_228().summaryRanges(nums).toArray()));
    }
}
