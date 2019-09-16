package P05_CodeExam.C17_QiAnXin.Problem1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,18:58
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/


public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String find_longest_num_str(String input) {
        int len=0,end=-1;

        for(int i = 0; i < input.length();i++){

            if(input.charAt(i)>='0' && input.charAt(i) <='9'){
                int j = i+1;
                while(j< input.length()&&input.charAt(j)>='0'&& input.charAt(j) <='9'){
                        j++;
                }
                if(j-i > len){
                    len = j-i;
                    end = j;
                }
            }

        }
        return input.substring(end-len,end);
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = find_longest_num_str(_input);
        System.out.println(String.format("%d/%s", res.length(), res));
    }
}

