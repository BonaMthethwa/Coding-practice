
package za.ac;


public class Thread2Class extends Thread{
    private String name;

    public Thread2Class(String name) {
        this.name = name;
    }
    
    
@Override
    public void run(){
    for(int i=0; i<5; i++){
        System.out.println(name + " hello world");
       //Thread2Class.yield();
    }
}    
}
