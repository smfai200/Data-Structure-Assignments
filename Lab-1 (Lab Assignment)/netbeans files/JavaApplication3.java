package javaapplication3;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaApplication3 {

    public static void main(String[] args) {
        try{
        int a,count=0;
        int array[] = new int[20];
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a Number");
        a = Integer.parseInt(input.readLine());
        //LOOP
        System.out.println("Enter a Number");
        for (int loop=0; loop<20; loop++){
            array[loop] = Integer.parseInt(input.readLine());
            if (array[loop] == a){
                count++;
            }
        }
        System.out.println("The Number '"+a+"' occured '"+count+"' in your input");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
