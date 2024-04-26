import java.util.Scanner;

class node{
    int val;
    node left;
    node right;
     
//constructor
  public node(int val){
    this.val=val;
    this.right=null;
    this.left=null;
  }
}

public class bst{
 node root;
 
    //constructor
    public bst(){
      this.root=null;

    }
    // insert
  public void insert(int val){
    if(root==null){
      root=new node(val);
    }
    node current= root;
    while(true){
      if(val<current.val)
      {
        if(current.left==null){
          current.left=new node(val);
        }
        current=current.left;
      }else{
          if(current.right==null){
          current.right=new node(val);
        }
       
        current=current.right;
      }
      }

    }
    //longest path
    public int longpath(node N){
      if(N==null){
      return 0;
      }
      int leftdepth=longpath(N.left);
      int rightdepth=longpath(N.right);
      return Math.max(leftdepth,rightdepth)+1;
    }

    public int min(node N){
      if(N==null){
      System.out.println("tree is empty");
    }
    node current=N;
    while(current.left!=null){
      current=current.left;
    }
     return current.val;
    }  



    // searching element
    public boolean search(node N,int target)
    {
  if(N==null){
    return false;
  }
  if (target == N.val)
      return true;
  else if (target < N.val)
      return search(N.left, target);
  else
      return search(N.right, target);
}
// swap left and right
public void swap(node N){
  if (N==null)
   System.out.println("tree is empty");

   swap(N.left);
   swap(N.right);

   node temp=N.left;
   N.left= N.right;
   N.right=temp;
}
 // traversal 
 public void inorder(node N)
 {
 inorder(N.left);{
 System.out.println(N.val+" ");
 inorder(N.right);
 }
}
}

class main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      bst BST=new bst();
      
      int choice;
      do{
        System.out.println("\nBinary Search Tree Operations:");
        System.out.println("1. Insert new node");
        System.out.println("2. Find number of nodes in the longest path from root");
        System.out.println("3. Find minimum data value in the tree");
        System.out.println("4. Swap left and right pointers of each node");
        System.out.println("5. Search a value");
        System.out.println("6. Inorder traversal");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        choice = s.nextInt();

        switch (choice) {
          case 1:
               System.out.println("enter value to insert");
               int value =s.nextInt();
               BST.insert(value);
               System.out.println("Node inserted");
            break;
          case 2:
               int longestp=BST.longpath(BST.root);
               System.out.println("NO OF NODES IN THE LOMGEST PATH from root:"+longestp);
            break;
          
          case 3:
              int minval=BST.min(BST.root);
              System.out.println("minimun data value ="+minval);
              break;
          case 4:
            BST.swap(BST.root);
            System.out.println("Right and Left pointer swapped succesfully");
            break;
          case 5:
            System.out.println("enter value to search");
            int Value=s.nextInt();
            boolean isFound=BST.search(BST.root, Value);
           break;
          
          case 6:
           System.out.println("inorder Traversal:");
          BST.inorder(BST.root);
          break;

          case 0:
          System.out.println("Exiting");

          break;
      
     default:
         System.out.println("invalid choice") ;


             
        }
        
        }
        while(choice!=0);
    }
  }



