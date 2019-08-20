package P01_DataStructure.CH3_StackQueue;

public class TwoStackQueue<Item> {
    private ArrayStack<Item> stack,stack2;
    public TwoStackQueue(){
         stack = new ArrayStack<>(10);
         stack2 = new ArrayStack<>(10);
    }
    public TwoStackQueue(int size){
        stack = new ArrayStack<>(size);
        stack2 = new ArrayStack<>(size);
    }
    public  void enqueue(Item item){
            while(!stack2.isEmpty())
                stack.push(stack2.pop());
            stack.push(item);

    }
    public Item dequeue(){
        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        Item item = stack2.pop();
        while(!stack2.isEmpty())
            stack.push(stack2.pop());
        return item;
    }
    public Item peek(){
        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        Item item = stack2.peek();
        ArrayStack<Item> temp = stack;
        stack = stack2;
        stack2 = temp;
        return item;
    }
    public int size(){
        return stack.getSize();
    }
}
