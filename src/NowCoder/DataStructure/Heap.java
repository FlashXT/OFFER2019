package NowCoder.DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/7/28 18:35
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//实现常用的大顶堆和小顶堆
//也可以将Test定义在 Adder 类中，但需要定义为静态内部类
class Test{
    int att1;
    int att2;
    public Test(int att1,int att2){
        this.att1 = att1;
        this.att2 = att2;
    }
}
public class Heap {

    public static void main(String [] args){
        //小顶堆
        Comparator<Test> comp1 = new Comparator<Test>() {
            @Override
            //o1是新来的元素，o2是heap中的元素
            public int compare(Test o1, Test o2) {
                //return 后面的式子大于0则交换o1,o2的顺序
                return o1.att1 - o2.att2;
            }
        };
        //大顶堆
        Comparator<Test> comp2 = new Comparator<Test>() {
            @Override
            //o1是新来的元素，o2是heap中的元素
            public int compare(Test o1, Test o2) {
                //return 后面的式子大于0则交换o1,o2的顺序
                return o2.att1 - o1.att2;
            }
        };
        //heap只保证出堆的顺序是大顶堆或者小顶堆的顺序，heap内部不保证元素的存放顺序！！！
        PriorityQueue<Test> heap = new PriorityQueue<>(comp2);
        for(int i = 0 ; i<10;i++){
            heap.add(new Test(i,i));
        }
        while(!heap.isEmpty()){
            System.out.println(heap.poll().att1);
        }

    }

}
