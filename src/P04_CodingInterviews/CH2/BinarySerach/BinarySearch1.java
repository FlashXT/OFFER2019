package P04_CodingInterviews.CH2.BinarySerach;

class BinarySearch1 {
    public static int BinarySerach(int key,int [] arr,int start,int end){
        if(start > end) return -1;
        int mid = start +(end - start)/2;
        if( arr[mid] == key)
            return mid;
        else if (arr[mid] > key)
            return BinarySerach(key,arr,start,mid-1);
        else
            return BinarySerach(key,arr,mid+1,end);

    }
}
