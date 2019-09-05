package P04_CodingInterviews.OldVersion.CH3.Problem12_BigNumProblem.Problem12_PrintN;

public class Method3 {

    //把数字加法转化为数字在不同位置上的全排列问题
    public static boolean Print1ToMaxOfDigits_3(int N) {
        if(N <= 0){
            System.out.println("The N is less than 1.");
            return false;
        }
        char [] number = new char[N];
        for(int i = 0; i< number.length;i++)
            number[i] = '0';
        NumberArrange(number,0);

        return true;

    }
    //字符串模拟整数加法
    private static void NumberArrange(char [] ch,int index){
        if(index >= ch.length){
            PrintNumber(ch);
            return ;
        }

        for(int i = 0; i <= 9; i++){
            ch[index] = (char)(i+'0');
            NumberArrange(ch,index+1);

        }

    }
    private static void PrintNumber(char [] ch){

        int i = 0;
        for(i = 0; i < ch.length;i++){
            if(ch[i] != '0'){
                break;
            }
        }
        while(i < ch.length){
            System.out.printf("%c",ch[i++]);
        }
        System.out.println();
    }
}
