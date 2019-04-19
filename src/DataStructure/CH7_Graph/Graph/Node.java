package DataStructure.CH7_Graph.Graph;

import java.util.ArrayList;

public class Node{
    public int value;       //结点编号
    public int indegree;    //入度
    public int outdegree;   //出度
    public ArrayList<Node> nexts; // 由该结点作为from连接的结点集
    public ArrayList<Edge> egdes; // 该结点的边集
    public Node(int value){
        this.value = value;
        this.indegree = 0;
        this.outdegree = 0;
        this.nexts = new ArrayList<>();
        this.egdes = new ArrayList<>();
    }

}
