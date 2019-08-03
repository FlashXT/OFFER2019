package Test.NetEase;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = 0;
        String res ="";
        while(k< n){
            res += scan.nextInt()+" ";
            k++;
        }
        int nums = Factorial(n);
        int m = getPermutation( n, res);
        System.out.println(getPermutation(n,nums-m));

    }
    public static int getPermutation(int n, String str) {
        int res = 0;
        for(int i = 0; i < str.length()-1;i+=2){
            int temp = Integer.valueOf(str.charAt(i)-'0');
            res+= Math.abs(temp-i-1)*Factorial(str.length()-i-3);
        }
        return res;
    }
    public static String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList<>();
        for(int i = 1; i <= n; i++)
            nums.add(i);
        String res = "";
        int pos = -1;
        while(n >= 1){
            int count = Factorial(n-1);
            pos = k /count;
            k = k%count;
            //余数为0时特殊情况，单独考虑
            if(k==0){
                res+=nums.get(pos-1)+" ";
                nums.remove(pos-1);
                int i = nums.size()-1;
                while (i >=0 ){
                    res+=nums.get(i--)+" ";
                }
                break;
            }
            res += nums.get(pos)+" ";
            nums.remove(pos);
            n--;
        }
        return res;
    }
    public static int Factorial(int n){
        int res =1;
        for(int i = 2; i <= n;i++){
            res*=i;
        }
        return res;
    }

}
