package TencentOffer.CH4.Matrix;
/*******************************************************************
*给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一列都是排好序的。
* 实现一个函数，判断K是否在matrix中。
* 例如：
*           0 1 2 5
*           2 3 4 7
*           4 4 4 8
*           5 7 7 9
*
* 如果K为7，返回true；如果K为6，返回false。
*【要求】：时间复杂度为O(N+M)，额外空间复杂度为O(1).
* 思路：根据数据的特点，从左下角或右上角开始比较，可以使得每更新一步可以排除一部
* 分数据；进而判断key 是否存在；
 ******************************************************************/
public class MatrixSearch {
    public static void main(String [] args){
        int [][] arr = {    {0,1,2,5},
                            {2,3,4,7},
                            {4,4,4,8},
                            {5,7,7,9}
                       };
        System.out.println(isInMstarix(arr,4));

    }
    public static boolean isInMstarix(int[][] arr,int key){
        int m = arr.length-1;
        int n = arr[0].length-1;
        int row = 0,col = n;
        while( row <= m && col >= 0){

            if(arr[row][col] < key){
                row++; // 若比 key 小，向下继续查找
            }
            else if(arr[row][col]> key){
                col--;// 若比 key 大，向左继续查找
            }

            else if(arr[row][col] == key) return true;

        }
        return false;

    }
}
