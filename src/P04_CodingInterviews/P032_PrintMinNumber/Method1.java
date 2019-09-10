package P04_CodingInterviews.P032_PrintMinNumber;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/10 17:49
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public String PrintMinNumber(int [] arr){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < arr.length;i++){
            for(int j = i+1;j < arr.length;j++){
                if(compare(arr[i],arr[j]) < 0){
                    //swap(arr[i],arr[j])
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        for(int i = 0; i< arr.length;i++){
            res.append(arr[i]);
        }
        return res.toString();
    }
    public  static  int compare(int num1,int num2){
        String str1 = ""+num1+num2;
        String str2 = ""+num2+num1;
        return str1.compareTo(str2);
    }
}
