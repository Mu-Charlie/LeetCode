package com.zju.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SaiMa_360_1 {
    public static void main(String[] args) {
        int n,m;
        Scanner sin=new Scanner(System.in);
        n=sin.nextInt();
        m=sin.nextInt();
        int[] num=new int[n];
        for (int i = 0; i < n; i++) {
            num[i]=sin.nextInt();
        }
        Arrays.sort(num);
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(num[num.length-1]+1,num[num.length-1]+1);
        int j=n-1;
        int index = num[num.length-1];
        for (; index > 0 ; index--) {
            if(j>=0&&index==num[j])
            {
                map.put(index,map.get(index+1));
                j--;
            }
            else
            {
                map.put(index,index);
            }
        }
        for (int i = 0; i < m; i++) {
            int t=sin.nextInt();
            System.out.println(map.get(t));
        }
    }
}
