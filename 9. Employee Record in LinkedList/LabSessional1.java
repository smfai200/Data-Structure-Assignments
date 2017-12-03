package labsessional1;
import java.util.Scanner;

public class LabSessional1 {
    static Scanner input = new Scanner(System.in);
    static Node first=null;
    static Node cur=null;
    static Node pre = null;
    static Node temp=null;
    
    public static void main(String[] args) {
        int choice;
        boolean ch = true;
        LabSessional1 classobj = new LabSessional1();
        
      while(ch){
        System.out.println("[1]. Creation of Linked List \n" +
                          "[2]. Edit specific record in the List \n" + 
                          "[3]. Eliminate retired employees \n" +
                          "[4]. Bonus Facility \n" +
                          "[5]. Exit \n" +
                          " My choice: " );
         choice = input.nextInt();
         switch(choice){
             case 1:
                 classobj.createlist();
                 break;
             case 2:
                 classobj.editrec();
                 break;
             case 3:
                 classobj.eliminateretired();
                 break;
             case 4:
                 classobj.bonus();
                 break;
             case 5:
                 ch = false;
                 break;
             default:
                 System.out.println("\n Incorrect Option Selected");
                 break;
         }
      }
   }
    
    public void createlist(){
        char flag = 'y';
     while(flag == 'y'){
        cur = new Node();
        System.out.println("Enter Employee ID: ");
        cur.emp_id = input.nextInt();
        input.nextLine();
        System.out.println("Enter Employee Name: ");
        cur.emp_name = input.nextLine();
        System.out.println("Enter Employee Salary: ");
        cur.emp_sal = input.nextInt();
        System.out.println("Enter Employee Age: ");
        cur.emp_age = input.nextInt();
        cur.next = null;
        if(first == null){
            first = pre = cur;
        }else{
            pre.next = cur;
            pre = cur;
        }
        
        System.out.println("Do You want to Add More Data:\n 1. y for Yes\n 2.n for No");
        flag = input.next().charAt(0);
     }
    }
    
    public void editrec(){
        System.out.println("Enter Employee ID To Edit Record For: ");
        int empno = input.nextInt();
        boolean flag = false;
        cur = first;
        while(cur!=null){
            if(cur.emp_id == empno){
                input.nextLine();
                System.out.println("Enter Changed Employee Name: ");
                cur.emp_name = input.nextLine();
                System.out.println("Enter Changed Employee Salary: ");
                cur.emp_sal = input.nextInt();
                System.out.println("Enter Changed Employee Age: ");
                cur.emp_age = input.nextInt();
                flag = true;
            }
            cur = cur.next;
        }
        if(!flag){
            System.out.println("Data Not Found!");
        }
    }
    
    public void eliminateretired(){
        cur = first;
        int count = 0;
        System.out.println("The Following Retired Has been Eliminated!\n");
       while(cur!=null){
           if(cur.emp_age >= 60){
               System.out.println("ID: " + cur.emp_id);
               System.out.println("Name: " + cur.emp_name);
               System.out.println("Age: " + cur.emp_age);
               System.out.println("Salary: " + cur.emp_sal);
               System.out.println("=====================\n");
               if(cur == first){ //MEANS FIRST NODE DELETION
                   first = cur.next;
                   cur.next = null;
                   cur = first;
               }else if(cur.next == null){ //LAST NODE DELETION
                   cur = pre;
                   pre.next = null;
               }else{
                    cur = cur.next;
                    pre.next = cur;
                    cur = cur.next;
               }
               count++;
           }else{
               pre=cur;
               cur = cur.next;
           }
       }
       System.out.println("Total Number of Retired Employees: " + count);
    }
    
    public void bonus(){
        cur = first;
        int count=0;
        int bonus;
       while(cur!=null){
           if(cur.emp_sal >= 50000){
               bonus = ((cur.emp_sal*20)/100);
               System.out.println("ID: " + cur.emp_id);
               System.out.println("Name: " + cur.emp_name);
               System.out.println("Age: " + cur.emp_age);
               System.out.println("Salary: " + cur.emp_sal);
               System.out.println("Bonus: " + bonus);
               System.out.println("Salary After Bonus: " + (cur.emp_sal+bonus));
               System.out.println("=====================");
           }
           cur = cur.next;
       }
    }
    
}
