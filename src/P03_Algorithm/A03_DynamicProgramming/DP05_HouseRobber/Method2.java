package P03_Algorithm.A03_DynamicProgramming.DP05_HouseRobber;

class Method2 {

    public static int HBMax(int[]arr,int N,int[] value){
        if(N < 0)
            return 0;
        if(value[N] == -1)
            value[N] =  Math.max(arr[N]+HBMax(arr,N-2,value),HBMax(arr,N-1,value));
        return value[N];
    }
}
