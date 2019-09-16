package P04_CodingInterviews.P040_FindNumsAppearOnce;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,10:48
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = 0;
        for(int i = 0; i < array.length;i++){
            temp = temp ^ array[i];
        }
        int bit = 1;
        while((bit&temp)==0){
            bit = bit<<1;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0 ; i< array.length;i++){
            if((array[i]&bit)==0)
                list1.add(array[i]);
            else
                list2.add(array[i]);
        }

        for(int i = 0; i < list1.size();i++)
            num1[0] = num1[0]^list1.get(i);

        for(int i = 0; i < list2.size();i++)
            num2[0] = num2[0]^list2.get(i);

    }
}
