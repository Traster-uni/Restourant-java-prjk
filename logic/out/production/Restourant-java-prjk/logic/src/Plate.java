/**
 * Created by Tommaso M. Lopedote on 20/07/2021
 * Time: 16:20
 * Project: Restourant-java-prjk
 */

import java.util.Objects;

/**
 * The Plate object is a basic implementation of a dish that could be prepared or served in a restaurant
 */

public class Plate {
    private String name;
    private Integer category;
    private double prize;

    /**
     *  Default empty constructor for the Plate object with no arguments.
     */
    public Plate(){
        name = "";
        category = 0;
        prize = 0;
    }

    /**
     * Default constructor for a Plate object.
     * The selectable categories are labeled numerically from 1 to 4,
     *      1: appetizer, 2: first dishes, 3: second dishes, 4: dessert
     * @param name - the name of the plate.
     * @param prize - the prize of the plate.
     */
    public Plate(String name, Integer selectCategory, double prize){
        this.name = name;
        this.category = selectCategory;
        this.prize = prize;
    }

    /**
     * Plate name getter.
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the category of the dish in question.
     * @return
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * Plate prize getter.
     * @return prize
     */
    public double getPrize() {
        return prize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return name + ";" + category + ";" + prize + ";\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plate plate = (Plate) o;
        return Double.compare(plate.getPrize(), getPrize()) == 0 && getName().equals(plate.getName()) && getCategory().equals(plate.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCategory(), getPrize());
    }
}
