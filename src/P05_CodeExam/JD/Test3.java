package P05_CodeExam.JD;

public class Test3 {
    public static void main(String [] args){
        int sum = calcDis(100)+calcDis(90)+calcDis(80)+calcDis(70);
        System.out.println(sum);
    }
    public static  int calcDis(int x)
    {

        return 3*x;
    }
}
