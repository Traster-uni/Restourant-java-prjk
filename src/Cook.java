import java.awt.desktop.SystemSleepEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cook extends Employee{
    private String cookedDirectory;
    private String allOrders;
    private ArrayList<Plate> orderToPrepare;
    private ArrayList<Plate> orderReady;

    /**
     * Default constructor for Cook object calls
     * super class constructor by default with no arguments.
     */
    public Cook() {
        super();
        allOrders = "Plate, category, price\n";
        cookedDirectory = "";
        orderToPrepare = new ArrayList<>();
        orderReady = new ArrayList<>();
    }

    /**
     * Default constructor for Waiter object calls
     * super class constructor by default.
     * @param initialCookedDirectory - name of cooked directory
     */
    public Cook(String initialCookedDirectory) {
        super();
        allOrders = "Plate;category;price\n";
        cookedDirectory = initialCookedDirectory;
        orderToPrepare = new ArrayList<>();
        orderReady = new ArrayList<>();
    }

    /**
     * Selects a table for service.
     * @param num - table number
     */
    public void setServedTable(Integer num){
        super.setServedTable(num);
    }

    /**
     * Selects an order to prepare.
     * @param restaurant - our restaurant
     */
    public void selectOrderToPrepare(Restaurant restaurant){
        HashMap< Integer, ArrayList<Order> > tableOrders = restaurant.getOrderDict();
        orderToPrepare = tableOrders.get(super.getServedTable()).get(0);
        restaurant.deleteOrder(super.getServedTable(), orderToPrepare);
        for (int i=0; i<orderToPrepare.size(); i++)
        {
            Plate currentPlate = orderToPrepare.get(i);
            allOrders += currentPlate.getName() +";" + currentPlate.getCategory() +";" +
                    String.format("%.2f", currentPlate.getPrize()).replace(",",".") + "\n";
        }
        allOrders += "\n" + "\n";
    }

    /**
     * Prepares one plate from the order.
     * @param namePlate - plate name
     */
    public void preparePlate(String namePlate){
        Plate currentPlate = new Plate();
        for (int i=0; i < orderToPrepare.size(); i++){
            Plate tempPlate = orderToPrepare.get(i);
            if (tempPlate.getName().toLowerCase().equals(namePlate.toLowerCase()))
            {
                currentPlate = tempPlate;
            }
        }
        orderReady.add(currentPlate);
        orderToPrepare.remove(currentPlate);
    }

    /**
     * Checks if the order is ready.
     * Writes the order to a file and sends it for payment.
     * @param restaurant - our restaurant
     * @return true if order is ready, false otherwise
     */
    //TODO risolvere la scrittura del file
    public boolean checkPreparedOrder(Restaurant restaurant){
        if (orderToPrepare.isEmpty()){
            restaurant.addPaymentDict(super.getServedTable(), orderReady);
            try {
                File inputFile = new File(cookedDirectory);
                FileWriter fileWriter = new FileWriter(inputFile);
                if (!inputFile.exists()) {
                    boolean created = inputFile.createNewFile();
                    fileWriter.write(allOrders);
                }
                else {
                    fileWriter.append(allOrders);
                }
                fileWriter.flush();
                fileWriter.close();
                allOrders = "";
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
            orderReady = new ArrayList<>();
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<Plate> getOrderToPrepare() {
        return orderToPrepare;
    }

    public ArrayList<Plate> getOrderReady() {
        return orderReady;
    }
}
