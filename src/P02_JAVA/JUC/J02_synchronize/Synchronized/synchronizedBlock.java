package P02_JAVA.JUC.J02_synchronize.Synchronized;

class web12306 implements Runnable{
    //票数
    private int ticketNums = 200;
    public void run(){
        synchronized (this){
         // ticketNums对象每次都在变，无法锁定，可以使用JUC包中的原子类型
//        synchronized((Integer)ticketNums){
            if(ticketNums <= 0){
                System.out.println(Thread.currentThread().getName()+":"+"Null");
                return ;
            }

            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+ticketNums--);
        }

    }
}
public class synchronizedBlock {

    public static void main(String [] args){
        //一份资源
        web12306 web = new web12306();

        //多个代理
        int i =0;
        while(i < 300){
            new Thread(web,"Thread-"+i).start();
            i++;
        }
    }

}
