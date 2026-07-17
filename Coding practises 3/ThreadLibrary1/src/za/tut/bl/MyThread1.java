
package za.tut.bl;


public class MyThread1 implements Runnable {
    @Override
    public void run(){
       for(int x=0;x<5;x++){
           System.out.println("Hello "+(x+1));
       } 
    }
    
}
