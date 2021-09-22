import java.util.ArrayList;
import java.util.HashMap;

public class Waiter extends Employee{
    private Order<Plate> order;

    /**
     * Default constructor for Waiter object calls
     * super class constructor by default with no arguments.
     */
    public Waiter() {
        super();
        order = new Order<>();
    }

    /**
     * Default constructor for Waiter object calls
     * super class constructor by default.
     * @param initialServedTable - the served table.
     */
    public Waiter(Integer initialServedTable){
        super(initialServedTable);
        order = new Order<>();
    }

    /**
     * Adds the dish to the order list.
     * @param plate - plate name
     */
    protected void addPlate(Plate plate){
        order.add(plate);
    }

    /**
     * Delete the dish to the order list.
     * @param plate - plate.
     */
    protected void deletePlate(Plate  plate){
        for (int i=0; i<order.size(); i++){
            Plate currentPlate = order.get(i);
            if (currentPlate.getName() == plate.getName())
            {
                order.remove(currentPlate);
                break;
            }
        }
    }

    /**
     * Submit the order in the order table and cancel the order.
     * @param restaurant - our restaurant
     */
    protected void endOrder(Restaurant restaurant){
        order.setStatusOrder("ready");
        restaurant.addOrderDict(getServedTable(), order);
        order = new Order<>();
    }

    /**
     * Sets a new served table.
     * @param num - served table number
     */
    public void setServedTable(Integer num) {
        super.setServedTable(num);
    }

    public ArrayList<Plate> getOrder() {
        return order;
    }

}