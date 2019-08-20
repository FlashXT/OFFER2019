package P01_DataStructure.CH3_StackQueue;
/********************************************************************************************
 * 将中缀表达式转化为逆波兰表达式，并求值;
 * 解法：
 * 第一步：将其转换为后缀表达式
 *  1.首先建立一个集合ArrayList来存放例子中的数据和操作符号，一个栈opStack来存放中间的
 *    操作符号，一个集合numStack来存放最后的转换结果。
 *  2.从sList中取出一个元素A然后进行以下判断：
 *    1.如果A是数字，则直接存如numstack
 *    2.如果A是运算符，则和opStack栈顶的元素进行运算优先级比较：
 *      ①如果opStack为空或A为左括号，则opStack.push(A);
 *      ②如果A是")",则将opStack中的运算符弹出存入numstack，直到左括号，然后opStack.pop("(");
 *      ③如果A的优先级高于栈顶运算符优先级,则opStack.push(A);
 *      ④如果A的优先级低于或等于栈顶运算符的优先级:
 *        numstack.push(opStack.pop()),重复此步骤直到opStack栈顶的运算符优先级低于当前运算符或opStack
 *        栈顶为"(",然后A入栈。
 *    3.不断重复以上步骤直到表达式解析完成。
 * 第二步：用后缀表达式来计算结果
 *   首先建立一个结果栈rStack，然后将numstack中的元素依次取出，进行入栈操作，如果碰到操作符就从
 *   栈中取出两个元素进行运算，结果入栈，依次重复。
 *********************************************************************************************/


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expressions2 {
    public static void main(String [] args){
        String str = "1+((2-3)*(4+5))+((6/2))";
        String exp = toReversePolishNotation(str);
        System.out.println(exp);
        System.out.println(ComputeRPN(exp));


    }
    //中缀表达式转逆波兰表达式
    public static String toReversePolishNotation(String str){
        Stack<String> numstack = new Stack<>();
        Stack<String> opstack = new Stack<>();
        List<String> ch = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+|\\+|\\-|\\*|\\/|\\(|\\)");
        Matcher matcher = p.matcher(str);
        ch.add("(");
        while(matcher.find()){
            ch.add(matcher.group());
        }
        ch.add(")");
        String  temp;
        Iterator<String> iter = ch.iterator();
        while(iter.hasNext()){
            temp = iter.next();
            if(isNumber(temp)){
                numstack.push(temp);
            }
            else {
                if (opstack.isEmpty() || temp.equals("("))
                    opstack.push(temp);
                else if (temp.equals(")")) {
                    while (!opstack.peek().equals("("))
                        numstack.push(opstack.pop());
                    opstack.pop();
                } else if (getLevel(temp)> getLevel(opstack.peek()))
                    opstack.push(temp);
                else{
                      while(!opstack.peek().equals("(")&& getLevel(temp)<=getLevel(opstack.peek())) {
                          numstack.push(opstack.pop());
                      }
                      opstack.push(temp);
                }
            }
        }
        Iterator<String> stackiter = numstack.iterator();
        String exp = new String();
        while(stackiter.hasNext()){
            exp+=stackiter.next()+" ";
        }
        return exp;
    }

    //计算逆波兰表达式
    public static String ComputeRPN(String str){
        Stack<String> stack = new Stack<>();
        String [] express =str.split(" ");
        int i= 0;
        int result = 0;
        while(i < express.length){
            if(isNumber(express[i]))
                stack.push(express[i]);
            else{
                stack.push(""+compute(stack.pop(),stack.pop(),express[i]));
            }
            i++;
        }
        return stack.pop();
    }
    //判断是不是数字
    private static boolean isNumber(String num){
        return num.matches("\\d+");
    }

    //判断是不是操作符
    private static boolean isOperate(String op){
        return op.matches("[\\+\\-\\*\\/\\(\\)]");
    }

    //conpute
    public static double compute(String opnum1,String opnum2,String op){
        if(op.equals("+"))
            return Double.valueOf(opnum2)+Double.valueOf(opnum1);
        else if(op.equals("-"))
            return Double.valueOf(opnum2)-Double.valueOf(opnum1);
        else if(op.equals("*"))
            return Double.valueOf(opnum2)*Double.valueOf(opnum1);
        else if(op.equals("/"))
            return Double.valueOf(opnum2)/Double.valueOf(opnum1);
        else
            return -1;
    }
    //获得操作符的优先级
    private static int getLevel(String op){

        if("+".equals(op)||"-".equals(op)){
            return 1;
        }
        if("*".equals(op)||"/".equals(op)){
            return 2;
        }
        if("(".equals(op)||")".equals(op)){
            return 3;
        }
        return -1;
    }

}
