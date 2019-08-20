package P03_Algorithm.A01_Recursion.OtherProblem;
//对一个整数进行加法划分
public class P01_AdditiveDivision {
    public static void main(String [] args){
        int num = 6;
        int [] arr = new int [num];
        AddDivision(num,arr,0);
    }
    public static void AddDivision(int num,int [] arr,int pos){

        if(num <= 0) {
            for(int i = 0; i < pos;i++)
                System.out.print(arr[i]+" ");
            System.out.println();
        }
        for(int i =num; i > 0;i--){
            if( pos > 0 && i > arr[pos-1]) continue;
            arr[pos] = i;
            AddDivision(num - i,arr,pos+1); //试探
        }

    }
}
