package P01_DataStructure.CH3_StackQueue;

public class TestTQMStack {

    public static void main(String [] args){
        TwoQueueStack<Integer> tqs = new TwoQueueStack(10);
        int [] arr = {1,2,3,4,5,6,7};
        for(int item:arr){
            tqs.push(item);
        }
        System.out.println(tqs.pop());
        System.out.println(tqs.peek());
        System.out.println();

    }

}
