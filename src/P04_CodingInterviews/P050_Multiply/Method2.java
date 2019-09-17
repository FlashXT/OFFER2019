package P04_CodingInterviews.P050_Multiply;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/17,20:35
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method2 {
    public int[] multiply(int[] A) {
        int [] first = new int [A.length];
        int [] second = new int[A.length];
        first[0]=1;
        for(int i = 1; i < A.length;i++){
            first[i]=first[i-1]*A[i-1];

        }
        second[A.length-1]=1;
        for(int i = A.length-2; i >=0;i--){
            second[i]=second[i+1]*A[i+1];

        }
        int []B = new int[A.length];
        for(int i = 0; i < A.length;i++){
            B[i] = first[i]*second[i];
        }
        return B;
    }
}
