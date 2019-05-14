package TencentOffer.CH5.Problem34_GetUglyNumber;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/14 18:47
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class GetUglyNumber2 {
    public static void main(String[] args) {

        System.out.println(GetUglyNumber(7));
    }

    public static int GetUglyNumber(int index) {
        if(index <=0)  return 0;
        int [] res = new int[index];
        res[0] = 1;
        int index2 =0,index3 = 0,index5 =0;
        for(int i = 1; i< res.length;i++){
            res[i] = Math.min(res[index2]*2,Math.min(res[index3]*3,res[index5]*5));
            if(res[i] == res[index2]*2)
                index2++;
            if(res[i] == res[index3]*3)
                index3++;
            if(res[i] == res[index5]*5)
                index5++;
        }
        return res[index-1];

    }

}
