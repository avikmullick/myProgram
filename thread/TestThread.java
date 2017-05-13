/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

/**
 *
 * @author avik
 */
public class TestThread {
    
    public static void main(String args[])
    {
         for(int i=30;i<40;i++)
            System.out.println("Main Beg :"+i);
        System.out.println("********");     
        Thread1 thread1= new Thread1();
        thread1.start();
        
        Thread2 thread2= new Thread2();
        thread2.start();
        
        for(int i=20;i<30;i++)
            System.out.println("Main End :"+i);
        
        
    }
    
}

class Thread1 extends Thread
{

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        
        for(int i=0;i<10;i++)
            System.out.println("Thread1 :"+i);
        
    }
    
}

class Thread2 extends Thread
{

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        
        for(int i=10;i<20;i++)
            System.out.println("Thread2 :"+i);
        
    }
    
}
