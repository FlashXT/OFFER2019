package DataStructure.CH6_Graph.MinCostSpanningTree;

import DataStructure.CH6_Graph.DenseGraph;
import DataStructure.CH6_Graph.Edge;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.ArrayList;

////加点法，适合稠密图
public class Prim {
//    public static ArrayList<Edge> Prim(DenseGraph g){
//        //点集，通过对应位置的值进行划分，对图中的结点进行二分
//        boolean [] nodeSet = new boolean[g.nodenum];
//        ArrayList<Edge> edgelist = new ArrayList<>();
//        nodeSet[0] = true;
//        Edge temp;
//        while(!isAllinSet(nodeSet)){
//            int i = 0;
//            temp = null;
//            double w = Integer.MAX_VALUE;
//            while(i< nodeSet.length){
//                //在两个点集之间寻找代价最小的边，将该边及其结点加入点集
//                if(nodeSet[i]){
//                    for( int j = 0; j<nodeSet.length;j++){
//                        if(!nodeSet[j] && g.adjMatrix[i][j] > 0
//                                       && g.adjMatrix[i][j] < w){
//                                w = g.adjMatrix[i][j];
//                                temp = new Edge(i,j,w);
//                        }
//                    }
//                }
//                i++;
//            }
//            if(temp!= null){
//                nodeSet[temp.to] = true;
//                edgelist.add(temp);
//                System.out.println("("+temp.from+","+temp.to+","+temp.weight+")");
//            }
//        }
//        double mst = 0;
//        for(int i = 0; i < edgelist.size();i++){
//            mst+=edgelist.get(i).weight;
//        }
//        System.out.println("MST Weight:"+mst);
//        return edgelist;
//    }
    //加点法，适合稠密图

    public static ArrayList<Edge>  Prim(DenseGraph g){
        ArrayList<Edge> edgelist = new ArrayList<>();
        int [] closeedgev = new int[g.nodenum];
        double [] closeedgew = new double[g.nodenum];
        for(int i = 1; i < g.nodenum;i++){
            if(g.adjMatrix[0][i] > 0){
                closeedgev[i] = 0;
                closeedgew[i] = g.adjMatrix[0][i];
            }
            else
                closeedgew[i] = Double.MAX_VALUE;
        }

        for (int i = 0; i < g.nodenum;i++){
            double w = Double.MAX_VALUE;
            int node = -1;
            for(int j = 1; j <g.nodenum;j++ ){
                if(closeedgew[j] > 0 && w > closeedgew[j]){
                    w = closeedgew[j];
                    node = j;
                }
            }
            if (node != -1){
                edgelist.add(new Edge(closeedgev[node],node,w));
                closeedgev[node] = i;
                closeedgew[node] = 0;

                for(int j = 0; j<g.nodenum;j++){
                    if(g.adjMatrix[node][j] >0 && g.adjMatrix[node][j] < closeedgew[j]){
                        closeedgev[j] = node;
                        closeedgew[j] = g.adjMatrix[node][j];
                    }

                }
            }

        }
        double mst = 0;
        for(int i = 0; i < edgelist.size();i++){
            System.out.println("("+edgelist.get(i).from+","+edgelist.get(i).to+","+edgelist.get(i).weight+")");
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
