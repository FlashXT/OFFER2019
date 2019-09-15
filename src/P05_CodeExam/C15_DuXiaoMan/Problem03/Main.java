package P05_CodeExam.C15_DuXiaoMan.Problem03;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/15,18:21
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int max = 201;
    static int[][] memo = new int[max][max];
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        for (int i = 0; i <max; i++) {
            Arrays.fill (memo[i],-1);
        }
        while (sc.hasNext ()) {
            int n = sc.nextInt (), m = sc.nextInt ();
            if (judge(n, m)!=0) {
                System.out.println ("WIN");
            } else {
                System.out.println ("LOSE");
            }
        }
    }

    private static int judge(int w, int h) {
        if (memo[w][h] != -1)
            return memo[w][h];
        Set<Integer> s = new HashSet<>();
        for (int i = 2; w - i>=2; i++)
            s.add(judge(i,h)^judge(w-i,h));
        for (int i = 2; h - i>=2; i++)
            s.add(judge(w,i)^judge(w,h-i));
        int res = 0;
        while (s.contains(res))
            res++;
        return memo[w][h] = res;
    }


}
