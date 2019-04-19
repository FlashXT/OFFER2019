package DataStructure.CH7_Graph.Graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
    public Graph(Integer[][]matrix){
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();

        for(int i =0;i < matrix.length;i++){
            Integer weight  = matrix[i][0];
            Integer from    = matrix[i][1];
            Integer to      = matrix[i][2];
            if(!this.nodes.containsKey(from))
                this.nodes.put(from,new Node(from));
            if(!this.nodes.containsKey(to))
                this.nodes.put(to,new Node(to));
            Node fromNode = this.nodes.get(from);
            Node toNode = this.nodes.get(to);
            Edge newEdge = new Edge(weight,fromNode,toNode);
            fromNode.nexts.add(toNode);
            fromNode.egdes.add(newEdge);
            fromNode.outdegree++;
            toNode.indegree++;
            this.edges.add(newEdge);

        }
    }
}
