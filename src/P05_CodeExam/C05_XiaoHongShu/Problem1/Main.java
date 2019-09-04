package P05_CodeExam.C05_XiaoHongShu.Problem1;

import java.util.Scanner;
import java.util.Stack;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/3,19:30
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//AC:100%
public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < str.length()){
            char ch = str.charAt(i);
            if(ch == '<'){
                if(!stack.isEmpty() && stack.peek()!='('&& stack.peek()!=')')
                    stack.pop();
            }

            else if(ch == '(')
                stack.push(ch);
            else if(ch == ')'){

                while(stack.peek()!='('){
                    stack.pop();
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
            i++;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        System.out.println(res.toString());
    }
}
