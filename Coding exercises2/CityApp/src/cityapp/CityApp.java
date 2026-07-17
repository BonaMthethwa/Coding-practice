
package cityapp;
import za.ac.tut.bl.CityInterface;
import za.ac.tut.bl.CityManager;
import za.ac.tut.entity.City;
import za.ac.tut.entity.Mayor;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CityApp {

   
    public static void main(String[] args) throws SQLException {
       City city;
       List<City> cities;
       Mayor mayor;
       Scanner sc=new Scanner(System.in);
      //Strings sql
      String addCitySql="Insert into citytbl(id, name, population)"+"values (?,?,?)";
      String addMayorSql= "Insert into mayor(id, name,surname, city_id) "+"values (?, ?, ?, ?)";
      String updateSql="Update mayor Set"+"mayor.city_id=? mayor.name=?, mayor.surname=? where mayor.";
      String deleteCitySql="Delete from citytbl "+"where id=?"; 
      String deleteMayorSql="Delete from mayor"+"where city_id=?";
      String getCitySql="Select citytbl.id, citytbl.name, citytbl.population, mayor.id AS mayor_id, mayor.name AS mayor_name, mayor.surname AS mayor_surname, mayor.city_id AS mayor_city_ud "
                           +"from citytbl"+"Inner join mayor on mayor.city_id=citytbl.id"+"where city.id=?" ;
      
      String getAllCitiesSql="Select citytbl.id, city.name, city.population, mayor.id AS mayor_id, mayor.name AS mayor.surname AS mayor_surname"
                               +"from citytbl"+ "inner join mayor on mayor.city_id=citytbl.id" ;
       
       
       try{
           CityManager cm= new CityManager("jdbc:mysql://localhost:3306/city?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "991113@Zama");
           int option;
            option=displayOption();
           while(option != 7){
           switch(option){
               case 1:
                   city=addCity();
                  cm.add(city, addCitySql, addMayorSql);
                  
                   break;
                   
               case 2:
                   city=changeMayor();
                   cm.update(city, updateSql);
                   break;
                   
               case 3:
                   int cityId=getId();
                   cm.delete(cityId, deleteCitySql);
                   cm.delete(cityId, deleteMayorSql);
                   
                   break;
                   
               case 4:
                    cityId=getId();
                   city= cm.get(cityId, getCitySql);
                   if(city==null){
                       System.out.println("There is no city");
                   }else{
                    display(city);}
                    
                   break;
                   
               case 5:
                   cities=cm.getAll(getAllCitiesSql);
                   if(cities== null){
                       System.out.println("No cities");
                   }else{
                   displayCities(cities);}
                   break;
                   
               default:
                   System.out.println("Invalid option!!. Enter valid option");
           }
           option=displayOption();
       }
       } catch (SQLException ex) {
            Logger.getLogger(CityApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static int displayOption(){
        Scanner sc=new Scanner(System.in);
        int option;
        System.out.println("Enter option to execute: \n 1.Add city \n 2.Update mayor \n 3. Delete city \n 4.Get city information \n 5.Get all cities ");
        option=sc.nextInt();
        return option;
        
    } 
    
    private static City addCity(){
       Scanner sc=new Scanner(System.in);
       String name, m_name, m_surname;
       int population, id, m_id;
       Mayor mayor;
       City city;
       
       System.out.println("Enter city id");
       id=sc.nextInt();
       System.out.println("Enter city name ");
       name=sc.nextLine();
       sc.nextLine();
       System.out.println("Enter city population");
       population=sc.nextInt();
       
       System.out.println("Enter mayor id");
       m_id=sc.nextInt();
       sc.nextLine();
       System.out.println("Enter mayor name");
       m_name=sc.nextLine();
       System.out.println("Enter mayor surname ");
       m_surname=sc.nextLine();
       
       mayor=new Mayor(m_id, m_name, m_surname);
       city=new City(id, name, population, mayor);
       
        return city;
        
    }
    private static int getId(){
        Scanner sc=new Scanner(System.in);
        int id;
        System.out.println("Enter id");
        id=sc.nextInt();
        return id;
        
    } 
    
  
    private static void display(City city){
        System.out.println(city+"\n");
    }
    
    private static void displayCities(List<City> cities){
        System.out.println(cities+"\n");
    }
    
    private static City changeMayor(){
        Scanner sc=new Scanner(System.in);
        String m_name, m_surname;
        
        System.out.println("Enter city id");
        int c_id=sc.nextInt();
        System.out.println("Enter mayor name");
        m_name=sc.nextLine();
        System.out.println("Enter mayor surname");
        m_surname=sc.nextLine();
        
        Mayor mayor=new Mayor();
        mayor.setName(m_name);
        mayor.setSurname(m_surname);
        
        City city=new City();
        city.setId(c_id);
        city.setMayor(mayor);
        return city;
        
    }
}
