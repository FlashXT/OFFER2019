package P04_CodingInterviews.CH6.Problem40_FindNumsAppearOnce;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 9:49;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class FindNumsAppearOnce {
    public static void main(String [] args){
        int [] arr = {2,4,3,6,3,2,5,5};
        int []num1 = new int[arr.length/2];
        int []num2 = new int[arr.length/2];
        FindNumsAppearOnce(arr,num1,num2);

        System.out.println(num1[0]+""+num2[0]);


    }
    public static void FindNumsAppearOnce(int [] arr,int[] num1,int[] num2){
        int res = 0;
        for(int num:arr){
            res ^=num;
        }
        int index = FindFirstBitisOne(res);

        for(int i = 0;i < arr.length;i++){
            if(IsBit1(arr[i]&res,index))
                num1[0]^= arr[i];
            else{
                num2[0]^= arr[i];
            }
        }
    }
    public static int FindFirstBitisOne(int num){

        int i = 0;
        while(num!=0 && i<8*32){
            if((num&1) == 1)
                break;
            num =num >> 1;
            i++;

        }
        return i;
    }
    public static Boolean IsBit1(int num,int index){
        num = num >> index;
        return (num&1)==0 ? false:true;
    }

}
