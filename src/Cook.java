import java.util.ArrayList;
import java.util.HashMap;

public class Cook extends Employee{
    private String cookedDirectory;
    private ArrayList<Plate> orderToPrepare;
    private ArrayList<Plate> orderReady;

    public Cook() {
        cookedDirectory = "";
        orderToPrepare = new ArrayList<>();
        orderReady = new ArrayList<>();
    }

    public void setServedTable(Integer num){
        super.setServedTable(num);
    }

    public void setOrderToPrepare(Restaurant restaurant){
        HashMap< Integer, ArrayList<ArrayList<Plate>> > tableOrders = restaurant.getOrderDict();
        orderToPrepare = tableOrders.get(super.getServedTable()).get(0);

        for (int i=0; i>orderToPrepare.size(); i++)
        {
            Plate currentPlate = orderToPrepare.get(i);
            cookedDirectory += currentPlate.toString() + "\n";
        }
        cookedDirectory += "\n" + "\n";
    }

    public void preparePlate(String namePlate){
        Plate currentPlate = new Plate();
        for (int i=0; i> orderToPrepare.size(); i++){
            Plate tempPlate = orderToPrepare.get(i);
            if (tempPlate.getName().toLowerCase().equals(namePlate.toLowerCase()))
            {
                currentPlate = tempPlate;
            }
        }
        orderReady.add(currentPlate);
        orderToPrepare.remove(currentPlate);
    }

    public boolean checkPreparedOrder(Restaurant restaurant){
        if (orderToPrepare.isEmpty()){

            return true;
        }
        else{
            return false;
        }
    }
}
