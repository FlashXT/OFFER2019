package P02_JAVA.JUC.J02_synchronize.SafeCase;

import java.util.HashSet;
import java.util.Set;

class Theatre {
    static int nums;
    String name;
    Set<Integer> seats;
    public Theatre(Set<Integer> seats,String name){
        this.seats = seats;
        this.name = name;
        this.nums = 0;
    }
    public boolean bookTickets(Set<Integer> seats){
        Set<Integer> temp = new HashSet<>(this.seats);
        temp.removeAll(seats);
        if(this.seats.size() - temp.size() == seats.size()){
            this.seats = temp;
            nums+=seats.size();
            return true;
        }
        return false;
    }
}
class Person implements Runnable{
    Theatre theatre;
    String name;
    Set<Integer> seats;
    public Person(Theatre theatre,String name,Set<Integer> seats){
        this.name = name;
        this.theatre = theatre;
        this.seats = seats;
    }
    public void run(){
        synchronized (theatre){
//        try{
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        boolean bool = theatre.bookTickets(this.seats);
            if(bool){
                System.out.println(this.name+",购票成功!您的位置为："+seats);
            }
            else{
                System.out.println(this.name+",购票失败!");
            }
        }
    }

}
public class MovieTheatre {
    public static void main(String [] args){
        Set<Integer> thseats = new HashSet<>();
        thseats.add(1);
        thseats.add(2);
        thseats.add(4);
        thseats.add(6);
        thseats.add(7);
        thseats.add(8);
        Theatre th = new Theatre(thseats,"幸福之家影院");

        Set<Integer> p1seats = new HashSet<>();
        p1seats.add(1);
        p1seats.add(2);
        p1seats.add(4);
        Person p1 = new Person(th,"FlashXT",p1seats);

        Set<Integer> p2seats = new HashSet<>();
        p2seats.add(1);
        p2seats.add(2);
        p2seats.add(4);
        Person p2 = new Person(th,"W",p2seats);

        new Thread(p1).start();
        new Thread(p2).start();
    }


}
