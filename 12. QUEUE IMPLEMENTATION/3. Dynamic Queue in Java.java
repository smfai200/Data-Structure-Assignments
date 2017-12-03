package javaapplication39;

import java.util.Scanner;

class Node{
    Node next;
    int data;
}

public class JavaApplication39 {
    
    Node pre;
    Node temp;
    Node rear;
    Node front = null;
    static Scanner input = new Scanner(System.in);
    int flag = 0;
    
    public static void main(String[] args) {
        JavaApplication39 obj = new JavaApplication39();
        boolean flag = true;
       int choice = 0;
    while(flag){
        
        try{
             System.out.println("===> MENU <==="
                + "\n 1. Insertion to Que"
                + "\n 2. Deletion From Que"
                + "\n 3. Display"
                + "\n 4. Exit");
             choice = input.nextInt();
             }catch(Exception e){
                System.out.println("|$| => The Input requires an Integer Only!");
                input.nextLine();
                continue;
            }
      switch(choice){
          case 1:
              obj.insert();
              break;
          case 2:
              obj.delete();
              break;
          case 3:
              obj.display();
              break;
          case 4:
              flag = false;
              break;
          default:
              System.out.println("|#| ==> INCORRECT OPTION SELECTED!");
      }
    }
    }
    
    public void insert(){
        rear = new Node();
        System.out.println("Enter Data: ");
        rear.data = input.nextInt();
        rear.next = null;
        if(front == null || flag == 1){
            pre = null;
            front = pre = rear;
            flag = 0;
        }else{
                pre.next = rear;
                pre = rear;
        }
    }
    
    public void delete(){
        temp = front;
      while(temp!= null){
        System.out.println("Data is: " + temp.data);
        pre = temp;
        temp = temp.next;
        pre.next = null;
      }
      pre = front;
      flag = 1;
    }
    
    public void display(){
        temp = front;
      while(temp!= null){
        System.out.println("Data is: " + temp.data);
        temp = temp.next;
      }
    }
    
}
