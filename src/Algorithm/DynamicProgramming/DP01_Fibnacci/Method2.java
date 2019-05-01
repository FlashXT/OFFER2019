package Algorithm.DynamicProgramming.DP01_Fibnacci;

public class Method2 {
    public static long fib(int n){
        long [] temp = new long[n+1];
        return fibo(n,temp);
    }


    private static long fibo(int n,long[] temp){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(temp[n] == 0)
            //记忆化搜索,自上向下
            temp[n] = fibo(n-1,temp)+fibo(n-2,temp);
        return temp[n];

    }
}
