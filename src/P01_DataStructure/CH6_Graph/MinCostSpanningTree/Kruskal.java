package P01_DataStructure.CH6_Graph.MinCostSpanningTree;

import P01_DataStructure.CH6_Graph.Edge;
import P01_DataStructure.CH6_Graph.SparseGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

//加边法，适用于稀疏图
//思想：①将图中的所有边按weight进行排序;
//     ②依次选择weight最小的边，若加入此边后不形成环，则此边符合条件；
public class Kruskal {
    //时间复杂度O(E*logE)
    public static ArrayList<Edge> Kruskal(SparseGraph g){

        ArrayList<Edge> edgelist = new ArrayList<>();
        PriorityQueue<Edge> heap = new PriorityQueue<>(new EdgeCompartor());
        for(int i = 0; i < g.nodenum;i++){
            for(int j = 0; j < g.adjlist.get(i).size();j++){
                if(j < i)
                    heap.offer( g.adjlist.get(i).get(j));
            }
        }
        //使用并查集来判断是否形成回路
        UnionFindSet uf = new UnionFindSet(g.nodenum);
        while(!heap.isEmpty() && edgelist.size()< g.nodenum-1){
            Edge e = heap.poll();
            if(uf.isconnected(e.to,e.from))
                continue;
            edgelist.add(e);
            //将两个结点相连
            uf.connect(e.to,e.from);
        }
        System.out.println("MinCostSpanningTree:");
        double mst = 0;
        for(int i = 0; i < edgelist.size();i++){
            System.out.printf("\t(%2d,%2d,%4.2f)\n",edgelist.get(i).from,+edgelist.get(i).to,+edgelist.get(i).weight);
            mst+=edgelist.get(i).weight;
        }
        System.out.println("MST Weight:"+mst);
        return edgelist;

    }

}
