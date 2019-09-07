package P04_CodingInterviews.P006_MinNuminRotateArray;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 17:03
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;
        int start = 0, end = array.length-1;
        while(start < end){
            //确认子数组是否是类似1,1,2,4,5,..,7的非递减数组
            if(array[start] < array[end]) break;
            int mid = start+(end-start)/2;
            //如果左半数组为有序数组
            if(array[start] < array[mid] )
                start = mid+1;
            //如果右半数组为有序数组
            else if( array[mid] < array[end])
                end = mid;
            //否则，rotateArray[left] == rotateArray[mid] == rotateArray[right]
            else {
                start++;
            }
        }
        System.out.println(array[start]);
        return array[start];
    }
}
