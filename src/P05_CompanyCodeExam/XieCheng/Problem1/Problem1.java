package P05_CompanyCodeExam.XieCheng.Problem1;
/*********************************************************
 * 输入：
 * 9 (训练集数目)
 * 0 0 0 0 1 1 1 1 1 (训练集标签)
 * 0 0 30 450 7
 * 1 1 5  500 3
 * 1 0 10 150 1
 * 0 1 40 300 6
 * 1 0 20 100 10
 * 0 1 25 180 12
 * 0 0 32 50  11
 * 1 0 23 120 9
 * 0 0 27 200 8
 * 0 0 40 180 8      (测试集)
 * 输出：1.229
 *********************************************************/

import java.util.Scanner;

public class Problem1 {

    public static void main(String [] args){
        //读取输入
        Scanner in = new Scanner(System.in);
        int i = 0;
        //读取训练集数目
        int length = in.nextInt();
        //读取训练集标签以及训练集和测试集
        String []str = new String[length+2];
        in.nextLine();
        while (in.hasNextLine()) {
            str[i++] = in.nextLine();
            if(i == length+2)
                break;
        }
        //处理训练集标签
        int [] y = new int [length];
        String[] ch = str[0].split(" ");
        for(i = 0; i<ch.length;i++)
            y[i] = Integer.valueOf(ch[i]);
        //处理训练集和测试集
        int [][] x = new int [length+1][5];
        for(i = 0;i < x.length;i++){
            ch = str[i+1].split("\\s+");
            for (int j=0;j < 5;j++ ){
                x[i][j] = Integer.valueOf(ch[j].trim());
            }
        }
        //训练集标签计数
        float y1 = 0,y0 = 0;
        for(i = 0; i<y.length;i++ ){
            if(y[i] == 0) y0+=1;
            else if (y[i] == 1) y1+=1;
        }
        float p0 = y0/y.length,p1 = y1/y.length;

        //特征处理与概率计算
        //特征1
        float [] x1 =  Discrfeature(x,y,0,y0,y1);
        //特征2
        float [] x2 =  Discrfeature(x,y,1,y0,y1);

        //特征3(离散化分箱)
        float [] x3 =  Continfeature(x,y,2,y0,y1);
        //特征4(离散化分箱)
        float [] x4 =  Continfeature(x,y,3,y0,y1);
        //特征5(离散化分箱)
        float [] x5 =  Continfeature(x,y,4,y0,y1);
        //print(x);
        //计算概率的时候下标转换
        float y1x = p1*x1[x[x.length-1][0]*2+1]*x2[x[x.length-1][1]*2+1]*
                    x3[x[x.length-1][2]*2+1]*x4[x[x.length-1][3]*2+1]*
                    x5[x[x.length-1][4]*2+1],
              y0x = p0*x1[x[x.length-1][0]*2]*x2[x[x.length-1][1]*2]*
                    x3[x[x.length-1][2]*2]*x4[x[x.length-1][3]*2]*
                    x5[x[x.length-1][4]*2];
        //结果保留3位小数
        System.out.printf("%.3f",y1x/y0x);

    }
    public static float[] Discrfeature (int [][]x,int []y,int k,float y0,float y1){
        float x0y0 = 0,x1y0 = 0,x0y1 = 0,x1y1 = 0;
        for(int i = 0; i < x.length-1;i++){
            if(x[i][k] == 0 && y[i]==0)
                x0y0+=1;
            else if(x[i][k]==0&& y[i]==1)
                x0y1+=1;
            else if(x[i][k]==1&& y[i]==0)
                x1y0+=1;
            else if(x[i][k]==1&& y[i]==1)
                x1y1+=1;
        }
        return new float[]{x0y0/y0,x0y1/y1,x1y0/y0,x1y1/y1};
    }

    public static float[] Continfeature(int [][]x,int []y,int k,float y0,float y1){
        //分箱
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;

        for(int i = 0; i < x.length-1;i++){
            if(x[i][k] > max)
                max = x[i][k];
            if(x[i][k] < min)
                min = x[i][k];
        }
        double point1 = min+(max -min)/3.0,point2 = min+(max -min)*2.0/3;

        for(int i = 0; i < x.length;i++){
            if(x[i][k] < point1)
                x[i][k] = 0;
            else if(x[i][k] >= point1 && x[i][k] < point2)
                x[i][k] = 1;
            else if ( x[i][k] >= point2)
                x[i][k] = 2;
        }
        //统计
        float   x0y1=0, x0y0=0,x1y1=0,x1y0=0,x2y1=0,x2y0=0;
        //测试集不统计，体现在 x.length-1
        for(int i = 0; i < x.length-1;i++){
            if(x[i][k] == 0 && y[i]==0)
                x0y0+=1;
            else if(x[i][k]==0&& y[i]==1)
                x0y1+=1;
            else if(x[i][k]==1&& y[i]==0)
                x1y0+=1;
            else if(x[i][k]==1&& y[i]==1)
                x1y1+=1;
            else if(x[i][k]==2&& y[i]==0)
                x2y0+=1;
            else if(x[i][k]==2&& y[i]==1)
                x2y1+=1;
        }
        return new float[]{x0y0/y0,x0y1/y1,x1y0/y0,x1y1/y1,x2y0/y0,x2y1/y1};
    }

    public static void print(int [][]x){
        for (int i = 0; i<x.length;i++){
            for(int j = 0; j<x[i].length;j++){
                System.out.printf("%4d",x[i][j]);
            }
            System.out.println();
        }
    }
}
