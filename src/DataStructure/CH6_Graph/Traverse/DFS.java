package DataStructure.CH6_Graph.Traverse;

import DataStructure.CH6_Graph.Graph.Graph;
import DataStructure.CH6_Graph.Graph.Node;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    public static void main(String [] args){
        Integer[][]matrix = {
                {3,1,2},
                {2,2,3},
                {1,1,4},
                {3,2,5},
                {4,5,3},
                {2,3,5}};
        Graph g= new Graph(matrix);
        DFSTraverse(g);
    }
    public static void DFSTraverse(Graph g){
        if(g.nodes.size() == 0) return ;
        Node node = g.nodes.get(g.nodes.keySet().toArray()[0]);

        Set<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack();
        set.add(node);
        stack.add(node);
        System.out.printf("%-4d",node.value);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node next:cur.nexts){
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    System.out.printf("%-4d",next.value);
                    set.add(next);
                    break;
                }
            }
        }
        System.out.println();

    }
}
