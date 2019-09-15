package P05_CodeExam.C10_58;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/11 17:00
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class BIGO {

        static int minpath = Integer.MAX_VALUE;
        public static void main(String [] args){
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int []  arr = new int [n];
                for(int i = 0; i < n;i++){
                    arr[i] = sc.nextInt();
                }
                int sum = 0;
                int [] nums = new int [n];
                for(int i = 0; i < n;i++)
                    nums[i] = 1;

                for(int i = 1; i< n;i++){
                    if(arr[i]> arr[i-1]){
                        if(nums[i] <= nums[i-1])
                            nums[i] = nums[i-1]+1;
                    }

                }
                for(int i = n-2; i>=0;i--){
                    if(arr[i]> arr[i+1]){
                        if(nums[i] <= nums[i+1])
                            nums[i] = nums[i+1]+1;
                    }
                }
                for(int i = 0; i< n;i++)
                    sum+=nums[i];
                System.out.println(sum);

            }


        public static void minpath(int [][] arr,int row,int col,int path){
            if(row == arr.length || col == arr[0].length) return;
            if(row == arr.length-1 && col == arr[0].length-1){
                minpath = minpath > path? path:minpath;
                return ;
            }
            if(row+1 < arr.length)
                minpath(arr,row+1,col,path+arr[row+1][col]);
            if(col+1 < arr[0].length)
                minpath(arr,row,col+1,path+arr[row][col+1]);
//            if(row >= 1)
//                minpath(arr,row-1,col,path+arr[row-1][col]);
//            if(col >= 1)
//                minpath(arr,row,col-1,path+arr[row][col-1]);

        }
}
