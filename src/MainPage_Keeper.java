
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
Main page keeper view
 */

public class MainPage_Keeper extends JPanel {
    public String f_name;

    private Keeper user_Keeper;

    private GridBagConstraints c = new GridBagConstraints();
    private JLabel hello_label = new JLabel();


    public MainPage_Keeper(int id){
        user_Keeper  = new Keeper(id);
        ResultSet employeeInfo = user_Keeper.searchEmployeeID(id);

        try {
            if(employeeInfo.next()){
                f_name = employeeInfo.getString("f_name");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        setBackground(Color.PINK);

        c.gridx = 0;
        c.gridy = 0;
        hello_label.setText("Hello, "+ f_name);
        add(hello_label,c);
    }
}
