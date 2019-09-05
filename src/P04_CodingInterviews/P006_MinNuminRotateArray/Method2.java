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

        while(start<= end){
            int mid = start + (end - start)/2;

            //mid和start在同一段
            if(array[mid] > array[start] && array[mid] < array[end])
                start = mid+1;
            //mid和start在不同段
            if(array[mid] < array[start]&& array[mid] < array[end]){
                end = mid-1;
            }
        }
        System.out.println(array[start]);
        return array[start];
    }
}
