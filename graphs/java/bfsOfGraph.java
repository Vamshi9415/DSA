import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bfsOfGraph {
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean visited[] = new boolean[V];

      List<Integer> bfs = new ArrayList<Integer>();

      Queue<Integer> q = new LinkedList<Integer>();

      q.add(0);
      visited[0]=true;

      while(!q.isEmpty()){
        Integer node = q.poll();

        bfs.add(node);

        for(Integer it : adj.get(node)){
          if(visited[it] == false){
            visited[it] = true;
            q.add(it);
          }
        }
      }
      return bfs;
    }
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);

        bfsOfGraph obj = new bfsOfGraph();
        List<Integer> result = obj.bfsOfGraph(V, adj);
        System.out.println(result);
    }
}
