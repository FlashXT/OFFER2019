package BucketSort;
//求一列数组排好序后的相邻数字间的最大差值；
public class MaxGap {
    public static void main(String [] args){

        int [] arr = {1,2,34,38,56,59,60,80,120};
        System.out.println(MaxGap(arr));
    }
    public static int MaxGap(int []arr){
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < len;i++){
            min = min > arr[i] ? arr[i]:min;
            max = max < arr[i] ? arr[i]:max;
        }
        int buckets = (max - min)/10+1;
        boolean[] hasnum = new boolean[buckets];
        int [] maxs = new int[buckets];
        int [] mins = new int[buckets];

        int pos = 0;
        for(int i = 0; i< len;i++){
            pos = bucket(arr[i],buckets,min);
            mins[pos] = hasnum[pos] ? Math.min(arr[i],mins[pos]):arr[i];
            maxs[pos] = hasnum[pos] ? Math.max(arr[i],maxs[pos]):arr[i];
            hasnum[pos] =true;
        }
        int res = 0;
        int lastmax = maxs[0];
        int i = 1;
        while(i < buckets){
            if(hasnum[i]){
                res = (mins[i] - lastmax) > res?(mins[i] - lastmax):res;
                lastmax = maxs[i];
            }
            i++;
        }
        return res;
    }
    public static int bucket(int num,int buckets,int min){
        int pos = (num - min)/buckets;
        return pos;
    }
}
