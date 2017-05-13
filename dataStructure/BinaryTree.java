/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStructure;

/**
 *
 * @author avik
 */
public class BinaryTree <E extends Comparable<E>> implements Tree<E> {

    private Node root;

    public void insertIntoTree(E val) {

        Node insertPos = root;
        Node actInsertPos = insertPos;
        boolean isLeft = false;

        Node node = new Node(val, null, null);
        if (root == null) {
            root = node;
        }
        else{
        while (insertPos != null) {
            actInsertPos = insertPos;
            E getVal=(E) insertPos.getVal();
            if (val.compareTo(getVal)>0) {
                isLeft = true;
                insertPos = insertPos.getlLink();
            } else {
                isLeft = false;
                insertPos = insertPos.getrLink();
            }
        }

        if (isLeft) {
            actInsertPos.setlLink(node);
        } else {
            actInsertPos.setrLink(node);
        }
        }
        

    }
    
    public void display()
    {
        System.out.println("Inorder :");
        inOrderDisplay(root);
         System.out.println("");
                System.out.println("PreOrder :");
        preeOrderDisplay(root);
        System.out.println("");
                System.out.println("PostOrder :");
        postOrderDisplay(root);
        System.out.println("");
        
    }

    public void inOrderDisplay(Node tree) {
        if (tree != null) {
            inOrderDisplay(tree.getlLink());
            System.out.print(" " + tree.getVal());
            inOrderDisplay(tree.getrLink());
        }

    }

    public void postOrderDisplay(Node tree) {
        if (tree != null) {
            postOrderDisplay(tree.getlLink());
            postOrderDisplay(tree.getrLink());
            System.out.print(" " + tree.getVal());
        }

    }

    public void preeOrderDisplay(Node tree) {
        if (tree != null) {
            System.out.print(" " + tree.getVal());
            preeOrderDisplay(tree.getlLink());
            preeOrderDisplay(tree.getrLink());
        }

    }

}
