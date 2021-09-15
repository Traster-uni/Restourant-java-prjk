import org.intellij.lang.annotations.Flow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//TODO: SPOSTARE LE CLASSI RELATIVE ALLA GRAFICA IN UNA CARTELLA APPOSITA.

public class myFrame extends JFrame{
    protected JPanel startPanel, mainMenuPanel, chefPanel, waiterPanel, cookPanel, cashierPanel;
    protected JButton startButton, chefButton, waiterButton, cookButton, cashierButton, exitButtonStart, exitButtonMenu;
    protected Restaurant restaurant;


    public myFrame(){
        exitButtonMenu = new JButton();
        exitButtonMenu.setText("EXIT");
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
//                restaurant = new Restaurant();
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
            }
        });
        waiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //test purpose
                ArrayList<Plate> dummyPlate = new ArrayList<>();
                dummyPlate.add(new Plate("Pizza", 1, 5));
                dummyPlate.add(new Plate("Maccheroni", 1, 7));
                dummyPlate.add(new Plate("Fiorentina", 2, 20));
                restaurant.addArrayPlates(dummyPlate);
                //test
                Waiter waiter1 = new Waiter();
                restaurant.addEmployee(waiter1);
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
        exitButtonStart.setText("EXIT");
        exitButtonStart.setBounds(860, 700, 100, 30);
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
