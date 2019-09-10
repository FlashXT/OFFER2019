package P04_CodingInterviews.P033_GetUglyNumber;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/10 18:03
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//解析：https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b?f=discussion
public class Method1 {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0) return 0;
        int [] arr = new int[index];
        arr[0] = 1;
        int index2 = 0,index3 =0,index5 = 0;
        for(int i =1;i < arr.length;i++){
            arr[i] = Math.min(arr[index2]*2,Math.min(arr[index3]*3,arr[index5]*5));
            if(arr[i] == arr[index2]*2) index2++;
            if(arr[i] == arr[index3]*3) index3++;
            if(arr[i] == arr[index5]*5) index5++;
        }
        return arr[index-1];
    }
}
