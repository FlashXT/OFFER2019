package P04_CodingInterviews.P052_isNumeric;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/17,21:52
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Method1 {
    public boolean isNumeric(char[] str) {
        boolean sign = false,hasE = false,hasD = false;
        for(int i = 0; i < str.length;i++){
            System.out.println(str[i]=='.');
            if(str[i] =='e' || str[i]=='E'){
                // e后面一定要接数字
                if(i == str.length-1)
                    return  false;
                // 不能同时存在两个e
                if(hasE)
                    return false;
                hasE=true;
            }else if(str[i]=='+'||str[i]=='-'){
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i-1] != 'e' && str[i-1] != 'E')
                    return false;

                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E')
                    return false;
                sign = true;

            }else if(str[i]=='.'){

                // e后面不能接小数点，小数点不能出现两次
                if (hasE || hasD)
                    return false;
                hasD = true;
            }else if (str[i] < '0' || str[i] > '9') // 不合法字符
                    return false;
        }
        return true;
    }
}
