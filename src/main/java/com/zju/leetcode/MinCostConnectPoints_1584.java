package com.zju.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinCostConnectPoints_1584 {
    public int minCostConnectPoints(int[][] points) {
        Edge[] edges=new Edge[(points.length*(points.length-1))/2];
//        System.out.println(edges.length);
        int count=0;
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges[count++]=new Edge(i,j,dist);
            }
        }
//        System.out.println(Arrays.toString(edges));
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost-o2.cost;
            }
        });
        int ans=0;
        int nums=1;
        UnionFind_1584 uf=new UnionFind_1584(points.length);
        for (Edge edge : edges) {
            int x=edge.from,y=edge.to,cost=edge.cost;
            if(uf.find(x)!=uf.find(y))
            {
                nums++;
                ans+=cost;
                uf.union(x,y);
                if(nums==points.length)
                {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points={{0,0}};
        System.out.println(new MinCostConnectPoints_1584().minCostConnectPoints(points));
    }
}
class UnionFind_1584{
    public int[] parent;
    public UnionFind_1584(int n)
    {
        parent=new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
    }
    public int find(int index)
    {
        if(parent[index]!=index)
        {
            parent[index]=find(parent[index]);
        }
        return parent[index];
    }
    public void union(int index1,int index2)
    {
        int root1=find(index1),root2=find(index2);
        parent[root1]=root2;
    }
}
class Edge{
    public int from;
    public int to;
    public int cost;
    public Edge(int from,int to,int cost)
    {
        this.from=from;
        this.to=to;
        this.cost=cost;
    }

//    @Override
//    public String toString() {
//        return "Edge{" +
//                "from=" + from +
//                ", to=" + to +
//                ", cost=" + cost +
//                '}';
//    }
}