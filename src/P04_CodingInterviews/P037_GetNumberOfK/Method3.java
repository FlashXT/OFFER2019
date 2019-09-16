package P04_CodingInterviews.P037_GetNumberOfK;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,9:53
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method3 {
    public int GetNumberOfK(int [] array , int k) {
        return getLast(array,k)-getFirst(array,k)+1;
    }
    public static int getFirst(int [] array,int k){
        int start = 0 ;
        int end = array.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(array[mid] == k){
              end = mid-1;
            }
            else if(array[mid] < k)
                start = mid+1;
            else
                end = mid-1;
        }
        return start;
    }
    public static int getLast(int [] array,int k){
        int start = 0 ;
        int end = array.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(array[mid] == k){
                start = mid+1;
            }
            else if(array[mid] < k)
                start = mid+1;
            else
                end = mid-1;
        }
        return end;
    }
}
