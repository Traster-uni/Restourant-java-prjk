import java.util.ArrayList;

public class Employee {
    private Integer servedTable;
    private ArrayList<Plate> order;

    /**
     * Default empty constructor for the Employee object with no arguments.
     */
    public Employee() {
        servedTable = 0;
        order = new ArrayList<>();
    }

    /**
     * Default empty constructor for the Employee object.
     * @param initialServedTable - the number of the served table.
     */
    public Employee(Integer initialServedTable){
        servedTable = initialServedTable;
        order = new ArrayList<>();
    }

    /**
     * Served table number getter.
     * @return served table
     */
    public Integer getServedTable() {
        return servedTable;
    }

    /**
     * Order getter.
     * @return order
     */
    public ArrayList<Plate> getOrder() {
        return order;
    }

    /**
     * Sets a new served table.
     * @param number - served table
     */
    public void setServedTable(Integer number){
        servedTable = number;
    }
}
