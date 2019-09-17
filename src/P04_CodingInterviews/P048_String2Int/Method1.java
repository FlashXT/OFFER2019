package P04_CodingInterviews.P048_String2Int;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/17 7:48
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public int StrToInt(String str) {
        if(str == null||str.equals("")) return 0;
        //判断首位是否为符号
        int sign = 1;
        if(str.charAt(0)=='-'||str.charAt(0)=='+') {
            if(str.charAt(0)=='-')sign=-1;
            str = str.substring(1);
        }
        int sum = 0;
        for(int i = str.length()-1;i >=0;i--){
            if(str.charAt(i) >='0' && str.charAt(i)<='9')
                //对于-2147483648，计算的是2147483648，计算完最后一位后
                // 溢出为2147483647，int强制转化后变为-2147483648，乘以
                //sign=-1,为2147483648，依然溢出为-2147483648

                sum+=(int)((str.charAt(i)-'0')*Math.pow(10,str.length()-1-i));
            else
                return 0;
        }
        return sign*sum;
    }
}
