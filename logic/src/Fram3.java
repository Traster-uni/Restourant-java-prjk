import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Formattable;
import java.util.HashMap;

public class Fram3 extends JFrame{
    final int FRAME_WIDTH = 985;
    protected JPanel startPanel, mainMenuPanel, chefPanel, waiterPanel, orderPanel, cookPanel, cashierPanel;
    private JButton startButton, chefButton, waiterButton, cookButton, cashierButton, exitButtonStart, endOrderButton, updateTablesButton, back1, back2, back3, back4;
    private ArrayList<JButton> tables;
    protected Waiter waiter;
    protected Restaurant restaurant;
    protected Chef chef;
    public Cook cook;
    private boolean waiterInstanceIs = false;

    public Fram3(){
        restaurant = new Restaurant();
        updateTablesButton = new JButton("UPDATE TABLES");
        updateTablesButton.setBounds(300, 699, 150, 30);
        endOrderButton = new JButton("END ORDER");
        endOrderButton.setBounds(806,699,140,30);

        createStartPanel();
        createMainMenuPanel();
        createChefPanel();
//        createWaiterPanel();
//        createCookPanel();

        back1 = new JButton();
        createBackButton(back1);
        chefPanel.add(back1);
        back2 = new JButton();
        createBackButton(back2);
        back3 = new JButton();
        createBackButton(back3);


        setResizable(false);
        setSize(1000, 800);
        setTitle("Restaurant");
        getContentPane().add(startPanel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ActionListener backToMainMenu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(mainMenuPanel);
            }
        };

        startButton.addActionListener( e -> switchPanel(mainMenuPanel));

        exitButtonStart.addActionListener( e -> switchPanel(startPanel));

        chefButton.addActionListener( e -> switchPanel(chefPanel));

        back1.addActionListener( e -> switchPanel(mainMenuPanel));
        back2.addActionListener( e -> switchPanel(mainMenuPanel));
        back3.addActionListener( e -> switchPanel(mainMenuPanel));

        waiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (restaurant.getMenuArray().size() == 0){
                    JOptionPane.showMessageDialog(mainMenuPanel, "The Menu doesn't exist yet, please set up your restaurant by selecting the Chef");
                }
                else {
                    if (!waiterInstanceIs){
                        createWaiterPanel();
                        waiterPanel.add(back2);
                    }
                    switchPanel(waiterPanel);
                }
            }
        });

        updateTablesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i < tables.size(); i++){
                    int tableNumber = i+1;
                    tables.get(i).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            createOrderPanel(tableNumber);
                            switchPanel(orderPanel);
                        }
                    });
                }
            }
        });

        endOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanel(waiterPanel);
                waiter.endOrder(restaurant);
            }
        });

        cookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCookPanel();
                cookPanel.add(back3);
                switchPanel(cookPanel);
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
        //logic
        chef = new Chef(4);
        restaurant.setChef(chef);
        //graphic
        chefPanel = new JPanel(null);
//        chefPanel.add(exitButtonMenu);
//        chefPanel.setLayout(null);

        JPanel topPanel = new JPanel();
        //uncomment to see the panel
//        topPanel.setBackground(Color.GREEN);
        chefPanel.add(topPanel);

        JPanel midPanel1 = new JPanel();
        //uncomment to see the panel
//        midPanel1.setBackground(Color.BLACK);
        chefPanel.add(midPanel1);

        JPanel midPanel2 = new JPanel();
        //uncomment to see the panel
//        midPanel2.setBackground(Color.RED);
        chefPanel.add(midPanel2);

        JPanel botPanel = new JPanel();
        //uncomment to see the panel
//        botPanel.setBackground(Color.BLUE);
        chefPanel.add(botPanel);

        //--------------------------------
        //--------topPanel
        //--------------------------------
        topPanel.setBounds(0, 0, FRAME_WIDTH, 90);
        //panel borders and layout
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        topPanel.setLayout(new BorderLayout(5, 5));
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
                if (editValid) {
                    Integer intInputValue = Integer.parseInt(textFieldTop.getText());
                    restaurant.setTablesLists(intInputValue);
                    chef.setTablesAttribute(intInputValue);
                    restaurant.setTablesAttribute(intInputValue);
                    JOptionPane.showMessageDialog(topPanel, "Number of Tables is now set to: " + textFieldTop.getText());
                }else{
                    JOptionPane.showMessageDialog(topPanel, "Insert only numerical value");
                }
            }
        };
        textFieldTop.addActionListener(numberOfTablesListener);
        enterTextButton.addActionListener(numberOfTablesListener);

        topPanel.add(frameTitle, BorderLayout.BEFORE_FIRST_LINE);
        topPanel.add(textFieldLabel, BorderLayout.WEST);
        topPanel.add(textFieldTop, BorderLayout.CENTER);
        topPanel.add(enterTextButton, BorderLayout.EAST);
        topPanel.add(new JLabel("Add entries here: "), BorderLayout.SOUTH);


        //--------------------------------
        //--------midPanel1---------------
        //--------------------------------
        midPanel1.setBounds(0, 90, FRAME_WIDTH, 65);
        //panel borders and layout
        midPanel1.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        midPanel1.setLayout(new FlowLayout(FlowLayout.LEADING));

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
        midPanel1.setAlignmentX(JPanel.LEFT_ALIGNMENT);

        midPanel1.add(new JLabel("Dish's name: "));
        midPanel1.add(nameTextField);
        midPanel1.add(new JLabel("Category: "));
        midPanel1.add(categoryTextField);
        midPanel1.add(new JLabel("Price: "));
        midPanel1.add(priceTextField);
        //buttons and spacers
        midPanel1.add(new Box.Filler(new Dimension(100, 2), new Dimension(400, 2), new Dimension(400, 2)));
        midPanel1.add(addButton);
        midPanel1.add(new Box.Filler(new Dimension(300,2), new Dimension(820,2),new Dimension(820,2)));
        midPanel1.add(deleteButton);


        //-----------------------------
        //-------midPanel2
        //-----------------------------
        midPanel2.setBounds(0, 155, FRAME_WIDTH, 300);
        //panel borders and layout
        midPanel2.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        midPanel2.setLayout(new BorderLayout(5,5));

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

        midPanel2.add(readLabel, BorderLayout.BEFORE_FIRST_LINE);
        midPanel2.add(displayMenu, BorderLayout.CENTER);


        //-----------------------------
        //-------botPanel
        //-----------------------------
        botPanel.setBounds(0, 460, FRAME_WIDTH, 100);
        //uncomment to see the panel
//        botPanel.setBackground(Color.BLUE);
        //panel borders and layout
        botPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        botPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

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
                    JOptionPane.showMessageDialog(botPanel, "CSV file written");
                }catch (IOException e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(botPanel, "An error as occurred and the CSV file has not been written");
                }
            }
        });

        dataRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restaurant.loadMenuFromChef();
                JOptionPane.showMessageDialog(botPanel, "Restaurant Array updated");
            }
        });

        botPanel.add(directoryLabel);
        botPanel.add(directoryTextField);
        botPanel.add(updateButton);
        botPanel.add(readButton);
        botPanel.add(writeButton);
        botPanel.add(new Box.Filler(new Dimension(300,2), new Dimension(620,2),new Dimension(620,2)));
        botPanel.add(dataRestaurantButton);

//        chefPanel.add(back1);

    }

    public void createWaiterPanel(){
        waiterInstanceIs = true;
        waiter = new Waiter();
        restaurant.addEmployee(waiter);
        waiterPanel = new JPanel(null);
        tables = new ArrayList<>();
        JPanel panel1 = new JPanel();
        int tablesNumber = chef.getNumberOfTables();
        panel1.setBounds(0,0, 990, 670);
        panel1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        int divider;
        if (tablesNumber<10){
            divider = 2;
        }
        else{
            divider = 4;
        }
        panel1.setLayout(new GridLayout(tablesNumber/divider,tablesNumber-tablesNumber/divider, 10, 10));
        for (int i=0; i<tablesNumber; i++){
            String text = "Table " + (i+1);
            JButton tableButton = new JButton(text);
            tables.add(tableButton);
            panel1.add(tableButton);
        }
        panel1.setBackground(Color.RED);
        waiterPanel.add(panel1);
//        updateTablesButton = new JButton("UPDATE TABLES");
////        (849, 699, 100, 30)
//        updateTablesButton.setBounds(600, 699, 100, 30);
//        waiterPanel.add(exitButtonMenu);
        waiterPanel.add(updateTablesButton);

    }

    public void switchPanel(JPanel panelToSwitch){
        getContentPane().removeAll();
        getContentPane().add(panelToSwitch);
        revalidate();
        repaint();
    }

    public void createOrderPanel(int tableNumber){
        waiter.setServedTable(tableNumber);
        int FRAME_WIDTH = 985;
        orderPanel = new JPanel(null);
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel botPanel = new JPanel();

        topPanel.setBounds(0,0, FRAME_WIDTH, 70);
        topPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
//        topPanel.setBackground(Color.RED);
        JLabel namePanel = new JLabel("Select the Dish from the menu: ");
        namePanel.setFont(new Font("Serif", Font.ITALIC, 40));
        topPanel.add(namePanel);

        leftPanel.setBounds(0,70, FRAME_WIDTH/2, 600);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
//        leftPanel.setBackground(Color.YELLOW);
        leftPanel.setLayout(new BorderLayout(5,5));

        rightPanel.setBounds(FRAME_WIDTH/2, 70, FRAME_WIDTH/2, 600);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
//        rightPanel.setBackground(Color.BLUE);
        rightPanel.setLayout(new BorderLayout(5,5));

        DefaultListModel<Plate> orderListModel = new DefaultListModel<>();
        JList<Plate> order = new JList(orderListModel);
        order.setCellRenderer(new PlateDisplay());
        JScrollPane rightScrollPane = new JScrollPane(order);
        rightPanel.add(rightScrollPane, BorderLayout.CENTER);
        JLabel orderText = new JLabel("You can modify your order here: ");
        orderText.setFont(new Font("Comic sans", Font.BOLD, 15));
        rightPanel.add(orderText, BorderLayout.BEFORE_FIRST_LINE);

//        Plate plate1 = new Plate("Pizza", 1, 5.56);
//        Plate plate2 = new Plate("Defe", 2, 8.97);
//        Plate plate3 = new Plate("sfjfjwos", 1, 8);
//        ArrayList<Plate> initialMenu = new ArrayList<>();
//        initialMenu.add(plate1);
//        initialMenu.add(plate2);
//        initialMenu.add(plate3);
        ArrayList<Plate> initialMenu = new ArrayList<>();
        for(int i=0; i<restaurant.getMenuArray().size(); i++){
            for (int j=0; j<restaurant.getMenuArray().get(i).size(); j++){
                if (restaurant.getMenuArray().get(i).get(j) != null) {
                    initialMenu.add(restaurant.getMenuArray().get(i).get(j));
                }
            }
        }


        JList<Plate> menu = new JList(initialMenu.toArray());
        menu.setCellRenderer(new PlateDisplay());
        JScrollPane leftScrollPane = new JScrollPane(menu);
        leftPanel.add(leftScrollPane, BorderLayout.CENTER);
        JLabel menuText = new JLabel("Select from the menu: ");
        menuText.setFont(new Font("Comic sans", Font.BOLD, 15));
        leftPanel.add(menuText, BorderLayout.BEFORE_FIRST_LINE);

        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                waiter.addPlate(menu.getSelectedValue());
                orderListModel.removeAllElements();
                orderListModel.addAll(waiter.getOrder());
            }
        });
        order.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JOptionPane.showConfirmDialog(rightPanel,"Would you like to delete? ","DELETE",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    waiter.deletePlate(order.getSelectedValue());
                    orderListModel.removeAllElements();
                    orderListModel.addAll(waiter.getOrder());

                }
            }
        });

        orderPanel.add(topPanel);
        orderPanel.add(leftPanel);
        orderPanel.add(rightPanel);
        orderPanel.add(botPanel);
        orderPanel.add(endOrderButton);

    }

    public void createCookPanel() {
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

//        DefaultListModel<ArrayList<String>> orderDefaultListModel = new DefaultListModel<>();
//        JList orderList = new JList(orderDefaultListModel);
//        JScrollPane orderScrollPane = new JScrollPane(orderList);

        DefaultListModel<ArrayList<String>> allOrdersListModel = new DefaultListModel<>();
        HashMap<Integer, ArrayList<Order<Plate>> > allOrders = restaurant.getOrderDict();
        JList orderList = new JList(allOrdersListModel);
        JScrollPane orderScrollPane = new JScrollPane(orderList);
        ArrayList<String> arrayString = new ArrayList<>();
        for (int i=1; i<=allOrders.size(); i++){
            String s = "Table " + i + " has " + allOrders.get(i-1).size() + " orders";
            arrayString.add(s);
        }


//        allOrdersListModel.addAll(allOrders);

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
//        cookPanel.add(exitButtonMenu);

        botCookPanel.add(evadeButton);

    }

    public void createBackButton(JButton button){
        button.setText("BACK");
        button.setBounds(849, 699, 100, 30);
    }

    public static void main(String[] args) {
        new Fram3();

    }



}
// C:\Users\baran\OneDrive\Desktop\eclipse-workspace\Restourant-java-prjk\menutest1.csv