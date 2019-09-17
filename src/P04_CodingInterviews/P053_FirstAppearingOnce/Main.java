package P04_CodingInterviews.P053_FirstAppearingOnce;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/17,22:25
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    int [] hashtable = new int[256];
    StringBuilder sb = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        if(hashtable[ch] == 0)
            hashtable[ch]=1;
        else
            hashtable[ch]+=1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char [] str = sb.toString().toCharArray();
        for(char ch:str){
            if(hashtable[ch] == 1)
                return ch;
        }
        return '#';
    }
}
