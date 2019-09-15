package P06_AuditionCoding;

public class TestClass {
    public static void main(String [] args){

        int [] arr = {1,2};

        //第1大数，第2大数，第3大数;
        long [] heap = {Long.MIN_VALUE,Long.MIN_VALUE,Long.MIN_VALUE};

        int i = 0;
        while(i < arr.length){
            if(arr[i] > heap[0]){
                heap[2] = heap[1];
                heap[1] = heap[0];
                heap[0] = arr[i];

            }
            else if(arr[i]< heap[0] && arr[i] > heap[1]){
                heap[2] = heap[1];
                heap[1] = arr[i];
            }
            else if(arr[i] < heap[1] && arr[i] > heap[2]){
                heap[2] = arr[i];
            }
            i++;
        }
        if(heap[2] == Long.MIN_VALUE )
            System.out.println(heap[0]);
        else
            System.out.println(heap[2]);
    }


}
