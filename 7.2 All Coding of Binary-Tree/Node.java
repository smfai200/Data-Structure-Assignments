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
            switch (option) {
                //0 is for simple triverse
                case 0:
                    System.out.println(root.data);
                    break;
                case 1:
                    //1 is for finding largest and smallest
                    if(root.data > large)
                        large = root.data;
                    if(root.data < small)
                        small = root.data;
                    break;
                case 2:
                    //2 for Searching
                    if(root.data == this.tempno){
                        this.flag1 = 1;
                        System.out.println("Data Found: " + root.data);
                    }
                    break;
                case 3:
                    //3 for Deletion
                    if(root.data == this.tempno){
                        this.deletenode(root,pre);
                    }
                    pre = root;
                    break;
                case 4:
                  if(root.data < smallsub){
                    smallsub = root.data;
                  }
                    break;
            }
            prefix(root.left,option);
            prefix(root.right,option);

        }
    }
    
    int large;
    int small;
    public void largest(Node root){
        large = root.data;
        small = root.data;
        this.prefix(root,1);
        System.out.println("Largest is: " + large);
        System.out.println("Smallest is: " + small);
    }
    
    public int treeHeight(Node root){
       if(root==null)
           return 0;
       return (1+ Math.max(treeHeight(root.left),treeHeight(root.right)));
    }
    
    int flag1;
    int tempno;
    public void search(Node root, int value){
        this.flag1 = 0;
        this.tempno = value;
        this.prefix(root, 2);
        if(flag1 == 0){
            System.out.println("Data not Found!");
        }
    }
    
    public void leveldisplay(Node root, int levelchoice, int level) {
        if(root == null){
            
        }else{
            if(level == levelchoice){
                System.out.println("Data is: " + root.data);
            }
            leveldisplay(root.left,levelchoice,level+1);
            leveldisplay(root.right,levelchoice,level+1);
        }
    }
    
 //   int flag3 = 0;
    int largesub;
    int smallsub;
    public void deletenode(Node root,Node prev){
            //if is leafNode
            if(root.left == null && root.right == null){
                if(prev.data > root.data){
                    prev.left = null;
                }else
                    prev.right = null;
            }else if(root.left == null || root.right ==  null){ //Node with One Child
                if(root.left != null){
                    root.data = root.left.data;
                    root.left = null;
                }else{
                    root.data = root.right.data;
                    root.right = null;
                }
            }else if(root.left != null && root.right !=null){
                smallsub = root.right.data;
                this.prefix(root.right, 4);
                this.tempno = smallsub;
             //   this.prefix(temp, 3);
                root.data = smallsub;
            }
    }
    
}
