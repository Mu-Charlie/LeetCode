package com.zju.leetcode;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PartationLabels_763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result=new LinkedList<>();
        int[][] indexs=new int[2][26];
        Arrays.fill(indexs[0],Integer.MAX_VALUE);
        for (int i = 0; i < S.length(); i++) {
            char c=S.charAt(i);
            if(i<indexs[0][c-'a'])
            {
                indexs[0][c-'a']=i;
            }
            if(i>indexs[1][c-'a'])
            {
                indexs[1][c-'a']=i;
            }
        }
//        System.out.println(Arrays.toString(indexs[0]));
//        System.out.println(Arrays.toString(indexs[1]));
        int start=0;
        int end=0;
        for (int i = 0; i < S.length(); i++) {
            if(indexs[1][S.charAt(i)-'a']>end)
            {
                end=indexs[1][S.charAt(i)-'a'];
            }
            if(indexs[1][S.charAt(i)-'a']==end&&i==end)
            {
                result.add(end-start+1);
                if(i!=S.length()-1)
                {
                    start=i+1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String S="ababcbacadefegdehijhklij";
        System.out.println(Arrays.toString(new PartationLabels_763().partitionLabels(S).toArray()));
    }
}
