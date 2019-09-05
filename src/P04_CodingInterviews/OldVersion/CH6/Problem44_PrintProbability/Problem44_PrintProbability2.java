package P04_CodingInterviews.OldVersion.CH6.Problem44_PrintProbability;


/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 16:18;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

/*****************************************************************************
 * (1)n个骰子的点数依赖于n-1个骰子的点数，相当于在n-1个骰子点数的基础上再进行投掷。
 * (2)求父问题的同时，需要多次利用子问题。由此定义状态转移方程为f(n,k)表示n个骰子点数和为k
 *    时出现的次数，于是可得:
 *   f(n,k)=f(n−1,k−1)+f(n−1,k−2)+f(n−1,k−3)+f(n−1,k−4)+f(n−1,k−5)+f(n−1,k−6)
 *   其中 n>0且k<=6n。其中f(n−1,k−i)表示的是第n次掷骰子时，骰子的点数为i对应的情况，所以
 *   从k−1到k−6分别对应第n次掷骰子时骰子正面为1到6的情况。而初始状态可以定义为：
 *                    f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1
 *****************************************************************************/
public class Problem44_PrintProbability2 {
    public static void main(String [] args){
        int num = 3;
        int point = 6;
        PrintProbability(num, point);
    }
    public static void PrintProbability(int num,int point){
        int [][] sum = new int[2][num*point+1];
        for(int i = 1; i<=point;i++){
            sum[1][i] = 1;
        }
        int flag = 1;
        for(int n = 2; n<=num;n++){
            for(int i = n; i<=n*point;i++){
                sum[1-flag][i] = 0;
                for(int j =1; j<i&&j <= point;j++){
                    sum[1-flag][i]+=sum[flag][i-j];
                }
            }

            flag = 1-flag;

        }

        double total = Math.pow(point,num);
        for(int i =num; i<= num*point;i++){
            double ratio = sum[flag][i]/total;
            System.out.println("P("+i+") = "+ratio);
        }
    }
}
