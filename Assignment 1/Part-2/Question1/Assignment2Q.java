package assignment2q;
import java.io.*;

public class Assignment2Q {

    public static void main(String[] args) throws IOException{
        Assignment2Q obj = new Assignment2Q();
        obj.menu();
        
    }
    
    public void menu() throws IOException{
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      Cases switchcase = new Cases();
      char ch = 'y';
      while (ch=='y'){
        System.out.print("\n\n [1]. Enter Lines of Text\n" +
                           " [2]. Retrieve all Lines\n" +
                           " [3]. Retrieve a particular line of Text\n" +
                           " [4]. Delete a particular line of Text\n" +
                           " [5]. Reverse a particular line\n" +
                           " [6]. EXIT \n" +
                           " Enter Your Choice: ");
        int choice = Integer.parseInt(input.readLine());
        
        switch(choice){
            case 1:
                switchcase.case1();
                break;
            case 2:
                switchcase.case2();
                break;
            case 3:
                switchcase.case3();
                break;
            case 4:
                switchcase.case4();
                break;
            case 5:
                switchcase.case5();
                break;
            case 6:
                ch = 'n';
                break;
            default:
                System.out.println("\n Incorrect Option Selected!");
        }
      }
    }
}
