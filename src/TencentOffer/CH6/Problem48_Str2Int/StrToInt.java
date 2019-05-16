package TencentOffer.CH6.Problem48_Str2Int;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/16 10:02;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class StrToInt {
    public static  void main(String [] args){
        System.out.println(Integer.valueOf("-2147483648"));
          System.out.println(StrToInt("-2147483648"));
//        System.out.println(Integer.MAX_VALUE+1);
//        System.out.println(Integer.MIN_VALUE);
    }
    public static int StrToInt(String str){
        if(str.length() == 0) return 0;
        char [] ch = str.toCharArray();
        int sum = 0;
        for(int i = ch.length -1; i >= 0 ;i--){
            if( ch[i] < '0' || ch[i] > '9'){
                if(i == 0){
                    if(ch[0] == '-'){
                            sum = -sum;
                    }
                    else if(ch[0] != '+')
                        return 0;
                }
                else
                    return 0;
            }
            else
//                sum+=(ch[i]-'0')*Math.pow(10,ch.length-1-i); //不强制转型，需要把sum改为long型
                  sum+=(int)((ch[i]-'0')*Math.pow(10,ch.length-1-i));

        }
        return (int)sum;
    }
}
