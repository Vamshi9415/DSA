import java.util.*;  
public class queue {
    public static void main(String[] args) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.offer(2);

        System.out.println(q.peek());

        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(20);
        pq.offer(10);

        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
        System.out.println();

        Deque<Integer> ad = new ArrayDeque<>();

        ad.offerFirst(1);
        ad.offerLast(2);
        System.out.println(ad.peekFirst());
        System.out.println(ad.peekLast());
        
    }
}
