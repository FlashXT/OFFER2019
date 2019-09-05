package P01_DataStructure.CH8_Search.BinarySearch;

/******************************************************
 * 旋转数组的最小数字
 *
 */
public class Main {
    public static void main(String [] args){
        int [] arr = {1,0,1,1,1};
        System.out.println(BinaryMin(arr));

    }
    public static int BinaryMin(int [] arr){
        if(arr.length == 0) return -1;
        int index1 = 0;
        int index2 = arr.length - 1;
        int indexmid = index1; //如果数组旋转了0个元素，则直接返回0位置的元素；
        while(arr[indexmid] >= arr[index2]){
            if(index2 - index1 == 1){
                indexmid = index2;
                break;
            }
            indexmid = (index1 + index2)/2;
//            //如果下标为index1，index2和indexMid 指向的三个数字相等；则顺序查找
//            if(arr[index1] == arr[index2] && arr[index1] == arr[indexmid])
//                return MinInorder(arr,index1,index2);
            //如果arr[mid]>arr[index1],说明mid位于第一个子串，
            // 此时沿着第一个子串向后找，所以index1 = indexmid;
            if(arr[indexmid] >= arr[index1]){
                index1 = indexmid;
            }
            //如果arr[mid]< arr[index2],说明mid位于第二个子串，
            // 此时沿着第二个子串向前找，所以index2 = indexmid;
            else if(arr[indexmid] <= arr[index2]){
                index2 = indexmid;
            }

        }
        return arr[indexmid];
    }
    public static int MinInorder(int [] arr,int index1,int index2){
        int result = arr[index1];
        for(int i = index1+1; i <= index2;i++){
            if(result > arr[i])
                result = arr[i];
        }
        return result;
    }

}
