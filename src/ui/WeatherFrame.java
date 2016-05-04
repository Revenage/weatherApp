package ui; /**
 * Created by revenage on 4/25/16.
 */
import javax.swing.*;
import java.awt.*;

public class WeatherFrame extends JFrame {
    //JPanel settingsPanel = new JPanel(new GridLayout(1,3));
    JPanel todayPanel = new JPanel(new GridLayout(3,1));
    JPanel weekdaysPanel = new JPanel(new GridLayout(6,5));

    JComboBox chooseCity = new JComboBox();
    JComboBox chooseCantry = new JComboBox();

    JButton reloadButton = new JButton("reload");

    JLabel todayDate = new JLabel("Today: 12 May 2016");
    JLabel todayTemp = new JLabel("17C");

    JLabel anyLabel = new JLabel("666");
   // BufferedImage myPicture = ImageIO.read(new File(""));
   // JLabel picLabel = new JLabel(new ImageIcon(myPicture));

    public WeatherFrame() {
        setBounds(500, 500, 500, 500);
        setLayout(new BorderLayout());
        //add(settingsPanel,BorderLayout.NORTH);
        add(todayPanel,BorderLayout.NORTH);
        add(weekdaysPanel,BorderLayout.SOUTH);

        /*settingsPanel.add(reloadButton);
        settingsPanel.add(chooseCantry);
        settingsPanel.add(chooseCity);*/

        for (int i = 0; i < 6; i++) {
            weekdaysPanel.add(anyLabel);
        }

        todayPanel.add(todayDate);
        todayPanel.add(todayTemp);
      //  todayDate.add(picLabel);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
