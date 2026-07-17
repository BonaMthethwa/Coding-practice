
package za.tut.bl;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MyThread1 extends Thread {

    @Override
    public void run(){
       for(int i=1; 1<=6; i++){
           if(i==5){
               try {
                   System.out.println("Thread is suspended");
                   sleep(2);
               } catch (InterruptedException ex) {
                   Logger.getLogger(MyThread1.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
           System.out.println(Thread.currentThread().getName() + ": "+ i);
       } 
        
    }
    
}
