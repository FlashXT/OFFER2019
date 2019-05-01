package Algorithm.DynamicProgramming.DP03_IntegerBreak;

public class Method1 {
    static int product = 1;
    public static int IntegerBreak(int num){

        int [] temp = new int[num];
        intBreak(num,0,temp);
        return product;
    }
    //递归穷举
    private static void intBreak(int num,int index,int [] temp){
        if( num <=0) {
//            for(int i = 0; i< index;i++)
//                System.out.printf("%-2d",temp[i]);
//            System.out.println();
            int produ = 1;
            for(int i = 0; i< index;i++)
                produ *= temp[i];
            if(index ==1)
                return ;
            product = produ > product ? produ:product;
            return ;
        }
        //递归穷举，效率不够高，只是可解
        for(int i = num;i > 0;i--){
            if( index > 0 && i > temp[index-1]) continue;
            temp[index] = i;
            intBreak(num-i,index+1,temp);
        }

    }
}
