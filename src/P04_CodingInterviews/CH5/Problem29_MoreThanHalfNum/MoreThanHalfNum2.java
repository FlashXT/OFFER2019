package P04_CodingInterviews.CH5.Problem29_MoreThanHalfNum;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/12 19:52
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class MoreThanHalfNum2 {
    public static void main(String [] args){
        int [] arr = {1,2,3,4,5,2,2,2,2,2};
        System.out.println(MoreThanHalfNum(arr));
    }
    public static int MoreThanHalfNum(int [] arr) {
        if(arr.length == 0) return 0;
        int result = arr[0];
        int time  = 1;
        for(int i = 1;i < arr.length;i++){
            if(arr[i] == result){
                time++;
            }
            else{
                time--;
            }
            if(time == 0){
                result = arr[i];
                time = 1;
            }
        }
        int times = 0;
        for(int i =0 ; i<arr.length;i++){
            if(arr[i] == result)
                times++;
        }
        if(times > arr.length/2)
            return result;
        return 0;
    }

}
