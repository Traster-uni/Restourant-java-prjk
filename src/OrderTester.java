/**
 * Created by Tommaso M. Lopedote on 13/08/2021
 * Time: 12:26
 * Project: Restourant-java-prjk
 */
public class OrderTester {
    public static void main(String[] args) {
        Plate dish1 = new Plate("Pizza", 2, 8);
        Order<Plate> order1 = new Order<>();
        order1.add(dish1);

    }
}
