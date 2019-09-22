package P04_CodingInterviews.P065_MovingCount;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,21:07
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean [] visited = new boolean[rows*cols];

        int count = movingCount(threshold,rows,cols,0,0,visited);

        return count;
    }
    public static int movingCount(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        int count = 0;
        if(check(threshold,rows,cols,row,col,visited)){
            visited[row*cols+col] = true;
            count = 1+movingCount(threshold,rows,cols,row,col-1,visited)+
                    movingCount(threshold,rows,cols,row,col+1,visited)+
                    movingCount(threshold,rows,cols,row-1,col,visited)+
                    movingCount(threshold,rows,cols,row+1,col,visited);

        }
        return  count;
    }
    public  static boolean check(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        if(row >=0 && row < rows && col >=0 && col < cols &&getDigitSum(row)+getDigitSum(col)<=threshold
                && !visited[row*cols+col]){
            return true;
        }
        return false;

    }
    public static int getDigitSum(int num){
        int sum  = 0;
        while(num >0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
