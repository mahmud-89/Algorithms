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
public interface IBST {

    void insert(int value);

    Node search(int value);

    Node getMin(Node root);

    Node getMax(Node root);

    int getTreeHeight(Node root);

    Node getRoot();

    boolean isBST(Node root);

    public void levelorderBFS(Node root);

    public void preorderDFS(Node root);

    public void inorderDFS(Node root);

    public void postorderDFS(Node root);
}
