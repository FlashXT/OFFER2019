package P03_Algorithm.A03_DynamicProgramming.DP05_HouseRobber;

class Method1 {
    public static int HBMax(int[]arr,int N){
        if(N < 0)
            return 0;
        return Math.max(arr[N]+HBMax(arr,N-2),HBMax(arr,N-1));
    }
}
