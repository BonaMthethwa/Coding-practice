
package testvehicles;
import oop.inheritance.exercise1.car.Car;
import oop.inheritance.exercise1.truck.Truck;
import oop.inheritance.exercise1.vehicle.Vehicle;

public class TestVehicles {

    
    public static void main(String[] args) {
        Vehicle v=new Vehicle();
        Car c=new Car(24,4,1000);
        Truck t= new Truck(4,2000,16, 12000);
        
        System.out.println(c.toString());
        System.out.println();
        System.out.println(t.toString());
    }
    
}
