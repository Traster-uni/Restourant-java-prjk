import java.util.ArrayList;

public class Employee {
    private int servedTable;
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
    public Employee(int initialServedTable){
        servedTable = initialServedTable;
        order = new ArrayList<>();
    }

    /**
     * Served table number getter.
     * @return served table
     */
    public int getServedTable() {
        return servedTable;
    }

    /**
     * Order getter.
     * @return order
     */
    public ArrayList<Plate> getOrder() {
        return order;
    }
}
