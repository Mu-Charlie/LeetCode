package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SplitIntoFibonacci_842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result=new LinkedList<>();
        search(result,S,0,0, 0);
        return result;
    }
    public boolean search(List<Integer> list,String S,int start,int sum,int pre)
    {
        if(start==S.length())
        {
            return list.size()>2;
        }
        long curLong=0;
        for (int i = start; i < S.length(); i++) {
            if(i>start&&S.charAt(start)=='0')
            {
                break;
            }
            curLong=curLong*10+(S.charAt(i)-'0');
            if(curLong>Integer.MAX_VALUE)
            {
                break;
            }
            int cur=(int)curLong;
            if(list.size()>=2)
            {
                if(cur<sum)
                {
                    continue;
                }
                else if(cur>sum)
                {
                    break;
                }
            }
            list.add(cur);
            if(search(list,S,i+1,pre+cur,cur))
            {
                return true;
            }
            else
            {
                list.remove(list.size()-1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String S="11235813";
        System.out.println(Arrays.toString(new SplitIntoFibonacci_842().splitIntoFibonacci(S).toArray()));
    }
}
