package P04_CodingInterviews.P027_Permutation;

import java.util.ArrayList;
import java.util.Iterator;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/9,22:27
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Main {
    public static void main(String [] agrs){
        String str = "abcc";
        ArrayList<String> res = new Method3().Permutation(str);
        Iterator<String> iter = res.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
    }
}
