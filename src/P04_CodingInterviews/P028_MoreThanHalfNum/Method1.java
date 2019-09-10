package P04_CodingInterviews.P028_MoreThanHalfNum;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/10 15:45
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public  int MoreThanHalfNum_Solution(int [] arr) {
        int mid = arr.length>>1;
        int start = 0;
        int end = arr.length-1;
        int index = Partation(arr,start,end);
        while(index != mid){
            if(index < mid){
                start = index+1;
            }else {
                end = index-1;
            }
            index = Partation(arr,start,end);
        }
        int res = arr[mid];
        if(Veritify(arr,res))
            return res;
        else
            return 0;
    }
    public static boolean Veritify(int [] nums ,int res){
        int num = 0;
        for(int i = 0;  i< nums.length;i++){
            if(nums[i] == res)
                num++;
        }
        if(num *2 > nums.length)
            return true;
        return false;
    }
    private static int Partation(int [] nums,int start,int end){
        int pivot = nums[end];
        int lessborder = start - 1;
        for(int i = start; i <=end;i++ ){
            if(nums[i] <= pivot){
                int temp = nums[++lessborder];
                nums[lessborder] = nums[i];
                nums[i] = temp;
            }
        }
        return lessborder;
    }
}
