package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargeGroupPosition_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans=new LinkedList<>();
        int start=0,end=0;
        while (end<s.length())
        {
            if(s.charAt(end)!=s.charAt(start))
            {
                if(end-start>=3)
                {
                    List<Integer> position=new LinkedList<>();
                    position.add(start);
                    position.add(end-1);
                    ans.add(position);
                }
                start=end;
            }
            else
            {
                if(end==s.length()-1&&end-start+1>=3)
                {
                    List<Integer> position=new LinkedList<>();
                    position.add(start);
                    position.add(end);
                    ans.add(position);
                }
            }
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="aba";
        List<List<Integer>> lists = new LargeGroupPosition_830().largeGroupPositions(s);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
