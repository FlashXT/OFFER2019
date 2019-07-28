package DataStructure.CH6_Graph.MinCostSpanningTree;

import DataStructure.CH6_Graph.DenseGraph;
import DataStructure.CH6_Graph.GraphTraverse.DFS;
import DataStructure.CH6_Graph.SparseGraph;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/6/9 20:32;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class TestMST {
    public static void main(String [] args) throws Exception {
        String filepath = "src\\DataStructure\\CH6_Graph\\MinCostSpanningTree\\MSTGraph.txt";
        //建立稠密图
//        DenseGraph dg = new DenseGraph(filepath);
//        dg.Print();
//        Prim.Prim(dg);
        //建立稀疏图
        SparseGraph sg = new SparseGraph(filepath);
        sg.Print();
//        Prim.Prim(sg);
        Kruskal.Kruskal(sg);
    }
}
