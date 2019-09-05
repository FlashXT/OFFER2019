package P04_CodingInterviews.OldVersion.CH8.Problem51_Duplicate;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/16 15:01;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem51_Duplicate {
    public static void main(String [] args){
        int [] arr = {2,3,1,0,2,5,3};
        System.out.println(duplicate(arr,arr));
    }
    public static boolean duplicate(int numbers[],int [] duplication) {
        if(numbers == null || numbers.length == 0) return false;
        int i = 0;
        for(; i< numbers.length;i++){
            if(numbers[i]!= i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }

                else
                    swap(numbers,i,numbers[i]);
            }
        }

        return false;
    }
    public static int Duplicate(int [] dup){
        int i = 0;
        for(; i< dup.length;i++){
            if(dup[i]!= i){
                if(dup[i] == dup[dup[i]])
                    break;
                else
                    swap(dup,i,dup[i]);
            }
        }
        swap(dup,i,0);
        return dup[0];

    }
    public static void swap(int [] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
