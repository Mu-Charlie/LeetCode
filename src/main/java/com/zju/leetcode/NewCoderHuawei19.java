package com.zju.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class NewCoderHuawei19 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        LinkedHashMap<String,Integer> map=new LinkedHashMap<>();
        while (sin.hasNext())
        {
            String s=sin.nextLine();
            String file_line[]=s.split(" ");
            String[] file = file_line[0].split("\\\\");
            String file_name = file[file.length - 1];
            if(file_name.length()>16)
            {
                file_name=file_name.substring(file_name.length()-16,file_name.length());
            }
            String file_name_line = file_name+" "+file_line[file_line.length-1];
            map.put(file_name_line,map.getOrDefault(file_name_line,0)+1);
        }
        int start=0;
        if(map.keySet().size()<=8)
        {
            start=0;
        }
        else
        {
            start=map.keySet().size()-8;
        }
        int count=0;
        for (String s : map.keySet()) {
            if(count>=start)
            {
                System.out.println(s+" "+map.get(s));
            }
            count++;
        }
    }
}
