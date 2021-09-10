import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.ArrayList;

/**
 * Created by Tommaso M. Lopedote on 11/08/2021
 * Time: 18:09
 * Project: Restourant-java-prjk
 */
public class RestaurantTester {
    public static void main(String[] args) {
        Restaurant DaGino = new Restaurant();
        Chef ginoChef = DaGino.getChef();
        int tableNum = 5;
        DaGino.setTablesNumbs(tableNum);

        System.out.println("Welcome to Restourant " );
//        System.out.println("With 5 star micheline chef "+ginoChef.getName());
        System.out.println("Number of table at your disposal: "+ DaGino.getTablesNumbs());

//        Cook cook1 = new Cook();
//        Waiter waiter = new Waiter();
//        DaGino.addEmployee(cook1);
//        DaGino.addEmployee(waiter);
//        System.out.println(DaGino.getEmployeeArrayList());

        String directory = "C:\\Users\\baran\\OneDrive\\Desktop\\eclipse-workspace\\Restourant-java-prjk\\menu.csv";
        ginoChef.setMenuDirectory(directory);
        ginoChef.setNumberOfCategories(4);
        try {
            ginoChef.addNewDish("Pizza", 2, 6.0);
            ginoChef.addNewDish("Fritti Vari", 1, 5.0);
            ginoChef.addNewDish("Pizza", 2, 6.0);
        } catch (PlateAlreadyExistException p) {
            System.out.println("AN ERROR OCCURRED");
            p.printStackTrace();
        }

        ginoChef.writeMenu();
//        System.out.println(ginoChef.getName()+" ha scritto il menu");
        System.out.println(ginoChef.getBufferPlate());
        ginoChef.clearBufferPlate();
        System.out.println("Gino wiped the array");
        ginoChef.readMenu();
        System.out.println("Gino has read the menu");
        System.out.println(ginoChef.getBufferPlate());
        DaGino.loadMenuFromChef();

        System.out.println();
        Waiter waiter = new Waiter(1);
        waiter.addPlate("Pizza", 2,  DaGino);
        waiter.addPlate("Fritti Vari",1, DaGino);
        waiter.deletePlate("Fritti Vari");
//        ArrayList<Plate> plates = new ArrayList<>();
//        plates.add(new Plate("Pasta", 1, 7.0));
//        DaGino.addOrderDict(1, plates);
        waiter.endOrder(DaGino);

        waiter.setServedTable(3);
        waiter.addPlate("Fritti Vari", 1, DaGino);
        waiter.addPlate("Pizza", 2, DaGino);
        waiter.addPlate("Pizza", 2, DaGino);
        waiter.endOrder(DaGino);

        waiter.setServedTable(1);
        waiter.addPlate("Fritti Vari", 1, DaGino);
        waiter.endOrder(DaGino);
        System.out.println(DaGino.getOrderDict());

        String cookedDirectory = "C:\\Users\\baran\\OneDrive\\Desktop\\eclipse-workspace\\Restourant-java-prjk\\cooked.csv";
        Cook cook = new Cook(cookedDirectory);
        System.out.println("Il cuoco sceglie il tavolo 1");
        cook.setServedTable(1);
        cook.selectOrderToPrepare(DaGino);
        System.out.println("Il cuoco deve preparare: " + cook.getOrderToPrepare());
        cook.preparePlate("Pizza");
        System.out.println("Il cuoco ha preparato: " + cook.getOrderReady());
        System.out.println("Il cuoco deve preparare: " + cook.getOrderToPrepare());
        cook.checkPreparedOrder(DaGino);
        System.out.println("Il cuoco ha preparato: " + cook.getOrderReady());
        System.out.println("Il cuoco deve preparare: " + cook.getOrderToPrepare());

        System.out.println();
        System.out.println("Il cuoco sceglie il tavolo 3");
        cook.setServedTable(3);
        cook.selectOrderToPrepare(DaGino);
        System.out.println("Il cuoco deve preparare: " + cook.getOrderToPrepare());
        cook.preparePlate("Fritti Vari");
        System.out.println("Il cuoco ha preparato: " + cook.getOrderReady());
        System.out.println("Il cuoco deve preparare: " + cook.getOrderToPrepare());
        cook.preparePlate("Pizza");
        System.out.println("Il cuoco ha preparato: " + cook.getOrderReady());
        System.out.println("Il cuoco deve preparare: " + cook.getOrderToPrepare());
        cook.preparePlate("Pizza");
        System.out.println("Il cuoco ha preparato: " + cook.getOrderReady());
        System.out.println("Il cuoco deve preparare: " + cook.getOrderToPrepare());
        cook.checkPreparedOrder(DaGino);

        System.out.println();
        System.out.println("Il cuoco sceglie il tavolo 3");
        cook.setServedTable(1);
        cook.selectOrderToPrepare(DaGino);
        System.out.println("Il cuoco deve preparare: " + cook.getOrderToPrepare());
        cook.preparePlate("Fritti Vari");
        System.out.println("Il cuoco ha preparato: " + cook.getOrderReady());
        System.out.println("Il cuoco deve preparare: " + cook.getOrderToPrepare());
        cook.checkPreparedOrder(DaGino);

        System.out.println();
        System.out.println("Ordini non pagati: " + DaGino.getPayableDict());
        String payment = "C:\\Users\\baran\\OneDrive\\Desktop\\eclipse-workspace\\Restourant-java-prjk\\payment.csv";
        Cashier cashier = new Cashier(payment);
        System.out.println("Il casiere sceglie il tavolo 1");
        cashier.setServedTable(1);
        cashier.selectOrder(DaGino);
        System.out.println("Il cliente deve pagare: " + cashier.getPayment());
        double amount = 20;
        System.out.println("Il cliente riceve il resto: " + cashier.giveChange(amount));
        String receipt1 = "C:\\Users\\baran\\OneDrive\\Desktop\\eclipse-workspace\\Restourant-java-prjk\\receipt1.txt";
        cashier.printReceipt(receipt1, DaGino);

        System.out.println();
        System.out.println("Ordini non pagati: " + DaGino.getPayableDict());
        cashier.setServedTable(3);
        System.out.println("Il casiere sceglie il tavolo 3");
        cashier.selectOrder(DaGino);
        System.out.println("Il cliente deve pagare: " + cashier.getPayment());
        double amount2 = 40;
        System.out.println("Il cliente riceve il resto: " + cashier.giveChange(amount2));
        String receipt2 = "C:\\Users\\baran\\OneDrive\\Desktop\\eclipse-workspace\\Restourant-java-prjk\\receipt2.txt";
        cashier.printReceipt(receipt2, DaGino);

    }

}
