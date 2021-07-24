/**
 * Created by Tommaso M. Lopedote on 24/07/2021
 * Time: 16:36
 * Project: Restourant-java-prjk
 */
public class ChefTest {
    public static void main(String[] args){
        String directory = "C:\\Users\\trast\\Desktop\\Università\\GitHub\\Restourant-java-prjk\\testChef.txt";
        Chef chefCapo = new Chef("Augusto");
        chefCapo.setMenuDirectory(directory);
        chefCapo.setNumberOfCategories(4);
        System.out.println("adds new dish, Carbonara, 2 = primi piatti, 12 euro");
        chefCapo.addNewDish("Carbonara", 2, 12.00);

        System.out.println("adds new dish, Tiramisù, 4 = dessert, 4 euro");
        chefCapo.addNewDish("Tiramisù", 4, 4.00);

        chefCapo.writeMenu();

        chefCapo.readMenu();
        System.out.println(chefCapo.getBufferPlate());
    }
}
