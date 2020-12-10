package com.zju.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PDD_ListPad04 {
    public static void main(String[] args) {
        Scanner sin=new Scanner(System.in);
        while (sin.hasNext())
        {
            int offset=sin.nextInt();
            int n=sin.nextInt();
            int l1=sin.nextInt();
            int l2=sin.nextInt();
            //第一个列表的初始位置是offset或者是l1的长度
            int start1=Math.min(offset,l1);
            //在第一个列表已经除去offset后还剩下 left个
            int left=l1-offset;
            ArrayList<Integer> list=new ArrayList<>();
            Iterator<Integer> iterator = list.iterator();
            int end1=Math.min(l1,offset+n);
            //第一个列表用完后 还剩下left_n个商品
            int left_n=n-(end1-start1);
            int start2=Math.min(Math.max(offset-l1,0),l2);
            int end2=Math.min(start2+left_n,l2);
            System.out.println(start1+" "+end1+" "+start2+" "+end2);
        }
    }
}
