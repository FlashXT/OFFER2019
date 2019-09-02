package P03_Algorithm.A04_BitOp;

/****************************************************
 * 判断一个数字用二进制表示有几个1
 */
public class NumberOfOne {
    public static void main(String [] args){
        int num = -100;
//        System.out.println(NumberOf1(num));
        System.out.println(NumberOf12(num));
        System.out.println(NumberOf13(num));

    }
    public static int NumberOf1(int num){

        int count = 0;
        while(num!= 0){
            int temp = num &1;
            if( temp!= 0){
                count++;
            }
            //循环左移，不能处理负数，符数右移最高位补1，造成死循环
            num = num >>1;
        }
        return count;
    }

    public static int NumberOf12(int num){

        int count = 0;
        int flag = 1;
        while(flag!=0){
            int temp = num & flag;
            if( temp!= 0){
                count++;
            }
            //flag左移避免造成死循环，当flag移动到超出整型的范围时，循环结束
            //该种方法循环次数等于整型二进制位的位数(32位)
            flag = flag <<1;
        }
        return count;
    }
    public static int NumberOf13(int num){
        //规律：一个整数减去1，再和原整数做与运算,会把该整数最右边一个1变成0；
        // 一个整数的二级制表示中有多少个1就可以进行多少次这样的操作；
        int count = 0;
        while(num != 0){
            count++;
            num = (num-1)&num;

        }
        return count;
    }
}
