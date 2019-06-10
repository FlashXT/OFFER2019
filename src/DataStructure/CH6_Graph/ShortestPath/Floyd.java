package DataStructure.CH6_Graph.ShortestPath;

import DataStructure.CH6_Graph.DenseGraph;

public class Floyd {
    public static  void Floyd(DenseGraph g){
        double [][] weight = new double[g.nodenum][g.nodenum];
        boolean[][][]Path = new boolean[g.nodenum][g.nodenum][g.nodenum];
        for(int v= 0; v < g.nodenum;v++){
            for(int w = 0; w < g.nodenum;w++){
                if(g.adjMatrix[v][w]!= Double.NaN){
                    weight[v][w] = g.adjMatrix[v][w];
                    for(int u = 0; u< g.nodenum;u++)
                        Path[v][w][u] = false;
                    Path[v][w][v] = true;
                    Path[v][w][w] = true;
                }
                else{
                    weight[v][w] = Double.NaN;
                }
            }
        }
        for(int u = 0; u < g.nodenum;u++){
            for(int v= 0 ; v < g.nodenum;v++){
                for(int w = 0; w < g.nodenum;w++){

                    if(Double.isNaN(weight[v][w]) || weight[v][u]+weight[u][w] < weight[v][w]){
                        weight[v][w] = weight[v][u]+weight[u][w];
                    }
                    for(int i =0 ; i < g.nodenum;i++){
                        Path[v][w][i] = Path[v][u][i]||Path[u][w][i];
                    }
                }
            }
        }
        for(int i = 0; i<g.nodenum;i++){
            for (int j =0 ; j< g.nodenum;j++){
                System.out.print(weight[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
