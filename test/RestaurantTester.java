import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 * Created by Tommaso M. Lopedote on 11/08/2021
 * Time: 18:09
 * Project: Restourant-java-prjk
 */
public class RestaurantTester {
    public static void main(String[] args) {
        Restaurant DaGino = new Restaurant("Da Gino", "Gino Giocondo");
        Chef ginoChef = DaGino.getChef();
        int tableNum = 5;
        DaGino.setTablesNumbs(tableNum);

        System.out.println("Welcome to Restourant " + DaGino.getRestaurantName());
        System.out.println("With 5 star micheline chef "+ginoChef.getName());
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
        System.out.println(ginoChef.getName()+" ha scritto il menu");
        System.out.println(ginoChef.getBufferPlate());
        ginoChef.clearBufferPlate();
        System.out.println("Gino wiped the array");
        ginoChef.readMenu();
        System.out.println("Gino has read the menu");
        System.out.println(ginoChef.getBufferPlate());

        System.out.println();
        Waiter waiter = new Waiter(1);
        waiter.addPlate("Pizza", DaGino);
        waiter.addPlate("Fritti Vari", DaGino);
        System.out.println(waiter.getOrder());
        waiter.deletePlate("Fritti Vari");
        System.out.println(waiter.getOrder());
        waiter.endOrder(DaGino);
        System.out.println(waiter.getOrder());
        System.out.println(DaGino.getOrderDict());

    }

}
