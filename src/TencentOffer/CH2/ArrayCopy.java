package TencentOffer.CH2;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String [] args){
        int [] a1 = {3,4,5,7,8,9,10,13};
        int [] a2 = {4,5,8,12,13,14,17,19};
        int i = 0,j = 0,k=0;
        int [] temp = new int[a1.length+a2.length];
        while (i < a1.length && j < a2.length){
            if(a1[i] < a2[j])
                temp[k++] = a1[i++];
            else
                temp[k++] = a2[j++];

        }
        while(i < a1.length){
            temp[k++] = a1[i++];
        }
        while(j < a2.length){
            temp[k++] = a2[j++];
        }
        System.out.println(Arrays.toString(temp));
    }
}
