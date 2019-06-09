package DataStructure.CH6_Graph.MinCostSpanningTree;

import DataStructure.CH6_Graph.DenseGraph;
import DataStructure.CH6_Graph.Edge;

import java.util.ArrayList;

//加点法，适合稠密图
public class Prim {
    public static ArrayList<Edge> Prim(DenseGraph g){
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
                        if(!nodeSet[j] && g.adjMatrix[i][j] > 0
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
        double mst = 0;
        for(int i = 0; i < edgelist.size();i++){
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
}
