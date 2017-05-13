/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;
import java.lang.Runnable;
/**
 *
 * @author avik
 */
public class TestThreadRunnable {

    public static void main(String args[]) throws InterruptedException {
        for (int i = 30; i < 40; i++) {
            System.out.println("Main Beg :" + i);
        }
        System.out.println("********");
        Runnable thread1 = new ThreadRun1();
        
        Thread threadRun1 =new Thread(thread1);
        threadRun1.start();
        
        Runnable thread2 = new ThreadRun2();
        Thread threadRun2 =new Thread(thread2);
        threadRun2.start();
        
        threadRun1.join();

        for (int i = 20; i < 30; i++) {
            System.out.println("Main End :" + i+" Thread Id"+Thread.currentThread().getId());
        }

    }

}

class ThreadRun1 implements Runnable{
    

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("Thread1 :" + i+" Thread Id"+Thread.currentThread().getId());
            Thread.yield();
        }

    }

}

class ThreadRun2 implements Runnable {

    @Override
    public void run() {

        for (int i = 10; i < 20; i++) {
            System.out.println("Thread2 :" + i+" Thread Id"+Thread.currentThread().getId());
        }

    }

}
