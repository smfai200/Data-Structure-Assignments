public class Node {
    Node left,right,temp,cur,pre = null;
    int data;
    int flag;
    
    public void insert(Node root, int value){
        if(root == null){
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
    }
