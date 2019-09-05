package P04_CodingInterviews.OldVersion.CH6.Problem44_PrintProbability;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/15 16:18;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem44_PrintProbability {
    public static void main(String [] args){
        int num = 5;
        int point = 6;

        PrintProbability(num, point);
    }
    public static void PrintProbability(int num,int point){
        int [] points = new int [num];
        int [] sum = new int[point*num+1];
        double cases = Math.pow(point,num);
        PrintProbability(num, point,points,sum);
        for(int i = num;i < sum.length;i++){

            System.out.println("P("+i+") = "+String.format("%."+num+"f",(sum[i]/cases)));

        }
    }
    //递归遍历
    private static void PrintProbability(int num,int point,int [] points,int [] sum){
        if(num == 0){
            sum[sum(points)]++;
//            System.out.println(Arrays.toString(points));
            return ;
        }
        for(int i = 1; i <=  point;i++){
            points[num-1] = i;
            PrintProbability(num-1, point,points,sum);
        }

    }
    public static int sum(int [] points){
        int sum = 0;
        for(int i =0; i< points.length;i++)
            sum+=points[i];
        return sum;
    }
}
