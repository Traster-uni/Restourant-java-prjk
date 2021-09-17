import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO: SPOSTARE LE CLASSI RELATIVE ALLA GRAFICA IN UNA CARTELLA APPOSITA.

public class myFrame extends JFrame{
    protected JPanel startPanel, mainMenuPanel, chefPanel, waiterPanel, cookPanel, cashierPanel;
    protected JButton startButton, chefButton, waiterButton, cookButton, cashierButton, exitButtonStart, exitButtonMenu;
    protected Restaurant restaurant;


    public myFrame(){
        exitButtonMenu = new JButton();
        exitButtonMenu.setText("BACK");
        exitButtonMenu.setBounds(860, 700, 100, 30);

        createStartPanel();

        createMainMenuPanel();

        createChefPanel();
        chefPanel.add(exitButtonMenu);

        setSize(1000, 800);
        setTitle("Restaurant");
        getContentPane().add(startPanel);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(mainMenuPanel);
                //testing
                restaurant = new Restaurant();
                restaurant.getChef().setTablesNumber(4);

                //
            }
        });
        exitButtonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(startPanel);
            }
        });
        chefButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(chefPanel);
                Chef chef = restaurant.getChef();
                chef.addNewDish("Carbonara",2,9.0);
                chef.addNewDish("Sorbetto", 4, 4.0);
            }
        });
        waiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //test purpose
//                List<Plate> dishDummy1 = Arrays.asList(new Plate("Carbonara", 2,8.00), new Plate("Amatriciana",2,10.00));
//                List<Plate> dishDummy2 = Arrays.asList((new Plate("Firoentina", 3, 25.00), new Plate("Stufato", 3, 25.00));
//                ArrayList<Plate> array1 = new ArrayList<>();
//                ArrayList<Plate> array2 = new ArrayList<>();
//                array1.addAll(dishDummy1);
//                array2.addAll(dishDummy2);
//                restaurant.addArrayPlates(new ArrayList<Plate>());
//                restaurant.addArrayPlates(array1);
//                restaurant.addArrayPlates(array2);
//                restaurant.addArrayPlates(new ArrayList<Plate>());
                //test
//                Waiter waiter1 = new Waiter();
//                restaurant.addEmployee(waiter1);
            }
        });
        exitButtonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(mainMenuPanel);
            }
        });

    }

    public void createStartPanel(){
        startPanel = new JPanel(new GridBagLayout());
        startButton = new JButton();
        startButton.setPreferredSize(new Dimension(200, 60));
        startButton.setText("START");
        startPanel.add(startButton);
    }

    public void createMainMenuPanel() {
        mainMenuPanel = new JPanel(null);

        chefButton = new JButton();
        chefButton.setBounds(99, 200, 300, 90);
        chefButton.setText("CHEF");
        chefButton.setFont(new Font("Comic Sans", Font.BOLD, 20));

        waiterButton = new JButton();
        waiterButton.setBounds(599, 200, 300, 90);
        waiterButton.setText("WAITER");

        cookButton = new JButton();
        cookButton.setBounds(599, 500, 300, 90);
        cookButton.setText("COOK");

        cashierButton = new JButton();
        cashierButton.setBounds(99, 500, 300, 90);
        cashierButton.setText("CASHIER");

        exitButtonStart = new JButton();
        exitButtonStart.setText("BACK");
        exitButtonStart.setBounds(860, 700, 100, 30);

        mainMenuPanel.add(Box.createVerticalGlue());
        mainMenuPanel.add(chefButton);
        mainMenuPanel.add(waiterButton);
        mainMenuPanel.add(cookButton);
        mainMenuPanel.add(cashierButton);
        mainMenuPanel.add(exitButtonStart);
    }

    public void createChefPanel(){
        //editing
        new ChefPanel();
    }

    public void switchPanel(JPanel panelToSwitch){
        getContentPane().removeAll();
        getContentPane().add(panelToSwitch);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new myFrame();
    }

}
