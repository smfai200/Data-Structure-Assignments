/* Construct a Linked List in which each node has the following information about a student
roll number, name and marks in 3 subjects. Enter records of BSE-3 B students in list.
Traverse this list and calculate the total marks, percentage and division of each student.
Count how many students have 1st, 2nd and 3rd division and how many students are fail.
Make you program menu driven with the following options.
[1]. Create List
[2]. Insert record at Top and any where in the list upon user choice
[3]. Delete record at Top and any where in the list upon user choice
[4]. Modify Record
[5]. Display result summary report of overall BSE 3 B
[6]. Exit
*/
import java.util.Scanner;
class LinkedList{
		int data;
	    String rollno;
	    String name;
	    int marks[] = new int[3];
	    int percentage = 0;
	    int totalmarks = 300;
	    char division;
		LinkedList next,back;

}


class Main{
	static LinkedList first = null;
	static LinkedList cur = null;
	static LinkedList pre = null;
	static LinkedList temp = null;
	static LinkedList last = null;
	static Scanner input = new Scanner(System.in);
	int flag = 0;
	int nodecount=0;
	boolean flag1 = false;
	int gradcount[] = {0,0,0,0,0};
	int gradcounta = 0;

	public static void main(String args[]){
		Main classobj = new Main();
		char ch = 'y';
	while(ch=='y'){
		classobj.menu();
		int choice = input.nextInt();

		switch(choice){
			case 1:
				cur = new LinkedList();
				cur.back = null;
				cur.next = null;
				input.nextLine();
				System.out.print("Enter RollNo for Student: "); //take rollno
				cur.rollno = input.nextLine();

				System.out.print("Enter Name for Student: ");	//take name
				cur.name = input.nextLine();
				for (int i=0; i<cur.marks.length; i++){	//take marks
					System.out.print("Enter Marks for Subject["+i+"]: ");
					cur.marks[i] = input.nextInt();
				}
				first = cur;
				last = cur;
				break;
			case 2:
				classobj.addnode();
				break;
			case 3:
				classobj.deletenode();
				break;
			case 4:
				classobj.changedata();
				break;
			case 5:
				classobj.printnode();
				break;
			case 6:
				classobj.summaryrep(1,1);
				break;
			case 7:
				ch = 'n';
				break;
		}
  	}
}

	public void menu(){
		System.out.println("\n[1]. Create List \n" +
						   "[2]. Insert record at Top and any where in the list upon user choice \n" +
						   "[3]. Delete record at Top and any where in the list upon user choice \n" +
						   "[4]. Modify Record \n" +
						   "[5]. Display Record of overall BSE 3-B \n" +
						   "[6]. Display result summary report of overall BSE 3-B \n" +
   						   "[7]. Exit\n" +
						   "[*] Enter Your Choice: ");
}
//ADDING DATA IN NODE (MID,TOP,END)IMPLEMENTED
	public void addnode(){
		nodecount++;
		System.out.print("\n WHERE DO YOU WANT TO ADD " +
						   "\n 	  1. TOP " +
						   "\n 	  2. MID " +
						   "\n 	  3. END " +
						   "\n Enter Your Choice: ");
		int choice = input.nextInt();
		System.out.println("\n  ===> ADDING DATA TO NODE <=== \n");
		switch(choice){
			case 1:
				cur = new LinkedList();
				first.back = cur;
				cur.back = null;
				cur.next = first;
				input.nextLine();
				System.out.print("Enter RollNo for Student: "); //take rollno
				cur.rollno = input.nextLine();

				System.out.print("Enter Name for Student: ");	//take name
				cur.name = input.nextLine();
				for (int i=0; i<cur.marks.length; i++){	//take marks
					System.out.print("Enter Marks for Subject["+i+"]: ");
					cur.marks[i] = input.nextInt();
				}
				System.out.println(" ===> ADDED AT TOP SUCCESSFULLY! <=== ");
				if (flag == 0){		//INITILIZING THE LAST NODE
					last = first;
					flag = 1;
				}
				first = cur;
				break;
			case 2:
				input.nextLine();
				System.out.print(" Enter the Rollno You want to Delete: ");
				String datachk = input.nextLine();
				cur = first;
				while(cur != null && !cur.rollno.equals(datachk)){
					pre=cur;
					cur = cur.next;
				}
				if (cur == null){
					System.out.println(" ===> DATA NOT FOUND IN NODE! <=== ");

				}else{
					temp = new LinkedList();
					temp.back = pre;
					pre.next = temp;
					cur.back = temp;
					temp.next = cur;
					input.nextLine();
					System.out.print("Enter RollNo for Student: ");
					temp.rollno = input.nextLine();
					input.nextLine();
					System.out.print("Enter Name for Student: ");
					temp.name = input.nextLine();
					for (int i=0; i<temp.marks.length; i++){
						System.out.print("Enter Marks for Subject["+i+"]: ");
						temp.marks[i] = input.nextInt();
					}
					System.out.println(" ===> ADDED IN MID SUCCESSFULLY! <=== ");
				}
				break;
			case 3:
				temp = new LinkedList();
				last.next = temp;
				temp.back = last;
				temp.next = null;
				input.nextLine();
				System.out.print("Enter RollNo for Student: ");
				temp.rollno = input.nextLine();

				System.out.print("Enter Name for Student: ");
				temp.name = input.nextLine();
				for (int i=0; i<temp.marks.length; i++){
					System.out.print("Enter Marks for Subject["+i+"]: ");
					temp.marks[i] = input.nextInt();
				}
				last = temp;
				System.out.println(" ===> ADDED IN END SUCCESSFULLY! <=== ");
				break;
  		}
	}

 //PRINT DATA FROM NODE IN YOUR OWN CHOICE SEQUENCE
	public void printnode(){
		Main classobj = new Main();
		classobj.summaryrep(0,0);
		int count;
		System.out.print("\n WHICH SEQUENCE DO YOU WANT TO PRINT DATA FROM NODE: " +
						 "\n 	1. FIRST TO LAST" +
						 "\n 	2. LAST TO FIRST" +
						 "\n Enter your Choice: ");
		int choice = input.nextInt();
		if(choice == 1){
			cur = first;
			count=0;
			while(cur != null){
				System.out.println("RollNo: " + cur.rollno);
				System.out.println("Name: " + cur.name);
				for(int i=0; i<cur.marks.length; i++){
					System.out.println("Marks["+i+"]: " + cur.marks[i]);
				}
				System.out.println("Percentage: " + cur.percentage);
				System.out.println("Grade: " + cur.division);
				cur = cur.next;
				count++;
				System.out.println("=============================");
		    }
		}else{
			cur = last;
			count = nodecount;
			while(cur != null){
				System.out.println("RollNo: " + cur.rollno);
				System.out.println("Name: " + cur.name);
				for(int i=0; i<cur.marks.length; i++){
					System.out.println("Marks["+i+"]: " + cur.marks[i]);
				}
				System.out.println("Percentage: " + cur.percentage);
				System.out.println("Grade: " + cur.division);
				cur = cur.back;
				count--;
				System.out.println("=============================");
		    }
	    }
	}
//DELETE A NODE FROM THE LIST (TOP,MID,END) IMPLEMENTED
	public void deletenode(){
		System.out.print("\n WHERE DO YOU WANT TO DELETE " +
								   "\n 	  1. FIRST " +
								   "\n 	  2. MID " +
								   "\n 	  3. LAST " +
								   "\n Enter Your Choice: ");
		int choice = input.nextInt();

		switch(choice){
			case 1:
				temp = first.next;
				temp.back = null;
				first.next = null;
				first = temp;
				System.out.println(" ===> DELETION IN TOP SUCCESSFUL! <===  ");
				break;
			case 2:
				input.nextLine();
				System.out.print(" Enter the Data of the Node You want to Delete: ");
				String datachk = input.nextLine();
				cur = first;
				while(cur != null && cur.rollno != datachk){
					pre=cur;
					cur = cur.next;
				}
				if (cur == null){
					System.out.println(" ===> DATA NOT FOUND IN NODE! <===  ");
				}else{
					temp = cur.next;
					temp.back = pre;
					pre.next = temp;
					System.out.println(" ===> DELETION IN MID SUCCESSFUL! <===  ");
				}
				break;
			case 3:
				temp = last.back;
				temp.next = null;
				last = temp;
				System.out.println(" ===> DELETION IN LAST SUCCESSFUL! <=== ");
				break;

		}
	}
//calculate the total marks, percentage and division of each student.

//CHANGE DATA IN NODE
	public void changedata(){
		input.nextLine();
		System.out.print(" Enter the RollNo, You wish to Change: ");
		String datachk = input.nextLine();
		cur = first;
		System.out.println("data is: "+datachk);
		while(cur != null && !cur.rollno.equals(datachk)){
			System.out.println("RL: " + cur.rollno);
			cur = cur.next;
		}
		if (cur != null){
			cur.rollno = datachk;
			System.out.print("Enter Name for Student: ");
			cur.name = input.nextLine();
			for (int i=0; i<cur.marks.length; i++){
				System.out.print("Enter Marks for Subject["+i+"]: ");
				cur.marks[i] = input.nextInt();
			}
			System.out.println(" CHANGED SUCCESSFULLY! ");
		}else{
			System.out.print(" DATA NOT FOUND IN NODE! ");
		}
	}

 	public void summaryrep(int choice,int choice1){
if(choice == 0){
	 cur = first;
	 while(cur!=null){
		cur.percentage = 0;
		for (int i = 0; i<cur.marks.length; i++){
			cur.percentage += (cur.marks[i]*100)/100;
		}
		cur.percentage = cur.percentage/3; //AVG percentage calculated

		if (cur.percentage >=90 ){ //BYPASSING USE OF LOGICAL OPERATORS BY PRIRIOTY!
			cur.division = 'A';
			gradcounta++;
		}
		else if(cur.percentage >= 80){
			cur.division = 'B';
			gradcount[1]++;
		}
		else if(cur.percentage >= 70){
			cur.division = 'C';
			gradcount[2]+= 1;
		}
		else if(cur.percentage >=60){
			cur.division = 'D';
			gradcount[3]+= 1;
		}
		else{
			cur.division = 'F';
			gradcount[4]+= 1;
		}
		cur = cur.next;
	  }
	 if(choice1 == 1){
	 	System.out.println("Total A Grade Students: " + gradcounta);
		System.out.println("Total B Grade Students: " + gradcount[1]);
		System.out.println("Total C Grade Students: " + gradcount[2]);
		System.out.println("Total D Grade Students: " + gradcount[3]);
	  	System.out.println("Total F Grade Students: " + gradcount[4]);
	}
 	}else{
		Main classobj = new Main();
		classobj.summaryrep(0,1);
  }
}
}
