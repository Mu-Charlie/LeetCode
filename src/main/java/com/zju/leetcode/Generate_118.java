package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Generate_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new LinkedList<>();
        if(numRows==0)
        {
            return result;
        }
        result.add(new LinkedList<>());
        result.get(0).add(1);
        if(numRows==1)
        {
            return result;
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> cur=new LinkedList<>();
            cur.add(1);
            for (int j = 1; j < i-1 ; j++) {
                int n=result.get(i-2).get(j)+result.get(i-2).get(j-1);
                cur.add(n);
            }
            cur.add(1);
            result.add(cur);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> list=new Generate_118().generate(6);
        for (List<Integer> nums : list) {
            System.out.println(Arrays.toString(nums.toArray()));
        }
    }
}
