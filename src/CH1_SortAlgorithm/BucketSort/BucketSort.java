package CH1_SortAlgorithm.BucketSort;

public class BucketSort {

    public static void main(String [] args){
            int arr [] = {12,10,38,42,75,68,54,9,40};
            CountSort(arr);
            System.out.println(arr);
    }
    //计数排序
    public static void CountSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length;i++)
            max = max < arr[i]? arr[i]:max;
        int [] bucket = new int[max+1];
        for(int i = 0; i < arr.length;i++)
            bucket[arr[i]]++;
        int i = 0;
        for(int j = 0; j < bucket.length;j++)
            while(bucket[j]-- > 0)
                    arr[i++] = j;

    }
}
