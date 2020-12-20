package com.zju.leetcode;

public class RemoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        int[] dict=new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i)-'a']+=1;
        }
        boolean[] count=new boolean[26];
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            dict[c-'a']--;
            if(!count[c-'a'])
            {
                if(sb.length()==0)
                {
                    sb.append(c);
                }
                else
                {
                    while(sb.length()!=0&&(sb.charAt(sb.length()-1)>=c&&dict[sb.charAt(sb.length()-1)-'a']>0))
                    {
                        count[sb.charAt(sb.length()-1)-'a']=false;
                        sb.deleteCharAt(sb.length()-1);
                    }
                    sb.append(c);
                }
                count[c-'a']=true;
            }
            else
            {
                int index=sb.length()-1;
                while (sb.charAt(index)!=c)
                {
                    index--;
                }
                if(index+1==sb.length()||sb.charAt(index+1)>c)
                {
                    continue;
                }
                else
                {
                    sb.deleteCharAt(index);
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="cbacdcbc";
        System.out.println(new RemoveDuplicateLetters_316().removeDuplicateLetters(s));
    }
}
