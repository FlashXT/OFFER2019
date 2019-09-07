package P04_CodingInterviews.P006_MinNuminRotateArray;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 9:28
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method3 {

    public int minNumberInRotateArray(int [] array) {
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            //(1)array[mid] > array[high]:
            //出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
            if(array[mid] > array[high]){
                low = mid + 1;
            //(2)array[mid] == array[high]:
            //出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边.
            //还是右边,这时只好一个一个试; high = high - 1
            }else if(array[mid] == array[high]){
                high = high - 1;
            //(3)array[mid] < array[high]:
            //出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
            //边。因为右边必然都是递增的。
            //high = mid
            }else{
                high = mid;
            }
        }
        System.out.println(array[low]);
        return array[low];
    }
}
