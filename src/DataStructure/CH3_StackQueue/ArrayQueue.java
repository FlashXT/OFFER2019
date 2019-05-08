package DataStructure.CH3_StackQueue;

public class ArrayQueue<Item>  {
    private Item [] queue;

    private int head = 0;
    private int tail = 0;
    public ArrayQueue(){
        queue = (Item [])new Object[10];
    }
    public ArrayQueue(int num){
        queue =(Item [])new Object[num];
    }
    public void enqueue(Item item){
        if(this.isFull())
            throw new RuntimeException("Queue is full!");
        queue[tail]=item;
        tail = (tail+1)%queue.length;
    }
    public Item dequeue(){
        if(this.isEmpty())
            throw new RuntimeException("Queue is empty!");
        Item item = queue[head];
        head = (head+1)%queue.length;
        return item;


    }
    public Item peek(){
        if(this.isEmpty())
            throw new RuntimeException("Queue is empty!");
        return queue[head];

    }

    public boolean isEmpty(){
        return head==tail;
    }
    public boolean isFull(){
        return (tail+1)%queue.length == head;
    }
    public int size(){
        if(tail > head)
            return tail - head;
        else if(head > tail){
            return tail+queue.length-head;
        }
        else{
            if(this.isEmpty())
                return 0;
            else
                return queue.length;
        }
    }


}
