/**
 * Created by Tommaso M. Lopedote on 17/09/2021
 * Time: 10:24
 * Project: Restourant-java-prjk
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

public class FormattedSample {
    public static void main(final String args[]) {
        JFrame frame = new JFrame("Formatted Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DateFormat displayFormat = new SimpleDateFormat("yyyy--MMMM--dd");
        DateFormatter displayFormatter = new DateFormatter(displayFormat);
        DateFormat editFormat = new SimpleDateFormat("MM/dd/yy");
        DateFormatter editFormatter = new DateFormatter(editFormat);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(displayFormatter,
                displayFormatter, editFormatter);
        JFormattedTextField date2TextField = new JFormattedTextField(factory, new Date());
        frame.add(date2TextField, BorderLayout.NORTH);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JFormattedTextField source = (JFormattedTextField) actionEvent.getSource();
                Object value = source.getValue();
                System.out.println("Class: " + value.getClass());
                System.out.println("Value: " + value);
            }
        };
        date2TextField.addActionListener(actionListener);

        frame.add(new JTextField(), BorderLayout.SOUTH);
        frame.setSize(250, 100);
        frame.setVisible(true);
    }
}
