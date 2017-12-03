package assignment2q2;
import java.util.Scanner;

public class FoodArray {
    char type;
    int id;
    FoodCodeType obj[] = new FoodCodeType[999];
    String desc;
    String expdate;
    Scanner input = new Scanner(System.in);
    
    FoodArray(int i){
        int flag=0;
        System.out.print("\n Enter the Type for Item: ");
        type = Character.toUpperCase(input.next().charAt(0));
        System.out.print(" Enter the Unique ID for Item: ");
        id = input.nextInt();
        input.nextLine();
        obj[i] = new FoodCodeType(type,id);
    }
    
    void search(int i,char type){
        if (obj[i].type == type){
            System.out.println("DESCRIPTION: " + this.desc);
            System.out.println("EXPIRY DATE: " + this.expdate);
            System.out.println("======================");
        }       
    }
    
}
