package ui; /**
 * Created by revenage on 4/25/16.
 */
import model.DayWeather;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.SwingConstants.NORTH;

public class WeatherFrame extends JFrame {
    //JPanel settingsPanel = new JPanel(new GridLayout(1,3));
    JPanel todayPanel = new JPanel(new GridLayout(3,1));
    JPanel weekdaysPanel = new JPanel();

    JLabel todayDate = new JLabel("Today: 12 May 2016");
    JLabel todayTemp = new JLabel("17C");
   // BufferedImage myPicture = ImageIO.read(new File(""));
   // JLabel picLabel = new JLabel(new ImageIcon(myPicture));

   public class MyTableModel extends AbstractTableModel {

       public MyTableModel(ArrayList<DayWeather> days) {
           super();
           this.days = days;
       }

       @Override
       public int getRowCount() {
           return 5;
       }
       @Override
       public int getColumnCount() {
           return 7;
       }

       @Override
       public Object getValueAt(int rowIndex, int columnIndex) {
           return days;
       }


       /*ArrayList<DayWeather> days = weatherData.getDays();
        for (DayWeather dayData : days) {
            System.out.print(dayData.getDayOfMonth());
            System.out.print(" ");
            System.out.println(dayData.getDayTemp());
        }*/
       /*@Override
       public Object getValueAt(int r, int c) {
           return r * c;
       }*/
   }

    public WeatherFrame(ArrayList<DayWeather> data) {

        TableModel model = new MyTableModel(data);
        JTable table = new JTable(model);

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
