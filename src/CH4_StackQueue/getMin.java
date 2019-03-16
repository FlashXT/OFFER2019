package CH4_StackQueue;

/*******************************************************************
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 要求：
 *  1．pop、push、getMin操作的时间复杂度都是O(1)。
 *  2．设计的栈类型可以使用现成的栈结构。
 *
 * 思路：准备两个栈，对于数组中的数i,栈1push(i)，对于栈2，设栈顶元素为k:
 *      若i > k,则栈2push(k);
 *      若i<= k,则栈2push(i);
 *      保证栈2的栈顶元素为栈1当前元素中最小的；
 *******************************************************************/



public class getMin {
    private ArrayStack<Integer> stack = new ArrayStack();
    private ArrayStack<Integer> stack2 = new ArrayStack();
    public  void push(Integer item){
        stack.push(item);
        if(!stack2.isEmpty())
            if(stack2.peek() < item)
                stack2.push(stack2.peek());
            else
                stack2.push(item);
        else
            stack2.push(item);
    }
    public  Integer pop(){
        stack2.pop();
        return stack.pop();
    }
    public static void main(String []args){
        getMin gm = new getMin();
        int [] arr = {23,32,11,34,45,9,10};
        for(int item:arr){
            gm.push(item);
        }
        gm.pop();
        gm.pop();
        gm.pop();

        System.out.println("AAAAAAAAA");
    }

}
