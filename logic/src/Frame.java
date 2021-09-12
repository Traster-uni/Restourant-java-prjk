import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
    private JPanel startPanel, mainMenuPanel, chefPanel, waiterPanel, cookPanel, cashierPanel;
    private JButton startButton, chefButton, waiterButton, cookButton, cashierButton, exitButtonStart, exitButtonMenu;


    public Frame(){
        exitButtonMenu = new JButton();
        exitButtonMenu.setText("EXIT");
        exitButtonMenu.setBounds(849, 699, 100, 30);
        createStartPanel();
        createMainMenuPanel();
        createChefPanel();
        chefPanel.add(exitButtonMenu);
        setSize(1000, 800);
        setTitle("Restaurant");
        getContentPane().add(startPanel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(mainMenuPanel);
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
        exitButtonStart.setBounds(849, 699, 100, 30);
        mainMenuPanel.add(chefButton);
        mainMenuPanel.add(waiterButton);
        mainMenuPanel.add(cookButton);
        mainMenuPanel.add(cashierButton);
        mainMenuPanel.add(exitButtonStart);
    }

    public void createChefPanel(){
        chefPanel = new JPanel(null);

    }

    public void switchPanel(JPanel panelToSwitch){
        getContentPane().removeAll();
        getContentPane().add(panelToSwitch);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new Frame();
    }






}
