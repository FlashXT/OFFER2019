package Algorithm.BackTrack;

import java.util.Arrays;
import java.util.Scanner;

/***********************************************************
 * 某财务部门结账时发小总金额不对。很可能时从明细上漏掉了某1笔或几笔。
 * 如果已知明细账目清单，能通过编程找到漏掉的是哪一笔或几笔吗？
 * 如果有多种可能，则输出所有可能的情况。
 * 规定：
 *    用户输入的第一行：有错的总金额；
 *    接下来是一个整数 n，表示下面将要输入的明细账目的条数；
 *    再接下来是 n 行整数，分别表示每笔账目的金额。
 *    要求是程序输出，所有可能漏掉的金额组合。每个情况1行，金额按照从
 *    小到大排列，中间用空格分开。
 * 示例：
 *    用户输入：
 *    6      //总金额6
 *    5      //明细共5笔
 *    3
 *    2
 *    4
 *    3
 *    1
 *    程序输出：
 *    3 3 1
 *    3 4
 *    2 4 1
 *    4 3
 *
 ************************************************************/
public class errorSum {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        int num = scan.nextInt();
        int i = 0;
        int [] arr = new int [num];
        while(i < arr.length){
            arr[i++] = scan.nextInt();
        }
        boolean[] bool = new boolean[arr.length];
//        System.out.println(Arrays.toString(arr));
        errorSum(0,arr,sum,0,bool);

    }
    public static void errorSum(int curr_sum,int [] arr,int sum,int pos,boolean[] bool){

        if(curr_sum > sum) return ;
        if(curr_sum == sum){
            for(int i= 0; i< arr.length;i++)
                if(!bool[i])
                    System.out.print(arr[i]+" ");
            System.out.println();
            return ;
        }
        if( pos >= arr.length) return;

        for(int i = pos; i < arr.length;i++ ){
            bool[i] = true;

//            System.out.println(Arrays.toString(bool));
            errorSum(curr_sum+arr[i],arr,sum,i+1,bool);    //试探

            bool[i] = false;                                           //回溯


        }

    }
}
