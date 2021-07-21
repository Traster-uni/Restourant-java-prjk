/**
 * Created by Tommaso M. Lopedote on 20/07/2021
 * Time: 16:20
 * Project: Restourant-java-prjk
 */

/**
 * The Plate object is a basic implementation of a dish that could be prepared or served in a restaurant
 */

public class Plate {
    private String name;
    private double prize;

    /**
     *  Default empty constructor for the Plate object with no arguments.
     */
    public Plate(){
        name = "";
        prize = 0;
    }

    /**
     * Default constructor for a Plate object.
     * @param name - the name of the plate.
     * @param prize - the prize of the plate.
     */
    public Plate(String name, double prize){
        this.name = name;
        this.prize = prize;
    }

    /**
     * Plate name getter.
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Plate prize getter.
     * @return prize
     */
    public double getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "name='" + name + '\'' +
                ", prize=" + prize +
                '}';
    }
}
