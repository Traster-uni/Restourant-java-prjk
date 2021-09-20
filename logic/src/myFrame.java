import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    protected JPanel topPanel, midPanel1, midPanel2, botPanel;
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
        restaurant = new Restaurant();
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
        Chef chef = new Chef(4);
        restaurant.setChef(chef);
        chef.addNewDish("Carbonara", 2, 10.00);
        chef.addNewDish("Torta", 4, 25.00);
        //editing
        chefPanel = new JPanel();
        chefPanel.setLayout(null);

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

        textFieldTop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws NumberFormatException {
                Integer intInputValue = Integer.parseInt(textFieldTop.getText());
                JOptionPane.showMessageDialog(topPanel, textFieldTop.getText().toString());

            }
        });

        JButton enterTextButton = new JButton("OK");
        enterTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //checks for valid input from textfield
                boolean editValid = textFieldTop.isEditValid();
                if (editValid) {
                    Integer intInputValue = Integer.parseInt(textFieldTop.getText());
                    JOptionPane.showMessageDialog(topPanel, intInputValue);
                }else{
                    JOptionPane.showMessageDialog(topPanel, "Insert only numerical value");
                }
            }
        });

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
        JScrollPane displayMenu = new JScrollPane(textArea);
        displayMenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        displayMenu.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);

        midPanel2.add(readLabel, BorderLayout.BEFORE_FIRST_LINE);
        midPanel2.add(displayMenu, BorderLayout.CENTER);


        //-----------------------------
        //-------botPanel
        //-----------------------------
        botPanel.setBounds(0, 455, FRAME_WIDTH, 80);
        //uncomment to see the panel
//        botPanel.setBackground(Color.BLUE);
        //panel borders and layout
        botPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        botPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        //panel components
        JLabel directoryLabel = new JLabel("File menu location: ");
        JTextField directoryTextField = new JTextField();
        directoryTextField.setColumns(65);
        JButton updateButton = new JButton("UPDATE");
        JButton readButton = new JButton("READ");
        JButton writeButton = new JButton("WRITE");

        ActionListener directoryActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String directory = directoryTextField.getText();
                chef.setMenuDirectory(directory);
            }
        };

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chef.readMenu();
                for (int i = 0; i < chef.getBufferPlate().size(); i++) {
                    for (int j = 0; j < chef.getBufferPlate().get(i).size(); j++)
                    menuListModel.addElement(chef.getBufferPlate().get(i).get(j));
                }
            }
        });

        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chef.writeMenu();
            }
        });
        directoryTextField.addActionListener(directoryActionListener);
        updateButton.addActionListener(directoryActionListener);

        botPanel.add(directoryLabel);
        botPanel.add(directoryTextField);
        botPanel.add(updateButton);
        botPanel.add(readButton);
        botPanel.add(new Box.Filler(new Dimension(300,2), new Dimension(800,2),new Dimension(800,2)));
        botPanel.add(writeButton);
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
