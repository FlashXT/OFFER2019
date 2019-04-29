package Algorithm.DynamicProgramming.DP01;

public class Fibonacci4 {
    static int count = 0;
    public static void main(String [] args){
        long time1 = System.currentTimeMillis()/1000;

        System.out.println(fib(50));
        System.out.println("耗时："+(System.currentTimeMillis()/1000- time1)+"s");
    }


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
