package P02_JAVA.JUC.J07_ForkJoin;

import java.util.Arrays;
import java.util.concurrent.*;

public class testForkJoinMergeSort2 {

    public static void main(String[]args)throws InterruptedException{
        int[] array = {4,2,1,7,5,3,8,2,7,1,78,89,6,5,4,8,5};

        MergeSort task =new MergeSort(array, 0,array.length-1);

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        while (!task.isDone()){
            Thread.sleep(50);
        }
        pool.shutdown();
        if (task.isCompletedNormally())
          System.out.println(Arrays.toString(array));
    }
}
class MergeSort extends RecursiveAction {
    //不需要返回值的task继承RecursiveAction更好
    private int[] array;
    private int left;
    private int right;
    private int THRESHOLD = 2;

    public MergeSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        //1. 当排序项分解成少于阈值时直接执行归并排序算法
        int middle = (left +right) / 2;
        if (right -left < THRESHOLD) {
            merge(array,left,middle,right);
        }
        else {
            //2. 当排序项大于10000时，将数组分成两部分（
            // 由框架根据条件自动递归分解，直到项数少于10000为止）

            MergeSort t1 =new MergeSort(array,left,middle);
            MergeSort t2 =new MergeSort(array,middle + 1,right);
            invokeAll(t1,t2);
            //3. 递归归并排序被分解的两组数字
            merge(array,left,middle,right);
        }
    }

    public  void merge(int a[], int left, int mid, int right) {
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
