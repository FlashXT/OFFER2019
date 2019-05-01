package Algorithm.DynamicProgramming.DP02_Triangle;

import java.util.*;

/*********************************************************************************
 * LeetCode120：Given a MainClass_triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following MainClass_triangle
 *      [
 *              [2],
 *             [3,4],
 *            [6,5,7],
 *           [4,1,8,3]
 *       ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *     Bonus point if you are able to do this using only O(n) extra space, where
 *  n is the total number of rows in the MainClass_triangle.
 *  //递归同时回溯，其实是暴力穷举，时间超过限制；
 **********************************************************************************/
public class MainClass_triangle {
    public static void main(String [] args){
        //[[7],[-5,9],[6,5,2],[-8,-2,-7,3],[-2,6,-6,-1,4]]
        List<List<Integer>> list = new ArrayList<>();
        Integer[] arr1 = {7};
        List<Integer> list1 = Arrays.asList(arr1);
        Integer[] arr2 = {-5,9};
        List<Integer> list2 = Arrays.asList(arr2);
        Integer[] arr3 = {6,5,2};
        List<Integer> list3 = Arrays.asList(arr3);
        Integer[] arr4 = {-8,-2,-7,3};
        List<Integer> list4 = Arrays.asList(arr4);
        Integer[] arr5 = {-2,6,-6,-1,4};
        List<Integer> list5 = Arrays.asList(arr5);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);

        for(int i = 0; i < list.size();i++) {
            for (int j = 0; j < list.get(i).size(); j++)
                System.out.printf("%4d",list.get(i).get(j));
            System.out.println();
        }
        System.out.println("========================");
        System.out.println(Mehtod2.minimumTotal(list));
        System.out.println(Mehtod3.minimumTotal(list));
        System.out.println(Mehtod4.minimumTotal(list));
        System.out.println(Mehtod5.minimumTotal(list));


    }






}
