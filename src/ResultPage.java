import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import static javax.swing.ScrollPaneConstants.*;

public class ResultPage extends JPanel {

    JLabel page_title = new JLabel("Results");
    JScrollPane scroll_pane = new JScrollPane(VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JTable result_table = new JTable();
    JButton back = new JButton("Back");

    public ResultPage (ResultSet rs){
        this.add(page_title);
        this.add(back);
        this.add(scroll_pane);

        //TODO:setting scroll pane size?

        scroll_pane.add(result_table);

        ListenForButton lfb = new ListenForButton();
        back.addActionListener(lfb);
    }
    /* //TODO: from sophia, code to "display" a results table.
    private static void printTable(ResultSet result) throws SQLException {
        // code from stack overflow
        ResultSetMetaData rsmd = result.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (result.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = result.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }
    */

    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back){
                //drop this page
                //set page before active
            }
        }
    }
}
