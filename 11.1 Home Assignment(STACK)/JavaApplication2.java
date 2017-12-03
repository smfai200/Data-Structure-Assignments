package javaapplication2;
import java.util.Scanner;

public class JavaApplication2 {
    static int stack[];
    int top = -1;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int a = in.nextInt();
        String b = Integer.toString(a); //CONVERTING TO STRING
        stack = new int[b.length()]; //INITIALIZING STACK
        JavaApplication2 obj = new JavaApplication2();
        obj.push(b);
        obj.pop();
    }
    
    public void push(String b){
        for(int i=(b.length()-1); i>=0; i--){
            top++;
            int d = Character.getNumericValue(b.charAt(i));
            stack[top] = d;
        }
    }
    
    public void pop(){
        int sum = 0;
        while(top>=0){
            sum += (stack[top]*stack[top]);
            top--;
        }
        System.out.println(sum);
    }
    
}
