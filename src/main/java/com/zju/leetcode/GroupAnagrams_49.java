package com.zju.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new LinkedList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] array=str.toCharArray();
            Arrays.sort(array);
            String newString=new String(array);
            List<String> list=map.getOrDefault(newString, new LinkedList<>());
            list.add(str);
            map.put(newString,list);
        }
        return new LinkedList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs={};
        List<List<String>> lists = new GroupAnagrams_49().groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
