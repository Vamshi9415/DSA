import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node (int val){
        this.val = val;
        left = null;
        right=null;
    }
}

public class zigzagorder{

    public List<List<Integer>> zigzag(Node root){
         List<List<Integer>> arr = new ArrayList<>();


         if(root == null){
            return arr;
         }
         Queue<Node> q = new LinkedList<>();

         q.add(root);

         boolean toggle = true;
         while(!q.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();

            int size = q.size();

            for(int i=0;i<size;i++){
                Node node = q.poll();

                if(!toggle){
                    level.addFirst(node.val);
                }else{
                    level.addLast(node.val);
                }

                if(node.left!=null){
                    q.add(node.left);
                }
                 if(node.right!=null){
                    q.add(node.right);
                }
                

            }
            toggle = !toggle;
            arr.add(level);

         }
         return arr;
    }
    public static void main(String[] args) {
        /*
         * 
         *          1
                 /     \
               2         3
            /    \    /    \
          4       5  6      7
        /  \    /  \ /  \  /  \
       8    9  10 11 12 13 14 15


       result :
[1]
[3, 2]
[4, 5, 6, 7]
[15, 14, 13, 12, 11, 10, 9, 8]
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        zigzagorder zz = new zigzagorder();
        List<List<Integer>> result = zz.zigzag(root);

        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}