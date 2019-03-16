package CH4_StackQueue;

public class TestArrayQueue {
    public static void main(String [] args){
        ArrayQueue<Integer> q = new ArrayQueue<>();
        int [] arr={1,2,3,4,5,6,7,8,9};
        for (int item:arr) {
            q.enqueue(item);
        }
        System.out.println(q.isFull());
        for(int i = 0;i< 3;i++)
           System.out.println(q.dequeue());
        System.out.println(q.peek());
    }
}
