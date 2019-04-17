package DataStructure.CH7_Graph.Traverse;

import DataStructure.CH7_Graph.GraphDefination.Graph;
import DataStructure.CH7_Graph.GraphDefination.Node;
import DataStructure.CH7_Graph.GraphDefination.createGraph;

import java.util.*;

public class BFS {
    public static void main(String [] args){
        Integer[][]matrix = {
                {3,1,2},
                {2,2,3},
                {1,1,4},
                {3,2,5},
                {4,5,3},
                {2,3,4}};
        Graph g= createGraph.createGraph(matrix);
        BFSTraverse(g);
    }
    public static void BFSTraverse(Graph g){
        if(g.nodes.size() == 0) return ;
        Node node = g.nodes.get(g.nodes.keySet().toArray()[0]);

        Set<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        set.add(node);
        queue.add(node);

        while(!queue.isEmpty()){

            Node cur = queue.poll();
            System.out.printf("%-4d",node.value);
            for(Node next:cur.nexts){
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);

                }
            }
        }
        System.out.println();

    }
}
