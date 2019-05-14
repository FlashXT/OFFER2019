package Algorithm.DynamicProgramming.DP07_LongestIncreasingSubsequence;

import java.util.Arrays;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/5/13 22:38
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/

/*********************************************************************
 * 思路：
 *  新建一个low数组，low[i]表示长度为i+1的LIS结尾元素的最小值。对于一个上升子序列，
 *  显然其结尾元素越小，越有利于在后面接其他的元素，也就越可能变得更长。因此，我们
 *  只需要维护low数组，对于每一个a[i]，如果a[i] > low[当前最长的LIS长度]，就把
 *  a[i]接到当前最长的LIS后面，即low[++当前最长的LIS长度]=a[i]。
 *  那么，怎么维护low数组呢？
 *  对于每一个a[i]，如果a[i]能接到LIS后面，就接上去；否则，就用a[i]取更新low数组。
 *  具体方法是，在low数组中找到第一个大于等于a[i]的元素low[j]，用a[i]去更新low[j]。
 *  如果从头到尾扫一遍low数组的话，时间复杂度仍是O(n^2)。我们注意到low数组内部一定
 *  是单调不降的，所有我们可以二分low数组，找出第一个大于等于a[i]的元素。二分一次low
 *  数组的时间复杂度的O(lgn)，所以总的时间复杂度是O(nlogn)。
 *
 ***********************************************************************/
public class LongestIncreasingSubsequence3 {
    public static void main(String [] args){
        int [] arr = {10,9,2,5,3,4};
        System.out.println(LIS(arr));
    }

    //贪心+二分
    private static int LIS(int [] nums){

        int maxL = 0;
        int[] low = new int[nums.length];
        low[0] = nums[0];
        for(int i = 1;i< nums.length;i++) {
            if (nums[i] > low[maxL]) {
                low[++maxL] = nums[i];
            } else {
                int pos = BinarySearch(low, maxL,nums[i]);
                low[pos] = nums[i];

            }
        }
        return ++maxL;

    }
    public static int BinarySearch(int [] arr,int high,int target){
        int low =0,mid;
        while(low<=high) {
            mid=(low+high)>>1;
            if(arr[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;
    }

}
