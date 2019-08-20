package P03_Algorithm.A03_DynamicProgramming.DP06_ZeroOnePackage;

class Method2 {

    public static int zeroOnePackage(int[] value,int [] weight,int C){
        //memo[i][j]表示处理索引为i的物品，背包容量为j时，背包中物品的总价值
        if(value.length == 0) return 0;
        int [] [] memo = new int[value.length][C+1];
        for(int i = 0; i < value.length;i++){
            for(int j = 0; j <memo[i].length;j++)
                memo[i][j] = -1;
        }
        //
        for(int j = 0; j <C+1;j++)
            memo[0][j] = j >= weight[0]?value[0]:0;

        for(int i = 1;i < value.length;i++){
            for(int j = 0; j < C+1;j++){
                memo[i][j] = memo[i-1][j];
                if(j >= weight[i])
                    memo[i][j] = Math.max(memo[i][j],value[i]+memo[i-1][j-weight[i]]);
            }
        }
        return memo[value.length-1][C];

    }
}
