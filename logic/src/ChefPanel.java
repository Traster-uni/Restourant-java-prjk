import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Tommaso M. Lopedote on 12/09/2021
 * Time: 10:30
 * Project: Restourant-java-prjk
 */
public class ChefPanel extends myFrame {
    final int FRAME_WIDTH = 985;
    private Restaurant restaurant;
    private JPanel topPanel, midPanel, botPanel;
    private JPanel overMidPanel;

    public void createChefPanel() {
        chefPanel = new JPanel();
        chefPanel.setLayout(null);

        topPanel = new JPanel();
        chefPanel.add(topPanel);
        applyTopPanelContent();

        midPanel = new JPanel();
        chefPanel.add(midPanel);
        applyMidPanelContent();

        overMidPanel = new JPanel();
        midPanel.add(overMidPanel);
        applyOverMidPanelContent();

        botPanel = new JPanel();
        chefPanel.add(botPanel);
        applyBotPanelContent();

    }

    public void applyTopPanelContent() {
        topPanel.setBounds(0, 0, FRAME_WIDTH, 60);
        //uncomment to see the panel
        topPanel.setBackground(Color.GREEN);
        //panel borders and layout
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        topPanel.setLayout(new BorderLayout(5, 5));
        //panel components
        JLabel frameTitle = new JLabel("Chef Control Panel");
        JLabel textFieldLabel = new JLabel("Table Number: ");
        JTextField textFieldTop = new JTextField(4);
        JButton enterTextButton = new JButton("OK");
        topPanel.add(frameTitle, BorderLayout.BEFORE_FIRST_LINE);
        topPanel.add(textFieldLabel, BorderLayout.WEST);
        topPanel.add(textFieldTop, BorderLayout.CENTER);
        topPanel.add(enterTextButton, BorderLayout.EAST);
    }

    public void applyMidPanelContent(){
        midPanel.setBounds(0, 60, FRAME_WIDTH, 500);
        //uncomment to see the panel
        midPanel.setBackground(Color.RED);
        //panel borders and layout
        midPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));

        //panel components
        JLabel writeLabel = new JLabel("Write the menu here: ");
        writeLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        JLabel readLabel = new JLabel("Menu entries: ");
        readLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);

        JScrollPane displayMenu = new JScrollPane();
        displayMenu.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);


        midPanel.add(writeLabel);
        midPanel.add(readLabel);
        midPanel.add(displayMenu);


//        public void displayAll() {
//            JOptionPane.showMessageDialog(null,
//                    new JScrollPane(new JList(cards.toArray())));
//        }
    }

    public void applyOverMidPanelContent(){
        overMidPanel.setBackground(Color.BLACK);
        overMidPanel.add(new JTextField());
        overMidPanel.add(new JLabel("Category: "));
        overMidPanel.add(new JTextField());
        overMidPanel.add(new JLabel("Price: "));
        overMidPanel.add(new JTextField());

        overMidPanel.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
        overMidPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        overMidPanel.setBounds(0,60,100,20);
        overMidPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        overMidPanel.setVisible(true);

    }

    public void applyBotPanelContent(){
        botPanel.setBounds(0, 560, FRAME_WIDTH, 130);
        botPanel.setBackground(Color.BLUE);

    }
}
