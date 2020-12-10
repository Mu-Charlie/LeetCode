package com.zju.leetcode;

import java.util.Arrays;
import java.util.OptionalInt;

public class MaximumGap_164 {
    public int maximumGap(int[] nums) {
        if(nums.length<2)
        {
            return 0;
        }
        int maxGap=0;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int d=Integer.max(1,(max-min)/(nums.length-1));//最小间隔为d 相邻两个数之间间隔大于等于d
        int boxSize=(max-min)/d+1;//总共有boxSize个桶
        int boxMinMax[][]=new int[boxSize][2];
        for (int i = 0; i < boxSize; i++) {
            Arrays.fill(boxMinMax[i],-1);
        }
        for (int i = 0; i < nums.length; i++) {
            int boxIndex=(nums[i]-min)/d;
            if(boxMinMax[boxIndex][0]==-1)//将其放入到第boxIndex的桶中
            {
                boxMinMax[boxIndex][0]=boxMinMax[boxIndex][1]=nums[i];
            }
            else
            {
                boxMinMax[boxIndex][0]=Integer.min(boxMinMax[boxIndex][0],nums[i]);
                boxMinMax[boxIndex][1]=Integer.max(boxMinMax[boxIndex][1],nums[i]);
            }
        }
        int last=-1;
        for (int i = 0; i < boxSize; i++) {
            if(boxMinMax[i][0]==-1)
            {
                continue;
            }
            if(last!=-1)
            {
                maxGap=Integer.max(maxGap,boxMinMax[i][0]-boxMinMax[last][1]);
            }
            last=i;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        int[] nums={3,6,9,1};
        System.out.println(new MaximumGap_164().maximumGap(nums));
    }
}
