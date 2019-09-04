package P05_CodeExam.C07_HuaWei;
/*****************************************************************
 * 2019.3.20：
 * 试题一：
 *      以字符串的格式输入一个算式，数字范围[0,99];操作符+，-；输出计算结果；
 * 要点：字符串切割，栈（通过100%测试用例）
 *****************************************************************/

import java.util.*;
public class HuaWeiTest1 {

    public static void main(String [] main){
            String str = "1+2+99-10-10";
            Stack<Integer> numstack = new Stack();
            Stack<Character> opstack = new Stack();
            char [] str2 = str.toCharArray();
            int temp = 0;
            int j = 0;
            for(int i = str.length()-1; i >=0;i=j-1){
                temp = 0;
                for(j = i ; j >= 0 && str.charAt(j)!='-'&& str.charAt(j)!='+';j--){
                    temp += Math.pow(10,i-j)*(int)(str.charAt(j)-48);
                }
                numstack.push(temp);
                if(j>0)
                    opstack.push(str.charAt(j));
            }
            int result = 0;
            while(!opstack.isEmpty()){
                char op = opstack.pop();
                if(op == '+'){
                    result= numstack.pop()+numstack.pop();

                }
                else{
                    result=numstack.pop()-numstack.pop();

                }
                numstack.push(result);
            }
            System.out.println(numstack.pop());

        }
}
