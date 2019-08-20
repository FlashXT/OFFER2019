package P04_CodingInterviews.CH8.Problem67_movingCount;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/17 16:03;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class movingCount {
    public static  void main(String [] args){
        System.out.println(movingCount(12,8,7));
    }
    public static int movingCount(int threshold, int rows, int cols)
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
