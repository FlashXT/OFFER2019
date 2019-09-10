package P04_CodingInterviews.P034_FirstNotRepeatingChar;

import java.util.HashMap;
import java.util.Map;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/10 22:45
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public static int FirstNotRepeatingChar(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        for(int i = 0; i< str.length();i++){
            if(map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
