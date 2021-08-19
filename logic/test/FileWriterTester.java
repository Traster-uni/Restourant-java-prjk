import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileWriterTester {
    public static void main(String[] args) {
        ArrayList<Plate> orderToPrepare = new ArrayList<>();
        ArrayList<Plate> order = new ArrayList<>();
        String allOrders = "Plate, category, price\n";
        Plate as = new Plate("refhjjefjqj", 1, 280);
        Plate a2 = new Plate("fqjjfq", 1, 22);
        Plate a3 = new Plate("fhref", 1, 28);
        Plate a4 = new Plate("fqfkqejfjwejfqenjr", 1, 28);
        order.add(as);
        order.add(a2);
        order.add(a3);
        order.add(a4);
//        for (int i=0; i<order.size(); i++)
//        {
//            Plate currentPlate = order.get(i);
//            allOrders += currentPlate.getName() +", " + currentPlate.getCategory() +", " +
//            String.format("%.2f", currentPlate.getPrize()) + "\n";
//        }
//        allOrders += "\n" + "\n";
//        System.out.println(allOrders);
//        if (orderToPrepare.isEmpty()) {
//            try {
//                File inputFile = new File("C:\\Users\\baran\\OneDrive\\Desktop\\eclipse-workspace\\Restourant-java-prjk\\test\\order.txt");
//                FileWriter fileWriter = new FileWriter(inputFile);
//                if (!inputFile.exists()) {
//                    boolean created = inputFile.createNewFile();
//                    fileWriter.write(allOrders);
//                }
//                else{
//                    fileWriter.append(allOrders);
//                }
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//        allOrders += "sjjcajcjaw";
//        try {
//            File inputFile = new File("C:\\Users\\baran\\OneDrive\\Desktop\\eclipse-workspace\\Restourant-java-prjk\\test\\order.txt");
//            FileWriter fileWriter = new FileWriter(inputFile);
//            if (!inputFile.exists()) {
//                boolean created = inputFile.createNewFile();
//                fileWriter.write(allOrders);
//            }
//            else{
//                fileWriter.append(allOrders);
//            }
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        order.clear();
        int maxLength = 0;
        double payment = 0;
        for (int i=0; i<order.size(); i++){
            maxLength = Math.max(maxLength, order.get(i).getName().length());
            payment += order.get(i).getPrize();
        }
        maxLength += 10;
        try {
            File inputFile = new File("C:\\Users\\baran\\OneDrive\\Desktop\\eclipse-workspace\\Restourant-java-prjk\\test\\receipt.txt");
            FileWriter fileWriter = new FileWriter(inputFile);
            boolean created = inputFile.createNewFile();
            fileWriter.append("RESTAURANT " + "\n");
            for (int i=0; i<order.size(); i++){
                Plate currentPlate = order.get(i);
                String price = String.format("%.2f", currentPlate.getPrize());
                String line = "Plate " + Integer.toString(i+1) + ": " + currentPlate.getName() +
                        " ".repeat(maxLength-currentPlate.getName().length()-price.length()) + price + "€" + "\n";
                fileWriter.append(line);
                System.out.println(line);
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
  }
}