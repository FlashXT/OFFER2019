package Algorithm.DynamicProgramming.DP05_HouseRobber;

import java.util.Vector;

class Method3 {

    public static int HBMax(int[]arr){
        //value[i]表示抢劫第i个房子后的最大收益
        int [] value = new int[arr.length];
        value[0] = arr[0];
        value[1] = value[0]>arr[1]?value[0]:arr[1];
        for(int i= 2 ; i < arr.length;i++){
            value[i] =  Math.max(arr[i]+value[i-2],value[i-1]);
        }
        return value[value.length-1];

    }
}
