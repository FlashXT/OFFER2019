package P03_Algorithm.A01_Recursion.A2_Permutations;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/20,14:02
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//从N个球中，取出M个球（不放回），有多少种不同的取法。
public class P01_GetBallMethod {
    public static void main(String [ ]args){
        System.out.println(GetBall(10,3));
    }
    public static int GetBall(int n ,int m){
        if( n < m ) return 0;
        if( n==m || m== 0) return 1;
        //想象一个特殊球c,取法划分位两种：
        // ①取的M个球中包含c:再从剩下的n-1个球中取m-1个球；
        // ②取的M个球中不包含c：从剩下的n-1个球中取m个球。
        return GetBall(n-1,m-1)+GetBall(n-1,m);
    }
}
