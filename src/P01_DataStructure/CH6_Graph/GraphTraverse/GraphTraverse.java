package P01_DataStructure.CH6_Graph.GraphTraverse;

import P01_DataStructure.CH6_Graph.SparseGraph;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/6/5 21:24
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class GraphTraverse {

    public static void main(String [] args) throws Exception{
        String filepath = "src\\P01_DataStructure\\CH6_Graph\\TestGraph\\testGraph1.txt";
        //建立稀疏图
        SparseGraph sg = new SparseGraph(filepath);
        sg.Print();
        System.out.println(BFS.BFS(sg));
//        System.out.println(sg.edgenum);
        System.out.println(DFS.DFSTraverseNR(sg));
//        System.out.println(Solution1_DFS.DFSTraverse(sg));
        //建立稠密图
//        DenseGraph dg = new DenseGraph(filepath);
//        dg.Print();
//        System.out.println(Solution1_DFS.DFSTraverseNR(dg));
//        System.out.println(dg.edgenum);
//        System.out.println(Solution1_DFS.DFSTraverse(dg));
        //寻找路径
//        FindPath.FindPath(dg,1,7);
//        Solution2_BFS.Solution2_BFS(dg);
    }

}
