package Algorithm.DynamicProgramming.DP01_Fibnacci;

public class Method1 {


    public static long fib(int n){

        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1)+fib(n-2);

    }
}
