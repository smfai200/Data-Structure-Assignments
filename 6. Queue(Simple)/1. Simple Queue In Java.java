package javaapplication37;

import java.util.Scanner;

public class JavaApplication37 {
    
    static int front;
    int rear;
    int que[];
    static Scanner input = new Scanner(System.in);
    
    JavaApplication37(){
        front=rear=-1;
        que = new int[100];
    }
    
    public static void main(String[] args) {
       JavaApplication37 obj = new JavaApplication37();
       boolean flag = true;
       int choice = 0;
    while(flag){
        try{
             System.out.println("===> MENU <==="
                + "\n 1. Insertion to Que"
                + "\n 2. Deletion From Que"
                + "\n 3. Exit");
             choice = input.nextInt();
             }catch(Exception e){
                System.out.println("|$| => The Input requires an Int Only!");
                input.nextLine();
                continue;
            }
    
      switch(choice){
          case 1:
              obj.insert_Q();
              front=0;
              break;
          case 2:
              obj.delete_Q();
              break;
          case 3:
              flag = false;
              break;
      }
    }
  }
    private void insert_Q(){
      while(rear<=6)
        if(rear >=4){
            System.out.println("|$| => Queue is Overflow!");
            break;
        }else{
            rear++;
            System.out.println("Enter Ticket Number: ");
            que[rear] = input.nextInt();
        }
    }
    
    private void delete_Q(){
        while(front <= rear)
            if(front<0){
                System.out.println("|$| => Queue Underflow!");
                break;
            }else{
                System.out.println(que[front]);
                front++;
            }
        rear=-1;
    }
    
    
}
