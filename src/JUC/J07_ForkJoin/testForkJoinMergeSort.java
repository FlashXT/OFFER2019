package JUC.J07_ForkJoin;

import java.util.Arrays;
import java.util.concurrent.*;

class MergeSortTask extends RecursiveAction {
    //不需要返回值的task继承RecursiveAction更好
    private int[] array;
    private int left;
    private int right;

    public MergeSortTask(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        boolean isNeedSplit = right - left >= 1;
        if (isNeedSplit) {
            int mid = (left + right) / 2;
            MergeSortTask mergeSortTask1 = new MergeSortTask(array, left, mid);
            MergeSortTask mergeSortTask2 = new MergeSortTask(array, mid + 1, right);
            mergeSortTask1.fork();
            mergeSortTask2.fork();
            mergeSortTask1.join();
            mergeSortTask2.join();
            merge(array, left, mid, right);
        } else {
            int mid = (left + right) / 2;
            merge(array, left, mid, right);
        }
    }

    public static void merge(int a[], int left, int mid, int right) {
        int len = right - left + 1;
        int temp[] = new int[len];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            temp[index++] = a[i] <= a[j] ? a[i++] : a[j++];
        }
        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= right) {
            temp[index++] = a[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            a[left++] = temp[k];
        }
    }
}
public class testForkJoinMergeSort{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] a = {4,2,1,7,5,3,8,2,7,1,78,89,6,5,4,8,5};
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MergeSortTask task = new MergeSortTask(a, 0, a.length-1);
        Future result = forkJoinPool.submit(task);
        result.get();
        System.out.println(Arrays.toString(a));

    }

}