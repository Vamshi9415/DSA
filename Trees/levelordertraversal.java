import java.util.*;
class Node{
    int data;
    Node left;
    Node right;

    Node(){
        this.data = 0;
        this.left = null;
        this.right = null;
    }
    
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

     Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
}

public class levelordertraversal {
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> level = new ArrayList<>();

            for(int i=0;i<size;i++){
                Node node = q.poll();

                level.add(node.data);

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }

            }
            ans.add(level);
        }
        return ans;
    }

    static void printList(List<Integer> list){
        for(int num : list){
         System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<List<Integer>> result = levelOrder(root);

        for(List<Integer> list : result){
            printList(list);
        }
    }
}
