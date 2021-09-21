import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


//TODO: SPOSTARE LE CLASSI RELATIVE ALLA GRAFICA IN UNA CARTELLA APPOSITA.

public class myFrame extends JFrame{
    final int FRAME_WIDTH = 985;
    protected JPanel startPanel, mainMenuPanel, chefPanel, waiterPanel, cookPanel, cashierPanel;
    protected JButton startButton, chefButton, waiterButton, cookButton, cashierButton, exitButtonStart, exitButtonMenu;
//    protected JPanel topPanel, midPanel1, midPanel2, botPanel;
    protected Restaurant restaurant;


    public myFrame(){
        exitButtonMenu = new JButton();
        exitButtonMenu.setText("BACK");
        exitButtonMenu.setBounds(860, 700, 100, 30);

        createStartPanel();
        createMainMenuPanel();
        mainMenuPanel.add(exitButtonStart);
        createChefPanel();
        chefPanel.add(exitButtonMenu);
        createCookPanel();
        cookPanel.add(exitButtonMenu);

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

        // lambda functions: (parametro1, parametro2) -> { blocco di codice }
        waiterButton.addActionListener(e -> switchPanel(waiterPanel));
        cookButton.addActionListener(e -> switchPanel(cookPanel));
        exitButtonMenu.addActionListener(e -> switchPanel(mainMenuPanel));

    }

    private void createStartPanel(){
        restaurant = new Restaurant();
        startPanel = new JPanel(new GridBagLayout());
        startButton = new JButton();
        startButton.setPreferredSize(new Dimension(200, 60));
        startButton.setText("START");
        startPanel.add(startButton);
    }

    private void createMainMenuPanel() {
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

        mainMenuPanel.add(chefButton);
        mainMenuPanel.add(waiterButton);
        mainMenuPanel.add(cookButton);
        mainMenuPanel.add(cashierButton);
    }

    private void createChefPanel(){
        //logic
        Chef chef = new Chef(4);
        restaurant.setChef(chef);
        //graphics
        chefPanel = new JPanel();
        chefPanel.setLayout(null);

        JPanel topChefPanel = new JPanel();
        //uncomment to see the panel
//        topChefPanel.setBackground(Color.GREEN);
        chefPanel.add(topChefPanel);

        JPanel midChefPanel1 = new JPanel();
        //uncomment to see the panel
//        midChefPanel1.setBackground(Color.BLACK);
        chefPanel.add(midChefPanel1);

        JPanel midChefPanel2 = new JPanel();
        //uncomment to see the panel
//        midChefPanel2.setBackground(Color.RED);
        chefPanel.add(midChefPanel2);

        JPanel botChefPanel = new JPanel();
        //uncomment to see the panel
//        botChefPanel.setBackground(Color.BLUE);
        chefPanel.add(botChefPanel);

        //--------------------------------
        //--------topPanel
        //--------------------------------

        topChefPanel.setBounds(0, 0, FRAME_WIDTH, 90);
        //panel borders and layout
        topChefPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        topChefPanel.setLayout(new BorderLayout(5, 5));
        //panel components
        JLabel frameTitle = new JLabel("Chef Control Panel");
        frameTitle.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JLabel textFieldLabel = new JLabel("Number of tables: ");
        //formatter
        NumberFormat integerFormatter = NumberFormat.getIntegerInstance();
        integerFormatter.setMaximumFractionDigits(0);
        integerFormatter.setParseIntegerOnly(true);
        //Formatted text field
        JFormattedTextField textFieldTop = new JFormattedTextField(integerFormatter);
        textFieldTop.setText("");
        textFieldTop.setFocusLostBehavior(JFormattedTextField.COMMIT);

        JButton enterTextButton = new JButton("ENTER");

        ActionListener numberOfTablesListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //checks for valid input from textfield
                boolean editValid = textFieldTop.isEditValid();
                try{
                    if (editValid) {
                        Integer intInputValue = Integer.parseInt(textFieldTop.getText());
                        chef.setTablesLists(intInputValue);
                        chef.setTablesAttribute(intInputValue);
                        restaurant.setTablesAttribute(intInputValue);
                        JOptionPane.showMessageDialog(topChefPanel, "Number of Tables is now set to: " + textFieldTop.getText());
                    }else{
                        JOptionPane.showMessageDialog(topChefPanel, "Insert only numerical value");
                    }

                }catch (NumberFormatException ne){
                    JOptionPane.showMessageDialog(topChefPanel, "Please write an integer in the Text Field");
                }
            }
        };

        textFieldTop.addActionListener(numberOfTablesListener);
        enterTextButton.addActionListener(numberOfTablesListener);

        topChefPanel.add(frameTitle, BorderLayout.BEFORE_FIRST_LINE);
        topChefPanel.add(textFieldLabel, BorderLayout.WEST);
        topChefPanel.add(textFieldTop, BorderLayout.CENTER);
        topChefPanel.add(enterTextButton, BorderLayout.EAST);
        topChefPanel.add(new JLabel("Add entries here: "), BorderLayout.SOUTH);


        //--------------------------------
        //--------midPanel1---------------
        //--------------------------------

        midChefPanel1.setBounds(0, 90, FRAME_WIDTH, 65);
        //panel borders and layout
        midChefPanel1.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        midChefPanel1.setLayout(new FlowLayout(FlowLayout.LEADING));

        //panel components
        JTextField nameTextField = new JTextField();
        nameTextField.setColumns(20);
        JFormattedTextField categoryTextField = new JFormattedTextField(integerFormatter);

        categoryTextField.setColumns(4);
        //component for JList
        DefaultListModel<Plate> menuListModel = new DefaultListModel<>();
        JFormattedTextField priceTextField = new JFormattedTextField(new DecimalFormat("##0.00"));

        ActionListener menuEntryField = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws PlateAlreadyExistException {
                String dishName = nameTextField.getText();
                Integer category = Integer.parseInt( categoryTextField.getText() );
                Double price = Double.parseDouble( priceTextField.getText().replaceAll(",",".") );
                menuListModel.addElement(new Plate(dishName, category, price));
                chef.addNewDish(dishName, category, price);
            }
        };

        nameTextField.addActionListener(menuEntryField);
        categoryTextField.addActionListener(menuEntryField);
        priceTextField.addActionListener(menuEntryField);


        priceTextField.setColumns(6);
        JButton addButton = new JButton("ADD");
        JButton deleteButton = new JButton("DELETE");
        addButton.addActionListener(menuEntryField);
        midChefPanel1.setAlignmentX(JPanel.LEFT_ALIGNMENT);

        midChefPanel1.add(new JLabel("Dish's name: "));
        midChefPanel1.add(nameTextField);
        midChefPanel1.add(new JLabel("Category: "));
        midChefPanel1.add(categoryTextField);
        midChefPanel1.add(new JLabel("Price: "));
        midChefPanel1.add(priceTextField);
        //buttons and spacers
        midChefPanel1.add(new Box.Filler(new Dimension(100, 2), new Dimension(400, 2), new Dimension(400, 2)));
        midChefPanel1.add(addButton);
        midChefPanel1.add(new Box.Filler(new Dimension(300,2), new Dimension(820,2),new Dimension(820,2)));
        midChefPanel1.add(deleteButton);


        //-----------------------------
        //-------midPanel2
        //-----------------------------

        midChefPanel2.setBounds(0, 155, FRAME_WIDTH, 300);
        //panel borders and layout
        midChefPanel2.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        midChefPanel2.setLayout(new BorderLayout(5,5));

        //panel components
        JLabel readLabel = new JLabel("Menu content: ");
        readLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        JList<Plate> textArea = new JList<>(menuListModel);
        textArea.setCellRenderer(new PlateDisplay());
        textArea.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        JScrollPane displayMenu = new JScrollPane(textArea);
        displayMenu.setEnabled(true);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //removed from JList
                String name = textArea.getSelectedValue().getName();
                Integer cat = textArea.getSelectedValue().getCategory();
                menuListModel.removeElement(textArea.getSelectedValue());
                //removed from bufferPlate
                if (chef.removeDish(name,cat)) {
                    JOptionPane.showMessageDialog(deleteButton, "Plate deleted");
                } else {
                    JOptionPane.showMessageDialog(deleteButton, "Plate was not deleted");
                }
            }
        });

        displayMenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        displayMenu.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);

        midChefPanel2.add(readLabel, BorderLayout.BEFORE_FIRST_LINE);
        midChefPanel2.add(displayMenu, BorderLayout.CENTER);

        //-----------------------------
        //-------botPanel
        //-----------------------------

        botChefPanel.setBounds(0, 460, FRAME_WIDTH, 100);
        //panel borders and layout
        botChefPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        botChefPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        //panel components
        JLabel directoryLabel = new JLabel("File menu location: ");
        JTextField directoryTextField = new JTextField();
        directoryTextField.setColumns(60);
        JButton updateButton = new JButton("UPDATE DIRECTORY");
        JButton readButton = new JButton("READ");
        JButton writeButton = new JButton("WRITE");
        JButton dataRestaurantButton = new JButton("UPDATE RESTAURANT");

        ActionListener directoryActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String directory = directoryTextField.getText();
                chef.setMenuDirectory(directory);
            }
        };
        directoryTextField.addActionListener(directoryActionListener);
        updateButton.addActionListener(directoryActionListener);

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    chef.readMenu();
                    JOptionPane.showMessageDialog(writeButton, "Menu recovered");
                    for (int i = 0; i < chef.getBufferPlate().size(); i++) {
                        for (int j = 0; j < chef.getBufferPlate().get(i).size(); j++)
                            menuListModel.addElement(chef.getBufferPlate().get(i).get(j));
                    }
                } catch (IOException e2){
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(writeButton, "Reading the file is impossible, check for extension in the name.");
                }
            }
        });

        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    chef.writeMenu();
                    JOptionPane.showMessageDialog(botChefPanel, "CSV file written");
                }catch (IOException e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(botChefPanel, "An error as occurred and the CSV file has not been written");
                }
            }
        });

        dataRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restaurant.loadMenuFromChef();
                JOptionPane.showMessageDialog(botChefPanel, "Restaurant Array updated");
            }
        });

        botChefPanel.add(directoryLabel);
        botChefPanel.add(directoryTextField);
        botChefPanel.add(updateButton);
        botChefPanel.add(readButton);
        botChefPanel.add(writeButton);
        botChefPanel.add(new Box.Filler(new Dimension(300,2), new Dimension(620,2),new Dimension(620,2)));
        botChefPanel.add(dataRestaurantButton);
    }

    private void createCookPanel() {
        //logic
        Cook cook = new Cook();
        restaurant.addEmployee(cook);
        //
        cookPanel = new JPanel();
        cookPanel.setLayout(null);
        //3 panels - top/mid/bot panels

        //############
        //---topPanel
        //############

        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.LEADING);
        JPanel topCookPanel = new JPanel(flow);
        //Uncomment to see the Panel
//        topCookPanel.setBackground(Color.CYAN);
        //
        topCookPanel.setBounds(0,0, FRAME_WIDTH, 35);
        topCookPanel.setBorder(BorderFactory.createEmptyBorder(5,10,0,10));
        //Components
        JLabel titleLabel = new JLabel("Cook Panel");
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JButton refreshButton = new JButton("REFRESH");
        refreshButton.addActionListener(e -> {});
        //
        cookPanel.add(topCookPanel);

        topCookPanel.add(titleLabel);

        //############
        //---midPanel
        //############

        JPanel midCookPanel = new JPanel(new BorderLayout(5,5));
        //Uncomment to see the Panel
//        midCookPanel.setBackground(Color.ORANGE);
        //
        midCookPanel.setBounds(0,35,FRAME_WIDTH,400);
        midCookPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        //Components constructors and methods call
        JLabel orderListLabel = new JLabel("Select the orders to evade here");
        orderListLabel.setFont(new Font("Comic Sans", Font.PLAIN, 12));

        DefaultListModel<Order<Plate>> orderDefaultListModel = new DefaultListModel<>();
        JList orderList = new JList(orderDefaultListModel);
        JScrollPane orderScrollPane = new JScrollPane(orderList);
        //
        cookPanel.add(midCookPanel);

        midCookPanel.add(orderListLabel, BorderLayout.BEFORE_FIRST_LINE);
        midCookPanel.add(orderScrollPane, BorderLayout.CENTER);

        //############
        //---botPanel
        //############

        JPanel botCookPanel= new JPanel(flow);
        //Uncomment to see the Panel
//        botCookPanel.setBackground(Color.YELLOW);
        //
        botCookPanel.setBounds(0,430, FRAME_WIDTH, 40);
        botCookPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        //Components constructors and methods call
        JButton evadeButton = new JButton("EVADE");
        //
        cookPanel.add(botCookPanel);

        botCookPanel.add(evadeButton);

    }

    private void switchPanel(JPanel panelToSwitch){
        getContentPane().removeAll();
        getContentPane().add(panelToSwitch);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new myFrame();
    }

}
