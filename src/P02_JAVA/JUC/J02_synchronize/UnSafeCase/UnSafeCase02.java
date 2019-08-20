package P02_JAVA.JUC.J02_synchronize.UnSafeCase;

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
        while (true) {
            if (account.money - drawing <= 0)
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.money -= drawing;
            packTotal += drawing;
            System.out.println(this.getName() + "账户余额为:" + account.money);
            System.out.println(this.getName() + "口袋总额为:" + packTotal);

        }

    }
}
public class UnSafeCase02{

    public static void main(String [] args){
        Account account = new Account(100,"ICBC");

        Drawer d1 = new Drawer(account,80,"FalshXT");
        Drawer d2 = new Drawer(account,40,"turboMan");
        d1.start();
        d2.start();
    }

}
