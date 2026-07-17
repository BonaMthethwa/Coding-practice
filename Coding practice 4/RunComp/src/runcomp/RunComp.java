
package runcomp;
import oop.example.employee.Employee;
import oop.example.salary.Salary;

public class RunComp {

    
    public static void main(String[] args) {
        Employee emp1=new Employee("211",22.00,12,2);
        Employee emp2=new Employee("212",26.00,22,4);
        Employee emp3=new Employee("213",49.00,32,7);
        
        System.out.println(emp1.displayEmployeeSalary());
        System.out.println(emp2.displayEmployeeSalary());
        System.out.println(emp3.displayEmployeeSalary());
    }
    
}
