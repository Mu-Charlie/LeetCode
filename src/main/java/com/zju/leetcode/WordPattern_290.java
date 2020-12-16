package com.zju.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        LinkedHashMap<Character,String> map=new LinkedHashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(map.getOrDefault(pattern.charAt(i),"")=="")
            {
                map.put(pattern.charAt(i),"");
            }
        }
        HashMap<String,Character> remap=new HashMap<>();
        String[] strings = s.split(" ");
        if(strings.length!=pattern.length())
        {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            Character c = remap.getOrDefault(strings[i], '\0');
            if(c=='\0'&&remap.size()<map.size())
            {
                for (Character key : map.keySet()) {
                    if(map.get(key).equals(""))
                    {
                        map.put(key,strings[i]);
                        remap.put(strings[i],key);
                        break;
                    }
                }
                continue;
            }
            if(c!=pattern.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern="deadbeef";
        String str="d e a d b e e f";
        System.out.println(new WordPattern_290().wordPattern(pattern, str));
    }
}
