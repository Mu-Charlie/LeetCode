package com.zju.leetcode;

import java.util.HashMap;

public class UniqueOccurences_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        boolean flag=true;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        HashMap<Integer,Boolean> count=new HashMap<>();
        for (Integer integer : map.keySet()) {
            if(!count.getOrDefault(map.get(integer),false))
            {
                count.put(map.get(integer),true);
            }
            else
            {
                flag=false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr= {1,2};
        System.out.println(new UniqueOccurences_1207().uniqueOccurrences(arr));
    }
}
