import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by Tommaso M. Lopedote on 12/09/2021
 * Time: 10:30
 * Project: Restourant-java-prjk
 */
public class ChefPanel extends myFrame {
    final int FRAME_WIDTH = 985;
    private Restaurant restaurant;
    private JPanel topPanel, midPanel1, midPanel2, botPanel;

    public void createChefPanel() {
        chefPanel = new JPanel();
        chefPanel.setLayout(null);

        topPanel = new JPanel();
        chefPanel.add(topPanel);
        applyTopPanelContent();

        midPanel1 = new JPanel();
        chefPanel.add(midPanel1);
        applyMidPanel1Content();

        midPanel2 = new JPanel();
        chefPanel.add(midPanel2);
        applyMidPanel2Content();

        botPanel = new JPanel();
        chefPanel.add(botPanel);
        applyBotPanelContent();

    }

    public void applyTopPanelContent() {
        topPanel.setBounds(0, 0, FRAME_WIDTH, 90);
        //uncomment to see the panel
        topPanel.setBackground(Color.GREEN);
        //panel borders and layout
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        topPanel.setLayout(new BorderLayout(5, 5));
        //panel components
        JLabel frameTitle = new JLabel("Chef Control Panel");
        frameTitle.setFont(new Font("Comic Sans", Font.BOLD, 20));
        JLabel textFieldLabel = new JLabel("Number of tables: ");

        NumberFormat integerFormatter = NumberFormat.getIntegerInstance();
        integerFormatter.setMaximumFractionDigits(0);
        JFormattedTextField textFieldTop = new JFormattedTextField(integerFormatter);
        textFieldTop.setText("");   // when one clicks on ok or just presses enter the text turns back to blank
        textFieldTop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer intInputValue = Integer.parseInt(textFieldTop.getText().replaceAll(",", ""));

                JOptionPane.showMessageDialog(topPanel, textFieldTop.getText().toString());
            }
        });

        JButton enterTextButton = new JButton("OK");
        enterTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(topPanel, textFieldTop.getText().toString());
                
            }
        });

        topPanel.add(frameTitle, BorderLayout.BEFORE_FIRST_LINE);
        topPanel.add(textFieldLabel, BorderLayout.WEST);
        topPanel.add(textFieldTop, BorderLayout.CENTER);
        topPanel.add(enterTextButton, BorderLayout.EAST);

        topPanel.add(new JLabel("Add entries here: "), BorderLayout.SOUTH);
    }

    public void applyMidPanel1Content() {
        midPanel1.setBounds(0, 90, FRAME_WIDTH, 65);
        //uncomment to see the panel
        midPanel1.setBackground(Color.BLACK);
        //panel borders and layout
        midPanel1.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        midPanel1.setLayout(new FlowLayout(FlowLayout.LEADING));

        //panel components
        JTextField nameTextField = new JTextField();
        nameTextField.setColumns(20);
        JFormattedTextField categoryTextField = new JFormattedTextField(); //onlyFewNumbersTextField
        categoryTextField.setColumns(4);
        JFormattedTextField priceTextField = new JFormattedTextField(new NumberFormatter());
        priceTextField.setColumns(6);
        JButton addButton = new JButton("ADD");
        JButton deleteButton = new JButton("DELETE");
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
    }

    public void applyMidPanel2Content() {
        midPanel2.setBounds(0, 155, FRAME_WIDTH, 300);
        //uncomment to see the panel
        midPanel2.setBackground(Color.RED);
        //panel borders and layout
        midPanel2.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        midPanel2.setLayout(new BorderLayout(5,5));

        //panel components
        JLabel readLabel = new JLabel("Menu content: ");
        readLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        // redacted
//        JTextArea textArea = new JTextArea();
//        textArea.setEditable(false);
//        textArea.setFont(new Font("Comic Sans", Font.PLAIN, 15));
//        textArea.setEditable(false);
//        for(int i = 0; i < restaurant.getMenuArray().size(); i++){
//            for(int j = 0; j < restaurant.getMenuArray().get(i).size(); j++);
//            textArea.append(restaurant.getMenuArray().get(i).toString());
//        }
//
//        JScrollPane displayMenu = new JScrollPane(textArea);
//        displayMenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        displayMenu.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);
//
//        midPanel2.add(readLabel, BorderLayout.BEFORE_FIRST_LINE);
//        midPanel2.add(displayMenu, BorderLayout.CENTER);
    }

    public void applyBotPanelContent() {
        botPanel.setBounds(0, 455, FRAME_WIDTH, 40);
        //uncomment to see the panel
        botPanel.setBackground(Color.BLUE);
        //panel borders and layout
        botPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        botPanel.setLayout(new BorderLayout(5,5));

        //panel components
        JLabel directoryLabel = new JLabel("File menu location: ");
        JTextField directoryTextField = new JTextField();
        JButton updateButton = new JButton("UPDATE");

        botPanel.add(directoryLabel, BorderLayout.WEST);
        botPanel.add(directoryTextField, BorderLayout.CENTER);
        botPanel.add(updateButton, BorderLayout.EAST);
    }
}
// DISPLAY THE ARRAY
// https://stackoverflow.com/questions/30222157/displaying-arrayliststring-in-jtextarea
//    JButton btnNewButton_1 = new JButton("Coordinate Anomalies");
//    btnNewButton_1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                ArrayList<String> anomalies = vessels.coordinateAnomaly();
//                JTextArea textArea = new JTextArea();
//                textArea.setText(anomalies);
//                textArea.setBounds(10, 79, 172, 339);
//                frame.getContentPane().add(textArea);
//            }
//        });
//}
