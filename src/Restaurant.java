/**
 * Created by Tommaso M. Lopedote on 21/07/2021
 * Time: 18:43
 * Project: Restourant-java-prjk
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * class Ristorante:
 * 	"contenitore di struttutre dati"
 * 	attributi:
 * 		nomeRistorante: str
 * 		numeroDiTavoli: determina le chiavi delle tabelle
 * 		Cheff: contiene lo cheff, proprietario del risotriante
 * 		ArrayList<Employee>: collezione di impioegati nel ristoriante
 * 		menuArray: contiene i piatti letti dal file composto dalla classe Cheff
 * 		tabellaOrdine: 		numTavolo : ArrayOrdine
 * 		tabellaPagamento:	numTavolo : ArrayPagamento
 * 		**
 * 	metodi:
 * 		public sala():
 * 			costruttore default
 * 		public sala(String nome, int numero, filepath)
 * 			genera le Tabelle a partire dal numero di tavoli forniti, intanzia con un nome, genera il file del menu su cui la classe Cheff andra' a scrivere
 */

public class Restaurant {
    String restaurantName;
    Integer tablesNumbs;
    Cheff cheff;
    ArrayList<Employee> employeeArrayList;
    ArrayList<Plate> menuArray;
    HashMap<Integer, ArrayList<Plate>> orderDict;
    HashMap<Integer, ArrayList<Plate>> payableDict;

    public Restaurant(String newRestaurantName, String cheffName){
        this.restaurantName = newRestaurantName;
        this.cheff = new Cheff(cheffName);
        employeeArrayList = new ArrayList<Employee>();
        menuArray = new ArrayList<>();
        orderDict = new HashMap<>();
        payableDict = new HashMap<>();
    }
}
