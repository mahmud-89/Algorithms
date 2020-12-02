/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.BST;

/**
 *
 * @author promise
 */
import DataStructure.Queues.GenericQueue;

public class BSTRecursive {

    private Node root;

    public BSTRecursive() {
        this.root = null;
    }

    public BSTRecursive(int val) {
        this.root = new Node(val);
    }
    /**
     * .....................manipulation......................
     * @param val 
     */

   public void insert(int val){
       this.root = inserting(this.root,val);
   }
   
   private Node inserting(Node root,int val){
       if(root == null){
           root = new Node(val);
           return root;
       }
       else if(val > root.val){
           root.right = inserting(root.right, val);
       }
       else{
           root.left = inserting(root.left, val);
       }
       return root;
       
   }

    public Node search(Node root,int val){
        if(root.val == val || root == null){
            return root;
        }
        else if(val > root.val){
           return  search(root.right, val);
        }
        else {
            return search(root.left, val);
        }
    }
    
    /**
     * .................Utilities....................
     * @param root
     * @return 
     */
    
    public Node getMin(Node root){
        if(root.left == null){
            return root;
        }else return getMin(root.left);
    }
    
    public Node getMax(Node root){
        if(root.right == null){
            return root;
        }
        else{
            return getMax(root.right);
        }
    }
    
    public int getTreeHeight(Node root){
      if(root == null){
          return -1;
      }
      int left = getTreeHeight(root.left);
      int right = getTreeHeight(root.right);
      return Integer.max(left, right) + 1;
    }

    public Node getRoot() {
        return this.root;
    }
    
    /**
     * .........................Traversing the tree......................
     * @param args 
     */
    //LevelOrder (BFS)
    public void levelorderBFS(Node root){
        GenericQueue<Node> queue = new GenericQueue<>();
        if(root == null){
            System.out.println("empty tree!!!");
            return;
        }
        queue.enqueue(root);
        while(!queue.isEmpty()){
            Node visited = queue.dequeue();
            System.out.print(visited.val+" ");
            
            if(visited.left != null){
                queue.enqueue(visited.left);
            }
            if(visited.right != null){
                queue.enqueue(visited.right);
            }
        }
        System.out.println("");
    }
    
    //preorder(DFS)
    public void preorderDFS(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preorderDFS(root.left);
        preorderDFS(root.right);
    }
    
    //in-order(DFS)
    public void inorderDFS(Node root){
        if(root == null){
            return;
        }
        inorderDFS(root.left);
        System.out.print(root.val+" ");
        inorderDFS(root.right);
    }
    
    //post-order(DFS)
    public void postorderDFS(Node root){
        if(root == null){
            return;
        }
        postorderDFS(root.left);
        postorderDFS(root.right);
        System.out.print(root.val+" ");
    }
    
    public static void main(String[] args) {
        BSTRecursive bst = new BSTRecursive();
         /*
              50 
           /     \ 
          30      130 
         /  \    /   \ 
       20   40  127  135 
            /
           35
        # LRD --> L-left --> R-right --> D-root(visited or process data or printing data)
        
        pre - 50 30 20 40 35 130 127 135 (D->L->R)
        in - 20 30 35 40 50 127 130 135 (L->D->R)
        post - 20 35 40 30 127 135 130 50 (L->R->D)
        */
         
        bst.insert(50);
        bst.insert(130);
        bst.insert(135);
        bst.insert(127);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(35);

        int search = 20;
        System.out.println(bst.search(bst.getRoot(), search) != null ? 
                String.format("%d is found", search):String.format("%d is not found", search));
        System.out.println("minimum value is: "+ bst.getMin(bst.getRoot()).val);
        System.out.println("maximum value is: "+ bst.getMax(bst.getRoot()).val);
        System.out.println("height of the tree is : "+ bst.getTreeHeight(bst.getRoot()));
        System.out.println("");
        
        //printing levelorder
        System.out.print("level traversing by bfs: ");
        bst.levelorderBFS(bst.getRoot());
        
        //printing preorder
        System.out.print("pre-order traversing : ");
        bst.preorderDFS(bst.getRoot());
        System.out.println();
        
        //printing inorder
        System.out.print("in-order traversing : ");
        bst.inorderDFS(bst.getRoot());
        System.out.println("");
        
         //printing post - order
        System.out.print("post-order traversing : ");
        bst.postorderDFS(bst.getRoot());
        System.out.println("");
        
    }
}
