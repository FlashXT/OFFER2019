package DataStructure.CH6_Graph;

import java.util.Comparator;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/6/5 19:15
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Edge {
    public int from;
    public int to;
    public double weight;

    public Edge(int from,int to, double weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
