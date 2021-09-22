import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tommaso M. Lopedote on 21/09/2021
 * Time: 17:41
 * Project: Restourant-java-prjk
 */
public class ChefTester2 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Chef chef = new Chef();
        restaurant.setChef(chef);

        restaurant.setTablesLists(7);

        System.out.println(restaurant.getOrderDict());
        System.out.println(restaurant.getOrderDict().toString());

    }
}
