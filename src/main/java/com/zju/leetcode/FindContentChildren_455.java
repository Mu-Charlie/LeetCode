package com.zju.leetcode;

import java.util.Arrays;

public class FindContentChildren_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result=0;
        int child_num=g.length;
        int cookie_num=s.length;
        int cur_index=0;
        for (int i = 0; i < cookie_num&& cur_index < child_num; i++) {
            if(s[i]>=g[cur_index])
            {
                result++;
                cur_index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] g={2,5,8};
        int[] s={1,4,7};
        System.out.println(new FindContentChildren_455().findContentChildren(g, s));
    }
}
