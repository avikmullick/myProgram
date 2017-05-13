/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprogram;

/**
 *
 * @author avik mullick
 */
public class FirstProgram {

    /**
     * @param args the command line arguments
     */
    static 
    {
      System.out.println("Static Block");  
    }
    FirstProgram()
            {
               System.out.println("Call of Constructor");
            }
    
        FirstProgram(int  i)
            {
               System.out.println("Call of Constructor"+i);
            }
    
    {
        System.out.println("I Block");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // FirstProgram abc=new  FirstProgram();
         
         FirstProgram[][] abc1 = new FirstProgram[3][];
         abc1[0] = new  FirstProgram[6];
         
         System.out.println("Array Length"+abc1[0].length+abc1.length);
         
         System.out.println(Long.toString(2345l, 2));
         
        // abc=new  FirstProgram(10);
        //final byte a=10;
        //boolean b=Boolean.TRUE;
        //System.out.println("First Program Size of Byte");
    }
    
}
