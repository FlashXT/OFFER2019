package P01_DataStructure.CH3_StackQueue;
/*******************************************************************************
 * 用栈实现表达式计算：
 * 输入 ：以字符串的形式输入表达式；包含基本的四则运算，以及括号，数字范围不限，
 *       输入保证表达式可计算；
 * 输出 ：表达式的计算结果
 * 思路分析：
 *         ①以字符串的形式输入，则需要对字符串进行切分，由于数字的位数不确定，所以切分时要
 *           对数字进行拼接；
 *         ②表达式中包含四则运算，以及括号，运算符之间有优先级，需要确定优先级；确定优先级
 *           的策略：
 *              a.在表达式的结尾附加‘#’作为表达式的结束符；并且在操作符栈的栈底压入‘#’；
 *                当表达式结尾的‘#’遇到操作符栈栈底的‘#’时，计算结束；
 *              b.同级操作符先出现的优先级高；不同级操作符的优先级同四则运算；
 *              c.‘(’与 ‘+’，‘-’，‘*’，‘/’，‘(’ 出现在后面的优先级高；
 *              d.‘)’与 ‘+’，‘-’，‘*’，‘/’,')' 出现在前面的优先级高；
 *              e.先出现的‘(’优先级等于后出现的‘)’;
 *              d.‘#’的优先级最低;
 *           按以上策略编写优先级函数；
 *         ③计算过程：
 *           expstack栈：栈底元素为‘#’，表达式栈；opstack栈：栈底元素为‘#’，操作符栈；
 *           numstack:操作数栈；
 *           while(当前op!= '#' || opstack.peek()!='#'){
 *              ch = expstack.pop();
 *              if(ch 为运算符或括号，‘#’){
 *                  如果 ch 的优先级 高于 opstack栈顶元素：
 *                    opstack.push(ch);
 *                  如果 ch 的优先级 等于 opstack栈顶元素：
 *                     opstack.pop();
 *                  如果 ch 的优先级 低于 opstack栈顶元素：
 *                      while(ch 的优先级 低于 opstack栈顶元素){
 *
 *                          a = numstack.pop();
 *                          b = numstack.pop();
 *                          numstack.push(op(b ,a));//注意后出栈的作为第一个操作数；
 *                          op = opstack.pop();
 *                          if(op == '#')
 *                                 opstack.push(op);
 *                      }
 *                      if(ch != ')')
 *                          opstack.push(ch);
 *
 *              }
 *
 *******************************************************************************/

import java.util.Stack;

public class Expressions {
    public static void main(String [] args){
        String str = "2*(2+(99-10))-10";
        Stack<String> expstack = new Stack<>();
        Stack<Integer> numstack = new Stack();
        Stack<Character> opstack = new Stack();
        expstack.push("#");
        int temp = 0;
        int j = 0;
        for(int i = str.length()-1; i >=0;i=j-1){
            temp = 0;
            for(j = i ; j >= 0 && '0'<= str.charAt(j) && str.charAt(j) <='9';j--){
                temp += Math.pow(10,i-j)*(str.charAt(j)-'0');
            }
            if(temp != 0)
                expstack.push(String.valueOf(temp));
            if(j>=0) expstack.push(String.valueOf(str.charAt(j)));
        }
        //字符串处理完成，开始计算
        String ch="";
        int opnum1,opnum2;
        char op;
        opstack.push('#');
        while(ch!="#"||opstack.peek()!='#'){
            ch =expstack.pop();

            if(ch.equals(String.valueOf('+'))||ch.equals(String.valueOf('-'))||ch.equals(String.valueOf('*'))||
               ch.equals(String.valueOf('/'))||ch.equals(String.valueOf('('))||ch.equals(String.valueOf(')'))
                ||ch.equals(String.valueOf('#')))
            {
                switch(oPriority(ch.charAt(0),opstack.peek())){
                     //当前运算符优先级大于栈顶运算符
                    case 1:
                        opstack.push(ch.charAt(0));
                        break;
                     //当前运算符优先级等于栈顶运算符
                    case 0:
                        opstack.pop();
                        break;
                     //当前运算符优先级大于栈顶运算符
                    case -1:
                        op = opstack.pop();
                        while(oPriority(ch.charAt(0),op) == -1){
                            opnum1 = numstack.pop();
                            opnum2 = numstack.pop();
                            if(op == '+')
                                numstack.push(opnum2+opnum1);
                            else if(op == '-')
                                numstack.push(opnum2-opnum1);
                            else if(op == '*')
                                numstack.push(opnum2*opnum1);
                            else if(op == '/')
                                numstack.push(opnum2/opnum1);

                            op = opstack.pop();
                            if(op == '#')
                                opstack.push(op);
                        }
                        if(ch.charAt(0)!=')')
                            opstack.push(ch.charAt(0));
                        break;
                }
            }
            else{
                numstack.push(Integer.valueOf(ch));
            }
        }
        System.out.println(str+" = "+numstack.pop());
    }
    //op1表示当前运算符，op2表示栈顶运算符
    public static int oPriority(char op1,char op2){
        if(op1 == '+'||op1 == '-'){
            if(op2 == '+' || op2 == '-'||op2 == '*' || op2 == '/')
                return -1;
            else if (op2 == '(')
                return 1;
            else if(op2 == ')')
                return -1;
            else
                return 1;
        }
        else if(op1 == '*'||op1 == '/'){
            if(op2 == '+' || op2 == '-')
                return 1;
            else if(op2 == '*' || op2 == '/')
                return -1;
            else if (op2 == '(' || op2 =='#')
                return 1;
            else
                return -1;
        }
        else if(op1 == '('){
                return 1;
        }
        else if(op1 == ')'){
            if(op2 == '(')
                return 0;
            else
                return -1;
        }
        else {
            if(op2 == '#')
                return 0;
            else
                return -1;
        }
    }
}
