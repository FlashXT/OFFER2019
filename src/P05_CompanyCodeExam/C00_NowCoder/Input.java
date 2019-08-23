package P05_CompanyCodeExam.C00_NowCoder;

import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/7/28 18:06
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*牛客网读取输入代码
  ①优先使用根据上下文信息来确定读取个数的读取方法；
  ②避免使用hasnextXXX()方法，该方法会引入不确定的错误；
 */

public class Input{
    public static void main(String[] args) {
        //①数组类
        //输入示例：第一行输入数组的长度，第二行输入数组中每个元素
        // 5
        // 1 3 4 5 6
        //a.按照元素个数逐个读取
        Scanner scan = new Scanner(System.in);
        int arrlength = scan.nextInt();
        int [] arr = new int[arrlength];
        for(int i = 0; i<arr.length;i++){
            arr[i] = scan.nextInt();
        }
        //b.按行读取然后按空格分割
        String arra = scan.nextLine();
        String [] temp = arra.split(" ");
        int [] arrb = new int[temp.length];
        for(int i = 0; i<arrb.length;i++){
            arrb[i] = Integer.valueOf(temp[i]);
        }

        //②整数类
        //输入整数,如果输入是多个测试用例，请通过while循环处理多个测试用例
        Scanner  in= new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
        //③字符串类
        //字符处理,切分多个空格
        String str = "asd ada  adaw ada";
        String [] res = str.split("\\s+");// \\s+ 匹配多个空格
        for(int i = 0; i < res.length;i++){
            res[i] = res[i].trim();//去除前后空格

        }

    }
}
