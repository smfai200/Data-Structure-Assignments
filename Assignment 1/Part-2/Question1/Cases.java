package assignment2q;

import java.io.*;
import java.util.*;

public class Cases {
    
    int count = 0;
    int linenum[] = new int[25];
    static LineType page[] = new LineType[25];
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
     public void case1() throws IOException{
        boolean check = false;
        int loopcancel=1;
        while(loopcancel!=2){
                check = false;
                System.out.print("\n Enter Line Number: ");
                linenum[count] = Integer.parseInt(input.readLine());
                page[linenum[count]] = new LineType();
                while(check == false){
                    System.out.print(" Enter Line(Max 80 Chars): ");
                    page[linenum[count]].line = input.readLine();
                    
                    if(page[linenum[count]].line.length() > 80)
                        System.out.println("\n YOU CANT ENTER MORE THAN 80 CHARS! ");
                    else
                        check = true;

                } //NESTED WHILE LOOP
                System.out.print("\n Do You want to Enter More Lines?\n 1.YES \n 2.NO \n Enter Your Choice: ");
                loopcancel = Integer.parseInt(input.readLine());
                    count++;
            }
        }
    
      public void case2(){
        for (int loop=0; loop<count; loop++){
           if(page[linenum[loop]] != null){
               System.out.print("\n Line #: "+linenum[loop] + " " + page[linenum[loop]].line);
           }
        }
        System.out.println();
      }
      
      public void case3() throws IOException{
          System.out.print("\n Enter Line Number to Retrieve: ");
          int lineno = Integer.parseInt(input.readLine());
          System.out.print("\n " + page[lineno].line);
      }
      
      public void case4() throws IOException{
          System.out.print("\n Enter Line Number to Delete: ");
          int lineno = Integer.parseInt(input.readLine());
          page[lineno].line = null;
          page[lineno] = null;
          System.out.print("\n DELETE SUCCESSFULLY! ");
      }
      
      public void case5() throws IOException{
          String reverse = "";
          System.out.print("\n Enter Line Number to Reverse: ");
          int lineno = Integer.parseInt(input.readLine());
          for (int loop=page[lineno].line.length()-1; loop >= 0 ; loop--){
              reverse += page[lineno].line.charAt(loop);
          }
          System.out.println(" REVERSE IS: "+reverse);
      }
}
