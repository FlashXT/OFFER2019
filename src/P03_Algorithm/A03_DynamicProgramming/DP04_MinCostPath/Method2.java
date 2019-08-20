package P03_Algorithm.A03_DynamicProgramming.DP04_MinCostPath;


class Method2 {

    public static int MinCostPath(int [][] arr){

        int [][] mincost = new int [arr.length][arr.length];
        int valleft,valup;
        for(int i = 0; i< arr.length;i++){
            for(int j = 0; j < arr.length;j++){
                valleft = i == 0 ? arr[0][j]:mincost[i-1][j];
                valup   = j == 0 ? arr[i][0]:mincost[i][j-1];
                if(i== 0 && j ==0 ) valleft =valup =0;
                //状态转移方程
                mincost[i][j] = arr[i][j]+Math.min( valleft,valup);
            }

        }
//        for(int i = 0; i < arr.length;i++){
//            for(int j = 0; j < arr.length;j++)
//                System.out.printf("%-4d",mincost[i][j]);
//            System.out.println();
//        }

        return mincost[arr.length-1][arr.length-1];

    }
}
