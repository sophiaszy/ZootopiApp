

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.SOUTH;

/*
Main function file.  Launches the app
 */

public class ZootopiApp {

    public static JFrame            window              = new JFrame("ZootopiApp");
    public static LoginPage         login               = new LoginPage();
    public static Employee          user                = null;
    public static ZooManager        manager             = null;
    public static MainPage_Manager  main_window_manager = null;
    public static MainPage_Keeper   main_window_keeper  = null;
    public static MainPage_Trainer  main_window_trainer = null;
    public static ResultPage        results             = null;

    public static Boolean loggedIn = false;


    public ZootopiApp(){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(1000,700));
        window.setBackground(Color.WHITE);
        window.setLocationRelativeTo(null);
        window.setResizable(true);
        window.add(login);

        java.net.URL imgUrl = getClass().getResource("image/Zapp_logo.png");
        ImageIcon icon = new ImageIcon(imgUrl);
        JLabel back = new JLabel(icon);
        window.add(back,SOUTH);
        window.setBackground(Color.WHITE);
        window.setVisible(true);
    }

    public static void main(String[] args ){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ZootopiApp application = new ZootopiApp();
            }
        });
    }
}

