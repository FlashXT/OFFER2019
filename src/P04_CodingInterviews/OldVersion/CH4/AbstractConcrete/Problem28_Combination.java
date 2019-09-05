package P04_CodingInterviews.OldVersion.CH4.AbstractConcrete;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/13 8:30;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem28_Combination {
    public static void main(String [] args){
        String str = "abc";
        Combination(str,3);


    }
    public static void Combination(String str,int len){
        char [] ch = str.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i = 1; i<= len;i++){
            Combination(ch,0,i,res);
        }

    }
    public static void Combination(char [] ch,int index,int length,StringBuilder str){
        if(length == 0){
            System.out.println(str);
            return ;
        }
        if(index == ch.length)
            return ;

        str.append(ch[index]);
        Combination(ch,index+1,length-1,str);
        str.deleteCharAt(str.length()-1);
        Combination(ch,index+1,length,str);

    }

}
