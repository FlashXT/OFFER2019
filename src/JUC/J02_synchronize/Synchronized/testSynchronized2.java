package JUC.J02_synchronize.Synchronized;

/**********************************************************************************
 * synchronized 锁对象，所错对象没有效果；简单的锁定方法是不行的，要分析需要锁定的对象，然后加锁
 *
 */
//账户类
class Account {
    int money;      //账户的钱
    String name;    //账户名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

}
//取款人员类
class Drawer extends Thread{
    Account account;
    int drawing;
    int packTotal;
    public Drawer(Account account,int drawMoney,String name) {
        super(name);
        this.account = account;
        this.drawing = drawMoney;
    }

    public void run() {

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
}
public class testSynchronized2{

    public static void main(String [] args){
        Account account = new Account(100,"ICBC");

        Drawer d1 = new Drawer(account,80,"FalshXT");
        Drawer d2 = new Drawer(account,40,"turboMan");
        d1.start();
        d2.start();
    }

}
