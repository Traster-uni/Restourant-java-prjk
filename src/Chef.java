/**
 * Created by Tommaso M. Lopedote on 21/07/2021
 * Time: 17:23
 * Project: Restourant-java-prjk
 */

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
    private ArrayList<ArrayList<Plate>> bufferPlate;
    private String menuDirectory;

    public Chef(){
        name = "";
        bufferPlate = new ArrayList<>();
        menuDirectory = "";
    }

    public Chef(String newName){
        this.name = newName;
        bufferPlate = new ArrayList<>();
        menuDirectory = "";
    }

    public String getName() {
        return name;
    }

    protected ArrayList<ArrayList<Plate>> getBufferPlate(){
        return bufferPlate;
    }

    protected void setMenuDirectory(String directory){
        this.menuDirectory = directory;
    }

    protected boolean addNewDish(String dishName, Integer category, Double prize){
        Plate newDish = new Plate(dishName, category, prize);
        if (bufferPlate.get(category - 1).contains(newDish)) {
            return false;
        }else{
            bufferPlate.get(category - 1).add(newDish);
            return true;
        }
    }

    protected void changeDish(String dishName, Integer category, Double prize){
        Plate modifyDish = new Plate(dishName, category, prize);
        if (bufferPlate.get(category - 1).contains(modifyDish)){
            int m = bufferPlate.get(category - 1).indexOf(modifyDish);
            bufferPlate.get(category - 1).set(m,modifyDish);
        }
    }

    protected void writeMenu() {
        try {
            File inputFile = new File(menuDirectory);
            FileWriter csvWriter = new FileWriter(inputFile);
            if (inputFile.exists()){
                for (int i=0; i<bufferPlate.size(); i++){
                    ArrayList<Plate> categoryArray = bufferPlate.get(i);
                    int j = 0;
                    if (i == 0){
                        csvWriter.write("Antipasti: ");
                        csvWriter.write("\n");
                    }else if(i == 1){
                        csvWriter.write("Primi: ");
                        csvWriter.write("\n");
                    }else if(i == 2){
                        csvWriter.write("Secondi: ");
                        csvWriter.write("\n");
                    }else if(i == 3){
                        csvWriter.write("Desserts: ");
                        csvWriter.write("\n");
                    }
                    while (j < categoryArray.size()){
                        csvWriter.write(categoryArray.get(j).toString());
                        j++;
                    }
                }
                csvWriter.flush();
                csvWriter.close();
            }else{
                inputFile.createNewFile();
                // TODO: crea il file quando non esiste;
            }
        }catch(IOException e){
            System.out.println("AN ERROR OCCURRED");
            e.printStackTrace();
        }
    }

}
