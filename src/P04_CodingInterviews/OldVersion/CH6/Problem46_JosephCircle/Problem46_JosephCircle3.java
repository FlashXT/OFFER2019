package P04_CodingInterviews.OldVersion.CH6.Problem46_JosephCircle;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/15 20:47
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//f(N,M) = (f(N-1,M)+M)%N
public class Problem46_JosephCircle3 {
    public static void main(String [] args){

        System.out.println(JosephCircle(5,3));
    }
    public static int JosephCircle(int n,int m){
        if(n<1||m<1) return -1;
        int last = 0;
        for(int i  =2; i <=n;i++)
            last = (last+m)%i;
        return last;
    }
}
