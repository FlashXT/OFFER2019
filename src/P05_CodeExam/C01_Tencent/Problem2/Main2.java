package P05_CodeExam.C01_Tencent.Problem2;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/1,19:54
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main2 {

    //Long型仍然不够！需要用BigInteger类
    public static void main(String [] args){
        Long MOD = 1000000007l;
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int k = scan.nextInt();
        for(int q = 0 ; q < m;q++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            Long [] memo = new Long[end+1];
            //第一层DP
            //每一个测试用例计算[start,end]
            memo[start] = getNumDP(start,k);
            if(start+1 < end+1)
                memo[start+1] = getNumDP(start+1,k);
            for(int i = start+2;i <= end;i++){
                //第二层DP
                memo[i] = memo[i-1]+memo[i-2];
            }
            Long sum = 0l;
            //每一个测试用例计算[start,end]
            for(int i = start;i <= end;i++){
               sum+=memo[i];
               if(sum >= MOD)
                   sum %= MOD;
            }
            System.out.println(sum);
        }
    }

    //动态规划
    public static Long getNumDP(int len,int k){
        if( k > len)
            return 1l;
        Long [] memo = new Long [len+1];
        for(int i = 0; i< k ;i++)
            memo[i] = 1l;
        for(int i = k ; i <=len;i++)
            memo[i] = memo[i-1]+memo[i-k];
        return memo[len];
    }
}
