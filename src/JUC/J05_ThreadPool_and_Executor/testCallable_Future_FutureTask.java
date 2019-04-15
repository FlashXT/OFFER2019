package JUC.J05_ThreadPool_and_Executor;

import java.util.concurrent.*;

/******************************************************************************
 * 在前面学习了创建线程的2种方式，一种是直接继承Thread，另外一种就是实现Runnable接口。
 *    这2种方式都有一个缺陷就是：在执行完任务之后无法获取执行结果。
 * 　 如果需要获取执行结果，就必须通过共享变量或者使用线程通信的方式来达到效果，这样使用
 *起来就比较麻烦。
 * 　而自从Java 1.5开始，就提供了Callable和Future，通过它们可以在任务执行完毕之后得
 *到任务执行结果。
 *
 *   Callable位于java.util.concurrent包下，它也是一个接口，在它里面也只声明了一个方法，
 * 这个方法叫做call();Callable一般情况下是配合ExecutorService来使用的;
 *
 *   Future接口就是对于具体的Runnable或者Callable任务的执行结果进行取消、查询是否完成、
 *获取结果。必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果。
 *  public interface Future<V> {
 *     boolean cancel(boolean mayInterruptIfRunning);
 *     boolean isCancelled();
 *     boolean isDone();
 *     V get() throws InterruptedException, ExecutionException;
 *     V get(long timeout, TimeUnit unit)
 *         throws InterruptedException, ExecutionException, TimeoutException;
 *  }
 *  Future提供了三种功能：1）判断任务是否完成；2）能够中断任务；3）能够获取任务执行结果。
 *  FutureTask是Future接口的一个唯一实现类。
 *      FutureTask类实现了RunnableFuture接口，RunnableFuture继承了Runnable接口和
 *    Future接口，而FutureTask实现了RunnableFuture接口。所以它既可以作为Runnable被线
 *    程执行，又可以作为Future得到Callable的返回值；
 *https://www.cnblogs.com/dolphin0520/p/3949310.html
 *******************************************************************************/
public class testCallable_Future_FutureTask {
    public static void main(String[] args) {
//        test1();
        test2();
    }
    public static void test1(){
        //使用Callable+Future获取执行结果
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
    public static void test2(){
        //使用Callable+FutureTask获取执行结果
        //第一种方式
//        ExecutorService executor = Executors.newCachedThreadPool();
//        Task task = new Task();
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
//
//        executor.shutdown();

        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是
        // ExecutorService，一个使用的是Thread
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }
}