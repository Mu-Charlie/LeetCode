package com.zju.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverLapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<=1)
        {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        int result=0;
        int last_end=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<last_end)
            {
                result++;
                last_end=Math.min(intervals[i][1],last_end);
            }
            else {
                last_end = intervals[i][1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals={{1,2}};
        System.out.println(new EraseOverLapIntervals().eraseOverlapIntervals(intervals));
    }
}
