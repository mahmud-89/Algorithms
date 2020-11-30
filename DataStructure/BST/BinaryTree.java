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
class Node {

    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTree {

    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int key) {
        this.root = new Node(key);
    }

    public void insert(int val) {
       Node newNode = new Node(val);
       if(root == null){
           root = newNode;
       }
       else{
           Node currentNode = root;
           while(true){
               if(val > currentNode.val){
                   if(currentNode.right == null){
                       currentNode.right = newNode;
                       return;
                   }
                   currentNode = currentNode.right;
               }else{
                   if(currentNode.left == null){
                       currentNode.left = newNode;
                       return;
                   }
                   currentNode = currentNode.left;
               }
           }
       }
    }
    
    public boolean lookup(int val){
        Node currentNode = root;
        while(currentNode != null){
            if(currentNode.val == val) return true;
            if(val > currentNode.val){
                currentNode = currentNode.right;
            }else currentNode = currentNode.left;
        }
        return false;
    }

    public boolean remove(int val){
       return false;
    }
    
    public void traverse() {
        if (root != null) {
            System.out.println("root: " + root.val);
        }
        
        Node left = root.left;
        Node right = root.right;
        
        System.out.print("left nodes are: ");
        while (left != null) {
            System.out.print(left.val+" ");
            left = left.left;
        }
        System.out.println("");
        
        System.out.print("right nodes are : ");
        while (right != null) {
            System.out.print(right.val+" ");
            right = right.right;
        }
        System.out.println("");

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(20);
        bt.insert(10);
        bt.insert(30);
        bt.insert(40);
        bt.insert(11);
        
        bt.traverse();
        System.out.println(bt.lookup(40));
    }
}
