/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import database.ConnectionJDBC;
import java.sql.Connection;

/**
 *
 * @author avik
 */
public class Main {
    
    public static void main(String args[])
    {
        Connection conn=ConnectionJDBC.connectDataBase();
        System.out.println("Database connected");
        
        
        int elements[]={4,5,3,8,9,6,7,9,2,1,0};
        MergeSort m=new MergeSort();

        m.mergeSort(elements,0, elements.length-1);
        
                String elements1="";
        for(int i=0;i<elements.length;i++)
            elements1=elements1+" , "+elements[i];
        System.out.println("After " + elements1);
    }
    
}
