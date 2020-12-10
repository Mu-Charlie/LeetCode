package com.zju.leetcode;

public class canCompleteCircuit_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size=gas.length;
        int i=0;
        while (i<size)
        {
            int bas=0;
            int total_gas=0;
            int total_cost=0;
            while (bas<size)
            {
                int j=(i+bas)%size;
                total_cost+=cost[j];
                total_gas+=gas[j];
                if(total_cost>total_gas)
                {
                    break;
                }
                bas++;
            }
            if(bas==size)
            {
                return i;
            }
            else
            {
                i=i+bas+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas={2,3,4};
        int[] cost={3,4,3};
        System.out.println(new canCompleteCircuit_134().canCompleteCircuit(gas,cost));
    }
}
