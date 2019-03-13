package Stack_Queue;

public class TwoQueueStack<Item>{
    private ArrayQueue<Item> queue1,queue2;
    public TwoQueueStack(){
        queue1 = new ArrayQueue<>(10);
        queue2 = new ArrayQueue<>(10);
    }
    public TwoQueueStack(int size){
        queue1 = new ArrayQueue<>(size);
        queue2 = new ArrayQueue<>(size);
    }
    public void push(Item item){
        if(queue1.isFull())
            throw new RuntimeException("Queue is Full!");
        queue1.enqueue(item);

    }
    public Item pop(){
        if(queue1.isEmpty())
            throw new RuntimeException("Stack in empty!");

        while(queue1.size() != 1){
            queue2.enqueue(queue1.dequeue());
        }
        Item item = queue1.dequeue();
        ArrayQueue<Item> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return item;

    }
    public Item peek(){
        if(queue1.isEmpty()){
            throw new RuntimeException("Stack in empty!");
        }

        while(queue1.size() != 1){
            queue2.enqueue(queue1.dequeue());
        }
        Item item = queue1.peek();
        ArrayQueue<Item> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return item;

    }

}
