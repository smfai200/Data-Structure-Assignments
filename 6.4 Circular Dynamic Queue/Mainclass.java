package mainclass;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*
Logic Used as Queue is Circular so We make the LinkedList Circular
For the Check of Max 10, The variable Count is Used
Count++ with Insertion
Count-- with Deletion
Check for InputMismatch Exception!
Check if User Inputs Date More than Today!
Search By Symptom for Doctor
Doctor can View top 3 in Queue

DELETION IN CIRCULAR:
as in normal circular, front when deleted in increased, here it is forwarded to next And 
previous is Deleted
rear when reaches limit, Shows Error of Queue Full
Queue Empty Check Implemented
If the Queue has Space, Rear can be used to Make new Node
*/

public class Mainclass {
    PatientRecords obj = new PatientRecords();
    PatientRecords pre,cur,temp,front,rear;
    static Scanner input = new Scanner(System.in);
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static LocalDate localDate = LocalDate.now();
    int count = 0; //to be used for the limit of 10
    int flag = 0;
    int totalpatients = 0;
    int patientchecked = 0;

    Mainclass(){
        pre = null;
        cur = null; //used for deletion
        temp = null;
        front = null; //used for front
        rear = null; //used for rear
    }
    public static void main(String[] args) {
     //   System.out.println(dtf.format(localDate));
     try{
        Mainclass obj1 = new Mainclass();
        int choice;
        char ch = 'y';
      while(ch == 'y'){
        System.out.println(" 1. INSERT TO QUEUE\n"
                + " 2. DELETE FROM QUEUE\n"
                + " 3. Find Patient\n"
                + " 4. Search by Symptom\n"
                + " 5. Display Patient\n"
                + " 6. Show ALL\n"
                + " 7. Show Stats\n"
                + " 8. EXIT\n"
                + "Enter Your Choice: ");
        choice = input.nextInt();
        switch(choice){
            case 1:
                obj1.insert_Q();
                break;
            case 2:
                obj1.delete_q();
                break;
            case 3:
                input.nextLine();
                System.out.println("Enter Date: ");
                String date = input.nextLine();
                obj1.Findpatient(date);
                break;
            case 4:
                input.nextLine();
                System.out.println("Enter Symptom to Search: ");
                String symp = input.nextLine();
                obj1.searchsym(symp);
                break;
            case 5:
                obj1.DisplayPatient();
                break;
            case 6:
                obj1.showall();
                break;
            case 7:
                obj1.record();
                break;
            case 8:
                ch = 'n';
                break;
        }
      }
     }catch(Exception e){
         System.out.println("You can Only Enter an Int Value!");
     }
    }
    
    public void insert_Q(){
     //   char ch = 'y';
        if(flag == 1){
            pre = rear;
        }
        if(count >= 4){
            System.out.println("The Queue is Made to Accomodate Only 10 People!");
            flag=1;
        }else{
            totalpatients++;
            input.nextLine();
            count++;
            rear = new PatientRecords();
 //           rear.next = null;
        try{
            System.out.println("Enter Your Name: ");
            rear.name = input.nextLine();
            System.out.println("Enter Date(format dd/mm/yyyy): ");
            rear.Datevisited = input.nextLine();
            System.out.println("Enter Medicines Prescribed: ");
            rear.MedicinePres = input.nextLine();
            System.out.println("Enter Symptoms: ");
            rear.symptoms = input.nextLine();
        }catch(Exception e){
            System.out.println("Only String Value is Allowed!");
        }
            if(front == null)
                front = cur = pre = rear;
            else{
                pre.next = rear;
                rear.next = front; //MAKING THE LINKEDLIST CIRCULAR
                pre = rear;
            }
            System.out.println("ADDED SUCCESSFULLY!");
        }
       // System.out.println("Enter New Data ? "); USED WHEN IN WHILE LOOP
       // ch = input.next().charAt(0);
    }

    public void delete_q(){
        if(count <= 0){
            System.out.println("The Queue is Empty!");
        }else{
            patientchecked++;
            count--;
            System.out.println("Name: " + front.name);
            temp = front;
            front = front.next;
            temp.next = null;
            rear.next = front;
            System.out.println("DELETED SUCCESSFULLY!");
        }
    }

    public void searchsym(String symp){
        temp = front;
        do{
            if(temp.symptoms.equals(symp)){
                System.out.println("Name: " + temp.name);
                System.out.println("Date: " + temp.Datevisited);
                System.out.println("Medicines Prescribed: " + temp.MedicinePres);
                System.out.println("Symptoms: " + temp.symptoms);
            }
            temp = temp.next;
        }while(temp != front);
    }
    
    public void showall(){
        temp = front;
        do{
             System.out.println("Name: " + temp.name);
             System.out.println("Date: " + temp.Datevisited);
             System.out.println("Medicines Prescribed: " + temp.MedicinePres);
             System.out.println("Symptoms: " + temp.symptoms);
            temp = temp.next;
        }while(temp != front);
    }
    
    public void Findpatient(String date){
        temp = front;
        do{
            if(temp.Datevisited.equals(date)){
                System.out.println("Name: " + temp.name);
                System.out.println("Date: " + temp.Datevisited);
                System.out.println("Medicines Prescribed: " + temp.MedicinePres);
                System.out.println("Symptoms: " + temp.symptoms);
            }
            temp = temp.next;
        }while(temp != front);
    }
    
    public void DisplayPatient(){
        temp = front;
        int i = 0;
        System.out.println("PRINTING TOP 3 IN THE QUEUE: ");
      while(i<4){
        System.out.println(i + ") Name: " + temp.name);
        temp = temp.next;
        i++;
      }
    }
    
    public void record(){
        System.out.println("TOTAL PATIENTS TODAY: " + totalpatients);
        System.out.println("PATIENTS CHECKED TILL NOW: " + patientchecked);
    }
    
}
