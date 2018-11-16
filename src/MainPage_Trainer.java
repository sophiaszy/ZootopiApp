
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
Main page Trainer View
 */
public class MainPage_Trainer extends JPanel {
    //initial commit
    public String f_name;

    private Trainer user_Trainer;

    private GridBagConstraints c = new GridBagConstraints();
    private JLabel hello_label = new JLabel();

    public MainPage_Trainer(int id){

        user_Trainer  = new Trainer(id);
        ResultSet employeeInfo = user_Trainer.searchEmployeeID(id);

        try {
            if(employeeInfo.next()){
                f_name = employeeInfo.getString("f_name");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        setBackground(Color.ORANGE);

        c.gridx = 0;
        c.gridy = 0;
        hello_label.setText("Hello, "+ f_name);
        add(hello_label,c);
    }
}
