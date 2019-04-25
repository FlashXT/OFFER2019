//package Test.Test360;
//
//import java.util.*;
//
//public class colorfulBall {
//    public static void main(String [] args) {
//        Scanner scan = new Scanner(System.in);
//        int num = scan.nextInt();
//        int i = 0, key;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        while (i < num) {
//            key = scan.nextInt();
//            if (map.containsKey(key))
//                map.put(key, map.get(key) + 1);
//            else
//                map.put(key, 1);
//            i++;
//        }
//        int[] ball = new int[map.size()];
//        i = 0;
//        int min = Integer.MAX_VALUE;
//        for (int item : map.values()){
//            ball[i++] = item;
//            min = min < item ? min:item;
//        }
//        int [] ball = {3,6};
//        int min = 4;
//        int i =0;
//        if(allEven(ball)){
//            i = 0;
//            for(int item:ball){
//                i+=item/min;
//            }
//            System.out.println(i);
//        }
//        else{
//            if(allOdd(ball) && allEqual(ball)){
//                System.out.println(ball.length);
//            }
//            else{
//                if(!allOdd(ball)){
//                    System.out.println(0);
//                }
//
//            }
//        }
//
//    }
//
//    public static boolean allEqual(int [] arr){
//        int item = arr[0];
//        for(int i =1;i < arr.length;i++){
//            if(arr[i]!=item)
//                return false;
//        }
//        return true;
//    }
//    public static boolean allEven(int [] arr){
//        for(int item:arr){
//            if(item%2 != 0 )
//                return false;
//        }
//        return true;
//    }
//    public static boolean allOdd(int [] arr){
//        for(int item:arr){
//            if(item%2 == 0)
//                return false;
//        }
//        return true;
//    }
//}
