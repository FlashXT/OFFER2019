package P01_DataStructure.CH3_StackQueue;

import java.util.Iterator;

/***************************************************
 * 数组实现栈数据结构
 ***************************************************/
public class ArrayStack<Item> implements Iterable<Item> {

    private Item[]  stack;
    private int size = 0;

    public ArrayStack(){
        stack =(Item []) new Object[10];
    }
    public ArrayStack(int num){
        stack =(Item []) new Object[num];
    }


     public  void  push(Item num){
         if(size == stack.length)
             resize(2*stack.length);
         stack[size++]=num;

     }
     public Item peek(){
         if(size == 0)
             throw new RuntimeException("Stack is null");
         return stack[size-1];
     }
     public Item pop(){
         if(size == stack.length/4)
             resize(stack.length/2);
         if(size == 0)
             throw new RuntimeException("Stack is null");

         return  stack[--size];
     }

     public void resize(int max){
         Item []temp = (Item [])new Object[max];
         for(int i = 0; i < size;i++)
             temp[i]=stack[i];
         stack = temp;
     }
    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }
    private class ArrayStackIterator implements Iterator<Item>{
        public int i = size;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return stack[--i];
        }
    }
}
