package P04_CodingInterviews.CH4.AbstractConcrete;

import java.util.Stack;

/****************************************************
 * 给出入栈和出战序列，判定出栈序列和入栈序列是否相对应
 ****************************************************/
public class StackpushpopSeq {
    public static void main(String [] args){
        int [] pushseq = {1,2,3,4,5};
        int [] popseq1 = {4,5,3,2,1};
        int [] popseq2 = {4,3,5,1,2};
        int [] popseq3 = {3,2,1,5,4};
        System.out.println(isPopSeq(pushseq,popseq1));
        System.out.println(isPopSeq(pushseq,popseq3));

    }
    public static boolean isPopSeq(int [] push,int[]pop){
        if(push.length == 0 && pop.length == 0) return true;
        if(push.length!= pop.length)           return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pop.length;i++){
            if(!stack.isEmpty()&&pop[i] == stack.peek()){
                stack.pop();
            }
            else{
                while(j < push.length){
                    if(push[j]== pop[i]) {
                        break;
                    }
                    stack.push(push[j]);
                    j++;

                }
                if(j == push.length){
                    return false;
                }
                j++;
            }

        }
        return true;
    }
}
