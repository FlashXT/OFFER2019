package P05_CodeExam.C08_BiliBili;

import java.util.*;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/9/10 19:39
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
//BiliBili笔试第二题，（from_vedioid,to_vedioid）,统计点击量最多的vediod，点击量相等时，输出Id大的;
public class Main {
    static class Node{
        String val;
        int size;
        Node parent;
        public Node(String val){
            this.val =val;
            this.parent = this;
            this.size = 0;
        }
        public void findparent(){
            Node ptr = this;
            while(ptr.parent != ptr){
                ptr = ptr.parent;
                ptr.size++;
            }
        }

    }
    public static  void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Map<String,Node> map = new HashMap<>();
        for(int i = 0; i < n;i++){
            String temp1 = scan.next();
            String temp2 = scan.next();

            if(!map.containsKey(temp1) ){
                map.put(temp1,new Node(temp1));
            }
            if(!map.containsKey(temp2) ){
                map.put(temp2,new Node(temp2));
            }
            Node node1 = map.get(temp1);
            Node node2 = map.get(temp2);
            node2.parent = node1;
        }
        for(String key : map.keySet()){
            map.get(key).findparent();
        }


        String res = "";
        int times = 0;
        for(String key:map.keySet()){
            if(res == ""){
                res = key;
                times = map.get(key).size;
            }else{
                int time = map.get(key).size;
                if(time > times){
                    res = key;
                    times = time;
                }
                if(time == times){
                    if(key.compareTo(res) >0)
                        res = key;
                }
            }
        }
        System.out.println(res);

    }


}
