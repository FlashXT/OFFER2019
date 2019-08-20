package P03_Algorithm.A01_Recursion.BasicProblem;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/20,10:36
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class P01_PrintN {
    public static void main(String [] args){
        Print1(10);
        System.out.println();
        Print2(10,0);
    }
    public static void Print1(int n){
        if(n > 0) Print1(n-1);
        System.out.print(n+"\t");
    }
    public static void Print2(int n,int k ){
        if(k > n) return ;
        System.out.print(k+"\t");
        Print2(n,k+1);
    }
}
