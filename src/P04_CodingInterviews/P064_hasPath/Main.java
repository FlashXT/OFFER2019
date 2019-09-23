package P04_CodingInterviews.P064_hasPath;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/19,21:02
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static  void main(String []args){
        char [] matrix = "AAAAAAAAAAAA".toCharArray();
        int rows = 3,cols = 4;
        char [] str = "AAAAAAAAAAAAA".toCharArray();
        boolean res = new Method3().hasPath(matrix,rows,cols,str);
        System.out.println(res);

    }
}
