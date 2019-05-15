package TencentOffer.CH6.Problem44_PrintProbability;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 16:18;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem44_PrintProbability2 {
    public static void main(String [] args){
        int num = 5;
        int point = 6;
        PrintProbability(num, point);
    }
    public static void PrintProbability(int num,int point){
       if(num <1 )return ;
       int [][] p = new int [2][point*num+1];
       int flag = 0;
       for(int i = 1; i <=point;i++){
           p[flag][i] = 1;
       }
       for(int k = 2; k<=num;k++){
           for(int i = 0; i < k;i++){
               p[1-flag][i]=0;
           }
           for(int i = k; i <= point*k;i++){
               p[1-flag][i]=0;
               for(int j = 1; j<= i && j <=point;j++){
                   p[1-flag][i]+=p[flag][i-j];
               }
           }
           flag = 1 -flag;
       }
       double total = Math.pow(point,num);
       for(int i = num; i < point*num+1;i++){
           double ratio = p[flag][i]/total;
           System.out.println("P("+i+") = "+String.format("%."+num+"f",ratio));

       }
    }
}
