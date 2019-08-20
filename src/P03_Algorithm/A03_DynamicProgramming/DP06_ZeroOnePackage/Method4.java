package P03_Algorithm.A03_DynamicProgramming.DP06_ZeroOnePackage;

/*******************************************************************************
 * 动态规划改进二：
 *    动态规划方法的时间复杂度是O(n*C);空间复杂度是O(n*C);而计算memo是只涉及到memo[i]行的
 *值和memo[i-1]行的值，因此Mehtod3把动态规划的空间复杂度降低到O(2*C)即O(C)复杂度；其实还可
 *以继续改进空间复杂度到O(C),即一维数组的复用，但是这种方法要注意的一点是，memo[i][j]此时用
 *memo[j]表示,在计算memo[i][j]时用到的memo[i-1][j-w[i]]，其实是此时的memo[j-w[i]],也就
 *是计算memo[i]时要用到memo[i]之前的元素，因此此时j要从C->0执行循环(不改变memo[i]之前的元
 *素);
 *******************************************************************************/

class Method4 {

    public static int zeroOnePackage(int[] value,int [] weight,int C){
        //memo[i][j]表示处理索引为i的物品，背包容量为j时，背包中物品的总价值
        if(value.length == 0) return 0;
        int[] memo = new int[C+1];

        for(int j = 0; j <C+1;j++)
            memo[j] = j>=weight[0]?value[0]:0;

        for(int i = 1;i < value.length;i++){
            //j从C->0开始循环
            for(int j = C; j >= weight[i]; j--){
                    memo[j] = Math.max(memo[j],value[i]+memo[j-weight[i]]);
            }

        }
        return memo[C];

    }
}
