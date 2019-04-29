package Algorithm.DynamicProgramming.DP03;

/*****************************************************************
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *      输入: 2
 *      输出: 1
 *      解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 *      输入: 10
 *      输出: 36
 *      解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *****************************************************************/
public class IntegerBreak {
    public static int product =1;
    public static void main(String [] args){
        int num = 10;
//        int [] temp = new int[num];
//        intBreak(num,0,temp);
//        System.out.println(product);

//        System.out.println(intBreak2(num));

        int [] memo = new int[num+1];
//        System.out.println(intBreak3(num,memo));
        System.out.println(intBreak4(num,memo));
    }

    //递归穷举
    public static void intBreak(int num,int index,int [] temp){
        if( num <=0) {
            for(int i = 0; i< index;i++)
                System.out.printf("%-2d",temp[i]);
            System.out.println();
            int produ = 1;
            for(int i = 0; i< index;i++)
                produ *= temp[i];
            if(index ==1)
                return ;
            product = produ > product ? produ:product;
            return ;
        }
        //递归穷举，效率不够高，只是可解
        for(int i = num;i > 0;i--){
//            if( index > 0 && i > temp[index-1]) continue;
            temp[index] = i;
            intBreak(num-i,index+1,temp);
        }

    }

    //递归,对整数n进行分割（至少分割为两部分），可以获得的最大乘积
    public static int intBreak2(int num){
        if(num ==1)
            return 1;
        int res = -1;
        for(int i = num; i > 0;i--){
            //最大乘积，由(i,i*(num-i),i*intBreak2(num-i)))三者中最大的产生;
            res = Math.max(res,Math.max(i*(num-i),i*intBreak2(num-i)));
        }
        return res;

    }

    //记忆化搜索，自顶向下
    public static int intBreak3(int num,int []memo){
        //memo[n] 表示整数 n 可以分解获得的最大乘积
        if(num == 1)
            return 1;

        if(memo[num] != 0)
            return memo[num];

        int res = -1;
        for(int i = num; i > 0;i--){
            res = Math.max(res,Math.max(i*(num-i),i*intBreak3(num-i,memo)));
        }
        memo[num] = res;
        return memo[num];

    }

    //动态规划，自底向上
    public static int intBreak4(int num,int []memo){
        //memo[n] 表示整数 n 可以分解获得的最大乘积
        memo[0] = 1;

        for(int i = 1 ; i <= num;i++){
            //求解memo[i]
            for(int j = 1; j <=Math.ceil(i/2);j++)
                // i = j+(i-j)
                memo[i] = Math.max(memo[i],Math.max(j*(i-j),j*memo[i-j]));
//                memo[i] = Math.max(memo[i],Math.max((i-j)*j,(i-j)*memo[j]));
        }

        return memo[num];

    }
}
