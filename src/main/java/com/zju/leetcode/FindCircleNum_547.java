package com.zju.leetcode;

public class FindCircleNum_547 {
    public int findCircleNum(int[][] M) {
        int ans=0;
        boolean flags[]=new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if(flags[i]==false)
            {
                ans++;
                search(M,i,flags);
            }
        }
        return ans;
    }
    private void search(int[][] M,int start,boolean[] flags)
    {
        flags[start]=true;
        for (int i = 0; i < M[start].length; i++) {
            if(M[start][i]==1&&flags[i]==false)
            {
                search(M,i,flags);
            }
        }
    }

    public static void main(String[] args) {
        int[][] M={{1}};
        System.out.println(new FindCircleNum_547().findCircleNum(M));
    }
}
