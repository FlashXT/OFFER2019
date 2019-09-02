package P05_CodeExam.C01_Tencent.Problem2;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/1,19:54
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//该程序存在两个问题:①回溯法超时；②数据类型范围太小；
public class Main1 {
    //遇到求模操作，要考虑数据类型的范围，使用Long类型,以及BigInteger类
    static int sum = 0;
    public static void main(String [] args){
        Long MOD = 1000000007l;
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int k = scan.nextInt();
        for(int q = 0 ; q < m;q++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            sum = 0;
            for(int i = start;i <= end;i++){
                getNums(i,k);
                if(sum >= MOD)
                    sum%= MOD;
            }
            System.out.println(sum);
        }
    }

    //递归回溯(超时需要改为动态规划)
    public static void getNums(int len,int k){
        if(len < 0) return ;
        if(len == 0){
            sum++;  //sum为全局变量
            return ;
        }
        getNums(len-1,k);
        getNums(len-k,k);
        return ;
    }
}
