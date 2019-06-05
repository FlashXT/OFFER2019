package DataStructure.CH6_Graph.Graph;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/6/5 19:15
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Edge{
    int from;
    int to;
    double weight;
    public Edge(int from,int to, double weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}