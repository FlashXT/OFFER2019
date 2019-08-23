package P05_CompanyCodeExam.PinDuoDuo;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/7/28 15:25
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//作业调度与作业依赖：
/**************
 *
 * 5 6
 * 1 2 1 1 1
 * 1 2
 * 1 3
 * 1 4
 * 2 5
 * 3 5
 * 4 5
 ***************/
public class Problem3 {
    static class worktime{
        int no;
        int time;
        public worktime(int no,int time){
            this.no = no;
            this.time = time;
        }

    }

    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);
        int workcount = scan.nextInt();
        int dependency = scan.nextInt();
        Comparator<worktime> comp = new Comparator<worktime>() {
            @Override
            public int compare(worktime o1, worktime o2) {
                if(o1.time != o2.time)
                    return o1.time - o2.time;
                else
                    return o1.no - o2.no;
            }
        };
        PriorityQueue<worktime> heap = new PriorityQueue<>(comp);
        for(int i = 0; i < workcount;i++){
            worktime temp = new worktime(i,scan.nextInt());
            heap.add(temp);
        }
        worktime [] arr = new worktime [workcount];
        int k = 0;
        while(!heap.isEmpty()){
            arr[k++] = heap.poll();
        }

        int [][] depend = new int [dependency][2];
        for(int i = 0; i < dependency;i++){
            depend[i][0] = scan.nextInt();
            depend[i][1] = scan.nextInt();
        }
        for(int i = 0; i < arr.length;i++){
            int no1 = depend[i][0];
            int no2 = depend[i][1];
            int [] res = isBehind(arr,no1-1,no2-1);
            if(res[0] > res[1])
                swap(arr,res[0],res[1]);

        }
        String  result = "";
        for(int i = 0 ; i < arr.length;i++){
            result+= (arr[i].no+1)+" ";
        }
        System.out.println(result);
    }
    public static  void swap (worktime [] arr,int w1,int w2){
        worktime temp = arr[w1];
        arr[w1] = arr[w2];
        arr[w2] = temp;

    }
    public static int [] isBehind(worktime [] arr,int no1,int no2){
        int pos1 = -1;
        int pos2  =-1;
        for(int i = 0;  i < arr.length;i++){
            if(arr[i].no == no1){
                pos1 = i;
            }
            if(arr[i].no == no2){
                pos2 = i;
            }
        }
        int[] res = new int[2];
        res[0] = pos1;
        res[1] = pos2;
        return res;
    }


}
