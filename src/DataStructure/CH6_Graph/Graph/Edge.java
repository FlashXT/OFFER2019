package DataStructure.CH6_Graph.Graph;

public class Edge {
    public double weight;
    public Node from;
    public Node to;
    public Edge(double weight,Node from,Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}