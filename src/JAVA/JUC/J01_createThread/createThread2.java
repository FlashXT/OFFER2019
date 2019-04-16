package JAVA.JUC.J01_createThread;


import java.util.concurrent.*;

/***************************************************************************
 * 创建线程方法三Callable()接口：
 *  ①创建Callable的实现类,并重写call()方法，该方法为线程执行体，并且该方法有返回值
 *  ②创建Callable的实现类的实例;
 *  ③以Callable的实现类的实例为参数，创建FutuerTask类的实例;该FutuerTask对象封装了
 *    Callable对象call()方法的返回值;
 *  ④以FutuerTask类的实例创建Thread类实例,调用start()方法启动线程;
 *  ⑤通过FutuerTask类的对象的get()方法来获取线程结束后的返回值;
 *
 ***************************************************************************/
class MyThread3 implements Callable<Integer> {
    int n;

    public MyThread3(int n){
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

public class createThread2 {
    public static void main(String [] args){

        MyThread3 mt3 = new MyThread3(10);
        FutureTask<Integer> task= new FutureTask<>(mt3);
        Thread t3 = new Thread(task);
        t3.start();
        try {
            //获取线程执行结果
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
