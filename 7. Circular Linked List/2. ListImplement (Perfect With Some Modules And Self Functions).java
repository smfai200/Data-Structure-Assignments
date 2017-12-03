//THIS IS PRACTICAL IMPLEMENTATION OF DOUBLE LINKED LIST MANUALLY IN JAVA INSTEAD OF USING LINKEDLIST LIBRARY
//Default is missing in Cases, You can Add it for yourself, I only wanted to give you Implemented!
//You are Free to Ask Anything that you get Confused With!
//CLASS Objects are reference based, taking advantage of this Fact!

import java.util.Scanner;

class LinkedList{
	int data;
//	String data1;  //WILL BE IMPLEMENTED LATER ON
	LinkedList next,back;

}

class ListImplement{
	static LinkedList first = null;
	static LinkedList cur = null;
	static LinkedList pre = null;
	static LinkedList temp = null;
	static LinkedList last = null;
	static Scanner input = new Scanner(System.in);
	int flag = 0;
	int nodecount=0;

	public static void main(String args[]){
		ListImplement classobj = new ListImplement();


		int flag=0;
		char ch = 'y';
		int choice;
		System.out.println(" 1. Generate Fibo \n 2. Normal ");
		int chi = input.nextInt();
		while(ch=='y'){
		if(chi == 1){
			classobj.fibo();
			flag = 1;
			chi = 2;
		}else{
			if(flag != 1){ //FOR FIRST TIME INITILIZATION
				System.out.println("\n INITILIZATION OF FIRST NODE BY DEFAULT ");
				cur = new LinkedList();
				cur.back = null;
				cur.next = null;
				System.out.println("Enter Data for First Node");
				cur.data = input.nextInt();
				first = pre = last = cur;
				flag = 1;
		  }else{
				classobj.menu();
				choice = input.nextInt();
				switch(choice){
					case 1:
						classobj.addnode();
						break;
					case 2:
						classobj.printnode();
						break;
					case 3:
						classobj.deletenode();
						break;
					case 4:
						classobj.changedata();
						break;
					case 5:
						classobj.swapchoosenode();
						break;
					case 6:
						classobj.checkevenodd();
						break;
					case 7:
						classobj.checkprime();
						break;
					case 8:
						ch = 'n';
						break;
				}
		  }
		} //WHILE LOOP
 	}
 }

 	public void menu(){
		System.out.print  ("\n 1. ADD NEW NODE" +
						   "\n 2. PRINT DATA FROM NODES" +
						   "\n 3. DELETE A NODE" +
						   "\n 4. CHANGE DATA IN A NODE" +
						   "\n 5. SWAP VALUES " +
						   "\n 6. PRINT EVEN AND ODD" +
						   "\n 7. PRIME PRIME NUMBERS "+
						   "\n 8. Exit " +
						   "\n Enter Your Choice: ");
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
				System.out.print(" Enter Data for Node: ");
				cur.data = input.nextInt();
				System.out.println(" ===> ADDED AT TOP SUCCESSFULLY! <=== ");
				if (flag == 0){		//INITILIZING THE LAST NODE
					last = first;
					flag = 1;
				}
				first = cur;
				break;
			case 2:
				System.out.print(" Enter the Data of the Node You want to Delete: ");
				int datachk = input.nextInt();
				cur = first;
				while(cur != null && cur.data != datachk){
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
					System.out.print("Enter Data for Node: ");
					temp.data = input.nextInt();
					System.out.println(" ===> ADDED IN MID SUCCESSFULLY! <=== ");
				}
				break;
			case 3:
				temp = new LinkedList();
				last.next = temp;
				temp.back = last;
				temp.next = null;
				System.out.print("Enter Data for Node: ");
				temp.data = input.nextInt();
				last = temp;
				System.out.println(" ===> ADDED IN END SUCCESSFULLY! <=== ");
				break;
  		}
  		first.back = last;
  		last.next = first;
	}

 //PRINT DATA FROM NODE IN YOUR OWN CHOICE SEQUENCE
	public void printnode(){
		int count;
		System.out.print("\n WHICH SEQUENCE DO YOU WANT TO PRINT DATA FROM NODE: " +
						 "\n 	1. FIRST TO LAST" +
						 "\n 	2. LAST TO FIRST" +
						 "\n Enter your Choice: ");
		int choice = input.nextInt();
		if(choice == 1){
			cur = first;
			count = 0;
			do{
				System.out.println("Data of Node["+count+"]: " + cur.data);
				cur = cur.next;
				count++;
		    }while(cur != first);
		}else{
			cur = last;
			count = nodecount;
			do{
				System.out.println("Data of Node["+count+"]: " + cur.data);
				cur = cur.back;
				count--;
		    }while(cur != first.back);
	    }
	}
//DELETE A NODE FROM THE LIST (TOP,MID,END) IMPLEMENTED
	public void deletenode(){
		System.out.print("\n WHERE DO YOU WANT TO ADD " +
								   "\n 	  1. FIRST " +
								   "\n 	  2. MID " +
								   "\n 	  3. LAST " +
								   "\n Enter Your Choice: ");
		int choice = input.nextInt();
		switch(choice){
			case 1:
				temp = first.next;
				temp.back = last;
				first.next = null;
				first = temp;
				System.out.println(" ===> DELETION IN TOP SUCCESSFUL! <===  ");
				break;
			case 2:
				System.out.print(" Enter the Data of the Node You want to Delete: ");
				int datachk = input.nextInt();
				cur = first;
				do{
					pre=cur;
					cur = cur.next;
				}while(cur != first && cur.data != datachk);
				if (cur == first){
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
				temp.next = first;
				last = temp;
				System.out.println(" ===> DELETION IN LAST SUCCESSFUL! <=== ");
				break;

		}
	}
//CHANGE DATA IN NODE
	public void changedata(){
		System.out.print(" Enter the Data of the Node You want to Change: ");
		int datachk = input.nextInt();
		cur = first;
		do{
			cur = cur.next;
		}while(cur.data != datachk);
		if (cur != first){
			System.out.print(" Enter the New Data: ");
			datachk = input.nextInt();
			cur.data = datachk;
			System.out.println(" CHANGED SUCCESSFULLY! ");
		}else{
			System.out.print(" DATA NOT FOUND IN NODE! ");
		}
	}
//SWAP VALUES
	public void swapchoosenode(){
		LinkedList Node1 = null;
		LinkedList Node2 = null;
		int flag=0;
		System.out.println("Enter Node Data to Swap N(1): ");
		int node1 = input.nextInt();
		System.out.println("Enter Node Data to Swap N(2): ");
		int node2 = input.nextInt();
		cur = first;
		do{
			if(cur.data == node1){
				Node1 = cur;
				flag++;
			}else if(cur.data == node2){
				Node2 = cur;
				flag++;
			}
			cur = cur.next;
		}while(cur!=first);
//FLAG WILL BE 2 IF BOTH DATA IS MATCHED FOR LINKEDLIST!
	   if(flag == 2){ //SWAPING WITHOUT 3rd VARIABLE
			Node1.data = Node1.data + Node2.data; //( x = x+y )
			Node2.data = Node1.data - Node2.data; //( y = x-y )
			Node1.data = Node1.data - Node2.data; //( x = x-y )

	   }else
	   		System.out.println(" DATA NOT FOUND IN NODE! ");


	}
//MODULE TO PRINT EVEN AND ODD FOR EACH NODE DATA
	public void checkevenodd(){
		cur = first;
		int count=0;
		do{
			if (cur.data == 2*(cur.data/2)){ //CHECKING EVEN ODD WITHOUT USING MOD %
				System.out.println("The Number "+cur.data+" at Position["+count+"] is Even");
			}else{
				System.out.println("The Number "+cur.data+" at Position["+count+"] is Odd");
			}
			count++;
			cur = cur.next;
		}while(cur!=first);
	}

	public void checkprime(){
		boolean flag;
		cur = first;
		do{
			flag = false;
			for(int i=2; i<cur.data; i++){
				if(cur.data%i == 0){
					System.out.println("The Number " + cur.data + " is NOT Prime!");
					flag=true;
					break;
				}
			}

		if(!flag)
			System.out.println("The Number " + cur.data + " is Prime!");
		cur= cur.next;
		}while(cur!=first);
	}

	public void fibo(){
		first = null;
		int data1=1;
		System.out.println(data1 + " ");
		do{
			cur = new LinkedList();
			cur.next = null;
			cur.back = null;
			if(first == null){
				pre=first=cur;
				cur.data = 1;
			}else{
				cur.data = pre.data+data1;
				System.out.println(cur.data + " ");
				data1 = pre.data;
				pre.next = cur;
				cur.back = pre;
				cur.next = first;
				pre = cur;
				nodecount++;
			}
			last = cur;
		}while(pre.data <= 1000);
	}

}