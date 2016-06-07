package ui;

import model.DayWeather;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by reven on 07.06.2016.
 */
public class MyTableModel extends AbstractTableModel {

    ArrayList<DayWeather> days;
    MyTableModel(ArrayList<DayWeather> days) {
        super();
        this.days = days;
    }

    @Override
    public int getRowCount() {
        return days.size();
    }

    @Override
    public int getColumnCount() {
        return days.size();
    }

    @Override
    public String getColumnName(int c) {
        return Integer.toString(days.get(c).getDayOfMonth());
    }

    @Override
    public Object getValueAt(int r, int c) {
        switch (r) {
            case 0:
                return days.get(c).getDayTemp();
            case 1:
                return days.get(c).getNigthTemp();
            case 2:
                return days.get(c).getWether();
            case 3:
                return days.get(c).getTypeOfWether();
            case 4:
                return days.get(c).getWindSpeed();
            case 5:
                return days.get(c).getWindDirection();
            case 6:
                return days.get(c).getCloudiness();
            default:
                return "";
        }
    }
}