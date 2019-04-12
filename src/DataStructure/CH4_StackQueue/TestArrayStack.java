package DataStructure.CH4_StackQueue;

import java.util.Iterator;

public class TestArrayStack {
    public static void main(String [] args){
        ArrayStack<Integer> stack = new ArrayStack<>();
        int [] arr = {1,2,3,4,5,6,7,8,9,10,11};
        for (int item: arr) {
            stack.push(item);
        }
        for(int i = 0;i< 9;i++){
//            System.out.println(stack.peek());
            stack.pop();
        }
        //迭代器遍历Stack
        Iterator iter = stack.iterator();
        while(iter.hasNext()){

            System.out.println(iter.next());
        }


    }
}
