package P04_CodingInterviews.CH8.Problem54_isNumeric;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/16 15:59;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//编写过滤规则
public class Problem54_isNumeric {
    public static void main(String [] args){
        System.out.println(isNumeric("12e+5.4"));
    }
    public static Boolean isNumeric(String str){
        int countD = 0,counte = 0;
        char [] ch = str.toCharArray();
        for(int i = 0 ;i < ch.length;i++){
            if(ch[i] >= '0' && ch[i] <= '9')
                continue;
            else if(ch[i] == 'E'||ch[i] == 'e'){

                if(counte == 1 || i == ch.length-1)
                    return false;
                else{
                    counte++;
                    continue;
                }
            }
            else if(ch[i]=='+'||ch[i]=='-'){
                if(i ==0)
                    continue;
                if(i == ch.length-1)
                    return false;
                else if(ch[i+1]== '+' || ch[i+1] == '-')
                    return  false;
                else if(ch[i-1] >= '0'&& ch[i-1] <= '9' ||ch[i-1]=='+'||ch[i-1]=='-')
                    return  false;
                else
                    continue;
            }

            else if(ch[i]=='.'){
                if(i ==ch.length-1||countD ==1||counte==1)
                    return  false;
                else{
                    countD++;
                    continue;
                }
            }
            else if(ch[i] == 'e'){
                if(i == ch.length-1)
                    return false;
                else if(ch[i+1]>= '0' && ch[i+1] <= '9'||ch[i+1]=='+'||ch[i+1]=='-')
                  continue;
                else
                  return false;
            }
            else
                return false;
        }
        return true;

    }
}
