package DataStructure.CH6_Graph.GraphTraverse;

import DataStructure.CH6_Graph.DenseGraph;
import DataStructure.CH6_Graph.SparseGraph;

import java.util.Stack;


/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/6/9 9:22;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//图的深度优先遍历
public class DFS{
    //该数组用来标记结点是否访问过
    private static boolean [] visited;

    public static int DFSTraverse(DenseGraph g){
        visited = new boolean[g.nodenum];
        //记录连通分量的个数
        int compent = 0;
        for (int i = 0; i < visited.length;i++){
            if (!visited[i]){
                compent++;
                DFSDg(g,i);
                System.out.println();
            }

        }
        return compent;

    }
    public static  void DFSDg(DenseGraph g,int node){
        visited[node] = true;
        System.out.print(node+"\t");

        for (int j = 0; j < g.nodenum;j++){
            if( !visited[j]&& !Double.isNaN(g.adjMatrix[node][j]))
                DFSDg(g,j);
        }

    }

    public static int DFSTraverse(SparseGraph g){
        visited = new boolean[g.nodenum];
        //记录连通分量的个数
        int compent = 0;
        for (int i = 0; i < visited.length;i++){
            if (!visited[i]){
                compent++;
                DFSSg(g,i);
                System.out.println();
            }
        }
        return compent;

    }
    public static  void DFSSg(SparseGraph g,int node){
        visited[node] = true;
        System.out.print(node+"\t");
        for (int j = 0; j < g.adjlist.get(node).size();j++){
            int to = g.adjlist.get(node).get(j).to;
            if( !visited[to])
                DFSSg(g,to);
        }

    }
    //DFS非递归
    public static int  DFSTraverseNR(DenseGraph g){
        boolean [] visited = new boolean[g.nodenum];
        int [] path = new int[g.nodenum]; //记录路径的数组
        int compent = 1; //记录连通分量，连通图的连通分量为1
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < path.length;i++){
            path[i] = -1;
        }
        int i = 0,temp;
        while(!isAllVisited(visited)){
            //如果该节点未倍遍历过，则压栈，输出
            if(!visited[i]){
                visited[i] = true;
                stack.push(i);
                System.out.print(i+"\t");
            }
            temp =i;
            //然后转向与该结点连接且未遍历过的结点
            for(int j = 0; j < visited.length;j++){
                if(!visited[j]&& !Double.isNaN(g.adjMatrix[i][j])){
                    //记录路径
                    path[j]=i;
                    //转向j
                    i = j;
                    break;//找到一个后就跳出
                }
            }
            //如果没有与当前结点相连的结点，或者相连结点均已遍历则出栈
            if(temp == i && !stack.isEmpty())
                i = stack.pop();

            //对于非联通图，遍历其他的连通分量
            if(stack.isEmpty() && !isAllVisited(visited)){
                compent++;
                for(int k = 0 ; k < visited.length;k++){
                    if(!visited[k]){
                        i =k;
                        break;
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
        return compent;
    }
    public static int  DFSTraverseNR(SparseGraph g){
        boolean [] visited = new boolean[g.nodenum];
        int [] path = new int[g.nodenum]; //记录路径的数组
        int compent = 1; //记录连通分量，连通图的连通分量为1
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < path.length;i++){
            path[i] = -1;
        }
        int i = 0,temp;
        while(!isAllVisited(visited)){
            //如果该节点未遍历过，则压栈，输出
            if(!visited[i]){
                visited[i] = true;
                stack.push(i);
                System.out.print(i+"\t");
            }
            temp =i;
            //然后转向与该结点连接且未遍历过的结点
            for(int j = 0; j < g.adjlist.get(i).size();j++){
                int node = g.adjlist.get(i).get(j).to;
                if(!visited[node]){
                    //记录路径
                    path[node]=i;
                    //转向node
                    i = node;
                    break;//找到一个后就跳出
                }
            }
            //如果没有与当前结点相连的结点，或者相连结点均已遍历则出栈
            if(temp == i && !stack.isEmpty())
                i = stack.pop();

            //对于非联通图，遍历其他的连通分量
            if(stack.isEmpty()){

                for(int k = 0 ; k < visited.length;k++){
                    if(!visited[k]){
                        compent++;
                        i =k;
                        break;
                    }
                }
                System.out.println();
            }
        }
        return compent;
    }
    public static boolean isAllVisited(boolean [] visited){
        for(int i = 0 ; i < visited.length;i++){
            if(!visited[i])
                return false;
        }
        return true;
    }
}
