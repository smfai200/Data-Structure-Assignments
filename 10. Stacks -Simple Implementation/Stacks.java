package stacks;
import java.util.Scanner;

public class Stacks {
    static Scanner input = new Scanner(System.in);
    static String stack[] = new String[5];
    int top = 0;
    
    public static void main(String[] args) {
        boolean flag = true;
        Stacks obj = new Stacks();
        
    do{
        System.out.print("\t ==== MENU ==== \n 1. PUSH TO STACK\n 2. POP FROM STACK\n 3. Exit\n Enter Choice: ");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                obj.push();
                break;
            case 2:
                 obj.pop();
                break;
            case 3:
                flag = false;
                break;
            default:
                System.out.println("Invalid Option Selected!");
        }
    }while(flag);

    }
    
    public void push(){
        input.nextLine();
    while(top <= stack.length)   
       if(top < stack.length){
         String data;
         System.out.println("\n Enter a Name: ");
         data = input.nextLine();
         stack[top] = data;
         top++;
       }else{
           System.out.println("\n\t ==> The STACK IS OVERFLOW <==");
           break;
       }
    }
    
    public void pop(){
     while(stack.length >= 0)
        if(top == 0){
            System.out.println("\n\t ==> The Stack is UnderFlow <==");
            break;
        }else{
            top--;
            System.out.println("The Popped Data is: " + stack[top]);
        }
        
    }
    
    
    
}
