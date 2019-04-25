package Algorithm.Recursion;

public class StringFullPermutation {
    public static void main(String [] args){
        String str = "ABC";
        char [] ch = str.toCharArray();
        FullPermutation(ch,0);

    }
    public static void FullPermutation(char []ch, int pos){

        if(pos == ch.length){
            for(char item:ch)
                System.out.print(item+" ");
            System.out.println();
        }
        for(int i = pos; i < ch.length;i++){
            swap(ch,i,pos);                 //试探
            FullPermutation(ch,pos+1);
            swap(ch,i,pos);                 //回溯
        }

    }
    public static void swap(char [] ch,int p1,int p2){
        char temp = ch[p1];
        ch[p1] = ch[p2];
        ch[p2] = temp;
    }
}
