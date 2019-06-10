package DataStructure.CH6_Graph.ShortestPath;

import DataStructure.CH6_Graph.DenseGraph;

import java.util.Arrays;

public class Dijkstra {
    //时间复杂度O(n^2)
    public static double[] Dijkstra(DenseGraph g,int v0) {
        //weight[v]表示从v0到v的路径权值
        double[] weight = new double[g.nodenum];
        //结果集，res[v]表示是否以求得从v0到v的最短路径
        boolean [] res = new boolean[g.nodenum];
        //Path[v][w] 表示w是否是从v0到v当前最短路径上的结点
        boolean [][] Path = new boolean[g.nodenum][g.nodenum];
        //初始化操作，将与v0相连的边放入weight中，设置res[v0]以及weight[v0]
        for(int v = 0; v < g.nodenum;v++){
            if(g.adjMatrix[v0][v]!=0){
                weight[v] = g.adjMatrix[v0][v];
                Path[v][v0] = true;
                Path[v][v] = true;
            }
            else
                weight[v] =Double.MAX_VALUE;
        }

        res[v0] = true;
        weight[v0] = 0;
        int v =v0;
        for(int i = 1; i< g.nodenum;i++){
            //寻找从v0可达结点中（结果集中的结点），能够到达不在结果集中
            // 的结点的最小权值的边，并将结点设为该边不在结果集中的结点，
            //min为从v0到达该结点的权值
            Double min = Double.MAX_VALUE;
            for(int j = 0; j< g.nodenum;j++){
                if(!res[j]){
                    if(weight[j] < min ){
                        v = j;
                        min = weight[j];
                    }
                }
            }
            //将该结点放入结果集
            res[v] = true;
            //从该结点相连的边中，进行权值更新
            for(int k = 0; k < g.nodenum;k++){
                if(g.adjMatrix[v][k]!= 0 ){
                    if(!res[k]&& min+g.adjMatrix[v][k] < weight[k]){
                        weight[k] = min+g.adjMatrix[v][k];
                        //权值更新表示从v0->v,v->k是v0->k的路径，所以
                        //v0->k路径上的结点包含v0->v最短路径上的结点
                        for(int j =0 ; j < Path.length;j++)
                            Path[k][j] = Path[v][j];
                        //k结点是v0->k路径的终点
                        Path[k][k]=true;
                    }
                }
            }
            System.out.println(Arrays.toString(weight));
        }
        System.out.print("\t");
        for(int i = 0; i< g.adjMatrix.length;i++){
            System.out.print(i+"\t\t");
        }
        System.out.println();
        for(int i = 0; i < Path.length;i++){
            System.out.print(i+"\t");
            for(int j = 0; j < Path[i].length;j++){
                if(Path[i][j])
                    System.out.print(Path[i][j]+"\t");
                else
                    System.out.print("\t\t");
            }
            System.out.println();
        }
        return weight;

    }

}
