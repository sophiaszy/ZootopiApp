import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;


import static javax.swing.ScrollPaneConstants.*;

public class ResultPage extends JPanel {


    private JLabel page_title = new JLabel("Results");
    private JButton back        = new JButton("Back");
    private JTable res_table = new JTable();
    //JScrollPane scrollPane = new JScrollPane(res_table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



    public ResultPage(ResultSet res){
        //scrollPane.setPreferredSize(new Dimension(1000,200));
        //this.add(scrollPane);
        this.add(page_title);
        page_title.setVisible(true);
        this.add(back);
        back.setVisible(true);
        ListenForButton lfb = new ListenForButton();
        back.addActionListener(lfb);
        this.setEnabled(true);
        this.setVisible(true);
       // JScrollBar bar = scrollPane.getVerticalScrollBar();
        //bar.setPreferredSize(new Dimension(40, 0));
        this.add(res_table);

        //scrollPane.setBackground(Color.ORANGE);
        res_table.setBackground(Color.green);


        //TODO: add table scroll pane
        //TODO: don't allow people to edit the scroll pane
        //Missing column headers(meta data)
        //res.getMetaData()
        try
        {

            res_table.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        //scrollPane.setVisible(true);
        res_table.setVisible(true);


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
