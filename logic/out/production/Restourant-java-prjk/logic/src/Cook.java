import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cook extends Employee{
    //    private String cookedDirectory;
//    private String allOrders;
//    private Order<Plate> orderToPrepare;
//    private Order<Plate> orderReady; //?
    private HashMap< Integer, ArrayList<Order<Plate>> > allOrders;


    /**
     * Default constructor for Cook object calls
     * super class constructor by default with no arguments.
     */
    public Cook() {
        super();
//        allOrders = "Plate, category, price\n";
//        cookedDirectory = "";
//        orderToPrepare = new Order<>();
//        orderReady = new Order<>(); //?
        allOrders = new HashMap<>();
    }

    /**
     * Default constructor for Cook object calls
     * super class constructor by default.
     //     * @param initialCookedDirectory - name of cooked directory
     */
    public Cook(Restaurant restaurant) {
        super();
//        allOrders = "Plate;category;price\n";
//        cookedDirectory = initialCookedDirectory;
//        orderToPrepare = new Order<>();
//        orderReady = new Order<>(); //?
        allOrders = restaurant.getOrderDict();
    }

    public void prepareOrder(Order order, Restaurant restaurant){
        restaurant.deleteOrder(getServedTable(), order);
        restaurant.addPaymentDict(getServedTable(), order);
    }
//    /**
//     * Selects a table for service.
//     * @param num - table number
//     */
//    public void setServedTable(Integer num){
//        super.setServedTable(num);    //?      //redacted by Jlist
//    }

    /**
     * Selects an order to prepare.
     * @param restaurant - our restaurant
     */
//    public void selectOrderToPrepare(){
//        HashMap< Integer, ArrayList<Order<Plate>> > tableOrders = restaurant.getOrderDict();
//        orderToPrepare = tableOrders.get(super.getServedTable()).get(0);
//        restaurant.deleteOrder(super.getServedTable(), orderToPrepare);
//        for (int i=0; i<orderToPrepare.size(); i++)
//        {
//            Plate currentPlate = orderToPrepare.get(i);
////            allOrders += currentPlate.getName() +";" + currentPlate.getCategory() +";" +
////                    String.format("%.2f", currentPlate.getPrize()).replace(",",".") + "\n";
//        }
//        allOrders += "\n" + "\n";
//    }

//    /**
//     * Prepares one plate from the order.
//     * @param namePlate - plate name
//     */
//    public void preparePlate(String namePlate){
//        Plate currentPlate = new Plate();
//        for (int i=0; i < orderToPrepare.size(); i++){
//            Plate tempPlate = orderToPrepare.get(i);
//            if (tempPlate.getName().toLowerCase().equals(namePlate.toLowerCase()))
//            {
//                currentPlate = tempPlate;
//            }
//        }
//        orderReady.add(currentPlate);
//        orderToPrepare.remove(currentPlate);
//    }

//    /**
//     * Checks if the order is ready.
//     * Writes the order to a file and sends it for payment.
//     * @param restaurant - our restaurant
//     * @return true if order is ready, false otherwise
//     */
//    //TODO cambiare il nome
//    public boolean checkPreparedOrder(Restaurant restaurant){
////        if (orderToPrepare.isEmpty()){
//            orderReady.setStatusOrder("evaded");
//            restaurant.addPaymentDict(super.getServedTable(), orderReady);
////            try {
////                File inputFile = new File(cookedDirectory);
////                FileWriter fileWriter = new FileWriter(inputFile);
////                if (!inputFile.exists()) {
////                    boolean created = inputFile.createNewFile();
////                    fileWriter.write(allOrders);
////                }
////                else {
////                    BufferedWriter bufferedWritter = new BufferedWriter(fileWriter);
////                    bufferedWritter.write(allOrders);
////                    bufferedWritter.close();
////                }
////                fileWriter.flush();
////                fileWriter.close();
////                allOrders = "";
////            }
////            catch (IOException ex){
////                System.out.println(ex.getMessage());
////            }
//            orderReady = new Order<Plate>();
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

//    public ArrayList<Plate> getOrderToPrepare() {
//        return orderToPrepare;
//    }

//    public ArrayList<Plate> getOrderReady() {
//        return orderReady;
//    }
}
