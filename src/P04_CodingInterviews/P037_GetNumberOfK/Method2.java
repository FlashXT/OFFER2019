package P04_CodingInterviews.P037_GetNumberOfK;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,9:23
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public int GetNumberOfK(int [] array , int k) {

        int start = 0 ;
        int end = array.length-1;
        while(start <= end){
         int mid = start + (end - start)/2;
         if(array[mid] == k){
             int times = 1;
             for(int i = mid+1; i< array.length&&array[i] ==k;i++)
                 times++;
             for(int i = mid-1; i>=0&&array[i] ==k;i--)
                 times++;
             return times;
         }
         else if(array[mid] <k)
             start=mid+1;
         else
             end = mid-1;
        }
        return 0;
    }
}
