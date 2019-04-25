package Algorithm.BackTrack;

public class EightQueens {
    public static int count = 0;
    public static void main(String [] args){
        int [] arr = new int[8];
        eightQueens(arr,0);

        System.out.println(count);
    }
    public static void eightQueens(int [] arr,int row){

        if(row >= arr.length) {
//            for (int item : arr) {
//                System.out.print(item + " ");
//            }
//            System.out.println();
            print(arr);
            count++;
            return ;
        }
        for(int j = 0;j < arr.length;j++){
            arr[row] = j;
            if(noConflict(arr,row)) {
                eightQueens(arr,row+1); //试探
            }

//            arr[row] = 0;                 //回溯
        }

    }
    public static  boolean noConflict(int [] arr,int i){
        for(int index = 0; index < i;index++){
            if(Math.abs(arr[index]-arr[i]) == Math.abs(index - i)|| arr[index] == arr[i])
                return false;
        }
        return true;
    }
    public static void print(int [] arr){
        System.out.println("========================");
        for(int i = 0; i < arr.length;i++){
            for(int j = 0; j < arr.length;j++){
                if(j == arr[i])
                    System.out.print(" * ");
                else{
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
        System.out.println("========================");
    }

}
