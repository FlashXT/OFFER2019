package P04_CodingInterviews.CH8.Problem55_FirstAppearingOnce;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/16 17:04;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem55_FirstAppearingOnce {
    static  int[] hashtable=new int[256];
    static  StringBuffer s=new StringBuffer();
    public static  void main(String [] args){
        Insert('a');
        System.out.println(FirstAppearingOnce());
        Insert('b');
        System.out.println(FirstAppearingOnce());
        Insert('b');
        System.out.println(FirstAppearingOnce());
        Insert('a');
        System.out.println(FirstAppearingOnce());

    }

    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        s.append(ch);
        if(hashtable[ch]==0)
            hashtable[ch]=1;
        else hashtable[ch]+=1;
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        char[] str=s.toString().toCharArray();
        for(char c:str)
        {
            if(hashtable[c]==1)
                return c;
        }
        return '#';
    }
}
