import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val){
        data = val;
        left = null;
        right = null;
    }
}

public class inordertraversal {
    
    static void inorder(Node root, List<Integer> arr){

        if (root == null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }


    static List<Integer> inOrder(Node root){
        List<Integer> arr = new ArrayList<>();

        inorder(root, arr);

        return arr;
    }

    public static void main(String[] args){
         Node root = new Node(1);
        root.left = new Node (2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result =  inOrder(root);

        for (int val : result)
{
    System.out.println(val);
}
    }
}
