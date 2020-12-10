package com.zju.leetcode;

public class CloneMap_133 {
    Node nodes[]=new Node[101];
    boolean visited[]=new boolean[101];
    public Node cloneGraph(Node node) {
        if(node==null)
        {
            return null;
        }
        return clone(node);
    }
    public Node clone(Node node)
    {
        Node new_node;
        if(nodes[node.val]==null)
        {
            new_node=new Node();
            new_node.val=node.val;
            nodes[node.val]=new_node;
        }
        else
        {
            new_node=nodes[node.val];
        }
        if(visited[node.val])
        {
            return new_node;
        }
        visited[node.val]=true;

        for (int i = 0; i < node.neighbors.size(); i++) {
            new_node.neighbors.add(clone(node.neighbors.get(i)));
        }
        return new_node;
    }
}
