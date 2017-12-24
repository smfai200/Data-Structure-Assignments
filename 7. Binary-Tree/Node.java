package tree;

import java.util.Scanner;

public class Node {
    Node left,right,temp,cur,pre = null;
    int data;
    int flag;
    
    public void insert(Node root, int value){
        if(root == null){ //ROOT Node to be Created
            cur = new Node();
            cur.left = null;
            cur.right = null;
            cur.data = value;
            if(flag == 0)
                pre.right = cur;
            else
                pre.left = cur;
        }else{
            if(value > root.data){
                flag = 0;
                pre = root;
                insert(root.right,value);
            }else if(value < root.data){
                flag = 1;
                pre = root;
                insert(root.left,value);
            }else{
                System.out.println("No Duplication Allowed");
            }
        }
    }  
    public void prefix(Node root, int option){
        if(root == null){
            
        }else{
            System.out.println(root.data);
            prefix(root.left,option);
            prefix(root.right,option);

        }
    }
}
    
