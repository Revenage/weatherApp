package ui; /**
 * Created by revenage on 4/25/16.
 */
import model.DayWeather;

import javax.swing.*;

import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class WeatherFrame extends JFrame {
    //JPanel settingsPanel = new JPanel(new GridLayout(1,3));
    JPanel todayPanel = new JPanel(new GridLayout(3,1));
    JPanel weekdaysPanel = new JPanel();

    public WeatherFrame(ArrayList<DayWeather> days) {
        TableModel model = new MyTableModel(days);
        JTable table = new JTable(model);

        JTableHeader header = table.getTableHeader();
        add(header, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);

        JLabel todayDate = new JLabel("Today: 12 May 2016");
        JLabel todayTemp = new JLabel("17C");

        todayPanel.add(todayDate);
        todayPanel.add(todayTemp);

        setBounds(600, 600, 600, 600);
        setLayout(new BorderLayout());

        add(todayPanel,BorderLayout.CENTER);
        add(weekdaysPanel,BorderLayout.SOUTH);
        weekdaysPanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        weekdaysPanel.add(table, BorderLayout.SOUTH);

        table.setPreferredSize(new Dimension(600, 300));
        table.getTableHeader().setPreferredSize(new Dimension(600, 30));

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
