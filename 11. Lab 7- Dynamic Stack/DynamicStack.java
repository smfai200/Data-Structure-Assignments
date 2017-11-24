package dynamicstack;

import java.util.Scanner;

public class DynamicStack {
    List stack;
    List top = null;
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        DynamicStack obj = new DynamicStack();
        obj.push();
        obj.pop();
    }
    
    public void push(){
        char ch = 'y';
        while(ch == 'y'){
            stack = new List();
            stack.next = null;
            stack.data = input.nextInt();
            if(top==null)
                top = stack;
            else{
                stack.next = top;
                top = stack;
            }
            System.out.println("Do You want to Add More Node: ");
            ch = input.next().charAt(0);
        }
    }
    
    public void pop(){
        while(top != null){
            System.out.println("Data is: " + top.data);
            top = top.next;
        }
    }
}
