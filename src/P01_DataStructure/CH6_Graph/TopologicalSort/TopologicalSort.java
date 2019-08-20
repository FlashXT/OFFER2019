package P01_DataStructure.CH6_Graph.TopologicalSort;

import P01_DataStructure.CH6_Graph.DenseGraph;
import P01_DataStructure.CH6_Graph.Edge;
import P01_DataStructure.CH6_Graph.SparseGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/6/10 18:59;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class TopologicalSort {
    public static  void main(String [] args) throws Exception {
        String filepath = "src\\P01_DataStructure\\CH6_Graph\\TopologicalSort\\graph.txt";
        DenseGraph dg = new DenseGraph(filepath);

        dg.Print();
        topoloSort(dg);
        SparseGraph sg = new SparseGraph(filepath);
        sg.Print();
        topoloSort(sg);
    }
    public static ArrayList<Integer> topoloSort(DenseGraph dg){

        ArrayList<Integer> res = new ArrayList<>();
        //统计每个点的入度
        int [] indegree= new int[dg.nodenum];
        for(int i =0 ; i < dg.nodenum;i++){
            for(int j = 0; j < dg.nodenum;j++){
                if(!Double.isNaN(dg.adjMatrix[j][i])){
                    indegree[i]+=1;
                }
            }
        }
        while(hasNode(indegree,res)){
            for(int i =0; i< indegree.length;i++){
                if(indegree[i] == 0 && !res.contains(i)){
                    res.add(i);
                    for(int j =0 ; j < dg.nodenum;j++) {
                        if (!Double.isNaN(dg.adjMatrix[i][j])){
                            indegree[j]--;
                        }
                    }
                }
            }

        }
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }
    public static boolean hasNode(int [] indegree,ArrayList<Integer> res){

        for(int i =0 ; i < indegree.length;i++){
            if(!res.contains(i) && indegree[i] == 0)
                return true;
        }
        return false;
    }

    public static ArrayList<Integer> topoloSort(SparseGraph sg){

        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        //统计每个点的入度
        int [] indegree= new int[sg.nodenum];
        for(int i =0 ; i < sg.nodenum;i++){
            for(int j = 0; j < sg.adjlist.get(i).size();j++){
                 Edge e = sg.adjlist.get(i).get(j);
                    indegree[e.to]+=1;
            }

        }
        //将入度为0的结点直接入栈
        for(int i = 0; i < indegree.length;i++){
            if(indegree[i] == 0)
                stack.push(i);
        }
        while(!stack.isEmpty()){
            int node = stack.pop();
            res.add(node);
            //与node相连的结点的入度减1
            for(int j =0; j< sg.adjlist.get(node).size();j++){
                Edge e = sg.adjlist.get(node).get(j);
                indegree[e.to]--;
                if(indegree[e.to]==0)
                    stack.push(e.to);
            }

        }
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }
}
