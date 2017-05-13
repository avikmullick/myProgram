/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author avik
 */
class Producer implements Runnable {

    public int[] buffer;

    Producer() {
        buffer = new int[4];
    }

    @Override
    public void run() {
        produce();
    }
    
    private void bufferFull()
    {
                synchronized (this) {
            //Buffer Full
            while (buffer[3] != 0)
                try {
                    System.out.println(Thread.currentThread().getName()+buffer[3]);
                    this.wait();
                } catch (InterruptedException e) {
                }
        }
    }

    private void produce() {

        for (int i = 1; i <= 20; i++) {
            for (int j = 0; j < 4; j++) {
                synchronized (this) {
                    buffer[j] = i+j;
                    System.out.println(Thread.currentThread().getName() + " -- " + buffer[j]+" -- "+j);
                    if (j == 0) {
                        this.notify(); //Notify Consumer that Producer have produced the data
                    }
                }
                bufferFull();
            }
        }
    }

}

class Consumer implements Runnable {

    private Producer p;

    Consumer(Producer p) {
        this.p = p;
    }

    @Override
    public void run() {

        consume();

    }

    private void consume() {
         bufferEmpty();
       
           for (int i = 1; i <= 20; i++) {
        synchronized (p) {
            for (int j = 3; j >= 0; j--) {
                if (p.buffer[j] != 0) {
                    //Consume
                    System.out.println(Thread.currentThread().getName() + " -- " + p.buffer[j] + " -- Consumed " + j);
                    p.buffer[j] = 0;
                    if (j == 3) {
                        p.notify(); //Notify Producer
                    }
                    break;
                }
            }

        }
           }
    }
    
    private void bufferEmpty()
    {
        synchronized (p) {
            //Buffer Empty
            while (p.buffer[0] == 0)
                try {
                    System.out.println(Thread.currentThread().getName()+p.buffer[0]);
                    p.wait();
                } catch (InterruptedException e) {
                }
        }        
    }

}

public class ProducerConsumer {

    public static void main(String args[])
    {
        Producer p=new Producer();
        Consumer c=new Consumer(p);
        Thread producer =new Thread(p);
        producer.setName("Producer");
        Thread consumer =new Thread(c);
        consumer.setName("Consumer");
        producer.start();
        consumer.start();
        
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("** End **");
        
    }
}
