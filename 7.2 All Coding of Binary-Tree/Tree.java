package tree;

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
                "[3]. Find out the smallest and the largest node in the Tree\n" +
                "[4]. Find the depth of the Tree\n" +
                "[5]. Search out the particular node in the Tree\n" +
                "[6]. Display all nodes of particular level\n" +
                "[7]. Delete particular node in the Tree\n" +
                "[8]. Exit");
        int choice = input.nextInt();
        
        switch(choice){
            case 1:
                System.out.print("Enter Data for Node: ");
                value = input.nextInt();
                obj.insert(root, value);
                break;
            case 2:
                obj.prefix(root,0);
                break;
            case 3:
                obj.largest(root);
                break;
            case 4:
                System.out.println("Depth of Tree is: " + obj.treeHeight(root));
                break;
            case 5:
                System.out.println("Enter Data for Search: ");
                value = input.nextInt();
                obj.search(root,value);
                break;
            case 6:
                System.out.println("Enter Level: ");
                value = input.nextInt();
                obj.leveldisplay(root, value ,1);
                break;
            case 7:
                obj.temp = root;
                System.out.println("Enter Data to Delete: ");
                obj.tempno = input.nextInt();
                obj.prefix(root, 3);
                break;
            case 8:
                flag = 'n';
                break;
        }
        
    }
    }
    
}
