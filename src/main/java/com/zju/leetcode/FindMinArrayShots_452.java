package com.zju.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class FindMinArrayShots_452 {
    public int findMinArrowShots(int[][] points) {//错误解法，时间复杂度过高
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0])
                {
                    return o1[0]-o2[0];
                }
                else
                {
                    return o1[1]-o2[1];
                }
            }
        });
        LinkedList<LinkedList<Integer>> combine_points=new LinkedList<>();
        for (int i = 0; i < points.length; i++) {
            LinkedList<Integer> list=new LinkedList<>();
            list.add(points[i][0]);
            list.add(points[i][1]);
            boolean flag=false;
            for (int j = 0; j < combine_points.size(); j++) {//从已经添加到候选区间中寻找是否存在有交集的
                LinkedList<Integer> temp_point = combine_points.get(j);//第j个候选区间
                int max_left=Math.max(points[i][0],temp_point.getFirst());//判断第j个候选区间与当前需要加入的区间左边界的最大值是否在另一个区间中 在另一个区间中则存在交集
                if(max_left>=points[i][0]&&max_left<=points[i][1]&&max_left>=temp_point.getFirst()&&max_left<=temp_point.getLast())
                {
                    flag=true;
                    int new_left=Math.max(points[i][0],temp_point.getFirst());
                    int new_right=Math.min(points[i][1],temp_point.getLast());
                    list.removeLast();
                    list.removeLast();
                    list.addLast(new_left);
                    list.addLast(new_right);
                    combine_points.remove(j);
                    combine_points.addFirst(list);
                    break;
                }
            }
            if(!flag)
            {
                combine_points.addLast(list);
            }
        }
        return combine_points.size();
    }
    public int findMinArrowShots2(int[][] points) {//标准解法
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points={{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(new FindMinArrayShots_452().findMinArrowShots(points));
    }
}