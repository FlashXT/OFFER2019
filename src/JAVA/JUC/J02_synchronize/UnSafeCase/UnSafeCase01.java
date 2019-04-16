package JAVA.JUC.J02_synchronize.UnSafeCase;

class web12306 implements Runnable{
    //票数
    private static int ticketNums = 100;
    public void run(){
        while(true){
            if(ticketNums <= 0)
                break;
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            ticketNums--;

            System.out.println(Thread.currentThread().getName()+":"+ticketNums);
        }


    }
}
public class UnSafeCase01 {

    public static void main(String [] args){
        //一份资源
        web12306 web = new web12306();

        //多个代理
        new Thread(web,"Thread-01").start();
        new Thread(web,"Thread-02").start();
        new Thread(web,"Thread-03").start();
    }

}
