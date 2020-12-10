package com.zju.leetcode;

public class NewCoderCombineWord {
    public String WordsMerge (String[] Words) {
        // write code here
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < Words.length; i++) {
            String str=Words[i];
            if(sb.length()==0)
            {
                sb.append(Words[i]);
            }
            else
            {
                int start=sb.length()-1;
                int end=0;
                while (true)
                {
                    if(start<0||end>=str.length()||sb.charAt(start)!=str.charAt(end))
                        break;
                    else
                    {
                        start--;
                        end++;
                    }
                }
                if(start!=sb.length()-1)
                {
                    sb=sb.delete(start+1,sb.length());
                }
                sb.append(str.substring(end));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] Wrods={"cab","bacdcc","ccd"};
        System.out.println(new NewCoderCombineWord().WordsMerge(Wrods));
    }
}
