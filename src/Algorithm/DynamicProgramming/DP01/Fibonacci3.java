package Algorithm.DynamicProgramming.DP01;

public class Fibonacci3 {
    static int count = 0;
    public static void main(String [] args){
        long time1 = System.currentTimeMillis()/1000;

        int n = 5;
        long [] temp = new long[n+1];
        System.out.println(fib(n,temp));
        System.out.println("耗时："+(System.currentTimeMillis()/1000- time1)+"s");
    }


    public static long fib(int n,long[] temp){

        temp[0] = 0;
        temp[1] = 1;
        //动态规划，自底向上
        for(int i = 2;i <= n;i++)
            temp[i]=temp[i-1]+temp[i-2];
        return temp[n];

    }
}
