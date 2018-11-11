package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
  This page will be the first thing the user sees.  This page will contain a "user id" field that will determine the
  view the person will see.  Login page should also have a button that executes the initial query for the user type,
  and error handling if the user does not exist etc.
   */
public class LoginPage extends JPanel {

    //components
    private JButton login_button = new JButton("Login");
    private JLabel   login_label = new JLabel("Please enter employee ID");
    private JLabel   piclabel;
    private JTextField login_field = new JTextField("#####");
    private JToolTip label_tt = new JToolTip();

    public LoginPage(){

        //try{
            //BufferedImage myPicture = ImageIO.read(new File(gui/VA_logo.png);
            //piclabel = new JLabel(new ImageIcon(myPicture));
            //piclabel.setSize(new Dimension(100,100));

        //this.add(piclabel);


        Border login_border = BorderFactory.createTitledBorder("login");
        this.add(login_label);
        this.add(login_field);
        this.add(login_button);
        this.setBorder(login_border);
        this.setVisible(true);
        login_field.requestFocusInWindow(); // Auto select highlight, currently not working
    /*
        }
    catch(IOException e) {
            System.out.println("Message: " + e.getMessage());
            }
     */
        }
    }

    //TODO: action listener
    //TODO: mouse input button
    //TODO: mouse tooltip "enter"

