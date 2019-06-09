package DataStructure.CH6_Graph.GraphTraverse;

import DataStructure.CH6_Graph.DenseGraph;

import java.util.ArrayList;
import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/6/9 9:22;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class FindPath {
    public static int [] path;
    public static boolean [] visited;

    public static boolean hasPath(DenseGraph g,int from,int to){
        DFSDg(g,from);
        return !(path[to] == -1);
    }
    public static ArrayList<Integer> FindPath(DenseGraph g,int from,int to){
        visited = new boolean[g.nodenum];
        path = new int[g.nodenum];
        for(int i = 0; i < path.length;i++){
            path[i] = -1;
        }
        DFSDg(g,from);
        if(hasPath(g,from,to)){
            Stack<Integer> stack = new Stack();
            int i = to;
            while(i >=0){
                stack.push(i);
                i = path[i];
            }
            ArrayList<Integer> res = new ArrayList<>();
            while(!stack.isEmpty()){
                res.add(stack.pop());
            }
            showPath(res);
            return res;
        }
        return null;



    }
    private static void showPath(ArrayList<Integer> list){
        if (list!=null){
            for(int i = 0; i < list.size();i++){
                System.out.print(list.get(i));
                if (i!= list.size()-1)
                    System.out.print(" -> ");
            }
            System.out.println();
        }

    }
    public static void DFSDg(DenseGraph g,int node){
        visited[node] = true;

        for (int j = 0; j < g.nodenum;j++){
            if( !visited[j]&& g.adjMatrix[node][j]!=0){
                path[j] = node;
                DFSDg(g,j);
            }

        }

    }
}
