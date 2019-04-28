package TencentOffer.CH2;

public class Singleton {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
        test5();

    }

    public static void test1() {
        int i = 0;
        while(i++ < 10){
            new Thread(()->{
                System.out.println(Singleton1.getInstance());
            }).start();
        }
    }
    public static void test2() {
        int i = 0;
        while(i++ < 10){
            new Thread(()->{
                System.out.println(Singleton2.getInstance());
            }).start();
        }
    }
    public static void test3() {
        int i = 0;
        while(i++ < 10){
            new Thread(()->{
                System.out.println(Singleton3.getInstance());
            }).start();
        }
    }
    public static void test4() {
        int i = 0;
        while(i++ < 10){
            new Thread(()->{
                System.out.println(Singleton4.getInstance());
            }).start();
        }
    }
    public static void test5() {
        int i = 0;
        while(i++ < 10){
            new Thread(()->{
                System.out.println(Singleton5.getInstance());
            }).start();
        }
    }
}
//单线程，多线程出错
class Singleton1 {
    private static Singleton1 instance = null;
    public Singleton1 (){
    }
    public static Singleton1 getInstance (){
        if(instance == null)
            instance = new Singleton1();
        return instance;
    }
}

//synchronized多线程，效率低下
class Singleton2 {
    private static Singleton2 instance = null;
    public Singleton2 (){
    }
    public static synchronized Singleton2 getInstance (){
        if(instance == null)
            instance = new Singleton2();
        return instance;
    }
}

//懒汉式，synchronized多线程，减小粒度，双重检测
class Singleton3 {
    private static Singleton3 instance = null;
    public Singleton3 (){
    }
    public static Singleton3 getInstance (){
        if(instance == null){
            synchronized(Singleton3.class){
                if(instance == null )
                  instance = new Singleton3();
            }
        }

        return instance;
    }
}
//饿汉式
class Singleton4 {
    private static final Singleton4 instance = new Singleton4();
    public  Singleton4 (){  }
    public static Singleton4 getInstance(){

        return instance;
    }
}
//静态内部类,按需创建对象
class Singleton5 {

    public  Singleton5 (){  }
    public static Singleton5 getInstance(){

        return Instance.instance;
    }
    private static class Instance{
        private static Singleton5 instance = new Singleton5();
    }

}