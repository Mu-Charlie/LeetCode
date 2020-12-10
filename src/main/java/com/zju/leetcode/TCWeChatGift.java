package com.zju.leetcode;

import javax.management.monitor.Monitor;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TCWeChatGift {
    public int getValue(int[] gifts, int n) {
        // write code here

        HashMap<Integer,Integer> countMap=new HashMap<>();
        int result=0;
        for (int i : gifts) {
            countMap.put(i,countMap.getOrDefault(i,0)+1);
            if(countMap.get(i)>=Math.ceil((double)n/2))
            {
                result=i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] gifts={1,1,3,2,2};
        System.out.println(new TCWeChatGift().getValue(gifts, 5));
    }
}
