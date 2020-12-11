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
public class Node {

    public int val;
    public Node left, right;

    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}
