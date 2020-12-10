package com.zju.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Image_733 {
    int move_x[]={0,-1,0,1};
    int move_y[]={-1,0,1,0};
    boolean visited[][]=new boolean[51][51];
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target=image[sr][sc];
        fill(image,sr,sc,target,newColor);
        return image;
    }
    public void fill(int[][] image,int x,int y,int target,int newColor)
    {
        visited[x][y]=true;
        image[x][y]=newColor;
        for (int i = 0; i < 4; i++) {
            if(x+move_x[i]<0||x+move_x[i]>=image.length||y+move_y[i]<0||y+move_y[i]>=image[0].length||visited[x+move_x[i]][y+move_y[i]])
            {
                continue;
            }
            if(image[x+move_x[i]][y+move_y[i]]==target)
            {
                fill(image,x+move_x[i],y+move_y[i],target,newColor);
            }
        }
    }

    public static void main(String[] args) {
        int image[][]={{0,0,0},{0,1,1}};
        new Image_733().floodFill(image,1,1,1);
        for (int[] ints : image) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
