
package za.ac.tut;


public class PersonThread implements Runnable{
    private Person person;

    public PersonThread(Person person) {
        this.person = person;
    }

    
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        
        for(int x=0; x<5; x++){
            incrementAge();
            
        }
        
        System.out.println(Thread.currentThread().getName() +" finished");
        
        
    }
    
    private  synchronized void incrementAge(){
        person.incrementAge();
        System.out.println(Thread.currentThread().getName() + ": " + person.getAge());
        
    }

}
