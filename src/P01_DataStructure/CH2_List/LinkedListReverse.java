package P01_DataStructure.CH2_List;

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
            System.out.print(iter.next());
        }
        System.out.println();

        System.out.println("Reversed:");
        list.Reverse();
        Iterator iter2 =list.iterator();
        while(iter2.hasNext()){
            System.out.print(iter2.next());
        }
        System.out.println();
    }

}
