package P01_DataStructure.CH1_Sort.P07_BucketSort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int arr [] = {12,10,68,42,75,38,54,9,40};
        RadixSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // only for no-negative value
    public static void RadixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }
    //确定最大数是几位数
    public static int maxbits(int[] arr) {
        int W = 0;
        for(int i =0;i < arr.length;i++){
            W = W > String.valueOf(arr[i]).length()? W: String.valueOf(arr[i]).length();
        }
        return W;
    }

//    public static int maxbits(int[] arr) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < arr.length; i++) {
//            max = Math.max(max, arr[i]);
//        }
//        int res = 0;
//        while (max != 0) {
//            res++;
//            max /= 10;
//        }
//        return res;
//    }

    public static void radixSort(int[] arr, int begin, int end, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] count = new int[radix];
        int[] bucket = new int[end - begin +1];
        for (int d = 1; d <= digit; d++) {
            //初始化
            for (i = 0; i < radix; i++) {
                count[i] = 0;
            }
            //分配
            for (i = begin; i <= end; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }

            //统计到i位置为止包含的数字个数(包含i位置上的数字个数)
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            //收集
            for (i = end; i >= begin; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            //排完一趟后，回写数组
            for (i = begin, j = 0; i <= end; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

}
