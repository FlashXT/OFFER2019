package Test.XieCheng.Problem2;
/********************************************************
 * 测试用例：输入：2,-2,7,6,-8,-10,-5 输出：-25
 * 提示：求两个最优子段问题，动态规划
 *
 ********************************************************/

import java.util.Arrays;
import java.util.Scanner;
public class Problem2 {

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        String str="2, -2, 7, 6, -8, -10, -5";
//        str = in.nextLine();
        String [] ch = str.split(", ");
        int [] x = new int[ch.length];
        for (int i =0; i< x.length;i++){
            x[i] = Integer.valueOf(ch[i]);
        }
        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
        int nsum = 0;
        int psum = 0;
        for(int i =0 ; i < x.length;i++){
            if (x[i] <= 0)
                nsum += x[i];
            else
                psum+= x[i];
        }
        if(nsum != 0){
            if(nsum == x[0])
                System.out.println(nsum+x[1]);
            else
                System.out.println(nsum);
        }

        else{
            System.out.println(x[0]+x[1]);
        }

    }

}



//import sys
//        for line in sys.stdin:
//        n = line.split(",")
//        n = list(map(int,n))
//        i = 0
//        temp =[]
//        while i < len(n):
//        if n[i]>0:
//        temp.append(n[i])
//        i+=1
//        else:
//        t= n[i]
//        j = i+1
//        while j < len(n):
//        if n[j] <0:
//        t+=n[j]
//        j+=1
//        else:
//        break
//        temp.append(t)
//        i=j
//        temp.sort()
//        if len(temp) ==1:
//        print(temp[0])
//        else:
//        print(sum(temp[:2]))
