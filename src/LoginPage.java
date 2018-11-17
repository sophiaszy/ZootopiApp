
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
  This page will be the first thing the user sees.  This page will contain a "user id" field that will determine the
  view the person will see.  Login page should also have a button that executes the initial query for the user type,
  and error handling if the user does not exist etc.
   */
public class LoginPage extends JPanel {
    Driver driver;
    public final String manager_psw = "abcde";


    //components
    private    JButton login_button = new JButton    ("Login");

    private     JLabel employeelogin_label  = new JLabel("If you are an employee, please enter employee ID:");
    private     JLabel managerlogin_label = new JLabel("If you are the manager, please enter the password:");
    private     JLabel error_label = new JLabel("one field should be filled");


    private JTextField employeeID_field  = new JTextField (10);
    private JTextField managerPwd_field = new JTextField("abcde",10);

    private GridBagConstraints c = new GridBagConstraints();

    public static final int Height = 80;
    public static final int Width = 80;


    public LoginPage() {
        setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        c.fill = GridBagConstraints.HORIZONTAL;

        Border login_border = BorderFactory.createTitledBorder("login");
        this.setBorder(login_border);

        c.gridy = 0;
        c.gridx = 0;
        add(employeelogin_label,c);
        c.gridx = 1;
        add(employeeID_field,c);

        c.gridy = 1;
        c.gridx = 0;
        add(managerlogin_label,c);
        c.gridx = 1;
        add(managerPwd_field,c);

        c.gridy = 4;
        c.anchor = GridBagConstraints.NORTH;
        add(login_button,c);
        ListenForButton lfb = new ListenForButton();
        login_button.addActionListener(lfb);
        login_button.requestFocus();

        c.gridx = 0;
        c.gridy = 6;
        error_label.setForeground(Color.red);
        error_label.setVisible(false);
        add(error_label);


        driver = Driver.getInstance();

        ResultSet r  = driver.executeQuery("select * from trainer");
        try {
            if (r.next()) {
                System.out.println("trainer added");

            }
        }catch (SQLException err) {
            System.out.println("trainer err !!!!!");

        }
    }



    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == login_button){
                String inputIDValue = employeeID_field.getText();
                String inputPswValue = managerPwd_field.getText();

                // check the type of employee
                boolean isKeeper = false;
                boolean isTrainer = false;

                // only one field should be filled
                // Employee login
                if(!employeeID_field.getText().isEmpty() && managerPwd_field.getText().isEmpty()) {

                    try {
                        int id = Integer.parseInt(inputIDValue);
                        String keeperQuery = "select * from keeper where employee_id = " + id;
                        System.out.println("executing query : " + keeperQuery);
                        ResultSet keeper_rse = driver.executeQuery(keeperQuery);
                        try {
                            isKeeper = keeper_rse.next();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                        String trainerQuery = "select * from trainer where employee_id = " + id;
                        System.out.println("executing query : " + trainerQuery);
                        ResultSet trainer_rse = driver.executeQuery(trainerQuery);

                        try {
                            isTrainer = trainer_rse.next();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                        if (isKeeper) {
                            ZootopiApp.user = new Keeper(id);
                            ZootopiApp.loggedIn = true;
                            MainPage_Keeper mainPage_keeper = new MainPage_Keeper(id);
                            ZootopiApp.main_window_keeper = mainPage_keeper;
                            ZootopiApp.window.add(mainPage_keeper);
                            employeeID_field.setText("");
                            setVisible(false);
                            setEnabled(false);
                        } else if (isTrainer) {
                            ZootopiApp.user = new Trainer(id);
                            ZootopiApp.loggedIn = true;
                            MainPage_Trainer mainPage_trainer = new MainPage_Trainer(id);
                            ZootopiApp.main_window_trainer = mainPage_trainer;
                            ZootopiApp.window.add(mainPage_trainer);
                            employeeID_field.setText("");
                            setVisible(false);
                            setEnabled(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid id, please try again", "Invalid ID", JOptionPane.ERROR_MESSAGE);

                        }

                    } catch (NumberFormatException err) {
                        JOptionPane.showMessageDialog(null, "account doe not exist", "Invalid ID", JOptionPane.ERROR_MESSAGE);
                    }

                    // Manager login
                }else if(employeeID_field.getText().isEmpty() && !managerPwd_field.getText().isEmpty()) {

                    if (managerPwd_field.getText().equals(manager_psw)){
                        ZootopiApp.manager = new ZooManager();
                        ZootopiApp.loggedIn = true;
                        MainPage_Manager mainPage_manager = new MainPage_Manager();
                        ZootopiApp.main_window_manager = mainPage_manager;
                        ZootopiApp.window.add(mainPage_manager);
                        employeeID_field.setText("");
                        setVisible(false);
                        setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid password, please try again", "Invalid Password", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "one field should be filled", "Invalid Fields", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }

    private class Focus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            employeeID_field = (JTextField)e.getComponent();
            employeeID_field.setText("");
            employeeID_field.removeFocusListener(this);
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

}


    //TODO: mouse input button
    //TODO: mouse tooltip "enter"

