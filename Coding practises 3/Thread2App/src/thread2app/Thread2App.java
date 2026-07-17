
package thread2app;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.Thread2Class;

public class Thread2App {

    public static void main(String[] args)  {
        Thread2Class t1= new Thread2Class("thread1");
        //Thread2Class t2= new Thread2Class("thread2");
        
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread2App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Thread is done");
    }
    
}
