package P05_CodeExam.C06_XieCheng.Problem2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/4 18:41
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
   input:
        10
        1 0.90
        0 0.70
        1 0.60
        1 0.55
        0 0.55
        1 0.40
        0 0.38
        0 0.35
        1 0.31
        0 0.10
   output : 0.66
 */
public class Main {
    static class Node{
        int label;
        double prob;
        public Node(int label,double prob){
            this.label = label;
            this.prob = prob;
        }
    }
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Node [] nodes = new Node[N];

        for(int i = 0; i< N;i++){
            nodes[i] = new Node(scan.nextInt(),scan.nextDouble());
        }
        //①面积法计算AUC
        System.out.printf("%.2f\n",AUCbyArea(nodes));
        //②公式法计算AUC(首选)
        System.out.printf("%.2f\n",AUCbyFormula(nodes));
    }
    public static double AUCbyArea(Node [] nodes){
        //按照预测概率排序
        Comparator<Node> cmp0 = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.prob != o2.prob) {
                    if(o2.prob - o1.prob < 0)
                        return -1;
                    else
                        return 1;
                }else{
                    //预测概率相等时，负例在前
                    return o1.label - o2.label;
                }
            }
        };
        Comparator<Node> cmp1 = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.prob != o2.prob) {
                    if(o2.prob - o1.prob < 0)
                        return -1;
                    else
                        return 1;
                }else{
                    //预测概率相等时，正例在前
                    return o2.label - o1.label;
                }
            }
        };

        Arrays.sort(nodes,cmp0);
        double aucNegFirst = AUCPosorNegFirst(nodes);
        Arrays.sort(nodes,cmp1);
        double aucPosFirst = AUCPosorNegFirst(nodes);
        return 0.5*(aucNegFirst+aucPosFirst);

    }
    public static double AUCPosorNegFirst(Node [] nodes){
        int N = nodes.length;
        int[] label = new int [N];
        double[] prob = new double[N];
        double [][] point = new double[N][2];
        int [] pred = new int [N];
        for(int i = 0; i < nodes.length;i++){
            label[i] = nodes[i].label;
            prob[i] = nodes[i].prob;
        }
        for(int i = 0; i < N;i++){
            pred[i] = 1;
            point[i] =  TPR_FPR(label,pred);
        }
        return  AUC(point);
    }

    public static double AUC(double [][] point){
        //X轴为FPR,Y轴为TPR
        double auc = 0;
        for(int i = 1; i < point.length;i++){
            auc+= (point[i][0] - point[i-1][0])*point[i][1];
        }
        return auc;
    }
    public static double [] TPR_FPR(int [] label,int [] pred){

        int tp =0,tn = 0,fp = 0,fn = 0;
        for(int i = 0; i < label.length;i++){
            if(label[i] == 1 && pred[i] == 1)
                tp++;
            else if(label[i] == 1 && pred[i] == 0)
                fn++;
            else if(label[i] == 0 && pred[i] == 0)
                tn++;
            else{
                fp++;
            }
        }
        return new double[]{fp*1.0/(fp+tn),tp*1.0/(tp+fn)};
    }

    //公式计算AUC(首选)
    public static double AUCbyFormula(Node [] nodes){
        int N = nodes.length;
        int[] label = new int [N];
        double[] prob = new double[N];

        for(int i = 0; i < nodes.length;i++){
            label[i] = nodes[i].label;
            prob[i] = nodes[i].prob;
        }
        //统计正例和负例的个数
        int pos = 0,neg=0;
        for(int i = 0; i < label.length;i++){
            if(label[i] == 1)
                pos++;
            else
                neg++;
        }
        double sum = 0;
        for(int i = 0; i< label.length;i++){
            //对于每一个正例
            if(label[i] == 1){
                for(int j = 0; j < label.length;j++){
                    //对于每一个负例
                    if(label[j] == 0){
                        //如果正例的预测概率大于负例的预测概率
                        if(prob[i] > prob[j])
                            sum++;
                        //如果正例的预测概率等于负例的预测概率
                        if(prob[i] == prob[j])
                            sum+=0.5;
                    }
                }
            }
        }
        sum = sum*1.0/(pos*neg);
        return sum;
    }
}
