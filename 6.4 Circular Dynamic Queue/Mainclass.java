package mainclass;

import java.util.Scanner;

public class Mainclass {
    PatientRecords obj = new PatientRecords();
    PatientRecords pre,cur,temp,front,rear;
    static Scanner input = new Scanner(System.in);
    int count = 0; //to be used for the limit of 10
    int flag = 0;
 //   int fcount = -1;
  //  int rcount = -1;
    Mainclass(){
        pre = null;
        cur = null; //used for deletion
        temp = null;
        front = null; //used for front
        rear = null; //used for rear
    }
    public static void main(String[] args) {
     try{
        Mainclass obj1 = new Mainclass();
        int choice;
        char ch = 'y';
      while(ch == 'y'){
        System.out.println(" 1. INSERT TO QUEUE"
                + " 2. DELETE FROM QUEUE"
                + " 3. Find Patient"
                + " 4. Display Patient"
                + " 5. Show ALL"
                + " 6. EXIT");
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
            //    System.out.println(date);
                obj1.Findpatient(date);
                break;
            case 4:
                obj1.DisplayPatient();
                break;
            case 5:
                obj1.showall();
                break;
            case 6:
                ch = 'n';
                break;
        }
      }
     }catch(Exception e){
         System.out.println("You can Only Enter an Int Value!");
     }
    }
    
    public void insert_Q(){
        char ch = 'y';
  //  while(ch == 'y'){
    //    if(fcount >= 9 || fcount==rcount+1){
    if(flag == 1){
        pre = rear;
    }
        if(count >= 9){
            System.out.println("The Queue is Made to Accomodate Only 10 People!");
            flag=1;
        }else{
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
                rear.next = front;
                pre = rear;
            }
        }
       // System.out.println("Enter New Data ? ");
       // ch = input.next().charAt(0);
   // }
    }

    public void delete_q(){
        if(count <= 0){
            System.out.println("The Queue is Empty!");
        }else{
            count--;
            System.out.println("Name: " + front.name);
            temp = front;
            front = front.next;
            temp.next = null;
            rear.next = front;
        }

    }
/*    public void delete_Q(){
        temp = cur;
        if(fcount < 0){
            System.out.println("Queue Underflow");
        }else{
            if(fcount >= 10){
                
            }else{
                if(fcount == rcount){
                    
                }else{
                    fcount++;
                    System.out.println("Name: "+cur.name);
                }
            }
        }
    } */
    
    public void showall(){
        temp = front;
        do{
      //      if(pre.symptoms == temp.symptoms){
                System.out.println("Name: " + temp.name);
                System.out.println("Date: " + temp.Datevisited);
                System.out.println("Medicines Prescribed: " + temp.MedicinePres);
                System.out.println("Symptoms: " + temp.symptoms);
       //     }
            pre = temp;
            temp = temp.next;
        }while(temp != front);
    }
    
    public void Findpatient(String date){
        temp = front;
        do{
        //    System.out.println(temp.Datevisited);
            if(temp.Datevisited.equals(date)){
                System.out.println("Name: " + temp.name);
            }
            temp = temp.next;
        }while(temp != front);
    }
    
    public void DisplayPatient(){
        temp = front;
        System.out.println("Name: " + temp.name);
    }
    
}
