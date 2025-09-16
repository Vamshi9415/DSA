import java.util.ArrayList;
import java.util.Scanner;

public class graphrepresentation{

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter number of nodes ");
        int n = scanner.nextInt();

        System.out.print("enter number of edges ");
        int m = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adjlist  = new ArrayList<>();

        for(int i=0;i<n+1;i++){
            adjlist.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<m;i++){
            System.out.print("Enter edge (u v) : ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }

        System.out.println("Adjacency List:");
        for(int i=1;i<=n;i++){
            System.out.print(i + ": ");
            for(int j : adjlist.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}