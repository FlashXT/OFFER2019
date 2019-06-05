package DataStructure.CH6_Graph.Graph;

import java.util.ArrayList;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/6/5 18:41
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//使用邻接表创建图，邻接表适合表示稀疏图
public class Graph2 {
    public int nodenum;
    public int edgenum;
    public boolean directed;
    private ArrayList<ArrayList<Edge>> list;
    public Graph2(int nodenum,boolean directed){
        this.nodenum = nodenum;
        this.edgenum = 0;
        this.directed = directed;
        for(int i = 0; i < nodenum;i++){
            list.add(new ArrayList<>());
        }

    }
    public Graph2(ArrayList<ArrayList<Edge>> list,boolean directed){
        this.directed = directed;
        this.list = list;
        for(int i = 0; i < list.size();i++){
           this.edgenum+=list.get(i).size();
        }
        this.nodenum = list.size();
    }

    public boolean addedge(int from, int to,double weight){
        Edge edge = new Edge(from,to,weight);
        if(!hasEdge(edge)) this.edgenum++;
        if (from >= 0 && from < this.nodenum && to >= 0 && to < this.nodenum){
            list.get(from).add(edge);
            if(from!= to && !directed){
                list.get(to).add(edge);
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
    public void Print(){
        for(int i = 0; i < list.size();i++){
            System.out.print(i+"\t");
            for(int j = 0; j < list.get(i).size();j++){
                System.out.print("("+list.get(i).get(j).weight+","+list.get(i).get(j).to+")");
            }
            System.out.println();
        }
    }
}
