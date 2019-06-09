package DataStructure.CH6_Graph.GraphTraverse;

import DataStructure.CH6_Graph.DenseGraph;
import DataStructure.CH6_Graph.SparseGraph;

import java.util.LinkedList;
import java.util.Queue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/6/9 16:13;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class BFS {
    public static int BFS(DenseGraph g){
        boolean [] visited = new boolean[g.nodenum];
        Queue<Integer> queue = new LinkedList<>();
        int compent=1;
        int [] path = new int[g.nodenum];
        for(int i = 0; i < path.length;i++){
            path[i] = -1;
        }
        queue.offer(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            System.out.print(node+"\t");
            for(int i = 0; i < g.adjMatrix[node].length;i++){
                if(!visited[i] && g.adjMatrix[node][i]!=0){
                    if(!queue.contains(i)){
                        path[i] = node;
                        queue.offer(i);
                    }
                }
            }
            if(queue.isEmpty()){
                for(int i = 0; i < visited.length;i++){
                    if(!visited[i]){
                        compent++;
                        queue.offer(i);
                    }
                }
            }
        }
        return compent;
    }

    public static int BFS(SparseGraph g){
        boolean [] visited = new boolean[g.nodenum];
        Queue<Integer> queue = new LinkedList<>();
        int compent = 1;
        int [] path = new int[g.nodenum];
        for(int i = 0; i < path.length;i++){
            path[i] = -1;
        }
        queue.offer(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            System.out.print(node+"\t");
            for(int i = 0; i < g.adjlist.get(node).size();i++){
                int temp = g.adjlist.get(node).get(i).to;
                if(!visited[temp] && !queue.contains(temp)){
                        path[temp] = node;
                        queue.offer(temp);
                }
            }
            if(queue.isEmpty()){
                for(int i = 0; i < visited.length;i++){
                    if(!visited[i]){
                        compent++;
                        queue.offer(i);
                    }
                }
            }
        }
        return compent;
    }
}
