import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cashier extends Employee{
    Order<Plate> order;
    String paymentDirectory;
    double change;
    double payment;
    String ordersHistory;
    Integer maxLength;

    /**
     * Default constructor for Cashier object calls
     * super class constructor by default with no arguments.
     */
    public Cashier(){
        super();
        paymentDirectory = "";
        change = 0;
        payment = 0;
        ordersHistory = "Plate, category, price\n";
        maxLength = 0;
        order = new Order<>();
    }

    /**
     * Default constructor for Cashier object calls
     * super class constructor by default.
     * @param initialPaymentDirectory - name of payment directory
     */
    public Cashier(String initialPaymentDirectory){
        super();
        paymentDirectory = initialPaymentDirectory;
        change = 0;
        payment = 0;
        ordersHistory = "Plate;category,;price\n";
        maxLength = 0;
        order = new Order<>();
    }

    /**
     * Selects a table
     * @param number - table number
     */
    public void setServedTable(Integer number) {
        super.setServedTable(number);
    }

    /**
     * Selects order for payment, adds all plates to orders history and
     * counts the amount to be paid
     * @param restaurant - our restaurant
     */
    public void selectOrder(Restaurant restaurant){
        HashMap<Integer, ArrayList<Order<Plate>>> tableOrders = restaurant.getPayableDict();
        ArrayList<Order<Plate>> allOrders = tableOrders.get(super.getServedTable());
        for (int i=0; i<allOrders.size(); i++){
            ArrayList<Plate> currentOrder = allOrders.get(i);
            for (int j=0; j<currentOrder.size(); j++){
                Plate currentPlate = currentOrder.get(j);
                order.add(currentPlate);
                payment += currentPlate.getPrize();
                ordersHistory += currentPlate.getName() +";" + currentPlate.getCategory() +";" +
                       String.format("%.2f", currentPlate.getPrize()).replace(",", ".") + "\n";
                maxLength = Math.max(maxLength, currentPlate.getName().length());
            }
            ordersHistory += "\n" ;
        }
    }

    /**
     * Payment getter
     * @return the amount to be paid
     */
    public double getPayment() {
        return payment;
    }

    /**
     * Change getter
     * @param pay - the money that the client gives
     * @return change to the client
     */
    public double giveChange(double pay){
        change = pay - payment;
        order.setStatusOrder("payed");
        return change;
    }

    /**
     * Writes the receipt on a file.
     * Writes the orders history on a file.
     * Cancels data where needed.
     * @param receiptDirectory - receipt directory
     * @param restaurant - our restaurant
     */

    public void printReceipt(String receiptDirectory, Restaurant restaurant){
        maxLength += 10;
        try {
            File inputFile = new File(receiptDirectory);
            FileWriter fileWriter = new FileWriter(inputFile);
            boolean created = inputFile.createNewFile();
            fileWriter.write("RESTAURANT " + restaurant.getRestaurantName().toUpperCase() + "\n");
            for (int i=0; i<order.size(); i++){
                Plate currentPlate = order.get(i);
                String price = String.format("%.2f", currentPlate.getPrize());
                String line = "Plate " + Integer.toString(i+1) + ":" + currentPlate.getName() +
                        " ".repeat(maxLength-currentPlate.getName().length()-price.length()) + price + "€" + "\n";
                fileWriter.append(line);
            }
            fileWriter.append("-".repeat(10+maxLength)+"\n");
            String total = "TOTAL: " + String.format("%.2f",payment) + "€";
            fileWriter.append(" ".repeat(10+maxLength-total.length()) + total);
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        restaurant.deletePayedOrder(super.getServedTable());
        maxLength = 0;
        order = new Order<>();
        change = 0;
        payment=0;
        try {
            File inputFile = new File(paymentDirectory);
            FileWriter fileWriter = new FileWriter(inputFile);
            if (!inputFile.exists()) {
                boolean created = inputFile.createNewFile();
                fileWriter.write(ordersHistory);
            }
            else {
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(ordersHistory);
                bufferedWriter.close();
            }
            fileWriter.flush();
            fileWriter.close();
            ordersHistory = "";
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
