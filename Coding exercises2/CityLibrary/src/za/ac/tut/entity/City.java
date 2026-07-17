
package za.ac.tut.entity;

 
public class City {
    private int id;
    private String name;
    private int population;
    private Mayor mayor;

    public City() {
    }

    public City(int id, String name, int population, Mayor mayor) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.mayor = mayor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Mayor getMayor() {
        return mayor;
    }

    public void setMayor(Mayor mayor) {
        this.mayor = mayor;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name=" + name + ", population=" + population + ", mayor=" + mayor + '}';
    }
            
            
    
}
