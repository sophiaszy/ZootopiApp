import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class MainPage_Manager extends JPanel {

    private static final String EMPLPOYEE = "Employee";
    private static final String ANIMAL = "Animal";
    private static final String FOOD = "Food";
    private static final String ZOO = "Zoo";
    private static final String LOCATION = "Location";
    private static final String SHOW = "Show";

    private static final String AD_ZOO1 = "2000 Meadowvale Rd";
    private static final String AD_ZOO2 = "80 Mandai Lake Rd";

    String[] tab_string = {EMPLPOYEE, ANIMAL, FOOD, ZOO, LOCATION, SHOW};
    String[] Zoos = {AD_ZOO1, AD_ZOO2};

    ZooManager user_manager = ZootopiApp.manager;
    JComboBox tabs = new JComboBox(tab_string);
    JButton logout_button = new JButton("Logout");
    JLabel tab_label = new JLabel("Select Tab:");

    private GridBagConstraints c = new GridBagConstraints();
    private GridBagConstraints c1 = new GridBagConstraints();
    private GridBagConstraints c2 = new GridBagConstraints();
    private GridBagConstraints c3 = new GridBagConstraints();
    private GridBagConstraints c4 = new GridBagConstraints();

    //======================================EMPLOYEE COMPONENTS======================================

    JButton employee_add = new JButton("Add Employee");
    JLabel employee_fNameLabel = new JLabel("First Name:");
    JTextField employee_inputFname = new JTextField(10);
    JLabel employee_lNameLabel = new JLabel("Last Name:");
    JTextField employee_inputLname = new JTextField(10);
    JLabel employee_wlkeeLabel = new JLabel("Walkeetalkee:");
    JTextField employee_inputwlkee = new JTextField(10);
    JLabel employee_IDLabel = new JLabel("ID:");
    JTextField employee_inputID = new JTextField(10);
    JLabel employee_payLabel = new JLabel("Pay");
    JTextField employee_inputPay = new JTextField(10);

    JLabel employee_ZAddressLabel = new JLabel("Zoo Address");
    JComboBox employee_inputZAddress = new JComboBox(Zoos);

    JButton employee_remove = new JButton("Remove Employee");
    JLabel employee_RfNameLabel = new JLabel("First Name:");
    JTextField employee_RinputFname = new JTextField(10);
    JLabel employee_RlNameLabel = new JLabel("Last Name:");
    JTextField employee_RinputLname = new JTextField(10);
    JLabel employee_RIDLabel = new JLabel("ID:");
    JTextField employee_RinputID = new JTextField(10);
    JButton employee_updateInfo = new JButton("Update Employee Info");
    JLabel employee_UfNameLabel = new JLabel("First Name:");
    JTextField employee_UinputFname = new JTextField(10);
    JLabel employee_UlNameLabel = new JLabel("Last Name:");
    JTextField employee_UinputLname = new JTextField(10);
    JLabel employee_UIDLabel = new JLabel("ID:");
    JTextField employee_UinputID = new JTextField(10);
    JLabel employee_UpayLabel = new JLabel("Pay");
    JTextField employee_UinputPay = new JTextField(10);
    JButton employee_search = new JButton("Search for Employee");
    JLabel employee_SfNameLabel = new JLabel("First Name:");
    JTextField employee_SinputFname = new JTextField(10);
    JLabel employee_SLNameLabel = new JLabel("Last Name:");
    JTextField employee_SinputLname = new JTextField(10);
    JButton employee_volunteer = new JButton("Search Volunteers");
    //======================================ANIMAL COMPONENTS======================================
    JButton animal_add = new JButton("Add Animal");
    JLabel animal_IDLabel = new JLabel("ID:");
    JTextField animal_inputID = new JTextField(10);
    JLabel animal_nameLabel = new JLabel("Name:");
    JTextField animal_inputName = new JTextField(10);
    JLabel animal_ageLabel = new JLabel("Age:");
    JTextField animal_inputAge = new JTextField(10);
    JLabel animal_sexLabel = new JLabel("Sex:");
    JTextField animal_inputSex = new JTextField(10);
    JLabel animal_heitLabel = new JLabel("Height:");
    JTextField animal_inputHeit = new JTextField(10);
    JLabel animal_weitLabel = new JLabel("Weight");
    JTextField animal_inputWeit = new JTextField(10);
    JLabel animal_speciesLabel = new JLabel("Species:");
    JTextField animal_inputSpecies = new JTextField(10);
    JLabel animal_eatFreqLabel = new JLabel("Eating Frequency:");
    JTextField animal_inputEatFreq = new JTextField(10);
    JLabel animal_eatAmtLabel = new JLabel("Eating Amount:");
    JTextField animal_inputEatAmt = new JTextField(10);
    JLabel animal_HabIDLabel = new JLabel("Habitat ID");
    JTextField animal_inputHabID = new JTextField(10);
    JButton animal_remove = new JButton("Remove Animal");
    JLabel animal_RIDLabel = new JLabel("ID:");
    JTextField animal_RinputID = new JTextField(10);
    JButton animal_updateInfo = new JButton("Update Animal Info");
    JLabel animal_UIDLabel = new JLabel("ID:");
    JTextField animal_UinputID = new JTextField(10);
    JLabel animal_UnameLabel = new JLabel("Name:");
    JTextField animal_UinputName = new JTextField(10);
    JLabel animal_UageLabel = new JLabel("Age:");
    JTextField animal_UinputAge = new JTextField(10);
    JLabel animal_UsexLabel = new JLabel("Sex:");
    JTextField animal_UinputSex = new JTextField(10);
    JLabel animal_UheitLabel = new JLabel("Height:");
    JTextField animal_UinputHeit = new JTextField(10);
    JLabel animal_UweitLabel = new JLabel("Weight");
    JTextField animal_UinputWeit = new JTextField(10);
    JLabel animal_UspeciesLabel = new JLabel("Species:");
    JTextField animal_UinputSpecies = new JTextField(10);
    JLabel animal_UeatFreqLabel = new JLabel("Eating Frequency:");
    JTextField animal_UinputEatFreq = new JTextField(10);
    JLabel animal_UeatAmtLabel = new JLabel("Eating Amount:");
    JTextField animal_UinputEatAmt = new JTextField(10);
    JLabel animal_UHabIDLabel = new JLabel("Habitat ID");
    JTextField animal_UinputHabID = new JTextField(10);
    JButton animal_searchSpecies = new JButton("Search by Species");
    JButton animal_SspeciesDetail = new JButton("Species Details");
    JLabel animal_SspeciesLabel = new JLabel("Species:");
    JTextField animal_SinputSpeci = new JTextField(10);
    //======================================FOOD COMPONENTS======================================
    JButton food_sites = new JButton("Get Food");
    JButton food_expires = new JButton("Expiring Food");
    //======================================ZOO COMPONENTS======================================
    JButton zoo_search = new JButton("Pick Zoo");
    JTextField zoo_input = new JTextField(10);
    JLabel zoo_inputLabel = new JLabel("Country:");
    //======================================LOCATION COMPONENTS======================================
    JButton location_searchByHab = new JButton("Find Animals In Habitat");
    JTextField location_InputByHab = new JTextField(10);
    JLabel location_ByHabLabel = new JLabel("Enclosure ID:");
    JButton location_searchForHab = new JButton("Suitable Habitat");
    JTextField location_InputSQFt = new JTextField(10);
    JLabel location_SQFtLabel = new JLabel("Square Feet:");
    JTextField location_InputDepth = new JTextField(10);
    JLabel location_depthLabel = new JLabel("Depth:");
    JTextField location_InputBiome = new JTextField(10);
    JLabel location_biomeLabel = new JLabel("Biome:");
    JButton location_searchByTemp = new JButton("Search by Temp");
    JTextField location_inputTemp = new JTextField(10);
    JLabel location_tempLabel = new JLabel("Temperature:");
    JButton location_seachForUse = new JButton("Not in Use");
    //======================================SHOW COMPONENTS======================================
    JButton show_seachBytime = new JButton("Showtimes");


    public MainPage_Manager() {
        setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        // c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        this.add(tab_label,c);

        c.gridx = 1;
        this.add(tabs,c);
        ListenForPulldown lfp = new ListenForPulldown();
        tabs.addActionListener(lfp);

        ListenForButton lfb = new ListenForButton();
        c.gridx = 2;
        this.add(logout_button,c);
        logout_button.addActionListener(lfb);

        //======================================EMPLOYEE ======================================
        c.insets = new Insets(35,0,0,0);  //top padding
//        JSeparator sep1 = new JSeparator(SwingConstants.HORIZONTAL);
//        sep1.setSize(100,1);
//        c.weightx = 5;
//        add(sep1,c);

        //y = 1
        c.gridy = 1;
        c.gridx = 0;
        this.add(employee_fNameLabel,c);
        c.gridx = 1;
        this.add(employee_inputFname,c);
        c.gridx = 2;
        this.add(employee_lNameLabel,c);
        c.gridx = 3;
        this.add(employee_inputLname,c);
        c.gridx = 4;

        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(employee_add,c);
        c.fill = GridBagConstraints.NONE;

        // y = 2
        c.insets = new Insets(0,0,0,0);  //top padding
        c.gridy = 2;
        c.gridx = 0;
        this.add(employee_wlkeeLabel,c);
        c.gridx = 1;
        this.add(employee_inputwlkee,c);
        c.gridx = 2;
        this.add(employee_IDLabel,c);
        c.gridx = 3;
        this.add(employee_inputID,c);
        c.gridx = 4;


        // y = 3
        c.gridy = 3;
        c.gridx = 0;
        this.add(employee_payLabel,c);
        c.gridx = 1;
        this.add(employee_inputPay,c);
        c.gridx = 2;
        this.add(employee_ZAddressLabel,c);
        c.gridx = 3;
        this.add(employee_inputZAddress,c);
        employee_add.addActionListener(lfb);


        // y = 4
        c.insets = new Insets(20,0,0,0);  //top padding
        c.gridy = 4;
        c.gridx = 0;
        this.add(employee_RfNameLabel,c);
        c.gridx = 1;
        this.add(employee_RinputFname,c);
        c.gridx = 2;
        this.add(employee_RlNameLabel,c);
        c.gridx = 3;
        this.add(employee_RinputLname,c);
        c.gridx = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(employee_remove,c);
        c.fill = GridBagConstraints.NONE;
        employee_remove.addActionListener(lfb);

        // y = 5
        c.gridy = 5;
        c.insets = new Insets(0,0,0,0);  //top padding
        c.gridx = 0;
        this.add(employee_RIDLabel,c);
        c.gridx = 1;
        this.add(employee_RinputID,c);

        // y= 6
        c.insets = new Insets(20,0,0,0);  //top padding
        c.gridy = 6;
        c.gridx = 0;
        this.add(employee_UfNameLabel,c);
        c.gridx = 1;
        this.add(employee_UinputFname,c);
        c.gridx = 2;
        this.add(employee_UlNameLabel,c);
        c.gridx = 3;
        this.add(employee_UinputLname,c);
        c.gridx = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(employee_updateInfo,c);
        c.fill = GridBagConstraints.NONE;


        // y = 7
        c.insets = new Insets(0,0,0,0);  //top padding
        c.gridy = 7;
        c.gridx = 0;
        this.add(employee_UIDLabel,c);
        c.gridx = 1;
        this.add(employee_UinputID,c);
        c.gridx = 2;
        this.add(employee_UpayLabel,c);
        c.gridx = 3;
        this.add(employee_UinputPay,c);
        employee_updateInfo.addActionListener(lfb);

        // y=8
        c.insets = new Insets(20,0,0,0);  //top padding
        c.gridx = 4;
        c.gridy = 8;
        this.add(employee_search,c);
        c.gridx = 0;
        this.add(employee_SfNameLabel,c);
        c.gridx = 1;
        this.add(employee_SinputFname,c);
        c.gridx = 2;
        this.add(employee_SLNameLabel,c);
        c.gridx = 3;
        this.add(employee_SinputLname,c);

        employee_search.addActionListener(lfb);

        // y = 9
        c.insets = new Insets(20,0,0,0);  //top padding
        c.gridy = 9;
        c.gridx = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(employee_volunteer,c);
        c.fill = GridBagConstraints.NONE;
        employee_volunteer.addActionListener(lfb);


        //======================================ANIMAL ======================================
        c1.insets = new Insets(30,0,0,0);  //top padding


        // Add new animal
        this.addComponent(0,1,1,1, GridBagConstraints.NONE,c1,animal_IDLabel);
        this.addComponent(1,1,1,1, GridBagConstraints.NONE,c1,animal_inputID);
        c1.insets = new Insets(0,0,0,0);
        this.addComponent(0,2,1,1, GridBagConstraints.NONE,c1,animal_nameLabel);
        this.addComponent(1,2,1,1, GridBagConstraints.NONE,c1,animal_inputName);
        this.addComponent(0,3,1,1, GridBagConstraints.NONE,c1,animal_ageLabel);
        this.addComponent(1,3,1,1, GridBagConstraints.NONE,c1,animal_inputAge);
        this.addComponent(0,4,1,1, GridBagConstraints.NONE,c1,animal_sexLabel);
        this.addComponent(1,4,1,1, GridBagConstraints.NONE,c1,animal_inputSex);
        this.addComponent(0,5,1,1, GridBagConstraints.NONE,c1,animal_heitLabel);
        this.addComponent(1,5,1,1, GridBagConstraints.NONE,c1,animal_inputHeit);
        this.addComponent(0,6,1,1, GridBagConstraints.NONE,c1,animal_weitLabel);
        this.addComponent(1,6,1,1, GridBagConstraints.NONE,c1,animal_inputWeit);
        this.addComponent(0,7,1,1, GridBagConstraints.NONE,c1,animal_speciesLabel);
        this.addComponent(1,7,1,1, GridBagConstraints.NONE,c1,animal_inputSpecies);
        this.addComponent(0,8,1,1, GridBagConstraints.NONE,c1,animal_eatFreqLabel);
        this.addComponent(1,8,1,1, GridBagConstraints.NONE,c1,animal_inputEatFreq);
        this.addComponent(0,9,1,1, GridBagConstraints.NONE,c1,animal_eatAmtLabel);
        this.addComponent(1,9,1,1, GridBagConstraints.NONE,c1,animal_inputEatAmt);
        this.addComponent(0,10,1,1, GridBagConstraints.NONE,c1,animal_HabIDLabel);
        this.addComponent(1,10,1,1, GridBagConstraints.NONE,c1,animal_inputHabID);
        this.addComponent(1,11,1,1, GridBagConstraints.NONE,c1,animal_add);
        animal_add.addActionListener(lfb);


        // remove animal
        c1.insets = new Insets(30,0,0,0);  //top padding
        this.addComponent(2,1,1,1, GridBagConstraints.NONE,c1,animal_RIDLabel);
        this.addComponent(3,1,1,1, GridBagConstraints.NONE,c1,animal_RinputID);
        c1.insets = new Insets(0,0,0,0);  //top padding
        this.addComponent(3,2,1,1, GridBagConstraints.NONE,c1,animal_remove);
        animal_remove.addActionListener(lfb);

        // update animal
        c1.insets = new Insets(30,0,0,0);  //top padding
        this.addComponent(4,1,1,1, GridBagConstraints.NONE,c1,animal_UIDLabel);
        this.addComponent(5,1,1,1, GridBagConstraints.NONE,c1,animal_UinputID);
        c1.insets = new Insets(0,0,0,0);  //top padding
        this.addComponent(4,2,1,1, GridBagConstraints.NONE,c1,animal_UnameLabel);
        this.addComponent(5,2,1,1, GridBagConstraints.NONE,c1,animal_UinputName);
        this.addComponent(4,3,1,1, GridBagConstraints.NONE,c1,animal_UageLabel);
        this.addComponent(5,3,1,1, GridBagConstraints.NONE,c1,animal_UinputAge);
        this.addComponent(4,4,1,1, GridBagConstraints.NONE,c1,animal_UsexLabel);
        this.addComponent(5,4,1,1, GridBagConstraints.NONE,c1,animal_UinputSex);
        this.addComponent(4,5,1,1, GridBagConstraints.NONE,c1,animal_UheitLabel);
        this.addComponent(5,5,1,1, GridBagConstraints.NONE,c1,animal_UinputHeit);
        this.addComponent(4,6,1,1, GridBagConstraints.NONE,c1,animal_UweitLabel);
        this.addComponent(5,6,1,1, GridBagConstraints.NONE,c1,animal_UinputWeit);
        this.addComponent(4,7,1,1, GridBagConstraints.NONE,c1,animal_UspeciesLabel);
        this.addComponent(5,7,1,1, GridBagConstraints.NONE,c1,animal_UinputSpecies);
        this.addComponent(4,8,1,1, GridBagConstraints.NONE,c1,animal_UeatFreqLabel);
        this.addComponent(5,8,1,1, GridBagConstraints.NONE,c1,animal_UinputEatFreq);
        this.addComponent(4,9,1,1, GridBagConstraints.NONE,c1,animal_UeatAmtLabel);
        this.addComponent(5,9,1,1, GridBagConstraints.NONE,c1,animal_UinputEatAmt);
        this.addComponent(4,10,1,1, GridBagConstraints.NONE,c1,animal_UHabIDLabel);
        this.addComponent(5,10,1,1, GridBagConstraints.NONE,c1,animal_UinputHabID);
        this.addComponent(5,11,1,1, GridBagConstraints.NONE,c1,animal_updateInfo);
        animal_updateInfo.addActionListener(lfb);


        // search species
        this.addComponent(2,5,1,1, GridBagConstraints.NONE,c1,animal_SspeciesLabel);
        this.addComponent(3,5,1,1, GridBagConstraints.NONE,c1, animal_SinputSpeci);
        this.addComponent(3,6,1,1, GridBagConstraints.NONE,c1,animal_searchSpecies);
        animal_searchSpecies.addActionListener(lfb);

        this.addComponent(3,11,1,1, GridBagConstraints.NONE,c1,animal_SspeciesDetail);
        animal_SspeciesDetail.addActionListener(lfb);

//======================================FOOD======================================
        c2.insets = new Insets(30,0,0,0);  //top padding

        this.addComponent(1,2,1,1, GridBagConstraints.NONE,c2,food_sites);
        this.addComponent(2,2,1,1, GridBagConstraints.NONE,c2,food_expires);

        food_sites.addActionListener(lfb);
        food_expires.addActionListener(lfb);
//======================================ZOO======================================

        c4.insets = new Insets(30,0,0,0);  //top padding
        this.addComponent(0,3,1,1, GridBagConstraints.NONE,c4,zoo_inputLabel);
        this.addComponent(1,3,1,1, GridBagConstraints.NONE,c4,zoo_input);
        this.addComponent(2,3,1,1, GridBagConstraints.NONE,c4,zoo_search);
        zoo_search.addActionListener(lfb);
//======================================LOCATION======================================
        c3.insets = new Insets(30,0,0,0);  //top padding

        this.addComponent(0,2,1,1, GridBagConstraints.NONE,c3,location_ByHabLabel);
        this.addComponent(1,2,1,1, GridBagConstraints.NONE,c3,location_InputByHab);
        this.addComponent(6,2,1,1, GridBagConstraints.HORIZONTAL,c3,location_searchByHab);
        location_searchByHab.addActionListener(lfb);
        c3.insets = new Insets(0,0,0,0);  //top padding
        this.addComponent(0,3,1,1, GridBagConstraints.NONE,c3,location_SQFtLabel);
        this.addComponent(1,3,1,1, GridBagConstraints.NONE,c3,location_InputSQFt);
        this.addComponent(2,3,1,1, GridBagConstraints.NONE,c3,location_depthLabel);
        this.addComponent(3,3,1,1, GridBagConstraints.NONE,c3,location_InputDepth);
        this.addComponent(4,3,1,1, GridBagConstraints.NONE,c3,location_biomeLabel);
        this.addComponent(5,3,1,1, GridBagConstraints.NONE,c3,location_InputBiome);
        this.addComponent(6,3,1,1, GridBagConstraints.HORIZONTAL,c3,location_searchForHab);
        location_searchForHab.addActionListener(lfb);

        this.addComponent(0,4,1,1, GridBagConstraints.NONE,c3,location_tempLabel);
        this.addComponent(1,4,1,1, GridBagConstraints.NONE,c3,location_inputTemp);
        this.addComponent(6,4,1,1, GridBagConstraints.HORIZONTAL,c3,location_searchByTemp);
        location_searchByTemp.addActionListener(lfb);

        this.addComponent(6,5,1,1, GridBagConstraints.HORIZONTAL,c3,location_seachForUse);
        location_seachForUse.addActionListener(lfb);

//======================================SHOW======================================
        this.add(show_seachBytime);
        show_seachBytime.addActionListener(lfb);

        // SET VISIBILITY
        for (String s : tab_string) {
            if (s != EMPLPOYEE) {
                setVis(s, false);
            } else setVis(s, true);
        }
    }


    private class ListenForPulldown implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String tabName = (String) cb.getSelectedItem();

            for (String s : tab_string) {
                if (s != tabName) {
                    setVis(s, false);
                } else setVis(s, true);
            }
        }
    }

    private class ListenForButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == logout_button) {//==========================================LOGOUT=====================
                ZootopiApp.login.setVisible(true);
                ZootopiApp.login.setEnabled(true);
                ZootopiApp.main_window_manager.setVisible(false);
                ZootopiApp.main_window_manager.setEnabled(false);
            } else if (e.getSource() == show_seachBytime) {//================================SHOW=======================
                resultCallHandle(user_manager.showAt());
            } else if (e.getSource() == zoo_search) {//======================================ZOO========================
                if (zoo_input.getText().isBlank()){
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input. Please try again", "Search Zoo", JOptionPane.ERROR_MESSAGE);
                }
                else
                resultCallHandle(user_manager.filterZooByCountry(zoo_input.getText()));
            } else if (e.getSource() == food_expires) {//====================================FOOD=======================
                resultCallHandle(user_manager.getFoodSoonToExpires());

            } else if (e.getSource() == food_sites) {
                resultCallHandle(user_manager.getFoodDetails());

            } else if (e.getSource() == location_searchByHab) {//============================LOCATION===================
                if (location_InputByHab.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input. Please try again", "Search Habitat", JOptionPane.ERROR_MESSAGE);
                }
                else
                resultCallHandle(user_manager.animalsInHabitat(Integer.parseInt(location_InputByHab.getText())));
            } else if (e.getSource() == location_searchByTemp) {
                if (location_inputTemp.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input. Please try again", "Search Temperature", JOptionPane.ERROR_MESSAGE);
                }
                else
                resultCallHandle(user_manager.searchByTemperature(Integer.parseInt(location_inputTemp.getText())));
            } else if (e.getSource() == location_searchForHab) {
                if (location_InputSQFt.getText().isBlank() || location_InputDepth.getText().isBlank() ||
                location_InputBiome.getText().isBlank()){
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input. Please try again", "Search Habitat", JOptionPane.ERROR_MESSAGE);
                }
                else
                resultCallHandle(user_manager.findHabitat(
                        Integer.parseInt(location_InputSQFt.getText()),
                        Integer.parseInt(location_InputDepth.getText()),
                        location_InputBiome.getText()));
            } else if (e.getSource() == location_seachForUse) {
                resultCallHandle(user_manager.sitesNotUsed());
            } else if (e.getSource() == animal_add) {//======================================ANIMAL=====================
                try {
                    String s = user_manager.addAnimal(
                            Integer.parseInt(animal_inputID.getText()),
                            animal_inputName.getText(),
                            Integer.parseInt(animal_inputAge.getText()),
                            animal_inputSex.getText(),
                            Integer.parseInt(animal_inputHeit.getText()),
                            Integer.parseInt(animal_inputWeit.getText()),
                            animal_inputSpecies.getText(),
                            Integer.parseInt(animal_inputEatFreq.getText()),
                            Integer.parseInt(animal_inputEatAmt.getText()),
                            Integer.parseInt(animal_inputHabID.getText()));
                    JOptionPane.showMessageDialog(null, s, "Add Animal",
                            JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception en){
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input. Please try again", "Add Animal", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == animal_remove) {
                try {
                    String s = user_manager.deleteAnimal(
                            Integer.parseInt(animal_RinputID.getText()));
                    JOptionPane.showMessageDialog(null,
                            s, "Remove Animal", JOptionPane.INFORMATION_MESSAGE);
                }catch(Exception er){
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input.  Please try again", "Remove Animal", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == animal_updateInfo) {
                try {
                    String s = user_manager.updateAnimal(
                            Integer.parseInt(animal_UinputID.getText()),
                            animal_UinputName.getText(),
                            Integer.parseInt(animal_UinputAge.getText()),
                            animal_UinputSex.getText(),
                            Integer.parseInt(animal_UinputHeit.getText()),
                            Integer.parseInt(animal_UinputWeit.getText()),
                            animal_UinputSpecies.getText(),
                            Integer.parseInt(animal_UinputEatFreq.getText()),
                            Integer.parseInt(animal_UinputEatAmt.getText()),
                            Integer.parseInt(animal_UinputHabID.getText()));
                    JOptionPane.showMessageDialog(null, s, "Update Animal", JOptionPane.INFORMATION_MESSAGE);
                } catch(Exception eua){
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input. Please try again", "Update Animal", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == animal_searchSpecies) {
                resultCallHandle(user_manager.getSpeciesDetail(animal_SinputSpeci.getText()));

            } else if (e.getSource() == animal_SspeciesDetail) {

                resultCallHandle(user_manager.groupAnimalBySpecies());

            } else if (e.getSource() == employee_add) {//======================================EMPLOYEE=================
                try {
                    String s = user_manager.addEmployee(
                            employee_inputFname.getText(),
                            employee_inputLname.getText(),
                            Integer.parseInt(employee_inputwlkee.getText()),
                            Integer.parseInt(employee_inputID.getText()),
                            Integer.parseInt(employee_inputPay.getText()),
                            employee_inputZAddress.getSelectedItem().toString());
                    JOptionPane.showMessageDialog(null,
                            s, "Add Employee", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception eae){
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input.  Please try again", "Add Employee", JOptionPane.ERROR_MESSAGE);
            }
            } else if (e.getSource() == employee_remove) {
                try {
                    String s = user_manager.removeEmployee(
                            Integer.parseInt(employee_RinputID.getText()),
                            employee_RinputFname.getText(),
                            employee_RinputLname.getText());
                    JOptionPane.showMessageDialog(null,
                            s, "Remove Employee", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception ere){
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input. Please try again", "Remove Employee", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == employee_updateInfo) {
                try {
                    String s = user_manager.updateEmployee(
                            employee_UinputFname.getText(),
                            employee_UinputLname.getText(),
                            Integer.parseInt(employee_UinputID.getText()),
                            Integer.parseInt(employee_UinputPay.getText()));
                    JOptionPane.showMessageDialog(null,
                            s, "Update Employee", JOptionPane.INFORMATION_MESSAGE);
                } catch(Exception eue){
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input. Please try again", "Update Employee", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == employee_search) {
                if (employee_SinputFname.getText().isBlank() ||  employee_SinputLname.getText().isBlank()){
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Input. Please try again", "Search Employee", JOptionPane.ERROR_MESSAGE);
                } else{
                    resultCallHandle(user_manager.searchEmployee(employee_SinputFname.getText(),
                            employee_SinputLname.getText()));
                }
            } else if (e.getSource() == employee_volunteer) {
                resultCallHandle(user_manager.getVolunteer());
            }
        }
    }
    //Helper to create and call results window
    private void resultCallHandle(ResultSet rs){
        ZootopiApp.results = new ResultPage(rs);
        ZootopiApp.results.setVisible(true);
        ZootopiApp.window.add(ZootopiApp.results);
        ZootopiApp.main_window_manager.setVisible(false);
        ZootopiApp.main_window_manager.setEnabled(false);
    }

    //Helper to set multiple components visibility
    private void setVis(String name, Boolean bool) {
        if (name == EMPLPOYEE) {
            employee_add.setVisible(bool);
            employee_fNameLabel.setVisible(bool);
            employee_inputFname.setVisible(bool);
            employee_lNameLabel.setVisible(bool);
            employee_inputLname.setVisible(bool);
            employee_wlkeeLabel.setVisible(bool);
            employee_inputwlkee.setVisible(bool);
            employee_IDLabel.setVisible(bool);
            employee_inputID.setVisible(bool);
            employee_payLabel.setVisible(bool);
            employee_inputPay.setVisible(bool);
            employee_ZAddressLabel.setVisible(bool);
            employee_inputZAddress.setVisible(bool);

            employee_remove.setVisible(bool);
            employee_RfNameLabel.setVisible(bool);
            employee_RinputFname.setVisible(bool);
            employee_RlNameLabel.setVisible(bool);
            employee_RinputLname.setVisible(bool);
            employee_RIDLabel.setVisible(bool);
            employee_RinputID.setVisible(bool);

            employee_updateInfo.setVisible(bool);
            employee_UfNameLabel.setVisible(bool);
            employee_UinputFname.setVisible(bool);
            employee_UlNameLabel.setVisible(bool);
            employee_UinputLname.setVisible(bool);
            employee_UIDLabel.setVisible(bool);
            employee_UinputID.setVisible(bool);
            employee_UpayLabel.setVisible(bool);
            employee_UinputPay.setVisible(bool);

            employee_search.setVisible(bool);
            employee_SfNameLabel.setVisible(bool);
            employee_SinputFname.setVisible(bool);
            employee_SLNameLabel.setVisible(bool);
            employee_SinputLname.setVisible(bool);

            employee_volunteer.setVisible(bool);
        } else if (name == ANIMAL) {
            animal_add.setVisible(bool);
            animal_IDLabel.setVisible(bool);
            animal_inputID.setVisible(bool);
            animal_nameLabel.setVisible(bool);
            animal_inputName.setVisible(bool);
            animal_ageLabel.setVisible(bool);
            animal_inputAge.setVisible(bool);
            animal_sexLabel.setVisible(bool);
            animal_inputSex.setVisible(bool);
            animal_heitLabel.setVisible(bool);
            animal_inputHeit.setVisible(bool);
            animal_weitLabel.setVisible(bool);
            animal_inputWeit.setVisible(bool);
            animal_speciesLabel.setVisible(bool);
            animal_inputSpecies.setVisible(bool);
            animal_eatFreqLabel.setVisible(bool);
            animal_inputEatFreq.setVisible(bool);
            animal_eatAmtLabel.setVisible(bool);
            animal_inputEatAmt.setVisible(bool);
            animal_HabIDLabel.setVisible(bool);
            animal_inputHabID.setVisible(bool);
            animal_remove.setVisible(bool);

            animal_RIDLabel.setVisible(bool);
            animal_RinputID.setVisible(bool);

            animal_updateInfo.setVisible(bool);
            animal_UIDLabel.setVisible(bool);
            animal_UinputID.setVisible(bool);
            animal_UnameLabel.setVisible(bool);
            animal_UinputName.setVisible(bool);
            animal_UageLabel.setVisible(bool);
            animal_UinputAge.setVisible(bool);
            animal_UsexLabel.setVisible(bool);
            animal_UinputSex.setVisible(bool);
            animal_UheitLabel.setVisible(bool);
            animal_UinputHeit.setVisible(bool);
            animal_UweitLabel.setVisible(bool);
            animal_UinputWeit.setVisible(bool);
            animal_UspeciesLabel.setVisible(bool);
            animal_UinputSpecies.setVisible(bool);
            animal_UeatFreqLabel.setVisible(bool);
            animal_UinputEatFreq.setVisible(bool);
            animal_UeatAmtLabel.setVisible(bool);
            animal_UinputEatAmt.setVisible(bool);
            animal_UHabIDLabel.setVisible(bool);
            animal_UinputHabID.setVisible(bool);

            animal_searchSpecies.setVisible(bool);

            animal_SspeciesDetail.setVisible(bool);
            animal_SspeciesLabel.setVisible(bool);
            animal_SinputSpeci.setVisible(bool);

            animal_SspeciesDetail.setVisible(bool);
        } else if (name == FOOD) {
            food_sites.setVisible(bool);
            food_expires.setVisible(bool);
        } else if (name == ZOO) {
            zoo_search.setVisible(bool);
            zoo_inputLabel.setVisible(bool);
            zoo_input.setVisible(bool);
        } else if (name == LOCATION) {
            location_searchByHab.setVisible(bool);
            location_ByHabLabel.setVisible(bool);
            location_InputByHab.setVisible(bool);

            location_searchForHab.setVisible(bool);
            location_InputSQFt.setVisible(bool);
            location_SQFtLabel.setVisible(bool);
            location_InputDepth.setVisible(bool);
            location_depthLabel.setVisible(bool);
            location_InputBiome.setVisible(bool);
            location_biomeLabel.setVisible(bool);

            location_searchByTemp.setVisible(bool);
            location_inputTemp.setVisible(bool);
            location_tempLabel.setVisible(bool);

            location_seachForUse.setVisible(bool);
        } else if (name == SHOW) {
            show_seachBytime.setVisible(bool);
        }
    }

    public void addComponent( int x, int y, int w, int h, int fill, GridBagConstraints gbc, Component aComponent ) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = fill;
        add(aComponent,gbc);
    }
}
