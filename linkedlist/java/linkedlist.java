import java.io.*;

public class linkedlist{

    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
        }
    }

    public static linkedlist insert(linkedlist list,int data){
        Node node = new Node(data);

        if(list.head == null){
            list.head = node;
        }else{
            Node temp = list.head ;

            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
        return list;
    }

    public static void printList(linkedlist list){
        Node temp = list.head;
        while(temp != null){
            System.out.println("data : "+temp.data);
            temp = temp.next;
        }
    }

    public static linkedlist delete(linkedlist list, int key){
        Node temp = list.head;
        Node prev = null;

        if(temp!=null && temp.data == key){
            
            list.head = temp.next;
            return list;  
        }
            while(temp != null && temp.data != key){

                prev = temp;
                temp = temp.next;
            }
            if(temp == null){
               return list;}
            prev.next = temp.next;   
        

        return list;
    }

    public static linkedlist reverse(linkedlist list){
        Node prev, current, nex;
        prev = null;
        current = list.head;

        while(current != null){
            nex = current.next;
            current.next = prev;
            prev = current;
            current = nex;
        }

        list.head = prev;
        return list;
    }

    public static void main(String[] args){

        linkedlist var = new linkedlist();

        var= insert(var,2);
        var= insert(var,4);
        var= insert(var,6);
        var= insert(var,8);
        var = delete(var, 4);
        var= insert(var,2);
        var= insert(var,4);
        var= insert(var,6);
        var= insert(var,8);

        printList(var);
        System.out.println("reverse of the list follows");

        var = reverse(var);

        printList(var);

    }
}