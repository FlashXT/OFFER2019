package DataStructure.CH7_Graph.GraphDefination;

import DataStructure.CH7_Graph.GraphDefination.*;

/********************************************************
 * matrix形式：(一行表示一条边，(权重，始点，终点))
 *              [
 *                  [weigth,from,to]
 *                  [weigth,from,to]
 *
 *                  ...
 *
 *                  [weigth,from,to]    ]
 ********************************************************/
public class createGraph{
    public static void main(String [] args){

    }
    public  static Graph createGraph(Integer[][]matrix){
        Graph graph = new Graph();
        for(int i =0;i < matrix.length;i++){
            Integer weight  = matrix[i][0];
            Integer from    = matrix[i][1];
            Integer to      = matrix[i][2];
            if(!graph.nodes.containsKey(from))
                graph.nodes.put(from,new Node(from));
            if(!graph.nodes.containsKey(to))
                graph.nodes.put(to,new Node(to));
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight,fromNode,toNode);
            fromNode.nexts.add(toNode);
            fromNode.egdes.add(newEdge);
            fromNode.outdegree++;
            toNode.indegree++;
            graph.edges.add(newEdge);

        }
        return graph;
    }
}
