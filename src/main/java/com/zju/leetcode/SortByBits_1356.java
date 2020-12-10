package com.zju.leetcode;

import java.util.*;

public class SortByBits_1356 {
    public int[] sortByBits(int[] arr) {
        List<Integer> list=new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int length1=0,length2=0;
                int flag=1;
                for (int i = 0; i < 15; i++) {
                    if((o1&flag)!=0)
                    {
                        length1++;
                    }
                    if((o2&flag)!=0)
                    {
                        length2++;
                    }
                    flag<<=1;
                }
                if(length1-length2!=0)
                {
                    return length1-length2;
                }
                else
                {
                    return o1-o2;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={10,100,1000,10000};
        System.out.println(Arrays.toString(new SortByBits_1356().sortByBits(arr)));
//        System.out.println("hello");
    }
}
