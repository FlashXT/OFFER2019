package P03_Algorithm.A03_DynamicProgramming.DP04_MinCostPath;

/*******************************************************************
 * 假设我们有一个 n 乘以 n 的矩阵 w[n][n]。矩阵存储的都是正整数。棋子起始位置
 * 在左上角，终止位置在右下角。我们将棋子从左上角移到右下角。每次只能向右或者向
 * 下移动一位。整个过程，会有多种不同的路径可以选择。我们把每条路径经过的数字加
 * 起来看作路径的长度。那从左上角到右下角的最短路径长度是多少呢？
 *                  {   {1,3,5,9},
 *                      {2,1,3,4},
 *                      {5,2,6,7},
 *                      {6,8,4,3}   }
 ********************************************************************/
public class MinCostPath {
    public static void main(String [] args){
        int [][] arr = {
                {1,3,5,9},
                {2,1,3,4},
                {5,2,6,7},
                {6,8,4,3}
        };

//        System.out.println(Method2.minpath);

        System.out.println(Method1.MinCostPath(arr));
        System.out.println(Method2.MinCostPath(arr));

    }
}
