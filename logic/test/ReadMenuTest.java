import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Tommaso M. Lopedote on 20/09/2021
 * Time: 12:17
 * Project: Restourant-java-prjk
 */

public class ReadMenuTest {
    public static void main(String[] args) {
        ArrayList< ArrayList<Plate> > arraytry = new ArrayList<>();
        arraytry.add(new ArrayList<Plate>());
        arraytry.add(new ArrayList<Plate>());
        arraytry.add(new ArrayList<Plate>());
        arraytry.add(new ArrayList<Plate>());

;        try {
            File inputFile = new File("C:\\Users\\trast\\Desktop\\Università\\GitHub\\Restourant-java-prjk\\menutest1.csv");
            Scanner csvReader = new Scanner(inputFile);
            csvReader.useLocale(Locale.US);
            csvReader.useDelimiter(";");

            if (inputFile.exists()) {
                while (csvReader.hasNext()) {
                    String nameRaed = csvReader.next();
                    Integer categoryRead = csvReader.nextInt();
                    //TODO: Scanner throws exception wile parsing a double, \n symbol may be the problem.
                    Double priceRead = csvReader.nextDouble();
                    csvReader.nextLine();
                    arraytry.get(categoryRead - 1).add(new Plate(nameRaed, categoryRead, priceRead));
                }
            }
        } catch (IOException e) {
            System.out.println("No file with such name was found");
            e.printStackTrace();
        }
        System.out.println(arraytry);
    }
}
