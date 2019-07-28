package DataStructure.CH6_Graph;

import DataStructure.CH6_Graph.Edge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/6/5 18:41
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//使用邻接表创建图，邻接表适合表示稀疏图
public class SparseGraph {
    public int nodenum;
    public int edgenum;
    public boolean directed;
    public ArrayList<ArrayList<Edge>> adjlist;
    public SparseGraph(int nodenum, boolean directed){
        this.nodenum = nodenum;
        this.edgenum = 0;
        this.directed = directed;
        adjlist = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i < this.nodenum;i++){
            adjlist.add(new ArrayList<>());
        }

    }
    public SparseGraph(String filepath) throws Exception {
        Edge [] edgearr = ReadGraph(filepath);
        adjlist = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i < this.nodenum;i++){
            adjlist.add(new ArrayList<>());
        }
        this.addedges(edgearr);

    }
    public SparseGraph(ArrayList<ArrayList<Edge>> list, boolean directed){
        this.directed = directed;
        this.adjlist = list;
        for(int i = 0; i < list.size();i++){
           this.edgenum+=list.get(i).size();
        }
        this.nodenum = list.size();
    }
    public void addedges(Edge [] edgearr){
        for(int i =0 ; i<edgearr.length;i++){
         addedge(edgearr[i].from,edgearr[i].to,edgearr[i].weight);
        }
    }

    public boolean addedge(int from, int to,double weight){
        Edge edge = new Edge(from,to,weight);
        if(!hasEdge(edge)) this.edgenum++;
        if (from >= 0 && from < this.nodenum && to >= 0 && to < this.nodenum){
            adjlist.get(from).add(edge);
            if(from!= to && !directed){
                Edge Corredge = new Edge(to,from,weight);
                adjlist.get(to).add(Corredge);
            }
            return true;
        }
        return false;
    }
    public boolean hasEdge(Edge edge){
        if( edge.from >=0 && edge.from < this.nodenum && edge.to >=0 && edge.to < this.nodenum){
            for(int i = 0; i < this.adjlist.get(edge.from).size();i++){
                if(this.adjlist.get(edge.from).get(i).to == edge.to)
                    return true;
            }
        }

        return false;

    }
    public void getEdge(int node){
        if(node >=0 && node <= this.nodenum){
            for(int i = 0; i < adjlist.get(node).size();i++){
                System.out.println(node+"--"+adjlist.get(node).get(i).weight+"-->"+adjlist.get(node).get(i).to);
            }
        }
    }
    private  Edge[] ReadGraph(String filepath) throws Exception {
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

        System.out.println("Graph's Adjacency List：");
        for(int i = 0; i < adjlist.size();i++){
            System.out.print(i+"\t");
            for(int j = 0; j < adjlist.get(i).size();j++){
                System.out.printf("(%2d,%4.2f)\t",adjlist.get(i).get(j).to,adjlist.get(i).get(j).weight);
            }
            System.out.println();
        }

    }
}
