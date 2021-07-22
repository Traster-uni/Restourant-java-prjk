/**
 * Created by Tommaso M. Lopedote on 21/07/2021
 * Time: 17:23
 * Project: Restourant-java-prjk
 */

import java.io.File;
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
    private Object NoSuchElementException;

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
        if (bufferPlate.get(category).contains(newDish)) {
            return false;
        }else{
            bufferPlate.get(category).add(newDish);
            return true;
        }
    }

    protected void changeDish(String dishName, Integer category, Double prize){
        Plate modifyDish = new Plate(dishName, category, prize);
        if (bufferPlate.get(category).contains(modifyDish)){
            int m = bufferPlate.get(category).indexOf(modifyDish);
            bufferPlate.get(category).set(m,modifyDish);
        }
    }
    
}
