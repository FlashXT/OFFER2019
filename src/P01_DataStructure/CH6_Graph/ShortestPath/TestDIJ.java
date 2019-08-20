package P01_DataStructure.CH6_Graph.ShortestPath;

import P01_DataStructure.CH6_Graph.DenseGraph;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/6/10 15:36;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class TestDIJ {
    public static void main(String [] args) throws Exception {
        String filepath = "src\\P01_DataStructure\\CH6_Graph\\ShortestPath\\graph.txt";
        DenseGraph dg = new DenseGraph(filepath);
        dg.Print();
        Dijkstra.Dijkstra(dg,0);
    }

}
