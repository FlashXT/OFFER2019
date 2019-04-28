package Algorithm.DynamicProgramming.DP01;

public class Fibonacci {
    static int count = 0;
    public static void main(String [] args){
        long time1 = System.currentTimeMillis()/1000;

        System.out.println(fib(5));
        System.out.println("fib()函数被调用："+count+"次");
        System.out.println("耗时："+(System.currentTimeMillis()- time1)/1000+"s");
    }

    public static long fib(int n){
        count++;
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1)+fib(n-2);

    }
}
