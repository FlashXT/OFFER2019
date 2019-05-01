package Algorithm.DynamicProgramming.DP01_Fibnacci;

public class Method4 {

    public static long fib(int n){

        long temp0 = 0;
        long temp1 = 1;
        long temp2 = temp0+temp1;
        for(int i = 2;i <= n;i++){
            temp2 = temp1+temp0;
            temp0 = temp1;
            temp1 = temp2;
        }

        return temp2;

    }
}
