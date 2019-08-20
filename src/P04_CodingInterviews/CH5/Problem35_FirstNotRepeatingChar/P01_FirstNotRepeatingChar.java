package P04_CodingInterviews.CH5.Problem35_FirstNotRepeatingChar;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/14 20:06
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class P01_FirstNotRepeatingChar {
    public static void main(String [] args){
        String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        System.out.println(FirstNotRepeatingChar(str));
    }
    public static int FirstNotRepeatingChar(String str){
        char [] ch = str.trim().toCharArray();
        int [][] time = new int [2][52];
        for(int i = 0; i< ch.length;i++){
            if(ch[i] >='a' && ch[i]<='z'){
                time[0][ch[i]-'a']++;

                time[1][ch[i]-'a'] = i;
            }

            else{
                time[0][ch[i]-'A'+26]++;
                time[1][ch[i]-'A'+26] = i;
            }

        }
        for(int i = 0; i< ch.length;i++){
            if(ch[i] >='a' && ch[i]<='z'){
                if(time[0][ch[i]-'a'] == 1)
                    return time[1][ch[i]-'a'];

            }

            else{
                if(time[0][ch[i]-'A'+26] == 1)
                    return time[1][ch[i]-'A'+26];
            }
        }
        return -1;

    }
}
