package P04_CodingInterviews.OldVersion.CH2;


import java.util.*;

/***************************************
 * 逆序打印链表
 ***************************************/
public class List {
    public static void main(String [] args){
        LinkedList<Integer> list = new LinkedList();
        int [] arr = {1,2,3,4,5,6,7,8};
        for(int item:arr){
            list.add(item);
        }
        System.out.println(list.toString());
        ReversePrint(list,0);
        System.out.println();
        ReversePrint2(list);
    }
    public static void ReversePrint(LinkedList list,int index){
        if(list.size() <= index) return ;
            ReversePrint(list,index+1);
        System.out.printf("%2d",list.get(index));

    }
    //用栈实现
    public static void ReversePrint2(LinkedList list){
        Stack<Integer> stack = new Stack<>();
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            stack.push(iter.next());
        }
        while(!stack.isEmpty()){
            System.out.printf("%2d",stack.pop());
        }
        System.out.println();
    }
}

