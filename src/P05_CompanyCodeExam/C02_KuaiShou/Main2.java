package P05_CompanyCodeExam.C02_KuaiShou;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/25,16:14
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main2 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);

    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        int i = 0,j = 0;

        while( j <n){
            Character ch = s.charAt(j);

            i = Math.max(index[ch],i);
            ans = Math.max(ans, j-i+1);
            index[ch] = j+1;
            j++;
        }
        return ans;
    }
}
