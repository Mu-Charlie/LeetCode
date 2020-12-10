package com.zju.leetcode;

import java.util.Arrays;

public class RoundRegion_130 {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='X'||board[i][j]=='U')
                {
                    continue;
                }
                else
                {
                    if(check(board,i,j,'T'))
                    {
                        check(board,i,j,'X');
                    }
                    else
                    {
                        check(board,i,j,'U');
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='U')
                {
                    board[i][j]='O';
                }
            }
        }
    }
    public boolean check(char[][] board,int x,int y,char new_target)
    {

        if(x<0||x>=board.length||y<0||y>=board[0].length)
        {
            return false;
        }
        if(board[x][y]=='X'||board[x][y]==new_target)
        {
            return true;
        }
        board[x][y]=new_target;
        boolean flag1,flag2,flag3,flag4;
        flag1=check(board,x,y-1,new_target);
        flag2=check(board,x-1,y,new_target);
        flag3=check(board,x,y+1,new_target);
        flag4=check(board,x+1,y,new_target);
        return flag1&&flag2&&flag3&&flag4;
    }

    public static void main(String[] args) {
        char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new RoundRegion_130().solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
