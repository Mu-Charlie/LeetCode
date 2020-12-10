package com.zju.leetcode;

import java.util.Arrays;

public class NewCoderminimumValue {
    public long minimumValueAfterDispel (int[] nums) {
        // write code here
        Arrays.sort(nums);
        long sum=0;
        long max=0;
        for (int j = 0; j < nums.length; j++) {
            sum+=nums[j];
            int index1=j;
            int index2=j;
            int index3=j;
            for (int i = 0; i <= j; i++) {
                while (index1>i&&nums[index1-1]>=(nums[j]-nums[i]))
                    index1--;
                while (index2>0&&nums[index2-1]>=nums[j]-nums[i])
                    index2--;
                while (index3<nums.length&&(long)nums[index3]<(long)nums[i]+nums[j])
                    index3++;
                long temp1=(index1-i)*(long)nums[i]+(j-index1)*((long)nums[j]-nums[i])+(nums.length-j)*(long)nums[j];
                long temp2=(i-index2)*((long)nums[j]-nums[i])+(j-i)*(long)nums[i]+(nums.length-j)*(long)nums[j];
                long temp3=(j-i)*(long)nums[i]+(index3-j)*(long)nums[j]+(nums.length-index3)*((long)nums[i]+nums[j]);
                max=Math.max(max,Math.max(temp1,Math.max(temp2,temp3)));
            }
        }
        return sum-max;
    }

    public static void main(String[] args) {
        int[] nums={2, 1, 3};
        System.out.println(new NewCoderminimumValue().minimumValueAfterDispel(nums));
    }
}
