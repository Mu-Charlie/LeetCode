package com.zju.leetcode;

public class MinCostClimbingStairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<2)
        {
            return 0;
        }
        int first=cost[0];
        int second=cost[1];
        int result=Integer.MAX_VALUE;
        for (int i = 2; i <= cost.length; i++) {
            result=Integer.min(first,second);
            if(i<cost.length)
            {
                first=second;
                second=result+cost[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] cost={1, 100};
        System.out.println(new MinCostClimbingStairs_746().minCostClimbingStairs(cost));
    }
}
