import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by Tommaso M. Lopedote on 18/09/2021
 * Time: 18:28
 * Project: Restourant-java-prjk
 */
import javax.swing.ListCellRenderer;
import javax.swing.JLabel;
import javax.swing.DefaultListCellRenderer;
import java.awt.Color; import javax.swing.JList; import java.awt.Component;
import java.util.HashMap;
public class ColorRenderer  extends DefaultListCellRenderer {
        /** Creates a new instance of ColorRenderer */
        public ColorRenderer() {
            initColorMap();
        }
        public Component getListCellRendererComponent(JList list, Object value,int index,boolean isSelected,boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Color) {
                Color color = (Color)value;
                String strColor = (String)colorMap.get(color);
                if (strColor != null) {
                    setText(strColor);
                }setBackground(color);
            }
            return this;
        }
        private void initColorMap() {
            colorMap = new HashMap();
            for (int x=0; x < colorAssociation.length; ++x) {
                colorMap.put(colorAssociation[x][0], colorAssociation[x][1]);
            }
            colorAssociation = null;
        }
        private HashMap colorMap;
        private Object[][] colorAssociation = {     {Color.BLACK, "Black" },
                {Color.BLUE, "Blue" },     {Color.CYAN, "Cyan" },
                {Color.DARK_GRAY, "Dark Gray" },     {Color.GRAY, "Gray" },
                {Color.GREEN, "Green"},     {Color.LIGHT_GRAY, "Light Gray" },
                {Color.MAGENTA, "Magenta"},      {Color.ORANGE, "Orange" },
                {Color.PINK, "Pink" },      {Color.RED, "Red"},
                {Color.WHITE, "White"},      {Color.YELLOW, "Yellow"},   };
}

