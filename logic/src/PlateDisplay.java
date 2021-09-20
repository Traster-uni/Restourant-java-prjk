import javax.swing.*;
import java.awt.*;

/**
 * Created by Tommaso M. Lopedote on 18/09/2021
 * Time: 18:38
 * Project: Restourant-java-prjk
 */
public class PlateDisplay extends JLabel implements ListCellRenderer<Plate> {
    public Component getListCellRendererComponent(JList<? extends Plate> list, Plate plate, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        if (isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }else{
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setFont(new Font("Comic Sans", Font.PLAIN, 20));
        setText(plate.getName() + " " + plate.getPrize());
        return this;
    }
}
