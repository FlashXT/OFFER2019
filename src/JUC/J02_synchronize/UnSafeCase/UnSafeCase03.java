package JUC.J02_synchronize.UnSafeCase;


import java.util.ArrayList;
import java.util.List;

//Java容器操作的线程不安全
public class UnSafeCase03{

    public static void main(String [] args){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 10000;i++){
            new Thread(()->
            {list.add(Thread.currentThread().getName());}
            ).start();
        }
        System.out.println(list.size());
    }

}
