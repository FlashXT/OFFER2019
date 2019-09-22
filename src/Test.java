import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/20 20:07
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Test {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Long [] A = new Long[n];
        Long [] B = new Long[m];
        Long max = Long.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < A.length;i++){

            A[i] = scan.nextLong();
            A[i] = A[i] < 0?-A[i]:A[i];
            if(max < A[i]){
                max = A[i];
                index = i;
            }
        }
        A[index] = Long.MIN_VALUE;
        max = Long.MIN_VALUE;
        for(int i = 0; i < B.length;i++){
            B[i] = scan.nextLong();
            B[i] = B[i] < 0?-B[i]:B[i];
            if(max < B[i]){
                max = B[i];
            }
        }
        Long sum = max;
        max = Long.MIN_VALUE;
        for(int i = 0; i < A.length;i++){
            if(max < A[i]){
                max = A[i];
            }
        }
        System.out.println(sum*max);

    }
}
