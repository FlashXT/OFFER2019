package P04_CodingInterviews.P001_FindNuminMatrix;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 14:41
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public boolean Find(int target, int [][] array) {
        int m = array.length;
        int n = array[0].length;
        int row = 0,col = n-1;
        while(row < m && col >=0){
            if(array[row][ col] < target){
                row++;
            }else if(array[row][col] > target){
                col--;
            }else{
                return true;
            }
        }
        return false;
    }
}
