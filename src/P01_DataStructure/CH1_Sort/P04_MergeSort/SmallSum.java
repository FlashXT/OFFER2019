package P01_DataStructure.CH1_Sort.P04_MergeSort;

/******************************************************************************
 * 求小和问题：在随机元素，随机数组大小的数组中，找出左边比右边元素小的所有元素之和。
 *
 * 例如：数组[4,2,5,1,7,3,6]
 *      第一个元素4比2大，不算小和，5比4和2都大，那就是4+2=6；1比4和2和5都小，不算小和；
 *      7比前面的都大，那就是上次小和6+4+2+5+1=18；
 *      然后3前面比2和1大，那就是18+2+1=21；
 *      最后6比4、2、5、1、3都大，结果就是21+4+2+5+1+3=36。那么最后的结果就是36。
 *
 * 解法：使用归并排序来进行求和，在归并的时候把数组分成左右两个，在归并排序进行左右两个数组进行
 *      合并排序的时候进行计算。如果左边数组元素N，小于右边数组元素M，那么从右边数组右指针P到
 *      右边数组最后R就有(R-P+1)个N，依次累计相加，最后求出最小和。
 *
 ********************************************************************************/
public class SmallSum {

    public static void main(String [] args){

        int [] arr = {4,2,5,1,7,3,6};
        int smallsum = MergeSort(arr,0,arr.length-1);
        System.out.println(smallsum);
    }
    public static int MergeSort (int [] arr,int start,int end){
        if(start == end) return 0;
        int mid = start+(end-start)/2;
        return  MergeSort(arr,start,mid)+
                MergeSort(arr,mid+1,end)+Merge(arr,start,mid,end);

    }
    public static int Merge(int []arr,int start,int mid,int end){
        int i = start;
        int j = mid+1;
        int k =0;
        int res = 0;
        int [] temp = new int[end-start+1];
        while(i <= mid && j <= end){
            if(arr[i] < arr[j]){
                res+=arr[i]*(end + 1 - j);
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }

        while(j <= end)
            temp[k++] = arr[j++];

        while(i <= mid)
            temp[k++] = arr[i++];

        for(i = 0 ;i <temp.length; i++)
            arr[start + i] = temp[i];
        return res;
    }

}
