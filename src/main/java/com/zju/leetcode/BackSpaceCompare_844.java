package com.zju.leetcode;

import java.util.LinkedList;

public class BackSpaceCompare_844 {
    public boolean backspaceCompare(String S, String T) {
        LinkedList<Character> s_list=new LinkedList<>();
        LinkedList<Character> t_list=new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='#')
            {
                if(s_list.size()==0)
                {
                    continue;
                }
                else
                {
                    s_list.removeLast();
                }
            }
            else
            {
                s_list.addLast(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if(T.charAt(i)=='#')
            {
                if(t_list.size()==0)
                {
                    continue;
                }
                else
                {
                    t_list.removeLast();
                }
            }
            else
            {
                t_list.addLast(T.charAt(i));
            }
        }
        if(s_list.size()==t_list.size())
        {
            for (int i = 0; i < s_list.size(); i++) {
                if(s_list.get(i)!=t_list.get(i))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String S="a#c";
        String T="b";
        System.out.println(new BackSpaceCompare_844().backspaceCompare(S, T));
    }
}
