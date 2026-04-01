import java.util.*;

// Producer-Consumer Problem

 class SharedBuffer {
    Queue<Integer> q = new LinkedList<>();

    int capacity;

    SharedBuffer(int capacity){
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException{

        while(capacity == q.size()){
            wait();
        }
        q.offer(value);
        System.out.println("Produced "+value);

        notifyAll();
    }
    
    public synchronized void consume() throws InterruptedException {
        while(q.isEmpty()){
            System.out.println("Buffer is empty .. Consumer is Waiting");
            wait();
        }

        int value = q.poll();

        System.out.println("Consumed "+value);

        notifyAll();
    }
    
}

public class ProducerProb {
    public static void main(String[] args) {
        SharedBuffer buf = new SharedBuffer(2);

        Thread producer = new Thread(() -> {
            for(int i=0;i<5;i++){
                try{
                    buf.produce(i);
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        );

        Thread consumer = new Thread(
            () -> {
                for (int i=0;i<5;i++){
                    try{
                        buf.consume();
                        Thread.sleep(500);
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        );

        producer.start();
        consumer.start();
        
    }
}
