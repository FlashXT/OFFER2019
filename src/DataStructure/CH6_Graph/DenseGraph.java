package DataStructure.CH6_Graph;

import DataStructure.CH6_Graph.Edge;

import java.io.BufferedReader;
import java.io.FileReader;

//使用邻接矩阵创建图,邻接矩阵适合表示稠密图
public class DenseGraph {

    public int nodenum;
    public int edgenum;
    boolean directed;
    public double [][] adjMatrix ;

    public DenseGraph(int nodenum, boolean directed){
        this.nodenum = nodenum;
        this.edgenum = 0;
        this.directed = directed;
        this.adjMatrix = new double[nodenum][nodenum];

    }
    public DenseGraph(double [][] adjmatrix, boolean directed){
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
    public DenseGraph(String filepath) throws Exception {
        Edge[] edgearr = ReadGraph(filepath);
        this.adjMatrix = new double[this.nodenum][this.nodenum];
        this.addedges(edgearr);
    }
    public void addedges(Edge [] edgearr){
        for(int i =0 ; i<edgearr.length;i++){
            addedge(edgearr[i].from,edgearr[i].to,edgearr[i].weight);
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
    private   Edge[] ReadGraph(String filepath) throws Exception {
        //文件格式如下：
        // 第   1   行： 结点数 边数 0/1(表示是否是有向图)
        // 第 2~边数 行： 结点1 结点2 weight (每一行表示一条边)
        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        String [] arr = line.split(" ");
        this.nodenum = Integer.valueOf(arr[0]);

        this.directed = Integer.valueOf(arr[2]) == 1? true:false;
        Edge [] edgearr = new Edge[Integer.valueOf(arr[1])];
        Edge temp;
        for(int i = 0;i < edgearr.length;i++) {
            line = br.readLine();
            arr = line.split(" ");
            temp = new Edge(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]), Double.valueOf(arr[2]));
            edgearr[i] = temp;
        }
        return edgearr;
    }
    public void Print(){

        System.out.println("Graph's Adjacency matrix:");
        System.out.print("\t");
        for(int i = 0; i< this.adjMatrix.length;i++){
            System.out.print(i+"\t\t");
        }
        System.out.println();
        for(int i = 0; i< this.adjMatrix.length;i++){
            System.out.print(i+"\t");
            for(int j = 0; j < this.adjMatrix[i].length;j++){
                System.out.printf("%3.2f\t",this.adjMatrix[i][j]);
            }
            System.out.println();
        }

    }
}
