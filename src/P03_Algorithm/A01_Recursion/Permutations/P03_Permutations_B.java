package P03_Algorithm.A01_Recursion.Permutations;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/20,14:36
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//求字符串"abcdef"的全排列（元素有重复）
public class P03_Permutations_B {
    public static void main(String [] args){
        String str = "bab";
        ArrayList<String> res= new ArrayList<>();
        permutation1(str.toCharArray(),res,0);
//        res = permutation2(str.toCharArray());
        for(int i = 0;i < res.size();i++){
            System.out.println(res.get(i));
        }
    }
    //交换法
    public static void permutation1(char [] arr,ArrayList<String> res,int index){
        if(index == arr.length){
            res.add(new String(arr));
            return ;
        }
        Set<Character> set = new HashSet<>();
        for(int i = index ;i < arr.length;i++){
            //如果 Set 集合中不包含要添加的对象，则添加对象并返回 true，否则返回 false.
            if(set.add(arr[i])){
                swap(arr,index,i);         //递归试探
                permutation1(arr,res,index+1);
                swap(arr,index,i);        //回溯
            }

        }
    }
    //统计次数法
    public static ArrayList<String> permutation2(char [] arr){
        //统计字符出现次数
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ;i < arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        char [] ch = new char[map.size()];
        int [] count = new int[map.size()];
        int i = 0;
        for(char key:map.keySet()){
            ch[i] = key;
            count[i++] = map.get(key);
        }
        ArrayList<String> res = new ArrayList<>();
        char [] temp = new char[arr.length];
        //递归回溯
        permutation2R(ch,count,temp,0,res);
        return res;
    }
    public static void permutation2R(char [] ch,int [] count,char [] temp,int index, ArrayList<String> res){
        if(index == temp.length){
            res.add(new String(temp));
            return ;

        }
        for(int i = 0; i < ch.length;i++){
            if(count[i]!=0){
                temp[index]=ch[i];
                count[i]--;

                permutation2R(ch,count,temp,index+1,res);

                count[i]++;
            }
        }
    }
    public static void swap(char[] str,int index1,int index2){
        char temp = str[index1];
        str[index1] = str[index2];
        str[index2] = temp;
    }

}
