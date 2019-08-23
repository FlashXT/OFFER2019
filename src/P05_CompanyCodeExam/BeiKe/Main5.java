package P05_CompanyCodeExam.BeiKe;
import java.math.BigInteger;

import java.util.Scanner;
import java.util.WeakHashMap;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/23,19:47
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main5 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int n = scan.nextInt();
        int [] nums = new int [n];
        for(int i = 0; i < nums.length;i++)
            nums[i] = scan.nextInt();
        for(int i = 0; i< n;i++){
            System.out.println(ways(str,new BigInteger(nums[i]+"")));
        }

    }
    public static int ways(String str,BigInteger key){
        int res = 0;
        int left = 0,right=0;
        int end = str.length();
        BigInteger temp = new BigInteger("0");
        while(right< end){
            if(left == right){
                right++;
                temp = new BigInteger(str.substring(left,right));
            }

            while( right < end &&temp.divideAndRemainder(new BigInteger("1000000007"))[1].compareTo(key) < 0 ){

                temp = new BigInteger(str.substring(left,right));
                right++;
            }
            while(left < right && temp.divideAndRemainder(new BigInteger("1000000007"))[1].compareTo(key) >0){

                temp = new BigInteger(str.substring(left,right));
                left++;
            }
            if(left < right && temp.divideAndRemainder(new BigInteger("1000000007"))[1].compareTo(key)==0){
                left++;
                res++;
            }

        }
        return res;
    }
}
