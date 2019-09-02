package P05_CodeExam.TrendTest.Problem1;

import java.util.Scanner;

/*****************************************************************
 * @Author:turboMan;
 * @Date:19-8-8 下午6:43;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Adder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String sum = add(num1,num2);
        System.out.println(sum);
    }

    private static String [] dataprocess(String num1){
        //数据预处理：防止整数加小数的情况，统一补为小数
        String [] nums1 = new String[2];
        if(num1.split("\\.").length == 2){
            nums1[0] = num1.split("\\.")[0];
            nums1[1] = num1.split("\\.")[1];
        }
        else{
            nums1[0] = num1.split("\\.")[0];
            nums1[1] = "0";
        }
        return nums1;
    }
    //该函数实现整数部分或小数部分的相加
    //carry表示进位，flag表示计算整数部分(0)还是小数部分(1)，计算小数部分时需要右边补0
    private static String addpart(String num1, String num2,int carry,int flag){
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        //如果计算的是小数部分，对位数较短的数字进行右边补0
        if(flag==1){
            if(index1 < index2){
                while(index1 <index2){
                    //计算小数部分是右边补0
                    num1 = num1+"0";
                    index1++;
                }
            }
            if(index1 > index2){
                while(index2 <index1){
                    num2 = num2+"0";
                    index2++;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        int  n1 ,n2;
        //循环终止条件
        while(index1 >=0 || index2 >=0 ||carry >0){
           if(index1 < 0)
               n1 = 0;
           else
               n1 = num1.charAt(index1--)-'0';
           if(index2 < 0)
               n2 = 0;
           else
               n2 = num2.charAt(index2--)-'0';
            res.insert(0,(n1+n2+carry)%10);
            carry = (n1+n2+carry)/10;
        }
        return res.toString();
    }
    private static String add(String num1, String num2){
        String [] nums1 = dataprocess(num1);
        String [] nums2 = dataprocess(num2);
        //len表示小数部分的最大长度，如果小数部分计算的结果长度大于len,则表示有进位
        int len = nums1[1].length()> nums2[1].length()?nums1[1].length():nums2[1].length();
        String n2 = addpart(nums1[1],nums2[1],0,1);

        int carry = 0;
        if(n2.length()>len){
            carry = n2.charAt(0)-'0';
            n2 = n2.substring(1);
        }
        String n1 = addpart(nums1[0],nums2[0],carry,0);
        StringBuilder res = new StringBuilder(n1+"."+n2);
        int left = 0,right=res.length()-1;
        while(res.charAt(left)=='0'){
            left++;
        }
        while(res.charAt(right)=='0'){
            right--;
        }
        if(res.charAt(right)=='.') right--;
        return res.substring(left,right+1);
    }


}
