
package za.ac.tut;


public class ThreadClass {
    private int value;

    public ThreadClass() {
    }

    public ThreadClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public void incrementValue(){
        value++;
    }
}
