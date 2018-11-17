
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
Main page keeper view
 */

public class MainPage_Keeper extends JPanel {
    public String f_name;
    public ArrayList<Integer> animalIDs;
    public ArrayList<String> animalNames;

    private Keeper user_Keeper;

    private GridBagConstraints c = new GridBagConstraints();
    private JLabel hello_label = new JLabel();


    public MainPage_Keeper(int id){
        user_Keeper  = new Keeper(id);
        ResultSet employeeInfo_rse = user_Keeper.searchEmployeeID(id);
        try {
            if(employeeInfo_rse.next()){
                f_name = employeeInfo_rse.getString("f_name");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        ResultSet keeperAnimal_rse = user_Keeper.getKeeperAnimal(id);
        try {
            while(keeperAnimal_rse.next()) {
                animalIDs.add(keeperAnimal_rse.getInt("animal_id"));
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
