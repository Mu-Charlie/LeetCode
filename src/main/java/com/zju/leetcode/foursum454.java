package com.zju.leetcode;

import java.util.HashMap;

public class foursum454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        int count=0;
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<B.length;j++)
            {
                int temp=A[i]+B[j];
                if(map.containsKey(temp))
                {
                    map.put(temp,map.get(temp)+1);
                }
                else
                {
                    map.put(temp,1);
                }
            }
        }

        for(int i=0;i<C.length;i++)
        {
            for(int j=0;j<D.length;j++)
            {
                int temp=-(C[i]+D[j]);
                if(map.containsKey(temp))
                {
                    count+=map.get(temp);
                }
            }
        }
        return count;
    }
}
