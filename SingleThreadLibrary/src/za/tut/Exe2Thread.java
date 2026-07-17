
package za.tut;

import za.ac.tut.ThreadClass;


public class Exe2Thread implements Runnable{
    ThreadClass tc;

    public Exe2Thread(ThreadClass tc) {
        this.tc = tc;
    }
    
    
    @Override
    public void run() {
        incrementValue();
        System.out.println(Thread.currentThread().getName()+ " started");
    }
    
    public synchronized void incrementValue(){
        tc.incrementValue();
        System.out.println(Thread.currentThread().getName()+ ": "+ tc.getValue());
    }
}
