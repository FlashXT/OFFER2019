package DataStructure.CH6_Graph.Graph;

import java.util.Iterator;

//使用邻接矩阵创建图,邻接矩阵适合表示稠密图
public class Graph1 {

    public int nodenum;
    public int edgenum;
    boolean directed;
    private double [][] adjMatrix ;

    public Graph1(int nodenum,boolean directed){
        this.nodenum = nodenum;
        this.edgenum = 0;
        this.directed = directed;
        this.adjMatrix = new double[nodenum][nodenum];

    }
    public Graph1(double [][] adjmatrix, boolean directed){
        this.nodenum = adjmatrix.length;
        this.adjMatrix = adjmatrix;
        this.directed = directed;
        this.edgenum = 0;
        for(int i =0; i < adjmatrix.length;i++){
            for(int j = 0; j < adjmatrix[i].length;j++){
                if(adjmatrix[i][j]!=0)
                    this.edgenum++;
            }
        }
    }
    public void addedge(int n1,int n2,double weight){
        if( n1 >=0 && n1 < this.nodenum && n2 >=0 && n2 < this.nodenum){
            if(this.adjMatrix[n1][n2] == 0)
                this.edgenum++;
            this.adjMatrix[n1][n2] = weight;
            if(!this.directed)
                this.adjMatrix[n2][n1] = weight;

            return ;
        }
        throw  new ArrayIndexOutOfBoundsException("Node is not exist");

    }
    public boolean hasEgde(int from,int to ,double weigth){
        if( from >=0 && from < this.nodenum && to >=0 && to < this.nodenum){
            if(this.adjMatrix[from][to] == weigth)
                return true;
        }
        return false;
    }

    public void getEdge(int node){
        if(node >=0 && node <= this.nodenum){
            for(int i = 0; i < this.adjMatrix[node].length;i++){
                if(this.adjMatrix[node][i]!= 0){
                    System.out.println(node+"--"+this.adjMatrix[node][i]+"-->"+i);
                }
            }
        }
    }
    public void Print(){
        System.out.print("\t");
        for(int i = 0; i< this.adjMatrix.length;i++){
            System.out.print(i+"\t");
        }
        System.out.println();
        for(int i = 0; i< this.adjMatrix.length;i++){
            System.out.print(i+"\t");
            for(int j = 0; j < this.adjMatrix[i].length;j++){
                System.out.print(this.adjMatrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
