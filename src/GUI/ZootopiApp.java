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
        window.setPreferredSize(new Dimension(1500,1000));
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
        window.add(login);
    }

    public static void main(String[] args ){

        //TODO: BRANDON -connect to database, and proceed to main page

        ZootopiApp application = new ZootopiApp();

    }
}

