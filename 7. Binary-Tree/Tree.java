import java.util.Scanner;

public class Tree {
    static Scanner input = new Scanner(System.in);
    static Node root;
    static Node obj = new Node();
    
    public static void main(String[] args) {
        char flag = 'y';
        int value;
        // CREATING ROOT NODE FOR TREE BY DEFAULT
            root = new Node();
            root.left = null;
            root.right = null;
            System.out.print("Enter Data for Root Node: ");
            root.data = input.nextInt();
    //ENGAGE FROM LOOP        
      while(flag=='y'){
        System.out.println("[1]. Insert to Binary Tree\n" +
                "[2]. Traverse Binary Tree\n" +
                "[3]. Exit");
        int choice = input.nextInt();
        
        switch(choice){
            case 1:
                System.out.print("Enter Data for Node: ");
                value = input.nextInt();
                obj.insert(root, value);
                break;
            case 2:
                obj.prefix(root);
                break;
            case 3:
                flag = 'n';
                break;
        }
        
    }
    }
    
}
