package com.zju.leetcode;

public class IslandPerimeter_463 {
    static int[] move_x={0,-1,0,1};
    static int[] move_y={-1,0,1,0};
    public int islandPerimeter(int[][] grid) {
        int counts=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1)
                {
                    int sum=4;
                    for (int k = 0; k < 4; k++) {
                        int n_i=i+move_x[k];
                        int n_j=j+move_y[k];
                        if(n_i>=0&&n_j>=0&&n_i<grid.length&&n_j<grid[0].length&&grid[n_i][n_j]==1)
                        {
                            sum--;
                        }
                    }
                    counts+=sum;
                }
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        int[][] grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(new IslandPerimeter_463().islandPerimeter(grid));
    }
}
