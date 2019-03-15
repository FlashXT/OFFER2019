package List;

import java.util.Iterator;

public class LinkedListReverse {
    public static void main(String [] args){
        LinkedList<Integer> list = new LinkedList<>();
        int [] arr = {1,2,3,4,5,6,7};
        for(int item:arr){
            list.tailInsert(item);
        }
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("List Reversed:");
        list.Reverse();
        Iterator iter2 =list.iterator();
        while(iter2.hasNext()){
            System.out.println(iter2.next());
        }
    }

}
