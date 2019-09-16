package P04_CodingInterviews.P043_LeftRotateString;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/16,15:22
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public String LeftRotateString(String str,int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = n; i < n+str.length();i++){
            sb.append(str.charAt(i%str.length()));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
