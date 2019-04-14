package JUC.J02_synchronize.Synchronized;

/*************************************************************************
 * 双重检测：使用同步方法时，效率较低，可以使用同步块，但是会引入风险，所以需要双重检测;
 *  要分析同步块的范围，既要保证正确，也要保证效率
 *************************************************************************/
//账户类
class Account2 {
    int money;      //账户的钱
    String name;    //账户名

    public Account2(int money, String name) {
        this.money = money;
        this.name = name;
    }

}

//取款人员类
class Drawer2 extends Thread{
    Account2 account;
    int drawing;
    int packTotal;
    public Drawer2(Account2 account,int drawMoney,String name) {
        super(name);
        this.account = account;
        this.drawing = drawMoney;
    }

    public void test1(){
        //不论account.money - drawing 是否小于0，所有线程到要在此处等待,效率低下
        synchronized (account){
            if (account.money - drawing < 0){
                System.out.println("账户余额为:" + account.money);
                System.out.println(this.getName() + "要取金额为："+drawing+",还需存款为:" +(drawing-account.money));
                return ;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawing;
            packTotal += drawing;
            System.out.println("账户余额为:" + account.money);
            System.out.println(this.getName() + "要取金额为："+drawing+",口袋总额为:" + packTotal);

        }
    }

    public void test2(){

        //account.money - drawing < 0之后的一部分进程在此处直接返回；
        if (account.money - drawing < 0){
            System.out.println("账户余额为:" + account.money+","+this.getName() + ",要取金额为："+drawing+",还需存款为:" +(drawing-account.money));
            return ;
        }
        //开始时的一部分进程可以到达此处,随着其他线程的执行，资源情况发生变动，
        // 所以这部分进程可能出错，也可能不出错
        synchronized (account){
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("账户余额为:" + account.money);
            account.money -= drawing;
            packTotal += drawing;

            System.out.println(this.getName() + ",要取金额为："+drawing+",口袋总额为:" + packTotal);
            System.out.println("账户余额为:" + account.money);
            System.out.println("=================================");
        }
    }
    //双重检测，粒度更小，同时更安全
    public void test3(){

        //处理没有票的情况（线程到达时已经没有资源了）
        if (account.money - drawing < 0){
            System.out.println("账户余额为:" + account.money+","+this.getName() +
                    ",要取金额为："+drawing+",还需存款为:" +(drawing-account.money)+"-->1stReturn");
            return ;
        }
        //开始阶段的线程都可以到达此处，但是随着一部分的线程执行，资源情况发生变化，所以需要二次检测
        //线程到达时还有资源，但是随着其他线程的执行，资源变动，需要二次检测
        synchronized (account) {
            //处理最后一张票
            if (account.money - drawing < 0) {
                System.out.println("账户余额为:" + account.money + "," + this.getName() +
                        ",要取金额为：" + drawing + ",还需存款为:" + (drawing - account.money)+"-->2ndReturn");
                return;
            }

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("账户余额为:" + account.money);
            account.money -= drawing;
            packTotal += drawing;

            System.out.println(this.getName() + ",要取金额为：" + drawing + ",口袋总额为:" + packTotal);
            System.out.println("账户余额为:" + account.money);
            System.out.println("=================================");
        }
    }
    public void run() {

       test3();

    }
}

public class synchronizedBlock2{

    public static void main(String [] args){
        Account2 account = new Account2(160,"ICBC");

        int i = 0;
        while(i < 100){
            new Drawer2(account,80,"Thread-"+i).start();
            i++;
        }

    }

}
