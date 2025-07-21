import java.util.ArrayList;
import java.util.List;

class Node{
    int data;
    Node left;
    Node right;

    Node (int val){
        data = val;
        left = null;
        right = null;
    }
}
public class postordertraversal {

    static void postorder(Node root, List<Integer> arr){
        if (root == null){
            return;
        }

        postorder(root.left, arr);
        postorder(root.right, arr);
        arr.add(root.data);
    }

    static List<Integer> postOrder(Node root){
        List<Integer> arr = new ArrayList<>();

        postorder(root,arr);

        return arr;
    }

    public static void main (String[] args){
        Node root = new Node(1);
        root.left = new Node (2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result =  postOrder(root);

        for (int val : result)
{
    System.out.println(val);
}
       
    }
    
}
