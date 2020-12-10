package com.zju.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WeekContest119_1 {
    public static String restoreString(String s, int[] indices) {
        StringBuffer new_s=new StringBuffer();
        Map<Integer,Integer> indice_map=new HashMap<Integer, Integer>();
        for (int i = 0; i < indices.length; i++) {
            indice_map.put(indices[i],i);
        }
        for (int i = 0; i < indices.length; i++) {
            new_s.append(s.charAt(indice_map.get(i)));
        }
        return new_s.toString();
    }

    public static void main(String[] args) {
//        String s="codeleet";
//        int indices[]={4,5,6,7,0,2,1,3};
        String s="aiohn";
        int indices[]={3,1,4,2,0};
        System.out.println(restoreString(s,indices));
    }
}
