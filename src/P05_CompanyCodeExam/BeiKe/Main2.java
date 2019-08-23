package P05_CompanyCodeExam.BeiKe;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/8/10 18:45
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main2 {

    public static  void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int [] nums = new int[10];
        for(int i = 0; i< 10;i++)
            nums[i] = scan.nextInt();
        int i =1 ;
        while( !isAllZero(nums)){
            int temp = i;
            while(temp!=0){
                nums[temp%10]--;
                temp = temp/10;
            }
            i++;
        }

        if(isAllZeros(nums)){
            System.out.println("No Answer");
            return;
        }

        Map<Integer,Integer> map= new HashMap<Integer, Integer>();

        int len = 0;
        for(int k = 0; k < nums.length;k++){
            if(nums[k] < 0){
                map.put(k,-nums[k]);
                len++;
            }
        }
        int []digits = new int[map.size()];
        int [] count = new int[map.size()];
        int m = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            digits[m] = entry.getKey();
            count[m++]=entry.getValue();
        }
        List<String> res = new ArrayList<>() ;
        permute(digits,count,len,"",i-1,res);
        for(int q= 0; q < res.size();q++)
            System.out.println(res.get(q));

    }
    public static boolean isAllZero(int [] nums){
        for(int i = 0; i < nums.length;i++)
            if(nums[i]> 0)
                return false;
        return true;
    }
    public static boolean isAllZeros(int [] nums){
        for(int i = 0; i < nums.length;i++)
            if(nums[i]!=0)
                return false;
        return true;
    }
    public static void permute(int [] nums ,int []count,int len,String temp,int num,List<String> res){
        if( len == temp.length()){
            res.add(num+" "+new String(temp));
            return ;
        }

        for(int i = 0; i < nums.length;i++){
            if(count[i]>0){
                temp+=nums[i];
                count[i]--;
                permute(nums,count,len,temp,num,res);
                temp= temp.substring(0,temp.length()-1);
                count[i]++;
            }
        }

    }

}
