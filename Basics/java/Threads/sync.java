import java.util.*;
// Print numbers safely using synchronized block
public class sync implements Runnable{
    
    public synchronized void run(){
        for(int i=0;i<4;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        sync s = new sync();

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        t1.start();
        t2.start();
    }
}

// Bank account withdrawal problem

class Bank implements Runnable{

    int balance ;
    Bank(int balance){
        this.balance = balance;
    }

    synchronized void withdraw(){
balance = balance -10;
System.out.println("balance "+ balance);
    }

    public void run(){
        
withdraw();
        

    }

    public static void main(String[] args) {
        Bank b1 = new Bank(1000);
        
        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b1);
        t1.start();
        t2.start();
    }
}

// Counter increment with multiple threads

class Counter implements Runnable{
    static int count=0;

     synchronized void increment(){
        
        System.out.println("Count Before " + count);
        count++;
        
System.out.println("Count After " + count);
    }

    public void run(){
        for(int i = 0; i < 5; i++) {
        
        increment();

        }
    
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c1);

        t1.start();
        t2.start();

    }
}
