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
    String name = "promise";
    private String age = "20";

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

    public void insert(int val) {
        this.root = insertRec(root, val);
    }

    private Node insertRec(Node root, int val) {
        if(root == null){
            root = new Node(val);
            return root;
        }
        else if(val > root.val){
            root.right = insertRec(root.right, val);
        }
        else{
            root.left = insertRec(root.left, val);
        }
        return root;
    }

    public Node search(Node root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        else if (val > root.val){
            return search(root.right, val);
        }
        else return search(root.left, val);
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
    
    public void levelOrderBFS(Node root){
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
        
    

    public static void main(String[] args) {
        BSTRecursive bt = new BSTRecursive();
        bt.insert(50);
        bt.insert(130);
        bt.insert(135);
        bt.insert(127);
        bt.insert(30);
        bt.insert(20);
        bt.insert(40);
        bt.insert(35);

        int search = 20;
        System.out.println(bt.search(bt.getRoot(), search) != null ? 
                String.format("%d is found", search):String.format("%d is not found", search));
        System.out.println("minimum value is: "+ bt.getMin(bt.getRoot()).val);
        System.out.println("maximum value is: "+ bt.getMax(bt.getRoot()).val);
        System.out.println("height of the tree is : "+ bt.getTreeHeight(bt.getRoot()));
        System.out.println("");
        System.out.print("level traversing by bfs: ");
        bt.levelOrderBFS(bt.getRoot());
    }
}
