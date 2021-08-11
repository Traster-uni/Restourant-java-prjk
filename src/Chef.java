/**
 * Created by Tommaso M. Lopedote on 21/07/2021
 * Time: 17:23
 * Project: Restourant-java-prjk
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

//class Cheff
//	attributi:
//        nome:
//        bufferPlate: ArrayList di inserimenti
//          private menuDirectory: directory del file di testo.
//
//     metodi:
//      protected changePlate( ) : modifica un piatto al menù.
//      protected deletePlate( ): cancella un piatto dall' array.
//      protected writeMenu( ): scrive su filepath i piatti inseriti in bufferPlate indicizzando gli inserimenti.
//      protected readMenu( ): legge il file e compila bufferPlate per una eventuale modifica del file del menu.

public class Chef {
    private String name;
    private int categoriesNumbs;
    private ArrayList<ArrayList<Plate>> bufferPlate;
    private String menuDirectory;

    public Chef() {
        name = "";
        categoriesNumbs = 0;
        bufferPlate = new ArrayList<>();
        menuDirectory = "";
    }

    public Chef(String newName) {
        name = newName;
        categoriesNumbs = 0;
        bufferPlate = new ArrayList<>();
        menuDirectory = "";
    }

    public String getName() {
        return name;
    }

    protected ArrayList<ArrayList<Plate>> getBufferPlate() {
        return bufferPlate;
    }

    protected void setMenuDirectory(String directory) {
        this.menuDirectory = directory;
    }

    //TODO: il numero di categorie e' sempre 4, se non fosse cosi' dovresti cambiare il metodo writeMenu
    protected void setNumberOfCategories(int newQuantities) {
        this.categoriesNumbs = newQuantities;
        for (int i = 0; i < categoriesNumbs; i++) {
            bufferPlate.add(new ArrayList<Plate>());
        }
    }

    /**
     * Creates and Adds an instance of Plate class to one of the four arrays contained in
     * the bufferArray to keep the menu partially organized. If the dish already exist the method
     * throws an unchecked exception.
     * The method codify categories of dishes with numbers in the following way:
     * 1 = appetizers
     * 2 = first dishes
     * 3 = second dishes
     * 4 = desserts
     *
     * @param dishName String - the name of the dish.
     * @param category Integer - the number corresponding to the Category of the dish.
     * @param prize    Double - the prize of the dish.
     */
    protected void addNewDish(String dishName, Integer category, Double prize) {
        Plate newDish = new Plate(dishName, category, prize);
        if (bufferPlate.get(category - 1).size() != 0) {

            if (bufferPlate.get(category - 1).contains(newDish)) {
                throw new PlateAlreadyExistException("The Plate is already in the list");
            } else {
                bufferPlate.get(category - 1).add(newDish);
            }

        } else {
            bufferPlate.get(category - 1).add(newDish);
        }
    }

    /**
     * Return the Dish given the name and the category.
     *
     * @param dishName String - the name of the dish.
     * @param category Integer - the category of the dish needed to find the desired Dish.
     */
    protected Plate getDish(String dishName, Integer category) {
        ArrayList<Plate> categoryArray = bufferPlate.get(category - 1);
        for (Plate plate : categoryArray) {
            if (plate.getName().equals(dishName)) {
                return plate;
            } else {
                throw new NoSuchPlateException("The plate doesn't exist in the buffer");
            }
        }
        //dummy empty plate.
        return new Plate();
    }

    protected void changeDish(String dishName, Integer category, Double prize) {
        Plate modifyDish = new Plate(dishName, category, prize);
        if (bufferPlate.get(category - 1).contains(modifyDish)) {
            int m = bufferPlate.get(category - 1).indexOf(modifyDish);
            bufferPlate.get(category - 1).set(m, modifyDish);
        }
    }

    /**
     * Writes the menu.csv file using the instances of plates inserted by the chef.
     * If the file is not existent, creates a new file and compiles it.
     */
    protected void writeMenu() {
        try {
            File inputFile = new File(menuDirectory);
            FileWriter csvWriter = new FileWriter(inputFile);
            if (!inputFile.exists()) {
                inputFile.createNewFile();
            }
            for (int i = 0; i < bufferPlate.size(); i++) {
                ArrayList<Plate> categoryArray = bufferPlate.get(i);
                int j = 0;
                //Valuta se eliminare tale classificazione dal csv
//                if (i == 0) {
//                    csvWriter.write("ANTIPASTI: ");
//                    csvWriter.write("\n");
//                } else if (i == 1) {
//                    csvWriter.write("PRIMI: ");
//                    csvWriter.write("\n");
//                } else if (i == 2) {
//                    csvWriter.write("SECONDI: ");
//                    csvWriter.write("\n");
//                } else if (i == 3) {
//                    csvWriter.write("DESSERT: ");
//                    csvWriter.write("\n");
//                }
                while (j < categoryArray.size()) {
                    csvWriter.write(categoryArray.get(j).toString());
                    csvWriter.write("\n");
                    j++;
                }
            }
            csvWriter.flush();
            csvWriter.close();
            } catch (IOException e) {
                System.out.println("AN ERROR OCCURRED");
                e.printStackTrace();
        }
    }

    /**
     * Reads the file given by the directory statement. Populate the bufferArray attribute with instances of Plates for
     * further modification by the user.
     */
    public void readMenu() {
        try {
            File inputFile = new File(menuDirectory);
            Scanner csvReader = new Scanner(inputFile);
            csvReader.useLocale(Locale.US);
            csvReader.useDelimiter(";");
            while (csvReader.hasNext()) {
                String nameRaed = csvReader.next();
                Integer categoryRead = csvReader.nextInt();
                //TODO: Scanner throws exception wile parsing a double, \n symbol may be the problem.
                Double priceRead = csvReader.nextDouble();
                csvReader.nextLine();
                System.out.println("name "+nameRaed);
                System.out.println("cat "+categoryRead);
                System.out.println("price "+priceRead);

                bufferPlate.get(categoryRead - 1).add(new Plate(nameRaed, categoryRead, priceRead));
            }
        } catch (IOException e) {
            System.out.println("No file with such name was found");
            e.printStackTrace();
        }
    }

    /**
     * Wipes the BufferArray.
     */
    protected void clearBufferPlate() {
        bufferPlate.clear();
        for (int i = 0; i < categoriesNumbs; i++) {
            bufferPlate.add(new ArrayList<Plate>());
        }
    }
}
