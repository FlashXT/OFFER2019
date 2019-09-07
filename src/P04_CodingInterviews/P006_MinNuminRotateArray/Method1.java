package P04_CodingInterviews.P006_MinNuminRotateArray;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/5 17:03
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*

    思路：

    （1）我们用两个指针left,right分别指向数组的第一个元素和最后一个元素。按照题目的旋转的规则，第一个元素应该
    是大于最后一个元素的（没有重复的元素）。但是如果不是旋转，第一个元素肯定小于最后一个元素。

   （2）找到数组的中间元素。中间元素大于第一个元素，则中间元素位于前面的递增子数组，此时最小元素位于中间元素的后面。
   我们可以让第一个指针left指向中间元素。   移动之后，第一个指针仍然位于前面的递增数组中。
   中间元素小于第一个元素，则中间元素位于后面的递增子数组，此时最小元素位于中间元素的前面。我们可以让第二个指针right
   指向中间元素。移动之后，第二个指针仍然位于后面的递增数组中。

   这样可以缩小寻找的范围。
   (3）按照以上思路，第一个指针left总是指向前面递增数组的元素，第二个指针right总是指向后面递增的数组元素。
   最终第一个指针将指向前面数组的最后一个元素，第二个指针指向后面数组中的第一个元素。也就是说他们将指向两个相邻的元素，
   而第二个指针指向的刚好是最小的元素，这就是循环的结束条件。

   链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba?f=discussion

 */
public class Method1 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;
        int start = 0, end = array.length-1;
        //①对应于旋转0个元素的数组，应该返回第一个元素；因此，mid初值置为start;
        int mid = start;
        while(array[start] >= array[end]){
            if(end - start ==1){
                mid = end;
                break;
            }
            mid = start + (end - start)/2;
            //②对应于重复值的情况
            if(array[mid] == array[start] && array[start] == array[end]){
                int res = array[start];
                for(int i = start ; i <= end;i++){
                    if(res > array[i])
                        res = array[i];
                }
                System.out.println(res);
                return res;
            }
            //③正常情况
            //mid和start在同一段
            if(array[mid] >= array[start])
                start = mid; //不是mid+1
            //mid和start在不同段
            else if(array[mid] <= array[end]){
                end = mid; //不是mid-1
            }
        }
        System.out.println(array[mid]);
        return array[mid];
    }
}
