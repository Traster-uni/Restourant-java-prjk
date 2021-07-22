import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Tommaso M. Lopedote on 21/07/2021
 * Time: 17:23
 * Project: Restourant-java-prjk
 */
//class Cheff
//	attributi:
//        nome:
//        bufferPlate: ArrayList di inserimenti
//          private menuDirectory: directory del file di testo.
//
//     metodi:
//      protected newPlate("namePlate", prezzo int): aggiunge una nuova instanza di Piatto all'interno dell'array
//      protected changePlate( ) : modifica un piatto al menù.
//      protected deletePlate( ): cancella un piatto dall' array.
//      protected writeMenu( ): scrive su filepath i piatti inseriti in bufferPlate indicizzando gli inserimenti.
//      protected readMenu( ): legge il file e compila bufferPlate per una eventuale modifica del file del menu.

public class Chef {
    private String name;
    private ArrayList<Plate> bufferPlate;
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

    protected ArrayList<Plate> getBufferPlate(){
        return bufferPlate;
    }

    protected void setMenuDirectory(String directory){
        this.menuDirectory = directory;
    }
}
