package com.zju.leetcode;

public class SearchWord_79 {
    static int[] move_x={0,-1,0,1};
    static int[] move_y={-1,0,1,0};
    public static void main(String[] args) {
        String word="ABCB";
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//        char[][] board={{'A'}};
        System.out.println(new SearchWord_79().exist(board, word));
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] flag=new boolean[board.length][board[0].length];
                if(search(board,i,j,word,0,flag))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board,int i,int j,String word,int start,boolean[][] flag)
    {

        if(start==word.length()-1&&word.charAt(start)==board[i][j])
        {
            return true;
        }
        boolean result=false;
        if(board[i][j]==word.charAt(start))
        {
            flag[i][j]=true;
            for (int k = 0; k < 4; k++) {
                int n_i=i+move_x[k],n_j=j+move_y[k];
                if(n_i>=0&&n_i<board.length&&n_j>=0&&n_j<board[0].length&&!flag[n_i][n_j])
                {
                    result=result||search(board,n_i,n_j,word,start+1,flag);
                }
            }
            flag[i][j]=false;
            return result;
        }
        else
        {
            return false;
        }
    }
}
