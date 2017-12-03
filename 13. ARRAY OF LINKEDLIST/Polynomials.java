package polynomials;
import java.util.Scanner;

class List{
    List next;
    int cof;
    int exp;
    char var = 'x';
}

public class Polynomials {
    static Scanner input = new Scanner(System.in);
    List first[],  //RATHER TO USE MULTIPLE LINKED LIST VARIABLES, MAKE USE OF DATA STRUCTURE!
         pre[],
         cur[],
         temp[];

    public Polynomials() {
        //INITILIZE
        this.first = new List[3];
        this.pre = new List[3];
        this.cur = new List[3];
        this.temp = new List[3];
    }
    
    public static void main(String[] args) {
        Polynomials obj = new Polynomials();
        System.out.println("|$| ==> READING FIRST POLYNOMIAL");
        obj.read(0);
        System.out.println("\n\n|$| ==> READING SECOND POLYNOMIAL");
        obj.read(1);
        obj.add();
        obj.display(2);
    }

    public void read(int i){ //THIS METHOD READS BOTH POLYNOMIALS
        first[i] = null;
        char ch = 'y';
      while(ch == 'y'){
        cur[i] = new List();
        cur[i].next = null;
        //TAKING VALUES
        System.out.print("\n Enter the Cof: ");
        cur[i].cof = input.nextInt();
        System.out.print(" Enter the EXP: ");
        cur[i].exp = input.nextInt();
        
        //INITILIZING FIRST
        if(first[i] == null)
            first[i] = pre[i] = cur[i];
        else{
            pre[i].next = cur[i];
            pre[i] = cur[i];
        }
        //CHECKING IF EXPRESSION IS FINISHED
        System.out.print(" Add More (y. YES | n. NO) \n Choice: ");
        ch = input.next().charAt(0);
      }
    }
    
    public void add(){
        //GENRALIZING KIND OF VARIABLES, IMAGINE THEM AS LOOP VARIABLES BUT THEY DON'T JUST ITERATE(BUT ARE STATIC)
        int i = 0;
        int j = 1;
        int k = 2;
        //CUR TO FIRST INITILIZE
        cur[i] = first[i];
        cur[j] = first[j];
        first[k] = null;
        //CHECKING IT ALL
        while(cur[i] != null || cur[j] != null){
            cur[k] = new List();
            cur[k].next = null;
            
            if(cur[i] == null){ //ADD THE DATA FROM SECOND LIST TO RESULT AS FIRST IS NULL
                cur[k].exp = cur[j].exp;
                cur[k].cof = cur[j].cof;
                cur[j] = cur[j].next;
            }else if(cur[j] == null){ //ADD THE DATA FROM FIRST LIST TO RESULT AS SECOND IS NULL
                cur[k].exp = cur[i].exp;
                cur[k].cof = cur[i].cof;
                cur[i] = cur[i].next;
            }else if(cur[i].exp > cur[j].exp){ //P1>P2
                cur[k].exp = cur[i].exp;
                cur[k].cof = cur[i].cof;
                cur[i] = cur[i].next;
            }else if(cur[j].exp > cur[i].exp){ //P2 > P1
                cur[k].exp = cur[j].exp;
                cur[k].cof = cur[j].cof;
                cur[j] = cur[j].next;
            }else if(cur[i].exp == cur[j].exp){ //P1 == P2
                cur[k].exp = cur[i].exp;
                cur[k].cof = (cur[i].cof+cur[j].cof);
                cur[i] = cur[i].next;
                cur[j] = cur[j].next;
            }
            //NEXT LINKING CODE BELOW
            if(first[k] == null)
                first[k] = pre[k] = cur[k];
            else{
                pre[k].next = cur[k];
                pre[k] = cur[k];
            }
        }
    }
    
    public void display(int i){ //DISPLAY THE RESULTANT
        System.out.print("\n |$| RESULTANT IS: ");
        cur[i] = first[i];
        while(cur[i] != null){
            System.out.print(cur[i].cof + "x^(" + cur[i].exp + ") + ");
            cur[i] = cur[i].next;
        }
    }
    
}
