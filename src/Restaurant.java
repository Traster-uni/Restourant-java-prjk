/*
  Created by Tommaso M. Lopedote on 21/07/2021
  Time: 18:43
  Project: Restourant-java-prjk
 */

import org.jetbrains.annotations.NotNull;

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
    Chef chef;
    ArrayList<Employee> employeeArrayList;
    ArrayList<ArrayList<Plate>> menuArray;
    HashMap< Integer, ArrayList<Order> > orderDict;
    HashMap< Integer, ArrayList<Order> > payableDict;

    public Restaurant(String newRestaurantName, String chefName){
        this.restaurantName = newRestaurantName;
        this.tablesNumbs = 0;
        this.chef = new Chef(chefName);
        employeeArrayList = new ArrayList<>();
        menuArray = new ArrayList<>();
        orderDict = new HashMap<>();
        payableDict = new HashMap<>();
    }

    /**
     * Returns the Restaurant name.
     * @return name
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     *  Returns the number of tables in the Restaurant.
     * @return tables
     */
    public Integer getTablesNumbs() {
        return tablesNumbs;
    }

    /**
     * Returns the Chef object.
     * @return Chef instance
     */
    public Chef getChef() {
        return chef;
    }

    /**
     * Returns the collection of Employees working in the restaurant.
     * @return Employees
     */
    public ArrayList<Employee> getEmployeeArray() {
        return employeeArrayList;
    }

    /**
     * Returns the menu Array o dishes orderable in the Restaurant.
     * @return menuArray
     */
    public ArrayList<ArrayList<Plate>> getMenuArray() {
        return menuArray;
    }

    /**
     * Returns a collection of table's numbers and Arrays of Array of dishes.
     * @return OrderDictionary
     */
    public HashMap< Integer, ArrayList<Order> > getOrderDict() {
        return orderDict;
    }

    /**
     * Returns the Dictionary containing the payable Orders evaded by the kitchen.
     * @return Payable order Dictionary
     */
    public HashMap< Integer, ArrayList<Order> > getPayableDict() {
        return payableDict;
    }


    public void loadMenuFromChef(){
        this.menuArray = chef.getBufferPlate();
    }

    /**
     * Sets a new number of tables in the Restaurant and initializes the proper dictionaries
     * @param tablesNumbs - number of tables present in the Restaurant
     */
    public void setTablesNumbs(Integer tablesNumbs) {
        this.tablesNumbs = tablesNumbs;
        for(Integer i = 1; i <= tablesNumbs; i++) {
            orderDict.put(i, new ArrayList<>());
            payableDict.put(i, new ArrayList<>());
        }
    }

    /**
     * Adds to the array of Employees a new Employee instance
     * @param newEmployee - a new Employee instance
     */
    public void addEmployee(Employee newEmployee){
        employeeArrayList.add(newEmployee);
    }

    /**
     * Adds a new order to be prepared by the kitchen.
     * @param tableNumber - the number of the tables that refers to the order.
     * @param orderArray - the Array containing a list of dishes
     */
    public void addOrderDict(Integer tableNumber, Order newOrder){
        this.orderDict.get(tableNumber).add(newOrder);
    }

    /**
     * Adds an evaded order to the to-be-Payed Dictionary.
     * @param tablesNumbs - the number of the tables that refers to the order.
     * @param tobePayedArray - the Array of payable orders evaded by the kitchen.
     */
    public void addPaymentDict(Integer tablesNumbs, Order tobePayedOrder){
        this.payableDict.get(tablesNumbs).add(tobePayedOrder);
    }

    /**
     * Deletes the first Array of dishes in the order Dictionary.
     * @param tableNumber - table served
     * @return True if the deletion is successful, False otherwise
     */
    public boolean deleteOrder(Integer tableNumber, Order evadedOrder){
        if (evadedOrder.equals(orderDict.get(tableNumber).get(0))) {
            orderDict.get(tableNumber).remove(0);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Deletes the first array of orders contained into the Payable orders Dictionary defined by
     * the number given for the table.\
     * Here's a reminder of the structure of the HashMap: HashMap< Integer, ArrayList<ArrayList<Plate>> >
     * @param tableNumber - Number related to the table desired
     * @return True if the deletion is successful, False otherwise.
     */
    public boolean deletePayedOrder(Integer tableNumber){
        if (!payableDict.get(tableNumber).get(0).isEmpty()){
            payableDict.get(tableNumber).clear();
            return true;
        } else {
            return false;
        }
    }

    //TODO: metodo dedito al confronto dei file csv generati dalle classi Cook e Cashier.
}
