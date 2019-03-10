package SortAlgorithm;

public class SmallSum {

    public static void main(String [] args){
        int [] arr={4,1,3,5,0,6};
        int smallsum = MergeSort(arr,0,arr.length-1);
        System.out.println(smallsum);
    }
    public static int MergeSort (int [] arr,int start,int end){
        if(start == end) return 0;
        int mid = start+(end-start)/2;
        return MergeSort(arr,start,mid)+ MergeSort(arr,mid+1,end)+Merge(arr,start,mid,end);

    }
    public static int Merge(int []arr,int start,int mid,int end){
        int i = start;
        int j = mid+1;
        int k =0;
        int res = 0;
        int [] temp = new int[end-start+1];
        while(i <= mid && j <= end){
            if(arr[i] < arr[j]){
                res+=arr[i]*(end+1 - j);
                i++;
                temp[k++] = arr[i++];
            }

            else{
                temp[k++] = arr[j++];
                j++;
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
