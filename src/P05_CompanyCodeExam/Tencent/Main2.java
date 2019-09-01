package P05_CompanyCodeExam.Tencent;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/1,19:54
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main2 {
    static int sum = 0;
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int k = scan.nextInt();
        for(int q = 0 ; q < m;q++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            sum = 0;
            int[] memo = new int [end+1];
            memo[start] = getNumDP(start,k);
            if(start+1 < memo.length)
                memo[start+1] = getNumDP(start+1,k);
            for(int i = start+2;i <= end;i++){
                memo[i] = memo[i-1]+memo[i-2];
            }
            for(int i = 0; i < memo.length;i++)
                sum+=memo[i];
            System.out.println(sum);
        }
    }
    public static int getNumDP(int len,int k){
        if( k > len) {
            return 1;
        }
        int [] memo = new int [len+1];
        for(int i = 0; i< k ;i++)
            memo[i] = 1;
        for(int i = k ; i <=len;i++)
            memo[i] = memo[i-1]+memo[i-k];
//        System.out.println(memo[len]);
        return memo[len];
    }
    public static void getNums(int len,int k){
        if(len < 0) return;
        if(len == 0){
            sum++;
            return ;
        }
        getNums(len-1,k);
        getNums(len-k,k);
    }
}
