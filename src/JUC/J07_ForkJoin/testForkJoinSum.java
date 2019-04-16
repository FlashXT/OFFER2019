package JUC.J07_ForkJoin;

import java.util.Arrays;
import java.util.concurrent.*;

//定义一个Task，继承自RecursiveTask，实现其compute方法
class SumTask extends RecursiveTask<Long>{
    private static final int THRESHOLD = 10;

    private long start;
    private long end;

    public SumTask(long n) {
        this(1,n);
    }

    private SumTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override  //有返回值
    protected Long compute() {
        long sum = 0;
        if((end - start) <= THRESHOLD){
            for(long l = start; l <= end; l++){
                sum += l;
            }
        }else{
            long mid = (start + end) >>> 1;
            SumTask left = new SumTask(start, mid);   //分治，递归
            SumTask right = new SumTask(mid + 1, end);
            left.fork();
            right.fork();
            sum = left.join() + right.join();
        }
        return sum;
    }
}

public class testForkJoinSum{
    public static void main(String [] args) throws Exception {
        SumTask sum = new SumTask(100);   //1个任务
        ForkJoinPool fjpool = new ForkJoinPool();  //1个ForkJoinPool
        Future<Long> future = fjpool.submit(sum); //提交任务
        Long r = future.get(); //获取返回值
        System.out.println(r);
        fjpool.shutdown();
    }

}
