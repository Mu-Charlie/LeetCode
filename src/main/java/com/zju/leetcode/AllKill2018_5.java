package com.zju.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AllKill2018_5 {
    public static void main(String[] args) {
        int n,m;
        List<Integer> list=new ArrayList<Integer>();
        Scanner sin=new Scanner(System.in);
        n=sin.nextInt();
        m=sin.nextInt();
        for (int i = 0; i < m; i++) {
            list.add(sin.nextInt());
        }

        Collections.sort(list);

        int max_value=0;
        int price=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)*(Math.min(n,m-i))>max_value)
            {
                max_value=list.get(i)*(Math.min(n,m-i));
                price=list.get(i);
            }
        }
        System.out.println(price);
    }
}
