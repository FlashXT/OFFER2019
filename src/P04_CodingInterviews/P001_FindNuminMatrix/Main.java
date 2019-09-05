package P04_CodingInterviews.P001_FindNuminMatrix;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 14:41
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/* 题目：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列
        都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数
        组中是否含有该整数。
 */
public class Main {
    public static void main(String [] args){
        int [][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean res = new Method1().Find(100,arr);
        System.out.println(res);
    }
}
