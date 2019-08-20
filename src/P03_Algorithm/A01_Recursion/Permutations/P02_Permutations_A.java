package P03_Algorithm.A01_Recursion.Permutations;

import java.util.ArrayList;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/20,14:36
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//求字符串"abcdef"的全排列（元素不重复）
public class P02_Permutations_A {
    public static void main(String [] args){
        String str = "bac";
        ArrayList<String> res= new ArrayList<>();
        permutation(str.toCharArray(),res,0);
        for(int i = 0;i < res.size();i++){
            System.out.println(res.get(i));
        }
    }
    public static void permutation(char [] arr,ArrayList<String> res,int index){
          if(index == arr.length){
                res.add(new String(arr));
                return ;
          }
          for(int i = index ;i < arr.length;i++){
              swap(arr,index,i);            //递归试探
              permutation(arr,res,index+1);
              swap(arr,index,i);            //回溯
          }
    }
    public static void swap(char[] str,int index1,int index2){
        char temp = str[index1];
        str[index1] = str[index2];
        str[index2] = temp;
    }
}
