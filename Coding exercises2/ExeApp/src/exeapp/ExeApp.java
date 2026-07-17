
package exeapp;
import za.tut.Producer;
import za.tut.ProducerThread;
import java.util.*;

public class ExeApp {

    
    public static void main(String[] args) {
      
        ProducerThread pt= new ProducerThread("Thread 1");
        ProducerThread pt1= new ProducerThread("Thread 2");
        ProducerThread pt2= new ProducerThread("Thread 3");
        
        pt.start();
        pt1.start();
        pt.start();
    }
    
}
