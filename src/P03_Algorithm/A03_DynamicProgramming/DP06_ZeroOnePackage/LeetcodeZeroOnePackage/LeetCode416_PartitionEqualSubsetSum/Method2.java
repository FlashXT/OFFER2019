package P03_Algorithm.A03_DynamicProgramming.DP06_ZeroOnePackage.LeetcodeZeroOnePackage.LeetCode416_PartitionEqualSubsetSum;

public class Method2 {
    //动态规划
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i< nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2 != 0) return false;
        int C = sum/2;
        boolean[] memo = new boolean[C+1];

        for(int j = 0; j < C+1;j++)
            memo[j] = nums[0]==j;
        for(int i = 1; i< nums.length;i++){
            for(int j = C; j >= nums[i];j--) {
                memo[j] = memo[j]||memo[j - nums[i]];
            }

        }
        return memo[C];

    }

}
