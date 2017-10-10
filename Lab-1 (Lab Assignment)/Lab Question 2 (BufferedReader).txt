package javaapplication2;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaApplication2 {
    
    public static void main(String[] args) {
        try{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in) {});
        int first,second,result,choice;
        //INPUT FROM USER
        System.out.println("Enter first Number: ");
        first = Integer.parseInt(input.readLine());
        System.out.println("Enter second Number: ");
        second = Integer.parseInt(input.readLine());
        
        //CHOICE SELECTION
        System.out.println("1. Addition (+).\n" +
                           "2. Subtraction (-).\n" +
                           "3. Multiplication (*).\n" +
                           "4. Division (/).");
        System.out.println("Enter Operation Number: ");
        choice = Integer.parseInt(input.readLine());
        
        switch(choice){
            case 1:
                result = first+second;
                System.out.println("The Result is " + result);
                break;
            case 2:
                result = first-second;
                System.out.println("The Result is " + result);
                break;
            case 3:
                result = first*second;
                System.out.println("The Result is " + result);
                break;
            case 4:
                result = first/second;
                System.out.println("The Result is " + result);
                break;
            default:
                System.out.println("You have Entered a Wrong Option!");
                break;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
}
