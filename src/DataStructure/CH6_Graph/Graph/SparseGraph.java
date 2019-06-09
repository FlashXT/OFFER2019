package DataStructure.CH6_Graph.Graph;

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
    private ArrayList<ArrayList<Edge>> list;
    public SparseGraph(int nodenum, boolean directed){
        this.nodenum = nodenum;
        this.edgenum = 0;
        this.directed = directed;
        list = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i < this.nodenum;i++){
            list.add(new ArrayList<>());
        }

    }
    public SparseGraph(String filepath) throws Exception {
        Edge [] edgearr = ReadGraph(filepath);
        list = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i < this.nodenum;i++){
            list.add(new ArrayList<>());
        }
        this.addedges(edgearr);

    }
    public SparseGraph(ArrayList<ArrayList<Edge>> list, boolean directed){
        this.directed = directed;
        this.list = list;
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
            list.get(from).add(edge);
            if(from!= to && !directed){
                Edge Corredge = new Edge(to,from,weight);
                list.get(to).add(Corredge);
            }
            return true;
        }
        return false;
    }
    public boolean hasEdge(Edge edge){
        if( edge.from >=0 && edge.from < this.nodenum && edge.to >=0 && edge.to < this.nodenum){
            for(int i = 0; i < this.list.get(edge.from).size();i++){
                if(this.list.get(edge.from).get(i).to == edge.to)
                    return true;
            }
        }

        return false;

    }
    public void getEdge(int node){
        if(node >=0 && node <= this.nodenum){
            for(int i = 0; i < list.get(node).size();i++){
                System.out.println(node+"--"+list.get(node).get(i).weight+"-->"+list.get(node).get(i).to);
            }
        }
    }
    public  Edge[] ReadGraph(String filepath) throws Exception {

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
        for(int i = 0; i < list.size();i++){
            System.out.print(i+"\t");
            for(int j = 0; j < list.get(i).size();j++){
                System.out.print("("+list.get(i).get(j).to+","+list.get(i).get(j).weight+")\t");
            }
            System.out.println();
        }

    }
}
