package com.zju.leetcode;

import java.util.Arrays;

public class SolveSudoku {
    static boolean box_flag[][]=new boolean[9][9];
    static boolean row_flag[][]=new boolean[9][9];
    static boolean col_flag[][]=new boolean[9][9];
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.')
                {
                    int num=board[i][j]-'0'-1;
                    box_flag[(i/3)*3+(j/3)][num]=true;
                    row_flag[i][num]=true;
                    col_flag[j][num]=true;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.')
                {
                    dfs(board,i,j);
                    break;
                }
            }
        }
    }
    public boolean dfs(char[][] board,int start_x,int start_y)
    {
        boolean flag=false;
        for (int k = 0; k < 9; k++) {
            if(!box_flag[(start_x/3)*3+(start_y/3)][k]&&!row_flag[start_x][k]&&!col_flag[start_y][k])
            {
                box_flag[(start_x/3)*3+(start_y/3)][k]=true;
                row_flag[start_x][k]=true;
                col_flag[start_y][k]=true;
                board[start_x][start_y]= (char) ('0'+k+1);
                if(check())
                {
                    return true;
                }
                int n_start_x=start_x;
                int n_start_y=start_y;
                boolean start_flag=false;
                for (int i = 0; i < 9; i++) {
                    boolean finded=false;
                    for (int j = 0; j < 9; j++) {
                        if(i==start_x&&j==start_y)
                        {
                            start_flag=true;
                        }
                        if(start_flag&&board[i][j]=='.')
                        {
                            n_start_x=i;
                            n_start_y=j;
                            finded=true;
                            break;
                        }
                    }
                    if(finded)
                    {
                        break;
                    }
                }
                flag=dfs(board,n_start_x,n_start_y);
                if(flag)
                {
                    break;
                }
                box_flag[(start_x/3)*3+(start_y/3)][k]=false;
                row_flag[start_x][k]=false;
                col_flag[start_y][k]=false;
                board[start_x][start_y]= '.';
            }
        }
        return flag;
    }
    public boolean check()
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(!(box_flag[i][j]&&col_flag[i][j]&&row_flag[i][j]))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] board={{'5','3','.','.','7','.','.','.','.'},
//                        {'6','.','.','1','9','5','.','.','.'},
//                        {'.','9','8','.','.','.','.','6','.'},
//                        {'8','.','.','.','6','.','.','.','3'},
//                        {'4','.','.','8','.','3','.','.','1'},
//                        {'7','.','.','.','2','.','.','.','6'},
//                        {'.','6','.','.','.','.','2','8','.'},
//                        {'.','.','.','4','1','9','.','.','5'},
//                        {'.','.','.','.','8','.','.','7','9'}};
        char[][] board={{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        new SolveSudoku().solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
