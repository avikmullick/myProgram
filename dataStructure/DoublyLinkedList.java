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
public class DoublyLinkedList implements LinkedList {

    private Node headNode;

    @Override
    public void insertNodeBegining(int val) {

        Node node;
        if (headNode == null) {
            node = new Node(val, null, null);
        } else {
            //New Node
            node = new Node(val, null, headNode);
            //Previous Node
            headNode.setlLink(node);
        }
        headNode = node;
    }

    @Override
    public void displayLinkedList() {
        Node traversal = headNode;

        while (traversal != null) {
            System.out.println(" " + traversal.getVal());
            traversal = traversal.getrLink();
        }
    }

    @Override
    public void insertNodeEnd(int val) {
        Node node;
        Node traversal = headNode;
        if (headNode == null) {
            node = new Node(val, null, null);
        } else {

            while (traversal.getrLink() != null) {
                traversal = traversal.getrLink();
            }
            node = new Node(val, traversal, null);
            traversal.setrLink(node);
        }
    }

}
