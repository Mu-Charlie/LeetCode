package com.zju.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class ValidBrackets {
    public boolean isValid(String s) {
        LinkedList<Character> stack=new LinkedList<>();
        HashMap<Character,Character> bracketsmap=new HashMap<>();
        if(s.length()==0)
        {
            return true;
        }
        bracketsmap.put(')','(');
        bracketsmap.put('}','{');
        bracketsmap.put(']','[');
        stack.addFirst(s.charAt(0));
        int i;
        for ( i = 1; i < s.length(); i++) {
            char c=s.charAt(i);
            boolean flag=true;
            switch (c){
                case '(': case '{': case '[':
                {
                    stack.addFirst(c);
                    break;
                }
                case ')': case '}': case ']':
                {
                    if(stack.size()==0||stack.getFirst()!=bracketsmap.get(c))
                    {
                        flag=false;
                    }
                    else
                    {
                        stack.removeFirst();
                    }
                }
            }
            if(!flag)
            {
                break;
            }
        }
        if(!stack.isEmpty()||i<s.length())
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="{[]}";
        System.out.println(new ValidBrackets().isValid(s));
    }
}
