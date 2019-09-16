package P04_CodingInterviews.P037_GetNumberOfK;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,9:23
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int GetNumberOfK(int [] array , int k) {

        int start = 0 ;
        int end = array.length-1;
        while(start <= end){
         int mid = start + (end - start)/2;
         if(array[mid] == k){
             int first = mid;
             while(first >0 && array[first] == k)
                 first--;
             int last = mid;
             while(last < array.length-1 && array[last] == k)
                 last++;
             if(first == 0) first=-1;
             if(last == array.length-1)last = array.length;
             return last-first-1;
         }
         else if(array[mid] <k)
             start=mid+1;
         else
             end = mid-1;
        }
        return 0;
    }
}
