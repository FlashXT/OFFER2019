package CH2_List;

public class TestDulinkList {
    public static void main(String [] args) {
        DulinkList<Integer> dlist = new DulinkList<>();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        for (int item : arr) {
//            dlist.headInsert(new DNode(item));
            dlist.tailInsert(new DNode(item));
        }
        dlist.Print();
        dlist.Print2();
        dlist.DulinklistReverse();
        dlist.Print();
        dlist.Print2();
        dlist.Print();
        System.out.println(dlist.deleteNode(2).item);
        dlist.Print();


    }
}
