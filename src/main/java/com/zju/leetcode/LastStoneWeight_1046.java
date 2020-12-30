package com.zju.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }
        while (queue.size()>1)
        {
            int a=queue.poll();
            int b=queue.poll();
            if(a-b!=0)
            {
                queue.add(a-b);
            }
        }
        if(queue.size()==0)
        {
            return 0;
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] stones={2,7,4,1,8,1};
        System.out.println(new LastStoneWeight_1046().lastStoneWeight(stones));
    }
}
