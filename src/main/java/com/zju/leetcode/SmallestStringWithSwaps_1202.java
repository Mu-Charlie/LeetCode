package com.zju.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SmallestStringWithSwaps_1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 将索引对之间的关系映射成图 寻找图中有几个联通分量，对每个联通分量对应的字符分别进行排序
        int[] flags=new int[s.length()];
        boolean[][] map=new boolean[s.length()][s.length()];
        //构建图
        for (int i = 0; i < pairs.size(); i++) {
            int index_1=pairs.get(i).get(0);
            int index_2=pairs.get(i).get(1);
            map[index_1][index_2]=true;
            map[index_2][index_1]=true;
        }
        int UnicomComponent=0;
        for (int i = 0; i < s.length(); i++) {
            if(flags[i]==0)
            {
                UnicomComponent+=1;
                travel(i,map,flags,UnicomComponent);
            }
        }
        StringBuilder sb=new StringBuilder(s);
        //遍历所有的连通分量
        for (int i = 0; i < UnicomComponent; i++) {
            int nums=0;
            for (int j = 0; j < flags.length; j++) {
                if(flags[j]==i+1)
                {
                    nums+=1;
                }
            }
            char[] chars=new char[nums];
            int count=0;
            for (int j = 0; j < flags.length; j++) {
                if(flags[j]==i+1)
                {
                    chars[count]=sb.charAt(j);
                    ++count;
                }
            }
            Arrays.sort(chars);
            count=0;
            for (int j = 0; j < flags.length; j++) {
                if(flags[j]==i+1)
                {
                    sb.setCharAt(j,chars[count]);
                    count++;
                }
            }
        }
        return sb.toString();
    }
    private void travel(int start,boolean[][] map,int[] flags,int flag)
    {
        flags[start]=flag;
        for (int i = 0; i < map[start].length; i++) {
            if(map[start][i]&&flags[i]==0)
            {
                travel(i,map,flags,flag);
            }
        }
    }

    public static void main(String[] args) {
        String s="cba";
        List<List<Integer>> pairs=new LinkedList<>();
        int[][] arraypairs={{0,1},{1,2}};
        for (int i = 0; i < arraypairs.length; i++) {
            List<Integer> list=new LinkedList<>();
            list.add(arraypairs[i][0]);
            list.add(arraypairs[i][1]);
            pairs.add(list);
        }
        System.out.println(new SmallestStringWithSwaps_1202().smallestStringWithSwaps(s, pairs));

    }
}
