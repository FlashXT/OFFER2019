package DataStructure.CH6_Graph.Graph;

import java.util.ArrayList;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/31 12:15
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class TestBulidGraph {
    public static  void main(String [] args){
        double[][] adjmatrix = {{1,1,0,3},
                                {2,0,2,1},
                                {1,3,4,2},
                                {8,5,6,7}
                             };
        DenseGraph g = new DenseGraph(adjmatrix,false);
        System.out.println(g.nodenum);
        g.addedge(0,3,1);
        System.out.println(g.nodenum);
        System.out.println(g.edgenum);
        g.getEdge(0);
        ArrayList<ArrayList<Edge>> list = new  ArrayList<ArrayList<Edge>>();
        ArrayList<Edge> node0 = new ArrayList<>();
        node0.add(new Edge(0,0,1));
        node0.add(new Edge(0,1,1));
        node0.add(new Edge(0,3,3));
        ArrayList<Edge> node1 = new ArrayList<>();
        node1.add(new Edge(1,0,2));
        node1.add(new Edge(1,2,2));
        node1.add(new Edge(1,3,1));
        ArrayList<Edge> node2 = new ArrayList<>();
        node2.add(new Edge(2,0,1));
        node2.add(new Edge(2,1,3));
        node2.add(new Edge(2,2,4));
        node2.add(new Edge(2,3,2));
        ArrayList<Edge> node3 = new ArrayList<>();
        node3.add(new Edge(3,0,8));
        node3.add(new Edge(3,1,5));
        node3.add(new Edge(3,2,6));
        node3.add(new Edge(3,3,7));

        list.add(node0);list.add(node1);
        list.add(node2);list.add(node3);
        SparseGraph g2 = new SparseGraph(list,false);
        System.out.println(g2.nodenum);
        System.out.println(g2.edgenum);
        g2.addedge(0,2,3.4);
        System.out.println(g2.edgenum);
        g2.getEdge(0);
    }
}
