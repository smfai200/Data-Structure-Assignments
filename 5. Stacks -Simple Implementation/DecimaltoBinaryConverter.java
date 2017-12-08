package decimaltobinary;

import java.util.Scanner;

public class DecimaltoBinary {
    static Scanner input = new Scanner(System.in);
    int stack[] = new int[100];
    int top = -1;
    public static void main(String[] args) {
        DecimaltoBinary obj = new DecimaltoBinary();
        System.out.println("Enter the Decimal Number: ");
        int num = input.nextInt();
        int mod;
        int result = num;
        while(result >=1){
            mod = result%2;
            result = result/2;
            obj.push(mod);
        }
        obj.pop();
    }
    
    public void push(int num){
        if(top >= 20){
            System.out.println("Stack Overflow");
        }else{
            top++;
            stack[top] = num;
        }
    }
    
    public void pop(){
        System.out.println("Binary for the Decimal is: ");
     while(top>=0){
        if(top < 0){
            System.out.println("Stack Underflow!");
            break;
        }else{
            System.out.print(stack[top] + " ");
            top--;
        }
     }
    }
}
