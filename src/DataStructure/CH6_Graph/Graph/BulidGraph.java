package DataStructure.CH6_Graph.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/6/5 21:24
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class BulidGraph {

    public static void main(String [] args) throws Exception{
        String filepath = "src\\DataStructure\\CH6_Graph\\Graph\\testGraph1.txt";
        //建立稀疏图
        SparseGraph sg = new SparseGraph(filepath);
        sg.Print();
        System.out.println(sg.edgenum);
        //建立稠密图
        DenseGraph dg = new DenseGraph(filepath);
        dg.Print();
        System.out.println(dg.edgenum);
    }

}
