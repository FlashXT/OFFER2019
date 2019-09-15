package P05_CodeExam.C15_DuXiaoMan.Problem02;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/15,18:21
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    static int mincost = Integer.MAX_VALUE;
    static int a = 0,b =0,c =0;
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
         a = scan.nextInt();
         b = scan.nextInt();
         c = scan.nextInt();
        int [] arr = new int[N];
        for(int i = 0 ;i < N;i++)
            arr[i] = scan.nextInt();
        boolean [] visited = new boolean[arr.length];
        minCost(arr,1,0);
        System.out.print(mincost);

    }
    public static void minCost(int [] arr,int index,int cost){
        if(index > arr.length)
            return;
        if(index == arr.length){
            mincost = mincost > cost ? cost:mincost;
            return;
        }

        if(index >= 1 && index <= arr.length)
            minCost(arr,arr[index-1],cost+a);
        if(arr[index-1] >1){
            minCost(arr,arr[index-1]-1,cost+b+a);
        }
        if(arr[index-1]  < arr.length){
            minCost(arr,arr[index-1]+1,cost+c+a);
        }

    }
}
