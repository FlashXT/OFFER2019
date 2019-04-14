package JUC.J01_createThread;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

/*
 * 线程池
 */
class MyThread4 implements Callable<Integer> {
    int n;

    public MyThread4(int n){
        this.n = n;
    }
    public Integer call(){
        return sum();

    }
    public int sum(){
        int res = 0;
        for(int i =0;i <=this.n;i++){
            res +=i;
        }
        return res;
    }
}

public class createThread3 {
    public static void main(String [] args) throws ExecutionException, InterruptedException {

        MyThread4 mt1 = new MyThread4(10);
        MyThread4 mt2 = new MyThread4(100);
        MyThread4 mt3 = new MyThread4(1000);


        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交线程执行
        Future<Integer> res1 = ser.submit(mt1);
        Future<Integer> res2 = ser.submit(mt2);
        Future<Integer> res3 = ser.submit(mt3);
        //获取执行结果
        Integer r1 = res1.get();
        Integer r2 = res2.get();
        Integer r3 = res3.get();
        System.out.println(r1+" "+r2+" "+r3);



    }

}
