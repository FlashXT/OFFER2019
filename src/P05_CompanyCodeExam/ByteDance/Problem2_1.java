package P05_CompanyCodeExam.ByteDance;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*****************************************************************
 * @Author:FlashXT;
 * @Date:2019/5/25 9:35;
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class Problem2_1 {
    static class indexPair {
        int row;
        int col;

        public indexPair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int [] [] arr = new int[1][1];
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr = new int[a][b];
            for (int i = 0; i < arr.length; i++){
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            break;
        }
        HashSet<HashSet<indexPair>> res = new HashSet<HashSet<indexPair>>();
        for (int i = 0; i <arr.length;i++ ) {

            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1){
                    if( isInSet(res,i,j)!= null){

                        isInSet(res,i,j).addAll(findOne(arr,i,j));
                    }
                    else{
                        HashSet<indexPair> temp = new HashSet<indexPair>();
                        temp.add(new indexPair(i,j));
                        temp.addAll(findOne(arr,i,j));
                        res.add(new HashSet<indexPair>((HashSet<indexPair>)temp.clone()));
                    }

                }
            }
        }
        System.out.println(res.size());


    }
    public static HashSet<indexPair> findOne(int[][] arr,int row,int col){
        HashSet<indexPair> res = new HashSet<>();
        if(row-1>= 0 && col-1>= 0 && arr[row-1][col-1] == 1)
            res.add(new indexPair(row-1,col-1));
        if(row-1>= 0 && col>= 0 && arr[row-1][col] == 1)
            res.add(new indexPair(row-1,col));
        if(row-1>= 0 && col+1 < arr[row-1].length && arr[row-1][col+1] == 1)
            res.add(new indexPair(row-1,col+1));
        if( col-1>= 0 && arr[row][col-1] == 1)
            res.add(new indexPair(row,col-1));
        if( col+1< arr[row].length&& arr[row][col+1] == 1)
            res.add(new indexPair(row,col+1));
        if(row+1< arr.length && col-1>= 0 && arr[row+1][col-1] == 1)
            res.add(new indexPair(row+1,col-1));
        if(row+1< arr.length && arr[row+1][col] == 1)
            res.add(new indexPair(row+1,col));
        if(row+1< arr.length && col+1< arr[row].length && arr[row+1][col+1] == 1)
            res.add(new indexPair(row+1,col+1));

        return res;
    }
    public static HashSet<indexPair> isInSet(HashSet<HashSet<indexPair>> set,int row,int col){
        Iterator<HashSet<indexPair>> iter = set.iterator();

        while(iter.hasNext()){
            HashSet<indexPair> res= iter.next();
            Iterator<indexPair> temp = res.iterator();
            while(temp.hasNext()){
                indexPair ip = temp.next();
                if(ip.row == row && ip.col == col)
                    return res;
            }
        }
        return null;
    }
}
