package P04_CodingInterviews.OldVersion.CH3.Problem12_BigNumProblem.Others;


/************************************************
 * 实现任意大小的两个数字加法
 * 输入：两个任意长度的String 形式的整数
 * 输出：输入整数的相加结果
 ************************************************/
public class BigNumAdd {
    public static void main(String [] args){


        String num1 = "8989666666666667";
        String num2 = "324329999999999993";

        System.out.println(Add(num1,num2));
    }
    public static String Add(String n1,String n2){
        char [] ch1 = n1.toCharArray();
        char [] ch2 = n2.toCharArray();
        byte [] num1 = new byte[ch1.length];
        byte [] num2 = new byte[ch2.length];
        for(int i = 0; i < ch1.length;i++){
            num1[i] = (byte)(ch1[i]-'0');
        }
        for(int i = 0; i < ch2.length;i++){
            num2[i] = (byte)(ch2[i]-'0');
        }

        int length = Math.max(num1.length,num2.length)+1;
        byte [] res = new byte[length];
        int bit1 = num1.length-1;
        int bit2 = num2.length-1;
        int bitres = res.length-1;
        while(bit1 >= 0 && bit2 >= 0){

            res[bitres-1] +=(byte)((num1[bit1]+num2[bit2])/10);
            res[bitres] = (byte)((res[bitres]+num1[bit1]+num2[bit2])%10);
            bitres--;bit1--;bit2--;

        }
        while(bit1 >=0){

            res[bitres-1] = (byte)((res[bitres]+num1[bit1])/10);
            res[bitres] = (byte)((res[bitres]+num1[bit1])%10);
            bitres--;bit1--;
        }
        while(bit2 >=0){
            res[bitres-1] = (byte)((res[bitres]+num2[bit2])/10);
            res[bitres] = (byte)((res[bitres]+num2[bit2])%10);

            bitres--;bit2--;
        }

        String str = res[0]==0?"":res[0]+"";
        bitres=1;
        while(bitres < res.length){
            str+=res[bitres++];
        }
        return str;

    }

}
