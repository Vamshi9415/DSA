import java.lang.Thread;
import java.util.*;
// creating thread with extends Thread class

class Mythread extends Thread {
    int time ;
    Mythread(int time){
        this.time = time;
    }
    public void run(){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread is running " + time);
    }
    public static void main(String[] args) {
        Mythread t1 = new Mythread(1000);
        Mythread t2 = new Mythread(200);
        t1.start();
        t2.start();
// t1.start() is called. t1 begins running, hits Thread.sleep(1000), and goes to sleep (TIMED_WAITING).

// Almost instantly after, t2.start() is called. t2 begins running, hits Thread.sleep(200), and goes to sleep (TIMED_WAITING).

// 200 milliseconds later: t2's timer expires. It wakes up (moves back to RUNNABLE), executes the System.out.println, prints "Thread is running 200", and terminates.

// 800 milliseconds later (1000ms total): t1's timer finally expires. It wakes up, executes its System.out.println, prints "Thread is running 1000", and terminates.
}
}
// Thread does NOT release locks: This is the most critical difference between sleep() and wait(). If a thread goes to sleep while inside a synchronized block or method,
//  it keeps the lock. No other thread can enter that synchronized block until the sleeping thread wakes up and finishes its work.
  
class newThread extends Thread {
    int time;
    newThread(int time ){
        this.time = time;
    }
    public synchronized void run(){
        try{
            Thread.sleep(time);
        }
        catch(Exception e){
            e.printStackTrace();

        }
        System.out.println(time);
    }

    public static void main(String[] args) {
        newThread t1 = new newThread(1000);
        newThread t2 = new newThread(200);

        t1.start();
        t2.start();
        // Because they are using two completely different locks, they do not block each other.
        //  They run concurrently. t2 finishes its 200ms sleep first, prints 200, and terminates. Then, 800ms later, t1 finishes its sleep and prints 1000.
    }
}

// so untill now we were not seeing any threads using sleep has we were creating the objects of them and they run concurrently this is like two objects
// so we want one object, multiple threads 
// we use Runnable

class Task implements Runnable {
    int time;

    Task(int time){
        this.time = time;
    }

    public synchronized void run(){
        System.out.println("Got Lock " + Thread.currentThread().getName());

        try {
            Thread.sleep(time);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Lock Released " + Thread.currentThread().getName());

    }

    public static void main(String[] args){
        Task obj1 = new Task(1000);

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj1);

        t1.start();
        t2.start();
    }

// Use Runnable instead of extending Thread because it gives better design and flexibility. With Runnable, you separate the task (what to run) 
// from the thread (who runs it), so the same task can be executed by multiple threads or reused in thread pools. Java also supports only single inheritance, 
// so if you extend Thread, you can’t extend any other class—but with Runnable, your class can still extend something else. It also makes sharing the same object 
// across threads easier, 
// which is important for synchronization problems. Overall, Runnable is more modular, reusable, and preferred in real-world and interview scenarios.
}


