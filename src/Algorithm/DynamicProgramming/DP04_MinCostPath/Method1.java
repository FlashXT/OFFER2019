package Algorithm.DynamicProgramming.DP04_MinCostPath;

import java.util.Arrays;

class Method1 {
    static int mincost = Integer.MAX_VALUE;
    static String [] path = new String[7];
    static String  minpath;
    public static int MinCostPath(int [][] arr){
        MinCostpath( arr,0 ,0,0,0);
        return mincost;
    }
    private static int MinCostpath(int [][] arr,int row ,int col,int cost ,int step){

        if(row == arr.length &&col == arr.length-1 ||row == arr.length-1 &&col == arr.length){
            if(mincost > cost){
                minpath = Arrays.toString(path);
            }
             mincost = mincost < cost ? mincost:cost;
        return mincost;
        }
        if(row == arr.length){
            row--;
            col++;
        }
        if(col == arr.length){
            row++;
            col--;
        }

        for(int i = step; i <=(arr.length -1)+(arr.length-1);i++){
            cost+=arr[row][col];
            path[i] = row+"-"+col;
            MinCostpath(arr,row+1,col,cost,i+1);
            MinCostpath(arr,row,col+1,cost,i+1);
            cost-=arr[row][col];

        }

        return mincost;
    }
}
