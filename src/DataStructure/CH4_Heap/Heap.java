package DataStructure.CH4_Heap;

import java.util.*;

/******************************************************************************
 * 使用PriorityQueue实现Heap数据结构,默认小顶堆，可以通过Comparator改变成大顶堆；
 *  1.构造函数
 *  ====================================================================
 *  PriorityQueue()
 *  PriorityQueue(Collection<? extends E> c)
 *  PriorityQueue(int initialCapacity)
 *  PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
 *  PriorityQueue(PriorityQueue<? extends E> c)
 *  PriorityQueue(SortedSet<? extends E> c)
 *  ====================================================================
 *
 *  2.常用功能函数
 *  =================================================
 *  方法名 	                    功能描述
 *  ------------------------------------------------
 *  add(E e) 	                添加元素
 *  clear() 	                清空
 *  contains(Object o) 	        检查是否包含当前参数元素
 *  offer(E e)               	添加元素
 *  peek()                  	读取元素，（不删除）
 *  poll()                  	取出元素，（删除）
 *  remove(Object o) 	        删除指定元素
 *  size() 	返回长度
 *  =================================================
 *******************************************************************************/
public  class Heap{

   public static void main(String [] args){
       PriorityQueue<Student> heap=new PriorityQueue<>(new StuComparator());
       Student stu1 = new Student(01,22,"FlashXT");
       Student stu2 = new Student(02,23,"turboman");
       Student stu3 = new Student(03,24,"XiaoMing");
       Student stu4 = new Student(04,24,"XiaoHong");
       heap.add(stu1);
       heap.add(stu2);
       heap.add(stu3);
       heap.add(stu4);
       System.out.println(heap);
       System.out.println(heap.poll());
       System.out.println(heap.poll());
       System.out.println(heap.contains(stu1));
       System.out.println(heap.contains(stu2));

       Integer [] array = {2,43,44,12,43,12,45,3,89,78};
       ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
       Iterator iter = arrayList.iterator();
       while(iter.hasNext()){
           System.out.println(iter.next());
       }

       PriorityQueue<Integer> heap2=new PriorityQueue(arrayList);
       System.out.println(heap2);


   }
}

class Student{
    public int id;
    public int age;
    public String name;
    public Student(){ }
    public Student(int id,int age,String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }
    public String toString(){
        return "Id:"+this.id+",Age:"+this.age+",Name:"+this.name;
    }
}
class StuComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.id > o2.id)
            return 1;
        else if(o1.id == o2.id)
            return 0;
        else
            return -1;
    }
}

