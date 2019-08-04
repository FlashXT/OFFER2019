package Test.NetEase;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//https://blog.csdn.net/Cworld2017/article/details/81814671
//康托展开:     已知一个排列，求这个排列在全排列中是第几个;
//康托展开逆运算：已知在全排列中排第几，求这个排列.
public class Main1 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String res = "";
        for(int i = 0; i < n;i ++)
            res+=scan.nextInt();
        int nums = Factorial(n);
//        for(int i = 1; i < nums;i++){
//            System.out.println(i+"\t:"+getPermutation(n,i));
//        }
        int m = getPermutation( n, res);

        //nums+1-m
        System.out.println(getPermutation2(n,m));


    }
    //康托展开
    public static int getPermutation(int n, String str) {

        int res = 1;
        for(int i = 0; i < n;i++){
            res+= place(str.substring(i),str.charAt(i))*Factorial(n-i-1);
        }
        return res ;
    }
    public static int place(String str,char num){
        char [] arrs = str.toCharArray();
        Arrays.sort(arrs);
        for(int i = 0; i < arrs.length;i++){
            if(arrs[i] == num)
                return i;
        }
        return -1;
    }

    //康托展开的逆运算
    public static String getPermutation1(int n, int k) {
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
    public static String getPermutation2(int n, int k){
        //用辗转相除法确定康托展开中的系数
        List<Integer> nums = new LinkedList<>();
        for(int i = 1; i <= n; i++)
            nums.add(i);
        String res = "";
        k--;
        while(n > 0){
            int pos = k/Factorial(n-1);
            k = k%Factorial(n--);
            res+=nums.get(pos%nums.size())+" ";
            nums.remove(pos%nums.size());
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
