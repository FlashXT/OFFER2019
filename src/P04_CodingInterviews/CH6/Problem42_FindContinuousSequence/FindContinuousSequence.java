package P04_CodingInterviews.CH6.Problem42_FindContinuousSequence;

import java.util.ArrayList;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 13:05;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class FindContinuousSequence {
    public static void main(String [] args){
        ArrayList<ArrayList<Integer>> res= FindContinuousSequence(9);
        for (int i = 0; i< res.size();i++){
            for(int j = 0;j < res.get(i).size();j++)
                System.out.printf("%d\t",res.get(i).get(j));
            System.out.println();
        }
    }
    public static  ArrayList<ArrayList<Integer>> FindContinuousSequence(int num){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int start = 1,end = 2;
        int mid = (1+num)/2;
        temp.add(start);
        temp.add(end);
        while(start < mid){
            if(sum(start,end) < num){
                temp.add(++end);
            }
            else if(sum(start,end) >num)
                temp.remove((Integer)start++);
            else {

                list.add(new ArrayList<>(temp));
                temp.remove((Integer)start++);
            }
        }
    return list;
    }
    public static int sum(int start,int end){
        for(int i = start+1;i <=end;i++){
            start+=i;
        }
        return start;
    }
}
