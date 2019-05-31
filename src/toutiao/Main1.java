package toutiao;

import java.util.Scanner;


public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(getStr(str));
    }

    static int t = -1;

    static String getStr(String str){
        String curr = "";
        int last = -1;
        int count = 0;
        String next = "";
        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i) == '%'){
                String num = "";
                for(int j = i-1; j >=0; j--){
                    if(str.charAt(j) <= '9' && str.charAt(j) >= '0'){
                        num += str.charAt(j);
                    }else{
                        break;
                    }
                }
                count = Integer.parseInt(num);
                last = i+1;
                next = getStr(str.substring(last));
                for(int j = 0; j < count; j++){
                    curr += next;
                }
                i += t;
            }else if(str.charAt(i) == '#'){
                t = i+1;
                break;
            }else if((last == -1) && (str.charAt(i) > '9' || str.charAt(i) < '0')){
                curr += str.charAt(i);
            }
        }
        return curr;
    }

}
