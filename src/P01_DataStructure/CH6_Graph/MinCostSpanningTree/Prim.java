package P01_DataStructure.CH6_Graph.MinCostSpanningTree;

import P01_DataStructure.CH6_Graph.DenseGraph;
import P01_DataStructure.CH6_Graph.Edge;
import P01_DataStructure.CH6_Graph.SparseGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//加点法，适合稠密图
public class Prim {
    //时间复杂度O(n^3)
    public static ArrayList<Edge> PrimS(DenseGraph g){
        //点集，通过对应位置的值进行划分，对图中的结点进行二分
        boolean [] nodeSet = new boolean[g.nodenum];
        ArrayList<Edge> edgelist = new ArrayList<>();
        nodeSet[0] = true;
        Edge temp;
        while(!isAllinSet(nodeSet)){
            int i = 0;
            temp = null;
            double w = Integer.MAX_VALUE;
            while(i< nodeSet.length){
                //在两个点集之间寻找代价最小的边，将该边及其结点加入点集
                if(nodeSet[i]){
                    for( int j = 0; j<nodeSet.length;j++){
                        if(!nodeSet[j] && !Double.isNaN(g.adjMatrix[i][j])
                                       && g.adjMatrix[i][j] < w){
                                w = g.adjMatrix[i][j];
                                temp = new Edge(i,j,w);
                        }
                    }
                }
                i++;
            }
            if(temp!= null){
                nodeSet[temp.to] = true;
                edgelist.add(temp);
                System.out.println("("+temp.from+","+temp.to+","+temp.weight+")");
            }
        }
        System.out.println("MinCostSpanningTree:");
        double mst = 0;
        for(int i = 0; i < edgelist.size();i++){
            System.out.printf("\t(%2d,%2d,%4.2f)\n",edgelist.get(i).from,+edgelist.get(i).to,+edgelist.get(i).weight);
            mst+=edgelist.get(i).weight;
        }
        System.out.println("MST Weight:"+mst);
        return edgelist;
    }

    //时间复杂度O(n^2)
    public static ArrayList<Edge>  Prim(DenseGraph g){
        ArrayList<Edge> edgelist = new ArrayList<>();
        //closeedgev[i]=j，表示从j到i的边
        int [] closeedgev = new int[g.nodenum];
        //closeedgew[i]=w，表示从到i的边的权重为w
        double [] closeedgew = new double[g.nodenum];
        //从结点0开始，所以将结点0的边加入数组
        for(int i = 1; i < g.nodenum;i++){
            if(!Double.isNaN(g.adjMatrix[0][i])){
                closeedgev[i] = 0;
                closeedgew[i] = g.adjMatrix[0][i];
            }
            else
                closeedgew[i] = Double.MAX_VALUE;
        }

        //从closeedgew数组中选择代价最小的边
        for (int i = 0; i < g.nodenum;i++){
            double w = Double.MAX_VALUE;
            int node = -1;
            for(int j = 1; j <g.nodenum;j++ ){
                if(closeedgew[j] > 0 && w > closeedgew[j]){
                    w = closeedgew[j];
                    node = j;
                }
            }
            //找到一个新结点，将与该结点的连边加入结果集
            if (node != -1){
                edgelist.add(new Edge(closeedgev[node],node,w));
                //修改closeedgev和closeedgev数组
                closeedgev[node] = i;
                closeedgew[node] = 0;
                //将该结点连边中代价小的边加入数组
                for(int j = 0; j<g.nodenum;j++){
                    if(g.adjMatrix[node][j] >0 && g.adjMatrix[node][j] < closeedgew[j]){
                        closeedgev[j] = node;
                        closeedgew[j] = g.adjMatrix[node][j];
                    }

                }
            }

        }
        System.out.println("MinCostSpanningTree:");
        double mst = 0;
        for(int i = 0; i < edgelist.size();i++){
            System.out.printf("\t(%2d,%2d,%4.2f)\n",edgelist.get(i).from,+edgelist.get(i).to,+edgelist.get(i).weight);
            mst+=edgelist.get(i).weight;
        }
        System.out.println("MST Weight:"+mst);
        return edgelist;

    }

    private static boolean isAllinSet(boolean [] nodeset){
        for(int i = 0; i< nodeset.length;i++){
            if(!nodeset[i])
                return false;
        }
        return true;
    }
    //Lazy_Prim，时间复杂度O(E*logE)
    public static ArrayList<Edge>  Prim(SparseGraph g){
        ArrayList<Edge> edgelist = new ArrayList<>();
        PriorityQueue<Edge> heap = new PriorityQueue<>(new EdgeCompartor());
        boolean [] visited = new boolean[g.nodenum];

        visited[0] = true;
        for(int j = 0; j < g.adjlist.get(0).size();j++){
            heap.offer(g.adjlist.get(0).get(j));
        }
        while(!heap.isEmpty()){
            Edge e = heap.poll();
            if(visited[e.from] == visited[e.to])
                continue;
            edgelist.add(e);
            if(!visited[e.from]){
                visited[e.from] =true;
                for(int j = 0; j < g.adjlist.get(e.from).size();j++){
                    heap.offer(g.adjlist.get(e.from).get(j));
                }
            }
            else{
                visited[e.to] = true;
                for(int j = 0; j < g.adjlist.get(e.to).size();j++){
                    heap.offer(g.adjlist.get(e.to).get(j));
                }
            }
        }

        System.out.println("MinCostSpanningTree:");
        double mst = 0;
        for(int i = 0; i < edgelist.size();i++){
            System.out.printf("\t(%2d,%2d,%4.2f)\n",edgelist.get(i).from,+edgelist.get(i).to,+edgelist.get(i).weight);
            mst+=edgelist.get(i).weight;
        }
        System.out.println("MST Weight:"+mst);
        return edgelist;
    }
    //Lazy_Primk可以继续优化，至时间复杂度O(E*logV)，
    // 方法类似O(n^2)的Prim(DenseGraph g)算法，但是将数组换为IndexMinHeap;
    public static ArrayList<Edge>  PrimPro(SparseGraph g){
        return null;
    }
}

class EdgeCompartor implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        if(o1.weight> o2.weight)
            return 1;
        else if(o1.weight < o2.weight)
            return -1;
        else
            return 0;
    }


}