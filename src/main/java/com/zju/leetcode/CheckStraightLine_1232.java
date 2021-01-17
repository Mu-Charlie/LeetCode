package com.zju.leetcode;

public class CheckStraightLine_1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<3)
        {
            return true;
        }
        int x1=coordinates[0][0],y1=coordinates[0][1];
        int x2=coordinates[1][0],y2=coordinates[1][1];
        int A=y2-y1,B=x2-x1;
        for (int i = 2; i < coordinates.length; i++) {
            int x=coordinates[i][0],y=coordinates[i][1];
            if(A*(x-x1)!=B*(y-y1))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coord={{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(new CheckStraightLine_1232().checkStraightLine(coord));
    }
}
