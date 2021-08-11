/**
 * Created by Tommaso M. Lopedote on 24/07/2021
 * Time: 16:36
 * Project: Restourant-java-prjk
 */
public class ChefTest {
    public static void main(String[] args){
        String directory = "C:\\Users\\trast\\Desktop\\Università\\GitHub\\Restourant-java-prjk\\testChef.csv";
        Chef chefCapo = new Chef("Augusto");
        chefCapo.setMenuDirectory(directory);
        chefCapo.setNumberOfCategories(4);
        System.out.println("adds new dish, Crudité, 1 = Appetizers, 5 euro");
        chefCapo.addNewDish("Crudité", 1, 5.00);
        System.out.println("adds new dish, Carbonara, 2 = primi piatti, 12 euro");
        chefCapo.addNewDish("Carbonara", 2, 12.00);
        System.out.println("adds new dish, Fiorentina, 3 = second dishes, 25 euro");
        chefCapo.addNewDish("Fiorentina", 3, 25.00);
        System.out.println("adds new dish, Tiramisù, 4 = dessert, 4 euro");
        chefCapo.addNewDish("Tiramisù", 4, 4.00);

        System.out.println("adds new dish, Crostino, 1 = Appetizers, 4 euro");
        chefCapo.addNewDish("Crostino", 1, 4.0);

        chefCapo.writeMenu();
        System.out.println(chefCapo.getBufferPlate());
        System.out.println("#########################");
        System.out.println("flush buffer plate");
        chefCapo.clearBufferArray();
        System.out.println("chef instance reads menu.csv");
        chefCapo.readMenu();
    }
}
