package Algorithm.DynamicProgramming.DP01;

public class Fibonacci2 {
    static int count = 0;
    public static void main(String [] args){
        long time1 = System.currentTimeMillis()/1000;

        int n = 5;
        long [] temp = new long[n+1];
        System.out.println(fib(n,temp));
        System.out.println("fib()函数被调用："+count+"次");
        System.out.println("耗时："+(System.currentTimeMillis()- time1)/1000+"s");
    }


    public static long fib(int n,long[] temp){
        count++;
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(temp[n] == 0)
            //记忆化搜索
            temp[n] = fib(n-1,temp)+fib(n-2,temp);
        return temp[n];

    }
}
