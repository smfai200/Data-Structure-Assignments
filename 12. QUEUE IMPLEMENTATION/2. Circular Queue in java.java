package javaapplication38;

import java.util.Scanner;

public class JavaApplication38 {
    
    static int front;
    int rear;
    int front1[] = new int [5];
    int que[];
    static Scanner input = new Scanner(System.in);
    
    JavaApplication38(){
        front=rear=-1;
        que = new int[100];
    }
    
    public static void main(String[] args) {
       JavaApplication38 obj = new JavaApplication38();
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
                break;
            }
    
      switch(choice){
          case 1:
              obj.insert_Q();
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
        
        if((front==0 && rear >=4) || (front==rear+1)){
            System.out.println("|$| => Queue is Overflow!");
        }else{
            if(rear >= 4){
                rear = 0;
                System.out.println("Enter Ticket Number: ");
                que[rear] = input.nextInt();
            }else{
                rear++;
                System.out.println("Enter Ticket Number: ");
                que[rear] = input.nextInt();
                if(front < 0)
                     front = 0;
            }

        }
        System.out.println("Front: " + front);
        System.out.println("Rear: " + rear);
    }
    
    private void delete_Q(){
            if(front<0){
                System.out.println("|$| => Queue Underflow!");
            }else{
                if(front >= 4){
                    System.out.println(que[front]);
                    front = 0;
                }else{
                    if(front == rear){
                        front = rear = -1;
                    }else{
                        System.out.println(que[front]);
                        front1[front] = front;
                        front++;
                }
            }
            }
        System.out.println("Front: " + front);
        System.out.println("Rear: " + rear);
    }
    
    
}
