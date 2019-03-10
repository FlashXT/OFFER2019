package SortAlgorithm;

public class Test {

    public static Test t1 = new Test();

    static {System.out.println("blockB静态块");}
    {System.out.println("blockA构造块");}

    public static void main(String[] args){
        Test t2;
        t2 = new Test();
    }
}
