package Algorithm.DynamicProgramming.DP03_IntegerBreak;

public class Method3 {
    //记忆化搜索，自顶向下
    public  static int IntegerBreak(int num){
        int [] memo = new int[num+1];
        return intBreak(num,memo);
    }

    private static int intBreak(int num,int []memo){
        //memo[n] 表示整数 n 可以分解获得的最大乘积
        if(num == 1)
            return 1;

        if(memo[num] != 0)
            return memo[num];

        int res = -1;
        for(int i = num; i > 0;i--){
            res = Math.max(res,Math.max(i*(num-i),i*intBreak(num-i,memo)));
        }
        memo[num] = res;
        return memo[num];

    }
}
