package TencentOffer.CH3;

import java.util.Arrays;

public class Problem14_ArrayPartation {
    public static void main(String [] args){
        int [] arr = {22};

        Partation(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void Partation(int [] arr){
        if(arr.length <=1)
            return ;
        int p1 = 0;
        int p2 = arr.length-1;
        while(p1 < p2) {
            while((arr[p2] & 0x1) == 0)
                p2--;
            while((arr[p1] & 0x1) == 1)
                p1++;
            if(p1 != p2)
                swap(arr, p1, p2);

            //这种方法会做多次无用的交换，但是也能保证结果正确
//            if((arr[p2] & 0x1) == 0)
//                p2--;
//            if((arr[p1] & 0x1) == 1)
//                p1++;
//            else{
//                if(p1 != p2)
//                    swap(arr, p1, p2);
//            }
        }
    }
    public static void swap(int [] arr,int pos1,int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}
