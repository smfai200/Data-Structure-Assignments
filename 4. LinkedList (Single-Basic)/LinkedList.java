package linkedlist;
import java.util.Scanner;

public class LinkedList {

    public static void main(String[] args) {
        Node first = null;
        Node pre = null;
        Node cur = null;
        Scanner input = new Scanner(System.in);
        char ch = 'y';
        int i =0;

        while(i<5){
            cur = new Node();
            cur.next = null;
            cur.data = (int) (10+Math.random()*100);
            if(first == null){
                first = pre = cur;
            }else{
                pre.next = cur;
                pre = cur;
            }
  			i++;
        }

        System.out.println("The Resulting Is: ");
        cur = first;
        while(cur != null){
            System.out.println(cur.data + " ");
            cur = cur.next;
        }

    }

}
