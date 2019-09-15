package P06_AuditionCoding;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/7 20:39
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    static  int res = 0;
    public static void main(String [] args){
        int x = 3;
        int y = 3;
        Methods(x,y);

    }
    public static int Methods(int x,int y){
        res = 0;
        getNums(x,y,0,0);
        System.out.println(res);
        return res;
    }
    public static void getNums(int x ,int y,int ix,int iy){
        if(ix == x - 1 && iy == y-1){
            res++;
            return ;
        }
        //向右走
        if(ix+1 < x)
        getNums(x,y,ix+1,iy);
        //向下走
        if(iy+1 < y)
        getNums(x,y,ix,iy+1);
    }
}