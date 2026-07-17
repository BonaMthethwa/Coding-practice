
package ruunable;
import za.ac.tut.ThreadClass;
import za.tut.Exe2Thread;

public class Ruunable {

     
    public static void main(String[] args) {
        
        //common resource
        ThreadClass tc= new ThreadClass();
        
        //runnable
        Exe2Thread et= new Exe2Thread(tc);
        
        //Threads
        Thread t1= new Thread(et);
        Thread t2=new Thread(et);
        Thread t3= new Thread(et);
        
        //start threads
        t1.start();
        t2.start();
        t3.start();
        
    }
    
}
