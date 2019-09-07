package P05_CodeExam.GuaZi;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/6 11:10
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
   假设你玩一个游戏，每盘游戏只有输和赢两种可能，你每盘游戏的胜率为70%，所以就有30%的可能会输。
你从第一盘开始玩，如果玩赢了就继续玩下一盘，如果玩输了就停止。也就是说，玩到第一次输就停止。
最少会玩一盘，这个情况下，第一盘玩输了，停止游戏。
也可能会玩很多盘，如果运气好，一直都赢了，就一直玩下去。

问：（1）你恰好只玩3盘的概率是多少？
   （2）你恰好玩n盘的概率是多少？
   （3）你玩这个游戏的盘数的期望是多少？并编程计算。


 */
public class Main {
    public static void main(String []args){
        double expection = 0;
        int i = 1;
        while(true){
            double temp = expection;
            expection +=i*Math.pow(0.7,i-1)*0.3;
            i++;
            if(Math.abs(expection - temp) < 0.0001){
               System.out.println(expection);
               break;
            }

        }
    }
}
