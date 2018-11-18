import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;


import static java.awt.GridBagConstraints.CENTER;
import static java.awt.GridBagConstraints.NORTH;
import static java.awt.GridBagConstraints.SOUTH;
import static javax.swing.ScrollPaneConstants.*;

public class ResultPage extends JPanel {


    private JLabel page_title = new JLabel("Results");
    private JButton back = new JButton("Back");
    private JTable res_table = new JTable();


    public ResultPage(ResultSet res) {
        setBackground(Color.WHITE);
        this.add(page_title);
        page_title.setVisible(true);
        this.add(back);
        back.setVisible(true);
        ListenForButton lfb = new ListenForButton();
        back.addActionListener(lfb);


        try {
            if (res.next() == false) {
                JOptionPane.showMessageDialog(null,
                        "No Results!", "Results", JOptionPane.WARNING_MESSAGE);
            } else {
                ResultSetMetaData rsMetaData = res.getMetaData();
                DefaultTableModel dtm = new DefaultTableModel();
                int cols = rsMetaData.getColumnCount();
                Vector colName = new Vector();
                Vector dataRows = new Vector();

                for (int i = 1; i < cols; i++) {
                    colName.addElement(rsMetaData.getColumnName(i));
                }
                dtm.setColumnIdentifiers(colName);

                do {
                    dataRows = new Vector();
                    for (int j = 1; j < cols; j++) {
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
        resizeColumnWidth(res_table);
        add(new JScrollPane(res_table, VERTICAL_SCROLLBAR_AS_NEEDED,HORIZONTAL_SCROLLBAR_AS_NEEDED));
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

    //table width code Modified from StackOverflow
    //https://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}