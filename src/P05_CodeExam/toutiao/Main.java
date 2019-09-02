package P05_CodeExam.toutiao;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i< n; i++){
            arr[i] = sc.nextInt();
        }
        int[] arr1 = new int[n];
        for (int i = 0; i< n; i++){
            arr1[i] = arr[i] + i;
        }
        int[] arr2 = new int[n];
        for (int i = 0; i< n; i++){
            arr2[i] = arr[i] - i;
        }
        int last = arr1[0];
        int max = 0;
        for (int i = 1; i< n; i++){
            if(arr2[i] + last > max){
                max = arr2[i] + last;
            }
            if(arr1[i] > last){
                last = arr1[i];
            }
        }


//        int max = 0;
//        for (int i = 0; i< n; i++){
//            for (int j = i+1; j< n; j++){
//                int temp = arr[i] + arr[j] + i-j;
//                if(temp > max){
//                    max = temp;
//                }
//            }
//        }
        System.out.println(max);
    }

}
