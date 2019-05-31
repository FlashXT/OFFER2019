package DataStructure.CH6_Graph.Graph;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/31 12:15
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static  void main(String [] args){
        double[][] adjmatrix = {{1,1,0,3},
                                {2,0,2,1},
                                {1,3,4,2},
                                {8,5,6,7}
                             };
        Graph g = new Graph(adjmatrix,false);
        System.out.println(g.nodenum);
        g.addedge(0,3,1);
        System.out.println(g.nodenum);
    }
}
