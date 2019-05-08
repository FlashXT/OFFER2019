package DataStructure.CH3_StackQueue;

public class TestTSMQueue {
    public static void main(String [] args){
        TwoStackQueue<Integer> tsq = new TwoStackQueue<>(10);
        int [] arr = {1,2,3,4,5,6,7,8,9};
        for(int item:arr){
            tsq.enqueue(item);
        }
        System.out.println(tsq.dequeue());
        tsq.enqueue(100);
        tsq.dequeue();tsq.dequeue();
        System.out.println(tsq.peek());


    }


}
