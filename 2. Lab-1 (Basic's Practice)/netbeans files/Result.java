package javaapplication4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Result {
    private int marks[] = new int[3];
    private int totalmarks=300,obtainedmarks;
    private String rollno,name;
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    //TAKES INPUT
    public void input() throws IOException{
        System.out.println("Enter Roll-No: ");
        this.rollno = input.readLine();
        System.out.println("Enter Your Name: ");
        this.name = input.readLine();
        System.out.println("Enter Your Marks: ");
        for (int loop=0; loop<marks.length; loop++){
            marks[loop] = Integer.parseInt(input.readLine());
        }
    }
    //SHOWS DATA ON SCREEN
    public void show(){
        System.out.println(" ====================== ");
        System.out.println(" Roll No: " + rollno +
                           "\n Name: " + name +
                           "\n Total Marks: 500");
        
        for (int loop=0; loop<marks.length; loop++){
           System.out.println(" Marks[" + loop + "]" + marks[loop]); 
        }
    }
    //RETURNS OBTAINED MARKS FOR AVERAGE REQUIRED
    public int total(){
       for (int loop=0; loop<marks.length; loop++){
           obtainedmarks += marks[loop];
        }
       return obtainedmarks;
    }
    //RETURNS AVERAGE OF MARKS
    public double avg(){
        return (this.total()/marks.length);
    }
    public static void main(String[] args) throws IOException {
      Result obj[] = new Result[10];
      for (int loop=0; loop<=obj.length; loop++){
          System.out.println("\n==> Student No: " + loop);
          obj[loop] = new Result();
          obj[loop].input();
          obj[loop].show();
          System.out.println(" Total Examination Marks: 300");
          System.out.println(" Obtains Marks: " + obj[loop].total());
          System.out.println(" Average Is: " + obj[loop].avg());
          System.out.println(" ====================== ");
      }
    } 
}
