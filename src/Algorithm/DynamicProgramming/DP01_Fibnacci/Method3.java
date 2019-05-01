package Algorithm.DynamicProgramming.DP01_Fibnacci;

public class Method3 {
    public static long fib(int n){

        long [] temp = new long[n+1];
        return fibo(n,temp);
    }

    private static long fibo(int n,long[] temp){

        temp[0] = 0;
        temp[1] = 1;
        //动态规划，自底向上
        for(int i = 2;i <= n;i++)
            temp[i]=temp[i-1]+temp[i-2];
        return temp[n];

    }
}
