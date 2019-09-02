package P05_CodeExam.C01_Tencent.Problem2;

import java.math.BigInteger;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/1,22:12
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main3 {
    public static void main(String [] args){
        BigInteger MOD = new BigInteger("1000000007");
        Scanner scan = new Scanner(System.in);
        //根据数据规模定义一个针对所有测试用例的数组
        BigInteger [] dp = new BigInteger[100001];
        int m = scan.nextInt();
        int k = scan.nextInt();
        for(int q = 0 ; q < m;q++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            BigInteger sum = new BigInteger("0");
            for(int i = 0; i < k;i++)
                dp[i]=new BigInteger("1");
            //每一个测试用例计算[k,end]
            for(int i = k; i <= end;i++){
                //dp[i] = dp[i-1]+dp[i-k];一层DP
                dp[i] = dp[i-1].add(dp[i-k]);
            }
            //每一个测试用例计算[start,end]
            for(int j = start; j <= end;j++){
                sum = sum.add(dp[j]);
                if(sum .compareTo( MOD) >= 0)
                    sum = sum.mod(MOD);
            }
            System.out.println(sum);
        }
    }
}
