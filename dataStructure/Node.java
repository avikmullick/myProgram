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
public class Node <E> {
    private E nodeValue;
    private Node lLink;
    private Node rLink;
    
    public Node(E val,Node lLink,Node rLink)
    {
        this.nodeValue=val;
        this.lLink=lLink;
        this.rLink=rLink;
    }
    
    public Node(E val,Node rLink)
    {
        this.nodeValue=val;
        this.lLink=null;
        this.rLink=rLink;
    }
    
    public void setVal(E val)
    {
        this.nodeValue=val;
    }
    
    public E getVal()
    {
        return nodeValue;
    }
    
    public void setrLink(Node node)
    {
        this.rLink=node;
    }
    public void setlLink(Node node)
    {
        this.lLink=node;
    }
    
    public Node getrLink()
    {
        return rLink;
    }
    public Node getlLink()
    {
         return lLink;
    }
    
}
