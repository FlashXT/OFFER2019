package P02_JAVA.JUC.J07_ForkJoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

//ForkJoin实现快速排序
public class testForkJoinQuickSort{

    public static void main(String [] args) throws Exception {
        long [] array = {12,10,38,42,75,68,54,9,40};
        //②创建一个ForkJoinPool
        ForkJoinPool fjpool = new ForkJoinPool(10);
        //③创建一个任务
        ForkJoinTask sort = new SortTask(array);
        //④提交任务ForkJoinPool内部会开多个线程，并行上面的子任务
        fjpool.submit(sort);
        //⑤结束
        fjpool.shutdown();

        fjpool.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println(Arrays.toString(array));
    }
}


//①定义一个Task，继承自RecursiveAction，实现其compute方法
class SortTask extends RecursiveAction {
    final long[] array;
    final int lo;
    final int hi;
    private int THRESHOLD =2;

    public SortTask(long[] array) {
        this.array = array;
        this.lo = 0;
        this.hi = array.length - 1;
    }

    public SortTask(long[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    protected void compute() {
        if (hi - lo < THRESHOLD)
            sequentiallySort(array, lo, hi);
        else {
            int pivot = partition(array, lo, hi);  //划分
            SortTask sortTask1 = new SortTask(array,lo,pivot-1);
            sortTask1.fork();
            SortTask sortTask2 = new SortTask(array,pivot,hi);
            sortTask2.fork();

            sortTask1.join();
            sortTask2.join();
        }

    }

    private int partition(long[] array, int lo, int hi) {
        long x = array[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, hi);
        return i + 1;
    }

    private void swap(long[] array, int i, int j) {
        if (i != j) {
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private void sequentiallySort(long[] array, int lo, int hi) {
        Arrays.sort(array, lo, hi + 1);
    }
}


