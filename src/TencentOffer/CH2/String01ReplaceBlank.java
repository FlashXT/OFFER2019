package TencentOffer.CH2;

/*********************************************************
 * 替换空格：请实现一个函数，把字符串中的每个空格都替换成%20.
 * 示例：输入：“We are happy.”输出：“We%20are%20happy.”
 *********************************************************/
public class String01ReplaceBlank {
    public static void main(String [] args){
        String str = "We are happy.";
        method1(str);
        method2(str);

    }
    public static void method1(String str){
        if(str == null) return ; //考虑特殊情况！！！
        String [] ch = str.split(" ");
        String temp = "";
        int i = 0;
        for( i = 0; i < ch.length-1;i++){

            temp +=ch[i]+"%20";
        }
        temp+=ch[i];
        System.out.println(temp);
    }

    //不使用库函数
    public static void method2(String str){
        if(str == null) return ; //考虑特殊情况！！！
        char[] ch = str.toCharArray();
        int count = 0;
        //计算空格的个数
        for(int i =0 ; i < ch.length;i++){
            if(ch[i] == ' ')
                count++;
        }
        //一个空格替换为%20，长度增加2；分配新数组，空间复杂度增加
        char [] temp = new char[ch.length+2*count];

        for(int  p1 =0,p2 = 0; p1 < ch.length;p1++){
                if(ch[p1] != ' ')
                    temp[p2++] =ch[p1];
                else{
                    temp[p2++] = '%';
                    temp[p2++] = '2';
                    temp[p2++] = '0';
                }
        }

//        System.out.println(temp);
    }
}
