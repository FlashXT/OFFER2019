package TencentOffer.CH5.Problem33_PrintMinNumber;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/13 21:21
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class PrintMinNumber {
    public static void main(String [] args){
        int [] arr ={3,32,321};
        PrintMinNumber(arr);
    }
    public static  void PrintMinNumber(int [] arr){
        for(int i =0; i< arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(compare(arr[i],arr[j]) >0){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int item:arr) {
            res.append(item);
        }
        System.out.println(res);
    }
    //学习比较函数的定义，比较巧妙
    public static  int compare(int n1,int n2){
        String str1 = ""+n1+n2;
        String str2 = ""+n2+n1;
        if(str1.compareTo(str2) >0)
            return -1;
        else
            return 1;
    }

}
