/**
 * Created by Tommaso M. Lopedote on 24/07/2021
 * Time: 19:01
 * Project: Restourant-java-prjk
 */
public class PlateTest {
    public static void main(String[] args) {
        Plate piatto1 = new Plate("Carbonara", 1, 12.0);
        System.out.println(piatto1.getName());
        System.out.println(piatto1.getCategory());
        System.out.println(piatto1.getPrize());
        System.out.println(piatto1.toString());
        System.out.println();
        piatto1.setName("Fiorentina");
        System.out.println(piatto1.getName());
        piatto1.setCategory(2);
        System.out.println(piatto1.getCategory());
        piatto1.setPrize(25.0);
        System.out.println(piatto1.getPrize());
        System.out.println(piatto1.toString());

    }
}
