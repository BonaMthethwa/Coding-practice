
package threadapp;
import za.ac.tut.bl.Numbers;
import za.ac.tut.bl.Numbers2;

public class ThreadApp {

   
    public static void main(String[] args) {
       Numbers n1= new Numbers();
       Numbers2 n2=new Numbers2();
       
       n1.start();
       n2.start();
    }
    
}
