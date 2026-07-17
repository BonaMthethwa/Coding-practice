
package threads;


public class Threads {

    
    public static void main(String[] args) {
        Thread t= Thread.currentThread();
        System.out.println(t.getName() + " started");
        
        t.getPriority();
    }
    
}
