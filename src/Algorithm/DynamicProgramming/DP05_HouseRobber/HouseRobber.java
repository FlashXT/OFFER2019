package Algorithm.DynamicProgramming.DP05_HouseRobber;

public class HouseRobber {
    public static void main(String [] args){
        int []arr = {4,3,1,2};
        int [] value = new int[arr.length];
        for(int i = 0; i < value.length;i++){
            value[i]=-1;
        }
        System.out.println(Method1.HBMax(arr,arr.length-1));
        System.out.println(Method2.HBMax(arr,arr.length-1,value));
        System.out.println(Method3.HBMax(arr));

    }
}
