import javax.swing.*;
import java.awt.*;

public class PlateDisplay extends JLabel implements ListCellRenderer<Plate> {
    public Component getListCellRendererComponent(JList<? extends Plate> list, Plate plate, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        if (isSelected){
//            setBackground(list.getSelectionBackground());
//            setForeground(list.getSelectionForeground());
            setBackground(new Color(115, 133, 142, 75));
            setForeground(new Color(68, 74, 79));
        }else{
//            setBackground(list.getBackground());
//            setForeground(list.getForeground());
            setBackground(Color.BLACK);
            setForeground(Color.BLACK);
        }
        setFont(new Font("Comic Sans", Font.PLAIN, 20));
        setText(plate.getName() + " " + plate.getPrize() + " Euro" );
        return this;
    }
}
