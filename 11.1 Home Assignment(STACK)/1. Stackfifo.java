package stackfifo;
import java.util.Scanner;

public class Stackfifo {
    
    static int stack[];
    int top = 0,top1 = 0,top2 = 0;
    static int stack1[];
    static int stack2[];
    static Scanner input = new Scanner(System.in);
    static Stackfifo obj = new Stackfifo();
    
    public static void main(String[] args) {
        System.out.println("Enter Range of Stack1 AND Stack2: ");
        int size = input.nextInt();
        stack1 = new int[size];
        stack2 = new int[size];
        stack = new int[(size*2)];
        obj.push();
        obj.pop();
    }
    
    public void push(){
        if(top >= stack.length){
            System.out.println("Stack Overflow");
        }else
          while(top < stack.length){
            if(top >= (stack.length/2)){
                System.out.println("Enter Data for Stack2: ");
                stack2[top2] = input.nextInt();
                top2++;
            }else{
                System.out.println("Enter Data for Stack1: ");
                stack1[top1] = input.nextInt();      
                top1++;
            }
            top++;
        }
        obj.twoinone();
    }
    
    public void twoinone(){
        top = 0;
        while(top < stack.length){
            if(top >= (stack.length/2)){
                top2--;
                stack[top] = stack2[top2];
                
            }else{
                top1--;
                stack[top] = stack1[top1];
            }
            top++;
        }
    }
    
    public void pop(){
        while(top>=0){
            if(top == 0){
                System.out.println("Stack UnderFlow");
                break;
            }else{
                top--;
                System.out.println(stack[top]);
            }
        }
    }
    
}
