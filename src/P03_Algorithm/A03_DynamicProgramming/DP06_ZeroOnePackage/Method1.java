package P03_Algorithm.A03_DynamicProgramming.DP06_ZeroOnePackage;

class Method1 {
    public static int ZeroOnePackage(int[] value,int [] weight,int C){

        //memo[i][j]表示处理索引为i的物品，背包容量为j时，背包中物品的总价值
        int [] [] memo = new int[value.length][C+1];
        for(int i = 0; i < value.length;i++){
            for(int j = 0; j <memo[i].length;j++)
                memo[i][j] = -1;
        }
        return zeroOnePackage(value,weight,value.length-1,C,memo);

    }
    public static int zeroOnePackage(int[] value,int [] weight,int index,int j,int [][]memo){
        if(j<= 0 || index < 0)
            return 0;
        if(memo[index][j] != -1)
            return memo[index][j];
        int value1 = value[index]+zeroOnePackage(value,weight,index-1,j-weight[index],memo);
        int value2 = zeroOnePackage(value,weight,index-1,j,memo);
        memo[index][j] = Math.max(value1,value2);
        return memo[index][j];


    }
}
