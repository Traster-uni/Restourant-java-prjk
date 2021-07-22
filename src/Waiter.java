import java.util.ArrayList;

public class Waiter extends Employee{
    private ArrayList<Plate> order;

    public Waiter() {
        super();
        order = new ArrayList<>();
    }

    public Waiter(Integer initialServedTable){
        super(initialServedTable);
        order = new ArrayList<>();
    }

    public void addPlate(String plateName, Integer category, Restaurant restaurant){
        ArrayList<Plate> menu = restaurant.getMenuArray();
        for (int i = 0; i<menu.size(); i++){
            Plate currentPlate = menu.get(i);
            if (currentPlate.getName().toLowerCase().equals(plateName.toLowerCase()))
            {
                order.add(currentPlate);
            }
        }
    }

    public void deletePlate(String plateName){
        for (int i=0; i>order.size(); i++){
            Plate currentPlate = order.get(i);
            if (currentPlate.getName().toLowerCase().equals(plateName.toLowerCase()))
            {
                order.remove(currentPlate);
            }
        }
    }

    public void endOrder(){

    }
}
