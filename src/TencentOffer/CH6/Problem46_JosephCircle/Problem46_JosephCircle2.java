package TencentOffer.CH6.Problem46_JosephCircle;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/15 20:47
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem46_JosephCircle2 {
    public static void main(String [] args){
        System.out.println(JosephCircle(2,3));
    }
    public static int JosephCircle(int n,int m){

        if(n <1 || m < 1) return -1;
        int [] nums = new int [n];
        int i = -1,step = 0, count = nums.length;
        while(count>0){   //跳出循环时将最后一个元素也设置为了-1
            i++;          //指向上一个被删除对象的下一个元素。

            if(i==nums.length) i=0;  //模拟环。

            if(nums[i] == -1) continue; //跳过被删除的对象。
            step++;                     //记录已走过的。
            if(step==m) {               //找到待删除的对象。
                nums[i]=-1;
                step = 0;
                count--;
            }
        }
        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
    }
}
