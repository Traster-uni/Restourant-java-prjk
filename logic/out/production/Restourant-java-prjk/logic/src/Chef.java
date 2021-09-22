/**
 * Created by Tommaso M. Lopedote on 21/07/2021
 * Time: 17:23
 * Project: Restourant-java-prjk
 */


import javax.swing.table.TableRowSorter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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

public class Chef extends Restaurant{
    private int categoriesNumbs;
    private ArrayList<ArrayList<Plate>> bufferPlate;
    private String menuDirectory;

    public Chef() {
        categoriesNumbs = 0;
        bufferPlate = new ArrayList<>();
        menuDirectory = "";
    }

    public Chef(Integer categories) {
        categoriesNumbs = categories;
        bufferPlate = new ArrayList<>();
        for (int i = 0; i < categories; i++){
            bufferPlate.add(new ArrayList<Plate>());
        }
        menuDirectory = "";
    }

    public Chef(Integer categories, String directory) {
        categoriesNumbs = categories;
        for (int i = 0; i < categories; i++) {
            bufferPlate.add(new ArrayList<Plate>());
        }
        menuDirectory = directory;
    }


    protected ArrayList<ArrayList<Plate>> getBufferPlate() {
        return bufferPlate;
    }

    protected void setMenuDirectory(String directory) {
        this.menuDirectory = directory;
    }


    /**
     * Sets a new number of tables in the Restaurant and initializes the proper dictionaries
     * @param tablesNumbs - number of tables present in the Restaurant
     */
//    protected void setTables(Integer tablesNumbs) {
//        setTablesLists(tablesNumbs);
//        setTablesAttribute(tablesNumbs);
//    }
    /**
     *  Sets the number of type of dishes that the restaurant will be serving
     * @param newQuantities
     */
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
     * Finds a dish with the given dishName in the given category
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

    protected boolean removeDish(String dishName, Integer category) {
        ArrayList<Plate> categoryArray = bufferPlate.get(category - 1);
        for (Plate plate : categoryArray) {
            if (plate.getName().equals(dishName)) {
                int index = categoryArray.indexOf(plate);
                categoryArray.remove(index);
                return true;
            }
        }
        return false;
    }

    /**
     * Writes the menu.csv file using the instances of plates inserted by the chef.
     * If the file is not existent, creates a new file and compiles it.
     */
    protected void writeMenu() throws IOException {
        try {
            File inputFile = new File(menuDirectory);
            FileWriter csvWriter = new FileWriter(inputFile);

            if (!inputFile.createNewFile()){
                for (ArrayList<Plate> categoryArray : bufferPlate) {
                    int j = 0;
                    while (j < categoryArray.size()) {
                        csvWriter.write(categoryArray.get(j).toString());
                        j++;
                    }
                }
            }else{
                for (ArrayList<Plate> categoryArray : bufferPlate) {
                    int j = 0;
                    while (j < categoryArray.size()) {
                        csvWriter.write(categoryArray.get(j).toString());
                        j++;
                    }
                }

            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
                System.out.println("AN ERROR OCCURRED WHILE TRYING TO WRITE ON THE DIRECTORY");
                e.printStackTrace();
        }
    }

    /**
     * Reads the file given by the directory statement. Populate the bufferArray attribute with instances of Plates for
     * further modification by the user.
     */
    public void readMenu() throws IOException{
        try {
            File inputFile = new File(menuDirectory);
            Scanner csvReader = new Scanner(inputFile);
            csvReader.useLocale(Locale.US);
            csvReader.useDelimiter(";");
            if (inputFile.exists()) {
                while (csvReader.hasNext()) {
                    String nameRaed = csvReader.next();
                    Integer categoryRead = csvReader.nextInt();
                    Double priceRead = csvReader.nextDouble();
                    csvReader.nextLine();
                    bufferPlate.get(categoryRead - 1).add(new Plate(nameRaed, categoryRead, priceRead));
                }
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

    protected String getMenuDirectory() {
        return menuDirectory;
    }
}