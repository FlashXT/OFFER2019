package P05_CompanyCodeExam.PinDuoDuo.Problem4;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/9/1,15:17
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
/*
   Test Case:
   intput:555503,772867,756893,339138,399447,40662,859037,628085,855723,974471,599631,636153,581541,174761,948135,411485,554033,858627,402833,546467,574367,360461,566480,755523,222921,164287,420256,40043,977167,543295,944841,917125,331763,188173,353275,175757,950417,284578,617621,546561,913416,258741,260569,630583,252845;10
   output:913416,566480,420256,339138,284578,40662,977167,974471,950417,948135
*/
 public class Main4 {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String [] strarr = str.split(";");
        int n = Integer.valueOf(strarr[1]);
        String [] arr = strarr[0].split(",");
        ArrayList<Long> temp1 = new ArrayList<>();
        ArrayList<Long> temp2 = new ArrayList<>();
        for(int i = 0; i < arr.length;i++){
            Long num = Long.valueOf(arr[i]);
            if(num%2==0)
                temp1.add(num);
            else
                temp2.add(num);
        }
        Comparator<Long> com = new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if(o1 > o2)
                    return -1;
               else
                   return 1;
            }
        };
        Collections.sort(temp1,com);
        Collections.sort(temp2,com);
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < n){
            if(i < temp1.size())
                res.append(temp1.get(i)+",");
            else
                res.append(temp2.get(i-temp1.size())+",");
            i++;
        }

        System.out.println(res.substring(0,res.length()-1));
    }
}
