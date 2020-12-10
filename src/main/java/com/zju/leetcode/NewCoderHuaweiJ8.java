package com.zju.leetcode;

import java.util.Scanner;
import java.util.TreeMap;

public class NewCoderHuaweiJ8 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        int n=sin.nextInt();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int index=sin.nextInt();
            int value=sin.nextInt();
            int new_value=map.getOrDefault(index,0)+value;
            map.put(index,new_value);
        }
        map.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
    }
}
