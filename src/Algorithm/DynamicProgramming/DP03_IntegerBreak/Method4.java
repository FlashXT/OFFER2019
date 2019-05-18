package Algorithm.DynamicProgramming.DP03_IntegerBreak;

public class Method4 {

    public static int IntegerBreak(int num){
        int [] memo = new int[num+1];
        return intBreak(num,memo);
    }
    //动态规划，自底向上
    private static int intBreak(int num,int []memo){
        //memo[n] 表示整数 n 可以分解获得的最大乘积
        memo[0] = 1;

        for(int i = 1 ; i <= num;i++){
            //求解memo[i]
            for(int j = 1; j <i;j++)
                memo[i] = Math.max(memo[i],Math.max((i-j)*j,(i-j)*memo[j]));
        }

        return memo[num];

    }
}
