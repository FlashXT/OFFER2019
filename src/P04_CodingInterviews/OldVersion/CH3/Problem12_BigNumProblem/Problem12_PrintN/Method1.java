package P04_CodingInterviews.OldVersion.CH3.Problem12_BigNumProblem.Problem12_PrintN;

public class Method1 {

    //无法处理大数问题，int是否会溢出，long long 型是否会溢出
    //java 中可以使用BigInteger(),BigDecimal()
    public static boolean Print1ToMaxOfDigits_1(int N) {
        if(N <= 0) {
            System.out.println("The N is less than 1.");
            return false;
        }
        int i = 0,number=1;
        while (i++ < N){
            number*= 10;
        }
        for(i = 1; i < number; i++){
            System.out.printf("%d\t",i);
        }
        System.out.println();
        return true;
    }
}
