package assignment2q2;
import java.util.Scanner;

public class Assignment2Q2 {
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
      
      Assignment2Q2 classobj = new Assignment2Q2();
      FoodArray[] foodobj = new FoodArray[999];
      char ch = 'y';
      int flag=0;
      int counttotal=0;
   while(flag != 1){
      int choice = classobj.menu();
      switch(choice){
          case 1:
              for(int i=0; ch=='y'; i++){
                foodobj[i] = new FoodArray(i);
                input.nextLine();
                System.out.print(" Enter The Description of the Item: ");
                foodobj[i].desc  = input.nextLine();
           
                System.out.print(" Enter The Expiry Date of the Item: ");
                foodobj[i].expdate = input.nextLine();
           
                counttotal++;
                System.out.print("\n New Entry: \n y: Yes \n n: No \n Enter Choice: ");
                ch = input.next().charAt(0);
              }
              break;
          case 2:
              System.out.print("\n Enter The Code to Search: ");
              char se = input.next().charAt(0);
              classobj.showitemtype(foodobj, counttotal, se);
              break;
          case 3:
              System.out.print("\n Enter The Exp Date to Search: ");
              String Todaydate = input.nextLine();
              classobj.ShowExpiredItem(foodobj, counttotal, Todaydate);
              break;
          case 4:
              flag = 1;
       }
      }
    }
    
    public void showitemtype(FoodArray[] obj, int nofooditems, char type){
        for (int loop=0; loop<nofooditems; loop++){
            obj[loop].search(loop,Character.toUpperCase(type));
        }
    }
    
    public void ShowExpiredItem(FoodArray[] obj, int nofooditems, String Todaydate){
        System.out.println("\n THE FOLLOWING ITEMS HAVE EXPIRED: ");
        for (int loop=0; loop<nofooditems; loop++){
            try{
            if(obj[loop].expdate.equals(Todaydate)){
                System.out.println(" DESC: " + obj[loop].desc);
                System.out.println(" EXPIRY DATE: " + obj[loop].expdate);
                System.out.println(" ================================= ");
            }
            }catch(NullPointerException ex){
                
            }
        }
    }
    
    public int menu(){
        System.out.print("\n\n =========> MENU <========= " + 
                           "\n [1]. Add New Entry\n " +
                           "[2]. Search for Specific Category\n" +
                           " [3]. List Expired Items\n" +
                           " [4]. Exit\n" +
                           " Enter Your Choice: ");
        int choice = input.nextInt();
        input.nextLine();
        return choice;
    }
    
}
