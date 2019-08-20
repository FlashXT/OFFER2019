package P01_DataStructure.CH8_Search.AVLTree;

import java.util.Comparator;

/**
 * @Author: turboman
 * @Date: 2019/5/11 10:35
 * @Version 1.0
 */
public class Student {
    public int id;
    public int age;
    public String name;
    public Student(){}
    public Student(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "Id:"+this.id+",Name:"+this.name+",Age:"+this.age;
    }
}
class StuComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.id > o2.id)
            return 1;
        else if (o1.id == o2.id)
            return 0;
        else
            return -1;
    }
}
