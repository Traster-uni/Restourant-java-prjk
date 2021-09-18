/**
 * Created by Tommaso M. Lopedote on 17/09/2021
 * Time: 18:27
 * Project: Restourant-java-prjk
 */
public class RestaurantTester2 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Chef chef = new Chef();
        restaurant.setChef(chef);
        restaurant.getChef().setTablesLists(5);
    }

}
