package com.zju.leetcode;

public class InsertIntervals_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[] last={intervals[0][0]-1,intervals[0][0]-1};
        int combine=-1;
        int start=0;
        int end=0;
        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[0]>=last[0]&&newInterval[0]<intervals[i][0])
            {
                start=i-1;
                if(newInterval[0]<=last[1])
                {
                    combine+=1;
                }
            }
            if(intervals[i][0]>newInterval[0]&&intervals[i][0]<=newInterval[1])
            {
                combine++;
            }
            if(intervals[i][1]<newInterval[1])
            {
                end=i+1;
            }
            if(intervals[i][0]>newInterval[1])
            {
                break;
            }
        }
        int[][] result=new int[intervals.length-combine][2];
        int j=0;
        for (int i = 0; i < intervals.length; i++) {
            if(i==start)
            {

            }
            else
            {
                result[j][0]=intervals[i][0];
                result[j][1]=intervals[i][1];
            }
            j++;
        }
        return result;
    }
}
