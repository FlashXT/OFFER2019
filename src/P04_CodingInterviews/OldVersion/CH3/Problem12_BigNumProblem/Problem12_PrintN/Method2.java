package P04_CodingInterviews.OldVersion.CH3.Problem12_BigNumProblem.Problem12_PrintN;

public class Method2 {

    //对于大数问题，通常使用字符串或数组来表示大数,然后模拟数值运算
    public static boolean Print1ToMaxOfDigits_2(int N) {
        if(N <= 0){
            System.out.println("The N is less than 1.");
            return false;
        }
        char [] number = new char[N];
        for(int i = 0; i< number.length;i++)
            number[i] = '0';
        while(!Increment(number)){
            PrintNumber(number);
        }
        return true;

    }
    //字符串模拟整数加法
    private static boolean Increment(char [] ch){
        boolean isOverflow = false;
        int nTakeOver = 0;  //代表进位
        for(int bit = ch.length-1; bit >= 0;bit--){
            int nSum = ch[bit]-'0'+nTakeOver;
            if(bit == ch.length-1)
                nSum++;     //最后一为数字做加法
            if(nSum >= 10){ //执行进位操作
                if(bit == 0) //进位溢出
                    isOverflow = true;
                else{
                    nSum -= 10;   //进位
                    nTakeOver  =1;
                    ch[bit] = (char)('0'+nSum);//当前位置为仅进位后剩下的值相加
                }
            }
            else{
                ch[bit] = (char)('0'+nSum);
                break;
            }
        }
        return isOverflow;

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
