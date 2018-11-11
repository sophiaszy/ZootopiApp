package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/*
  This page will be the first thing the user sees.  This page will contain a "user id" field that will determine the
  view the person will see.  Login page should also have a button that executes the initial query for the user type,
  and error handling if the user does not exist etc.
   */
public class LoginPage extends JPanel {

    //components
    private    JButton login_button = new JButton    ("Login");
    private    JButton focus_grab = new JButton    ();
    private     JLabel login_label  = new JLabel     ("Please enter eployee ID:");
    private JTextField login_field  = new JTextField ("1234567",10);

    int buttonClicked = 0;
    private JLabel b_click  = new JLabel("Button clicked:" + buttonClicked);


    public LoginPage() {

        this.add(login_button);
        ListenForButton lfb = new ListenForButton();
        login_button.addActionListener(lfb);
        add(b_click);
        login_button.requestFocus();

        this.setBackground(Color.GRAY);
        Border login_border = BorderFactory.createTitledBorder("login");
        this.setBorder(login_border);
        this.add(login_label);
        login_label.setToolTipText("<HtMl><p>If you have forgotten,&nbsp;<strong>contact your supervisor</strong>.</p></HtMl>");

        this.add(login_field);
        Focus f = new Focus();
        login_field.addFocusListener(f);

    }

    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == login_button){
                buttonClicked ++;
                b_click.setText("Button clicked:" + buttonClicked);
            }
        }

    }

    private class Focus implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            login_field = (JTextField)e.getComponent();
            login_field.setText("");
            login_field.removeFocusListener(this);
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

}


    //TODO: mouse input button
    //TODO: mouse tooltip "enter"

