package P03_Algorithm.A03_DynamicProgramming.DP06_ZeroOnePackage;

/*******************************************************************************
 * 动态规划改进一：
 *    动态规划方法的时间复杂度是O(n*C);空间复杂度是O(n*C);而计算memo是只涉及到memo[i]行的
 *值和memo[i-1]行的值，因此可以把动态规划的空间复杂度降低到O(2*C)即O(C)复杂度；
 *
 *******************************************************************************/
class Method3 {

    public static int zeroOnePackage(int[] value,int [] weight,int C){
        //memo[i][j]表示处理索引为i的物品，背包容量为j时，背包中物品的总价值
        if(value.length == 0) return 0;
        int [] [] memo = new int[2][C+1];

        for(int j = 0; j <C+1;j++)
            memo[0][j] = j >= weight[0]?value[0]:0;

        for(int i = 1;i < value.length;i++){
            for(int j = 0; j < C+1;j++){
                memo[i%2][j] = memo[(i-1)%2][j];
                if(j >= weight[i])
                    memo[i%2][j] = Math.max(memo[i%2][j],value[i]+memo[(i-1)%2][j-weight[i]]);
            }
        }
        return memo[(value.length-1)%2][C];

    }
}
