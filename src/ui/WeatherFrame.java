package ui; /**
 * Created by revenage on 4/25/16.
 */
import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.NORTH;

public class WeatherFrame extends JFrame {
    //JPanel settingsPanel = new JPanel(new GridLayout(1,3));
    JPanel todayPanel = new JPanel(new GridLayout(3,1));
    JPanel weekdaysPanel = new JPanel();

    JLabel todayDate = new JLabel("Today: 12 May 2016");
    JLabel todayTemp = new JLabel("17C");

    JLabel anyLabel = new JLabel("666");
   // BufferedImage myPicture = ImageIO.read(new File(""));
   // JLabel picLabel = new JLabel(new ImageIcon(myPicture));

    String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};

    Object[][] data = {
            {"Kathy", "Smith",
                    "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
                    "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
                    "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
                    "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
                    "Pool", new Integer(10), new Boolean(false)}
    };

    JTable table = new JTable(data, columnNames);

    public WeatherFrame() {
        setBounds(500, 500, 500, 500);
        setLayout(new BorderLayout());
        //add(settingsPanel,BorderLayout.NORTH);

        add(todayPanel,BorderLayout.CENTER);
        todayPanel.add(todayDate);
        todayDate.setHorizontalAlignment(SwingConstants.CENTER);

        add(weekdaysPanel,BorderLayout.SOUTH);
        //weekdaysPanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        weekdaysPanel.add(table, BorderLayout.SOUTH);
        table.setShowGrid(false);
        for (int i = 0; i < 5; i++) {
            table.setRowHeight(i, 40);
        }

        for (int i = 0; i < 5; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(95);
        }

        //table.setPreferredSize(new Dimension(500, 300));
        //table.getTableHeader().setPreferredSize(new Dimension(500, 30));

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
