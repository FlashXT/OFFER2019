package DataStructure.CH6_Graph.Graph;


public class Graph {

    int nodenum;
    int edgenum;
    boolean directed;
    double [][] adjMatrix ;

    public Graph(double [][] adjmatrix,boolean directed){
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


}
