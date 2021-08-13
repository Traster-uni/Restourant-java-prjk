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
     * @param plateName - plate name
     * @param category - category
     * @param restaurant - our restaurant
     */
    protected void addPlate(String plateName, Integer category, Restaurant restaurant){
        ArrayList<ArrayList<Plate>> menu = restaurant.getMenuArray();
        ArrayList<Plate> categoryMenu = menu.get(category-1);
        for (int i = 0; i<categoryMenu.size(); i++){
            Plate currentPlate = categoryMenu.get(i);
            if (currentPlate.getName().toLowerCase().equals(plateName.toLowerCase()))
            {
                order.add(currentPlate);
            }
        }
    }

    /**
     * Delete the dish to the order list.
     * @param plateName - plate name.
     */
    protected void deletePlate(String plateName){
        for (int i=0; i<order.size(); i++){
            Plate currentPlate = order.get(i);
            if (currentPlate.getName().toLowerCase().equals(plateName.toLowerCase()))
            {
                order.remove(currentPlate);
            }
        }
    }

    /**
     * Submit the order in the order table and cancel the order.
     * @param restaurant - our restaurant
     */
    protected void endOrder(Restaurant restaurant){
        order.setStatusOrder("");
        restaurant.addOrderDict(super.getServedTable(), order);
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
