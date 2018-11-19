
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;

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
    private JButton logout = new JButton("Log out");
    private JTable res_table = new JTable();

    ListenForButton lfb = new ListenForButton();

    private JButton updateAnimal_btn = new JButton("update animal");
    JLabel animal_UIDLabel = new JLabel("ID:");
    JTextField animal_UinputID = new JTextField(10);
    JLabel animal_UheitLabel = new JLabel("Height:");
    JTextField animal_UinputHeit = new JTextField(10);
    JLabel animal_UweitLabel = new JLabel("Weight");
    JTextField animal_UinputWeit = new JTextField(10);
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
//
//        ResultSet keeperAnimal_rse = user_Keeper.getKeeperAnimal(id);
//        try {
//            while(keeperAnimal_rse.next()) {
////                animalIDs.add(keeperAnimal_rse.getInt("animal_id"));
//            }
//        } catch (SQLException e){
//            e.printStackTrace();
//        }

        setBackground(Color.white);
        setLayout(new GridBagLayout());
        hello_label.setText("Hello, keeper "+ f_name);
        c.insets = new Insets(0,0,0,0);  //top padding

        this.addComponent(0,0,1,1,GridBagConstraints.NONE,c,new JLabel());
        JLabel j = new JLabel("                           ");

        this.addComponent(3,0,1,1,GridBagConstraints.NONE,c,j);

        this.addComponent(1,0,1,1, GridBagConstraints.NONE,c,hello_label);
        this.addComponent(2,0,1,1, GridBagConstraints.NONE,c,logout);
        logout.addActionListener(lfb);

        // update animal
        c.insets = new Insets(30,0,0,0);  //top padding
        this.addComponent(1,1,1,1, GridBagConstraints.NONE,c,animal_UIDLabel);
        this.addComponent(2,1,1,1, GridBagConstraints.NONE,c,animal_UinputID);
        c.insets = new Insets(0,0,0,0);  //top padding
        this.addComponent(1,2,1,1, GridBagConstraints.NONE,c,animal_UheitLabel);
        this.addComponent(2,2,1,1, GridBagConstraints.NONE,c,animal_UinputHeit);
        this.addComponent(1,3,1,1, GridBagConstraints.NONE,c,animal_UweitLabel);
        this.addComponent(2,3,1, 1,GridBagConstraints.NONE,c,animal_UinputWeit);
        this.addComponent(2,4,1,1, GridBagConstraints.NONE,c,updateAnimal_btn);
        updateAnimal_btn.addActionListener(lfb);

        ResultSet res = user_Keeper.getKeeperView();
        setTable(res);
        c.insets = new Insets(30,0,0,0);  //top padding
        c.gridwidth = 4;

        this.addComponent(1,5,4,1, GridBagConstraints.HORIZONTAL,c,res_table);

    }

    private void setTable(ResultSet rse){
        // remove all rows
        DefaultTableModel model = (DefaultTableModel) res_table.getModel();
        int rows = model.getRowCount();
        for(int i = rows - 1; i >=0; i--) {
            model.removeRow(i);
            System.out.println("removing row " +i);
        }
        res_table.setModel(model);

        try {
            if (rse.next() == false) {
                JOptionPane.showMessageDialog(null, "No Results.");
            } else {
                ResultSetMetaData rsMetaData = rse.getMetaData();
                DefaultTableModel dtm = new DefaultTableModel();
                int cols = rsMetaData.getColumnCount();
                Vector colName = new Vector();
                Vector dataRows = new Vector();

                for (int i = 1; i < cols+1; i++) {
                    colName.addElement(rsMetaData.getColumnName(i));
                    System.out.println("adding identifier column name " + rsMetaData.getColumnName(i));
                }

//                // debug logs
//                System.out.println("column count =  "+dtm.getColumnCount());
                dtm.setColumnIdentifiers(colName);
//                System.out.println("column count =  "+dtm.getColumnCount());
//                for(int i = 1; i < cols+1; i++){
//                    System.out.println("column "+ i + dtm.getColumnName(i));
//
//                }

                dtm.addRow(colName);
                int n  =0 ;
                do {
                    dataRows = new Vector();
                    for (int j = 1; j < cols+1; j++) {
                        dataRows.addElement(rse.getString(j));
                        System.out.println("adding element " + rse.getString(j));

                    }
                    dtm.addRow(dataRows);
                }
                while (rse.next());
                res_table.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
                res_table.setModel(dtm);
                //table.getColumnModel().getColumn(4).setPreferredWidth(127);
                res_table.getColumnModel().getColumn(0).setPreferredWidth(100);
                res_table.getColumnModel().getColumn(2).setPreferredWidth(100);
                res_table.getColumnModel().getColumn(3).setPreferredWidth(130);
                res_table.getColumnModel().getColumn(4).setPreferredWidth(80);
                res_table.getColumnModel().getColumn(5).setPreferredWidth(80);
                res_table.getColumnModel().getColumn(6).setPreferredWidth(80);
                res_table.getColumnModel().getColumn(7).setPreferredWidth(120);
                res_table.getColumnModel().getColumn(8).setPreferredWidth(120);


            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
        System.out.println("column count =  "+res_table.getModel().getColumnCount());

        this.remove(res_table);
        c.gridwidth = 4;
        this.addComponent(1,5,4,1, GridBagConstraints.HORIZONTAL,c,res_table);
        System.out.println("column count =  "+res_table.getModel().getColumnCount());

    }


    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == logout){
                ZootopiApp.main_window_keeper.setEnabled(false);
                ZootopiApp.main_window_keeper.setEnabled(false);
                ZootopiApp.window.remove(ZootopiApp.main_window_keeper);
                ZootopiApp.main_window_keeper = null;
                ZootopiApp.login.setVisible(true);
                ZootopiApp.login.setEnabled(true);
                ZootopiApp.loggedIn = false;
            } else if (e.getSource() == updateAnimal_btn){
                try { user_Keeper.updateAnimal(
                            Integer.parseInt(animal_UinputID.getText()),
                            Integer.parseInt(animal_UinputWeit.getText()),
                            Integer.parseInt(animal_UinputHeit.getText())
                    );
                } catch(Exception err){
                JOptionPane.showMessageDialog(null,
                        "Incorrect Input. Please try again", "Update Animal", JOptionPane.ERROR_MESSAGE);
                }
                ResultSet r = user_Keeper.getKeeperView();
                setTable(r);

            }
        }
    }


    public void addComponent( int x, int y, int w, int h, int fill, GridBagConstraints gbc, Component aComponent ) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = fill;
        add(aComponent,gbc);
    }
}
