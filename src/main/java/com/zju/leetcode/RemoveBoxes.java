package com.zju.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int result=0;
        int total_num[]=new int[101];
        LinkedList<Integer> color_list=new LinkedList<>();
        LinkedList<Integer> color_num_list=new LinkedList<>();
        int last=-1;
        for (int i = 0; i < boxes.length; i++) {
            total_num[boxes[i]]++;
            if(boxes[i]==last)
            {
                color_num_list.set(color_num_list.size()-1,color_num_list.getLast()+1);
            }
            else
            {
                color_list.addLast(boxes[i]);
                color_num_list.addLast(1);
            }
            last=boxes[i];
        }
        System.out.println(Arrays.toString(color_list.toArray()));
        System.out.println(Arrays.toString(color_num_list.toArray()));
        System.out.println("==============================");
        while (color_list.size()>0)
        {
            int min_cost=Integer.MAX_VALUE;
            int min_cost_index=-1;
            for (int i = 0; i < color_list.size(); i++) {
                int cur_color=color_list.get(i);
                int cur_color_num=color_num_list.get(i);
                int total_cur_num=total_num[cur_color];
                int earn=0;
                if(i-1>=0&&i+1<color_list.size()&&color_list.get(i-1)==color_list.get(i+1))
                {
                    earn=color_num_list.get(i-1)+color_num_list.get(i+1);
                }
                int cost=total_cur_num*total_cur_num-((total_cur_num-cur_color_num)*(total_cur_num-cur_color_num))-(cur_color_num*cur_color_num)-earn;
//                cost=cost-earn;
                if(cost<min_cost)
                {
                    min_cost=cost;
                    min_cost_index=i;
                }
            }
            int min_cost_num=color_num_list.get(min_cost_index);
            total_num[color_list.get(min_cost_index)]-=min_cost_num;
            result+=min_cost_num*min_cost_num;
            if(min_cost_index-1>=0&&min_cost_index+1<color_list.size()&&color_list.get(min_cost_index-1)==color_list.get(min_cost_index+1))
            {
                int new_num=color_num_list.get(min_cost_index-1)+color_num_list.get(min_cost_index+1);
                int color=color_list.get(min_cost_index-1);
                color_list.remove(min_cost_index-1);
                color_list.remove(min_cost_index-1);
                color_list.remove(min_cost_index-1);
                color_list.add(min_cost_index-1,color);
                color_num_list.remove(min_cost_index-1);
                color_num_list.remove(min_cost_index-1);
                color_num_list.remove(min_cost_index-1);
                color_num_list.add(min_cost_index-1,new_num);
            }
            else
            {
                color_list.remove(min_cost_index);
                color_num_list.remove(min_cost_index);
            }
            System.out.println(result);
            System.out.println(Arrays.toString(color_list.toArray()));
            System.out.println(Arrays.toString(color_num_list.toArray()));
            System.out.println("==============================");
        }
        return result;
    }

    public static void main(String[] args) {
        int[] boxs={5,8,3,8,4,8,5,7,4,2};
        System.out.println(new RemoveBoxes().removeBoxes(boxs));
    }
}
