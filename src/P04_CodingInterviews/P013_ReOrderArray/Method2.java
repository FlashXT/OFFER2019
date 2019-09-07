package P04_CodingInterviews.P013_ReOrderArray;

import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 11:24
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//该方法不能保证奇数和偶数的相对位置不变。
public class Method2 {
    public void reOrderArray(int [] array) {
        int ptr = 0; //ptr只想排好序的奇数的下一个位置
        for(int i = 0; i < array.length;i++){
            if(array[i] % 2==1){
                int j = i;
                while(j > ptr){
                    swap(array,j,j-1);
                    j--;
                }
                ptr++;
            }

        }
        System.out.println(Arrays.toString(array));
    }
    private void swap(int[] array,int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
