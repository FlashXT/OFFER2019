package Test.HuaWei;
/*****************************************************************
 * 2019.3.20：
 * 试题二：输出蛇形字符串；
 * 要点：字符串处理 ，通过80%测试用例
 *****************************************************************/

public class HuaWeiTest2 {
    public static void main(String [] args){
        String str ="SwSE$3454356DD$$#E#eswsxxsssAAWDxxdderf" +
                    "vcRFER65645hbg^^%%^UnbnvccTRChnyvcxcvVCFR";
        //存储26个字母的大小
        int []upper = new int[26];
        int []lower = new int[26];
        //将字符串转为字符数组
        char [] chararray = str.toCharArray();
        //构造大小字母对应出现次数的数组
        for(int i = 0; i < chararray.length;i++){
            if( chararray[i] >= 'a' && chararray[i] <='z'){
                lower[chararray[i]-97] += 1;
            }
            if( chararray[i] >= 'A' && chararray[i] <='Z'){
                upper[chararray[i]-65] += 1;
            }
        }
        //如果没有大小写同时出现的字符，返回"Not Found"
        int count = 0;
        for(int m = 0; m < upper.length;m++){
            if(upper[m] == 0 || lower[m] == 0)
                count++;
        }
        if(count == 26) {
            System.out.println("Not Found");
            return ;
        }
        //统计字母大小写对出现的次数（统一字母大写字母与小写字母出现次数中最小的）
        String [] strarray = new String[26];
        int []  times = new int[26];
        int j = 0;
        for(int i = 0; i < upper.length;i++){
            if(upper[i] > 0  & lower[i] > 0 ){
                strarray[i] = String.valueOf((char)('A'+i))+(char)('a'+i);
                times[i] = upper[i] < lower[i] ? upper[i]:lower[i];
            }
        }
        //输出找到的蛇形字符串
        j = 0;
        for(int i = 0; i < strarray.length;i++){
            if(times[i]>0){
                j = i;
                while(times[j]!=0){
                    //表示该字母已用过一次，出现次数减1
                    times[j]--;
                    j++;
                }
                //输出本次循环找到的字符串
                for(int k = i; k < j;k++){
                    System.out.print(strarray[k]);
                }
                System.out.println();
            }
            //输出后如果该字母还有出现次数，i不变(先减后加)
            if( times[i] > 0) i--;
        }

    }
}
