package com.zju.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class NewCoderXiangqi {
    public static String playchess (String[] chessboard) {
        // write code here
        char[][] board=new char[chessboard.length][chessboard[0].length()];
        for (int i = 0; i < chessboard.length; i++) {
            board[i]=chessboard[i].toCharArray();
        }
        char[] chesses={'J','P','C','B'};
        HashMap<Character,ArrayList<Integer>> indexs=new HashMap<Character, ArrayList<Integer>>();
        boolean flag=false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(flag)
                {
                    break;
                }
                switch (board[i][j])
                {
                    case 'C':
                    {
                        if(moveC(board,i,j))
                        {
                            flag=true;
                        }
                        break;
                    }
                    case 'B':
                    {
                        if(moveB(board,i,j))
                        {
                            flag=true;
                        }
                        break;
                    }
                    case 'P':
                    {
                        if(moveP(board,i,j))
                        {
                            flag=true;
                        }
                        break;
                    }
                    case 'J':
                    {
                        if(moveJ(board,i,j))
                        {
                            flag=true;
                        }
                        break;
                    }
                }
            }
        }
        if(flag)
        {
            return "Happy";
        }
        return "Sad";
    }
    public static boolean moveB(char[][] board,int x,int y)
    {
        if(x-1>=0&&board[x-1][y]=='j'||y-1>=0&&board[x][y-1]=='j')
        {
            return true;
        }
        if(x+1<board.length&&board[x+1][y]=='j'||y+1<board[0].length&&board[x][y+1]=='j')
        {
            return true;
        }
        return false;
    }
    public static boolean moveJ(char[][] board,int x,int y)
    {
        return moveB(board,x,y);
    }
    public static boolean moveC(char[][] board,int x,int y)
    {
        for (int i = 0; i < board.length; i++) {
            if(board[i][y]=='j')
            {
                return true;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if(board[x][i]=='j')
            {
                return true;
            }
        }
        return false;
    }
    public static boolean moveP(char[][] board,int x,int y)
    {
        boolean finded=false;
        int j_x=-1,j_y=-1;
        for (int i = 0; i < board.length; i++) {
            if(board[i][y]=='j')
            {
                finded=true;
                j_x=i;
            }
        }
        if(finded)
        {
            int start_x=Math.min(x,j_x);
            int end_x=Math.max(x,j_x);
            int chess_count=0;//统计P和j之间棋子个数
            for (int i = start_x+1; i < end_x; i++) {
                if(board[i][y]!='.')
                {
                    chess_count++;
                }
            }
            if(chess_count==1)//刚好有一个
            {
                return true;
            }
        }
        else{
            for (int i = 0; i < board[0].length; i++) {
                if(board[x][i]=='j')
                {
                    finded=true;
                    j_y=i;
                }
            }
            if(finded)
            {
                int start_y=Math.min(y,j_y);
                int end_y=Math.max(y,j_y);
                int chess_count=0;//统计P和j之间棋子个数
                for (int i = start_y+1; i < end_y; i++) {
                    if(board[x][i]!='.')
                    {
                        chess_count++;
                    }
                }
                if(chess_count==1)//刚好有一个
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] chessboard={"......", "..B...", "P.C.j.", "......", "..b..."," ...J.."};
        System.out.println(playchess(chessboard));
    }
}
