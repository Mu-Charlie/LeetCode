package com.zju.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CommonChars_1002 {
    public List<String> commonChars(String[] A) {
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < A[0].length(); i++) {
            map.put(A[0].charAt(i),map.getOrDefault(A[0].charAt(i),0)+1);
        }
        for (int i = 1; i < A.length; i++) {
            String s=A[i];
            HashMap<Character,Integer> temp=new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                if(map.getOrDefault(s.charAt(j),0)>0)
                {
                    temp.put(s.charAt(j),temp.getOrDefault(s.charAt(j),0)+1);
                    map.put(s.charAt(j),map.get(s.charAt(j))-1);
                }
            }
            map=temp;
        }
        List<String> result=new LinkedList<>();
        for (Character character : map.keySet()) {
            int num=map.get(character);
            for (int i = 0; i < num; i++) {
                result.add(character.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] A={"cool"};
        System.out.println(Arrays.toString(new CommonChars_1002().commonChars(A).toArray()));
    }
}
