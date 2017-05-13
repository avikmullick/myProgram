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
public class Main {
    
    public static void main(String args[])
    {
     /*   DoublyLinkedList dd=new DoublyLinkedList();
        dd.insertNodeBegining(12);
        dd.insertNodeBegining(13);
        dd.insertNodeBegining(14);
        dd.insertNodeBegining(15);
        dd.insertNodeBegining(16);
        dd.insertNodeEnd(10);
        
        dd.displayLinkedList();*/
        
        System.out.println("Binary Tree");
        BinaryTree<String> bb=new BinaryTree<String>();
        bb.insertIntoTree("50");
        bb.insertIntoTree("15");
        bb.insertIntoTree("62");
        bb.insertIntoTree("5");
        bb.insertIntoTree("20");
        bb.insertIntoTree("58");
        bb.insertIntoTree("91");
        bb.insertIntoTree("3");
        bb.insertIntoTree("8");
        bb.insertIntoTree("37");
        bb.insertIntoTree("60");
        bb.insertIntoTree("24");
        
        bb.display();
        
    }
        
}
