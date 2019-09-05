package P04_CodingInterviews.P002_BlankReplace;

import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 14:57
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    //先遍历一遍数组，确定空格的个数，确定要增加的长度，然后从后往前进行替换；
    public String replaceSpace(StringBuffer str) {
        if(str == null ) return str.toString();
        char [] arr = str.toString().toCharArray();
        int num = 0;
        for(int i = 0; i < arr.length;i++){
            if(str.charAt(i) == ' ')
                num++;
        }
        char [] temp = new char[arr.length+2*num];
        for(int i = temp.length-1,j = arr.length-1;i >=0&&j>=0;i--,j--){
            if(arr[j]!= ' '){
                temp[i] = arr[j];
            }else{
                temp[i--] = '0';
                temp[i--] = '2';
                temp[i] = '%';
            }
        }
        System.out.println(temp);
        return String.valueOf(temp);

    }
}
