package JUC.J09_Others;

/***********************************************************************
 * volatile用于保证数据的同步，也就是可见性：
 *   一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就
 *具备了两层语义：
 *  1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这
 *     新值对其他线程来说是立即可见的,使用volatile关键字会强制将修改的值立即写入主存；
 *  2）volatile只能保证每次读取的是最新的值，但是volatile没办法保证对变量的操作的
 *    原子性。
 *  3）禁止进行指令重排序。
 *
 *https://www.cnblogs.com/dolphin0520/p/3920373.html
 ***********************************************************************/
public class testvolitale {
    public volatile static int inc = 0;

    public static void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {

        for(int i=0;i<100;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<10;j++)
                         increase();
                };
            }.start();
        }
        Thread.sleep(1000);
        System.out.println(inc);
    }
}
