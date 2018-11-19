
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;

/*
Main page Trainer View
 */
public class MainPage_Trainer extends JPanel {
    //initial commit
    public String f_name;
    private JButton logout = new JButton("Log out");
    private JTable res_table = new JTable();

    private Trainer user_Trainer;

    private GridBagConstraints c = new GridBagConstraints();
    private JLabel hello_label = new JLabel();

    public MainPage_Trainer(int id){
        setBackground(Color.WHITE);
        user_Trainer  = new Trainer(id);
        ResultSet employeeInfo = user_Trainer.searchEmployeeID(id);

        try {
            if(employeeInfo.next()){
                f_name = employeeInfo.getString("f_name");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());

        c.gridy = 0;

        c.gridx = 0;
        add(new JLabel("     "),c);

        hello_label.setText("Hello, trainer "+ f_name);
        c.gridx = 1;
        add(hello_label,c);

        c.gridx = 2;
        add(logout,c);
        ListenForButton lfb = new ListenForButton();
        logout.addActionListener(lfb);

        c.gridx = 3;
        add(new JLabel("     "),c);
        c.gridx = 4;
        add(new JLabel("     "),c);
        c.gridx = 5;
        add(new JLabel("     "),c);

        ResultSet res = user_Trainer.getTrainerView();
        try {
            if (res.next() == false) {
                JOptionPane.showMessageDialog(null, "No Results.");
            } else {
                ResultSetMetaData rsMetaData = res.getMetaData();
                DefaultTableModel dtm = new DefaultTableModel();
                int cols = rsMetaData.getColumnCount();
                Vector colName = new Vector();
                Vector dataRows = new Vector();

                for (int i = 1; i < cols+1; i++) {
                    colName.addElement(rsMetaData.getColumnName(i));
                }
                dtm.setColumnIdentifiers(colName);

                dtm.addRow(colName);
                do {
                    dataRows = new Vector();
                    for (int j = 1; j < cols+1; j++) {
                        dataRows.addElement(res.getString(j));
                    }
                    dtm.addRow(dataRows);
                }
                while (res.next());
                res_table.setModel(dtm);
                res_table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
                TableColumnModel colModel= res_table.getColumnModel();
                colModel.getColumn(0).setPreferredWidth(150);
                colModel.getColumn(2).setPreferredWidth(100);
                colModel.getColumn(3).setPreferredWidth(100);
                colModel.getColumn(4).setPreferredWidth(140);
                colModel.getColumn(7).setPreferredWidth(100);
                colModel.getColumn(8).setPreferredWidth(120);

                res_table.setColumnModel(colModel);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 4;
        c.insets = new Insets(30,0,0,0);  //top padding

        addComponent(1,2,1,1,GridBagConstraints.HORIZONTAL,c,res_table);
    }

    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == logout){
                ZootopiApp.main_window_trainer.setEnabled(false);
                ZootopiApp.main_window_trainer.setEnabled(false);
                ZootopiApp.window.remove(ZootopiApp.main_window_trainer);
                ZootopiApp.login.setVisible(true);
                ZootopiApp.login.setEnabled(true);
                ZootopiApp.main_window_trainer = null;
                ZootopiApp.loggedIn = false;
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
