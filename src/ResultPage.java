import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class ResultPage extends JPanel {
    
    private JLabel page_title = new JLabel("Results");
    private JButton back = new JButton("Back");
    private JTable res_table = new JTable();

    public ResultPage(ResultSet res) {
        this.add(page_title);
        setBackground(Color.WHITE);
        page_title.setVisible(true);
        this.add(back);
        back.setVisible(true);
        ListenForButton lfb = new ListenForButton();
        back.addActionListener(lfb);

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

                do {
                    dataRows = new Vector();
                    for (int j = 1; j < cols+1; j++) {
                        dataRows.addElement(res.getString(j));
                    }
                    dtm.addRow(dataRows);
                }
                while (res.next());
                res_table.setModel(dtm);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
        add(new JScrollPane(res_table));
    }
    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back){
                ZootopiApp.main_window_manager.setVisible(true);
                ZootopiApp.main_window_manager.setEnabled(true);
                ZootopiApp.results.setVisible(false);
                ZootopiApp.results.setEnabled(false);
            }
        }
    }
}