package P05_CodeExam.DiDi;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/8/27,19:38
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//6
//3 + 2 + 1 + -4 * -5 + 1
public class Main1 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();//读取换行符
        String[] str = scan.nextLine().split(" ");
        Stack<String> num = new Stack<>();
        Stack<String> op = new Stack<>();
        for(int i = 0; i < str.length;i++){
            if(str[i].equals("/"))
                op.add(str[i]);
            else if(str[i].equals("+")||str[i].equals("-")||str[i].equals("*")){
                if(!op.isEmpty()){
                    if(op.peek().equals("/"))
                    {   op.add(str[i]);
                        continue;
                    }
                    int pri = opPrity(op.peek(),str[i]);
                    if(pri > 0){
                        String num1 = num.pop();
                        String num2 = num.pop();
                        if(num1.compareTo(num2)<0){
                            String temp = num1;
                            num1 = num2;
                            num2 = temp;
                        }
                        num.push(num1);
                        num.push(num2);
                    }
                    else if (pri == 0){
                        List<String> num1 = new ArrayList<>();
                        List<String> oplist = new ArrayList<>();
                        String opt = str[i];
                        String n1 = num.pop();
                        while(!op.isEmpty()&&opPrity(op.peek(),opt)==0){
                            String n2 = num.pop();
                            String temp =n1.compareTo(n2)> 0? n1 :n2;
                            n1 = temp == n1 ? n2:n1;
                            num1.add(temp);
                            oplist.add(opt);
                            opt = op.pop();
                        }
                        num1.add(n1);


                        int size = num1.size()-1;
                        while(size >=0)
                            num.push(num1.get(size--));
                        size = oplist.size()-1;
                        while(size >= 0)
                            op.push(oplist.get(size--));
                    }
                }
                op.push(str[i]);
            }
            else {
                num.push(str[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!num.isEmpty() || !op.isEmpty()){
            if(!num.isEmpty())
                sb.insert(0,num.pop()+" ");
            if(!op.isEmpty())
                sb.insert(0,op.pop()+" ");
        }
        System.out.println(sb.toString());
    }
    public static  int opPrity(String op1,String op2){
        if(op1.equals("+")||op1.equals("-")){
            if(op2.equals("*")|| op2.equals("/"))
                return -1;
        }
        else{
            if(op2.equals("+")|| op2.equals("-"))
                return 1;

        }
        return 0;
    }
}
