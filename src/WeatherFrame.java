/**
 * Created by revenage on 4/25/16.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class WeatherFrame extends JFrame {
    JPanel settingsPanel = new JPanel(new GridLayout(1,3));
    JPanel todayPanel = new JPanel(new GridLayout(3,1));
    JPanel weekdaysPanel = new JPanel(new GridLayout(7,5));

    JComboBox chooseCity = new JComboBox();
    JComboBox chooseCantry = new JComboBox();

    JButton reloadButton = new JButton("reload");

    JLabel todayDate = new JLabel("Today: 12 May 2016");
    JLabel todayTemp = new JLabel("17C");
   // BufferedImage myPicture = ImageIO.read(new File(""));
   // JLabel picLabel = new JLabel(new ImageIcon(myPicture));

    


    WeatherFrame() {
        setBounds(500, 500, 500, 500);
        setLayout(new BorderLayout());
        add(settingsPanel,BorderLayout.NORTH);
        add(todayPanel,BorderLayout.CENTER);
        add(weekdaysPanel,BorderLayout.SOUTH);

        settingsPanel.add(reloadButton);
        settingsPanel.add(chooseCantry);
        settingsPanel.add(chooseCity);

        todayPanel.add(todayDate);
        todayPanel.add(todayTemp);
      //  todayDate.add(picLabel);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
