
package studentapp;

import java.sql.*;
import java.util.*;
import za.tut.bl.StudentInterface;
import za.tut.bl.StudentManager;
import za.tut.entity.Student;
public class StudentApp {

    
    public static void main(String[] args) throws SQLException {
       Student student;
       
       int studNum;
       StudentManager sm=new StudentManager("jdbc:mysql://localhost:3306/student?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "991113@Zama");
       int option;
       option=displayOption();
       while(option !=7){
           switch(option){
               case 1:
                   //add 
                   student=addStudent();
                   //add
                   sm.add(student);
                   break;
                   
               case 2:
                   //remove
                   studNum=getStudentNum();
                   sm.remove(studNum);
                   break;
                   
               case 3:
                  //update
                   student=updateStudent();
                   sm.update(student);
                   break;
                   
               case 4:
                   //get 
                   studNum=getStudentNum();
                   student=sm.get(studNum);
                   display(student);
                   break;
                   
               case 5:
                   //get All
                   List<Student> stud=sm.getAll();
                   displayStudent(stud);
                   break;
                   
               case 6:
                   //get statitics
                   int numStudents=sm.getCnt();
                   int lowestMark=sm.getLowestTestMark();
                   int highestMark=sm.getHighestTestMark();
                   int numDevices=sm.getNumComputingDevices();
                   int ageAvg=sm.getAgeAvarage();
                   int testAvg=sm.getTestAvarage();
                   int numPassed=sm.getNumPassed();
                   int numFailed=sm.getNumFailed();
                   int fPassed=sm.getNumPassed('F');
                   int fFailed= sm.getNumFail('F');
                   int mPassed=sm.getNumPassed('M');
                   int mFailed=sm.getNumFail('M');
                   List<Student> failed=sm.getFailed();
                   List<Student> passed=sm.getPassed();
                   
                   statistics(numStudents, lowestMark, highestMark, numDevices, ageAvg, testAvg, numPassed, numFailed, fPassed, fFailed, mPassed, mFailed, failed, passed);
                   break;
                   
               case 7:
                   
                   break;
                   
               default:
                   System.out.println("Invalid option! Select again");
            
           }
           option=displayOption();
       }
       
       
       
       
    }
    private static int displayOption(){
        int option;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter option to perfom : \n 1. Add student. \n 2. Change marks. \n 3. Remove student. \n 4. Search student. \n 5. Display students \n 6. Statitics");
        option=sc.nextInt();
        return option;
        
    }
    
    private static Student addStudent(){
        Student student;
        Scanner sc=new Scanner(System.in);
        String name, surname;
        int studNo, numDevices, age, testMark;
        char gender;
        
        System.out.println("Enter name");
        name=sc.nextLine();
        System.out.println("Enter surname");
        surname=sc.nextLine();
        System.out.println("Enter student number");
        studNo=sc.nextInt();
        System.out.println("Enter gender M/F");
        sc.nextLine();
        gender=sc.nextLine().charAt(0);
        System.out.println("Enter age");
        age=sc.nextInt();
        System.out.println("Enter number of devices");
        numDevices=sc.nextInt();
        System.out.println("Enter test mark %");
        testMark=sc.nextInt();
        
        student=new Student(name, surname, studNo, gender, age, numDevices, testMark);
        return student;
        
    }
    private static Student updateStudent(){
       int studNo, testMark;
       Scanner sc=new Scanner(System.in);
       Student student;
       System.out.println("Enter student number to update");
       studNo=sc.nextInt();
       System.out.println("Enter test mark to update");
       testMark=sc.nextInt();
       student=new Student();
       student.setStudNo(studNo);
       student.setTestMarkPerc(testMark);
       
        return student;
        
    }
    private static void display(Student student){
      System.out.println(student+ "\n");  
    }
    
    private static void displayStudent(List<Student> students){
        System.out.println(students + "\n");
    }
    
    private static Integer getStudentNum(){
        int studNum;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter student number");
        studNum=sc.nextInt();
        return studNum;
        
    }
    private static void statistics(int countStudents, int lowestMark, int highestMark, int numDevices, int ageAvg, int testAvg, int numPassed, int numFailed, int fPassed, int fFailed, int mPassed, int mFailed, List<Student> failed, List<Student> passed ){
     System.out.println("Number of students :"+ countStudents);
     System.out.println("Lowest mark :"+ lowestMark);
     System.out.println("Highest mark :"+ highestMark);
     System.out.println("Number of devices :"+ numDevices);
     System.out.println("Avarage of age is :"+ageAvg);
     System.out.println("Test avarage is :"+testAvg);
     System.out.println("Number of students who passes :"+numPassed);
     System.out.println("Number of students who failed :"+ numFailed);
     System.out.println("Number of females who passed :"+ fPassed);
     System.out.println("Number of females who failed :"+fFailed);
     System.out.println("Number of males who passed :"+mPassed);
     System.out.println("Numbner of males who failed :"+ mFailed);
     System.out.println("Students who failed: "+ failed);
     System.out.println("Students who passed :"+ passed);
     
     
     
     
    } 
}
