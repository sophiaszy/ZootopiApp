package GUI;


import javax.swing.*;
import java.awt.*;

/*
Main function file.  Launches the app
 */
public class ZootopiApp {

    public static JFrame                  window = new JFrame("ZootopiApp");
    public static LoginPage                login = new LoginPage();
    //public static ZooManager                user = null;
    public static MainPage_Manager   main_window = null;


    public ZootopiApp(){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(800,500));
        window.setBackground(Color.BLUE);
        window.setLocationRelativeTo(null);
        window.setResizable(true);
        window.add(login);
        window.setVisible(true);
    }

    public static void main(String[] args ){

        //TODO: BRANDON -connect to database, and proceed to main page

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ZootopiApp application = new ZootopiApp();
            }
        });
    }
}

