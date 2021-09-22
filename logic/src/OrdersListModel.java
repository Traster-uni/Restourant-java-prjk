import javax.swing.*;
import java.util.ArrayList;

public class OrdersListModel {

    public static void main(String[] args) {
        ArrayList<JButton> tables = new ArrayList<>();
        for (int i=1; i<6; i++){
            JButton button = new JButton("Table " + i);
            tables.add(button);
        }
        System.out.println();
    }

}
