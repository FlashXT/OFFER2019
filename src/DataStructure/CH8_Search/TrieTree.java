package DataStructure.CH8_Search;

/********************************************************
 * 前缀树：单词查找树，句子查找树
 ********************************************************/
class Node{

    public int prefix; //该结点是多少个字符串的前缀
    public int tail;   //该结点是多少个字符串的结尾
    public Node[] postfix;
    public Node(){
        this.prefix = 0;
        this.tail = 0;
        //26个字母
        this.postfix = new Node[26];
    }

}

public class TrieTree {
    public static Node root = new Node();
    public static void main(String [] args){
        String str = "abcd",str2="abe",str3="bcd";
        insert(str);
        insert(str2);
        insert(str3);
        System.out.println(search(str3));
        delete(str3);
        System.out.println(search(str3));
        System.out.println(search(str));
        System.out.println(prefixNumber("abcde"));
    }
    //添加字符串
    public static void insert(String str){
        int post=0;
        Node ptr = root;
        char[] chars = str.toCharArray();
        for(int i =0;i<chars.length;i++){
            post = chars[i]-'a';
            if(ptr.postfix[post] == null)
                ptr.postfix[post]=new Node();
            ptr.postfix[post].prefix+=1;
            ptr = ptr.postfix[post];
        }
        ptr.tail+=1;

    }
    //删除字符串str
    public static void delete(String str){
        if(!search(str))
            return ;
        else{
            int post=0;
            Node ptr = root;
            char[] chars = str.toCharArray();
            for(int i =0;i<chars.length;i++){
                post = chars[i]-'a';
                if(ptr.postfix[post].prefix == 1){
                    ptr.postfix[post]=null;
                    return ;
                }
                ptr.postfix[post].prefix-=1;
                ptr = ptr.postfix[post];
            }
            ptr.tail-=1;
        }


    }
    //查找字符串str是否存在
    public static boolean search(String str){
        int post=0;
        Node ptr = root;
        char[] chars = str.toCharArray();
        int i = 0;
        while(i < chars.length){
            post = chars[i]-'a';
            if(ptr.postfix[post] != null){
                ptr = ptr.postfix[post];
            }
            else {
                return false;
            }
            i++;
        }
        return ptr.tail!=0;

    }
    //判断str作为前缀出现了多少次
    public static int prefixNumber(String str) {
        if (str == null) {
            return 0;
        }
        char[] chs = str.toCharArray();
        Node ptr = root;
        int post = 0;
        for (int i = 0; i < chs.length; i++) {
            post= chs[i] - 'a';
            if (ptr.postfix[post] == null) {
                return 0;
            }
            ptr =ptr.postfix[post];
        }
        return ptr.prefix;
    }
}
