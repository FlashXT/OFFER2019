package P03_Algorithm.A03_DynamicProgramming.DP01_Fibnacci;

public class MainClass_Fibonacci {
    public static void main(String [] args){
        long time1 = System.currentTimeMillis()/1000;

        System.out.println(Method1.fib(5));
        System.out.println(Method2.fib(5));
        System.out.println(Method3.fib(5));
        System.out.println(Method4.fib(5));

        System.out.println("耗时："+(System.currentTimeMillis()- time1)/1000+"s");
    }
}
