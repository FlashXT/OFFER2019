package P04_CodingInterviews.OldVersion.CH8.Problem52_multiply;

import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/16 15:24;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class MultiplyArray {
    public static  void  main(String [] args){

        int [] arr = {1,2,3,4,5};
        int [] res = Multiply2(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] Multiply2(int [] arr){
        int [] res = new int[arr.length];
        //空间复杂度O(n),时间复杂度O(n)
        int [] former = new int[arr.length];
        int [] letter = new int[arr.length];
        for(int i = 0; i<res.length;i++){
            res[i]  = 1;
            former[i] = 1;
            letter[i] = 1;
        }

        for(int i = 1; i < arr.length;i++){
            former[i]*= former[i-1]*arr[i-1];
        }

        for(int i = arr.length-2; i>=0;i--){
            letter[i]*= letter[i+1]*arr[i+1];
        }

        for(int i = 0; i < res.length;i++)
            res[i] = former[i]*letter[i];
        return res;
    }
    //时间复杂度O(n^2)
    public static int[] Multiply1(int [] arr){
        int [] res = new int[arr.length];
        for(int i = 0; i<res.length;i++)
            res[i] =1;
        for(int i = 0; i < arr.length;i++){
            for(int j = 0; j< arr.length;j++){
                if(i != j)
                    res[i]*= arr[j];
            }
        }
        return res;
    }
}
