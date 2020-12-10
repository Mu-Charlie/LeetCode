package com.zju.leetcode;

public class ReturnToOrigin_657 {
    public boolean judgeCircle(String moves) {
        int l=0;
        int r=0;
        int u=0;
        int d=0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i))
            {
                case 'U':
                {
                    u++;
                    break;
                }
                case 'D':
                {
                    d++;
                    break;
                }
                case 'L':
                {
                    l++;
                    break;
                }
                case 'R':
                {
                    r++;
                    break;
                }
            }
        }
        if(u!=d||l!=r)
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ReturnToOrigin_657().judgeCircle("LL"));
    }
}
