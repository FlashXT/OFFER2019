package Algorithm.DynamicProgramming.DP06_ZeroOnePackage.LeetcodeZeroOnePackage.LeetCode416_PartitionEqualSubsetSum;

public class Method1 {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i< nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2 != 0) return false;
        int C = sum/2;
        //memo[i][c]表示使用索引为[0,..,i]的这些元素，是否可以完全填充一个
        //容量为c的背包：-1表示为填充；0表示不可以填充；1表示可以填充；
        int [][]memo = new int[nums.length][C+1];
        for(int i = 0;i < memo.length;i++)
            for(int j = 0; j < C+1;j++){
                memo[i][j] = -1;
            }
        return tryPartition(nums,nums.length-1,C,memo);
    }
    //记忆化搜索
    private static boolean tryPartition(int[] value,int index,int C,int[][]memo){
        if(C == 0)
            return true;
        if(C<= 0 || index < 0)
            return false;

        if(memo[index][C] == -1){
            boolean can = tryPartition(value,index-1,C,memo)||tryPartition(value,index-1,C-value[index],memo);

            memo[index][C] = can?1:0;
        }
        return memo[index][C] ==1;

    }
}
