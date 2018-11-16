import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage_Manager extends JPanel {

    private static final String EMPLPOYEE = "Employee";
    private static final String ANIMAL = "Animal";
    private static final String FOOD = "Food";
    private static final String ZOO = "Zoo";
    private static final String LOCATION = "Location";
    private static final String SHOW = "Show";

    private static final String AD_ZOO1 ="2000 Meadowvale Rd";
    private static final String AD_ZOO2 ="80 Mandai Lake Rd";

    String[] tab_string = {EMPLPOYEE, ANIMAL, FOOD, ZOO, LOCATION, SHOW};
    String[] Zoos = {AD_ZOO1, AD_ZOO2};

    ZooManager user_manager = new ZooManager();
    JComboBox tabs = new JComboBox(tab_string);
    JButton logout_button = new JButton("Logout");
    JLabel tab_label = new JLabel("Select Tab:");
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

    JLabel employee_ZAddressLabel = new JLabel("Pay");
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
    JLabel employee_SlNameLabel = new JLabel("Last Name:");
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
    JLabel animal_UIDLabel = new JLabel("Name:");
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
    JTextField employee_SinputSpeci = new JTextField(10);
    //======================================FOOD COMPONENTS======================================
    JButton food_sites = new JButton("Get Food");
    JButton food_expires = new JButton("Expiring Food");
    //======================================ZOO COMPONENTS======================================
    JButton zoo_search = new JButton("Pick Zoo");
    JTextField zoo_input = new JTextField(10);
    JLabel zoo_inputLabel = new JLabel("Country:");
    //======================================LOCATION COMPONENTS======================================
    JButton location_searchByHab = new JButton("Find Habitat");
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
               this.add(tab_label);
        this.add(tabs);
        ListenForPulldown lfp = new ListenForPulldown();
        tabs.addActionListener(lfp);

        ListenForButton lfb = new ListenForButton();
        this.add(logout_button);
        logout_button.addActionListener(lfb);

        //======================================EMPLOYEE ======================================
        this.add(employee_add);
        this.add(employee_fNameLabel);
        this.add(employee_inputFname);
        this.add(employee_lNameLabel);
        this.add(employee_inputLname);
        this.add(employee_wlkeeLabel);
        this.add(employee_inputwlkee);
        this.add(employee_IDLabel);
        this.add(employee_inputID);
        this.add(employee_payLabel);
        this.add(employee_inputPay);
        this.add(employee_ZAddressLabel);
        this.add(employee_inputZAddress);
        employee_add.addActionListener(lfb);


        this.add(employee_remove);
        this.add(employee_RfNameLabel);
        this.add(employee_RinputFname);
        this.add(employee_RlNameLabel);
        this.add(employee_RinputLname);
        this.add(employee_RIDLabel);
        this.add(employee_RinputID);
        employee_remove.addActionListener(lfb);

        this.add(employee_updateInfo);
        this.add(employee_UfNameLabel);
        this.add(employee_UinputFname);
        this.add(employee_UlNameLabel);
        this.add(employee_UinputLname);
        this.add(employee_UIDLabel);
        this.add(employee_UinputID);
        this.add(employee_UpayLabel);
        this.add(employee_UinputPay);
        employee_updateInfo.addActionListener(lfb);

        this.add(employee_search);
        this.add(employee_SfNameLabel);
        this.add(employee_SinputFname);
        this.add(employee_SlNameLabel);
        this.add(employee_SinputLname);
        employee_search.addActionListener(lfb);

        this.add(employee_volunteer);
        employee_volunteer.addActionListener(lfb);


        //======================================ANIMAL ======================================
        this.add(animal_IDLabel);
        this.add(animal_inputID);
        this.add(animal_add);
        this.add(animal_nameLabel);
        this.add(animal_inputName);
        this.add(animal_ageLabel);
        this.add(animal_sexLabel);
        this.add(animal_inputSex);
        this.add(animal_heitLabel);
        this.add(animal_inputHeit);
        this.add(animal_weitLabel);
        this.add(animal_inputWeit);
        this.add(animal_speciesLabel);
        this.add(animal_inputSpecies);
        this.add(animal_eatFreqLabel);
        this.add(animal_inputEatFreq);
        this.add(animal_eatAmtLabel);
        this.add(animal_inputEatAmt);
        this.add(animal_HabIDLabel);
        this.add(animal_inputHabID);
        animal_add.addActionListener(lfb);

        this.add(animal_remove);

        this.add(animal_RIDLabel);
        this.add(animal_RinputID);
        animal_remove.addActionListener(lfb);

        this.add(animal_updateInfo);
        this.add(animal_UIDLabel);
        this.add(animal_UinputID);
        this.add(animal_UnameLabel);
        this.add(animal_UinputName);
        this.add(animal_UageLabel);
        this.add(animal_UinputAge);
        this.add(animal_UsexLabel);
        this.add(animal_UinputSex);
        this.add(animal_UheitLabel);
        this.add(animal_UinputHeit);
        this.add(animal_UweitLabel);
        this.add(animal_UinputWeit);
        this.add(animal_UspeciesLabel);
        this.add(animal_UinputSpecies);
        this.add(animal_UeatFreqLabel);
        this.add(animal_UinputEatFreq);
        this.add(animal_UeatAmtLabel);
        this.add(animal_UinputEatAmt);
        this.add(animal_UHabIDLabel);
        this.add(animal_UinputHabID);
        animal_updateInfo.addActionListener(lfb);

        this.add(animal_searchSpecies);

        this.add(animal_SspeciesDetail);
        this.add(animal_SspeciesLabel);
        this.add(employee_SinputSpeci);
        animal_searchSpecies.addActionListener(lfb);

        this.add(animal_SspeciesDetail);
        animal_SspeciesDetail.addActionListener(lfb);

//======================================FOOD======================================
        this.add(food_sites);
        food_sites.addActionListener(lfb);
        this.add(food_expires);
        food_expires.addActionListener(lfb);
        this.add(zoo_search);
        this.add(zoo_inputLabel);
        this.add(zoo_input);
        zoo_search.addActionListener(lfb);


//======================================LOCATION======================================
        this.add(location_searchByHab);
        this.add(location_ByHabLabel);
        this.add(location_InputByHab);
        location_searchByHab.addActionListener(lfb);

        this.add(location_searchForHab);
        this.add(location_InputSQFt);
        this.add(location_SQFtLabel);
        this.add(location_InputDepth);
        this.add(location_depthLabel);
        this.add(location_InputBiome);
        this.add(location_biomeLabel);
        location_searchForHab.addActionListener(lfb);

        this.add(location_searchByTemp);
        this.add(location_searchByTemp);
        this.add(location_inputTemp);
        location_searchByTemp.addActionListener(lfb);

        this.add(location_seachForUse);
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
            if (e.getSource() == logout_button) {

                ZootopiApp.main_window_manager.setVisible(false);
                ZootopiApp.main_window_manager.setEnabled(false);//TODO: not sure about this, this might need to be dropped....

                ZootopiApp.login.setVisible(true);
                ZootopiApp.login.setEnabled(true);





                ;
            } else if (e.getSource() == show_seachBytime) {
                //test_label.setText("show search");



                ResultPage result = new ResultPage(user_manager.showAt());
                //here set page visibility etc
                // ??? When do we "dump" a page vs just hiding it?



                //TODO: call to results() page
            } else if (e.getSource() == zoo_search) {
                //test_label.setText(zoo_input.getText());
                user_manager.filterZooByCountry(zoo_input.getText());
                //TODO: call to results() page
            } else if (e.getSource() == food_expires) {
                //test_label.setText("food expires");
                user_manager.getFoodSoonToExpires();
                //TODO: call to results() page
            } else if (e.getSource() == food_sites) {
                //test_label.setText("food sites");
                user_manager.getFoodDetails();
                //TODO: call to results() page
            } else if (e.getSource() == location_searchByHab) {
                //test_label.setText("search by habitat");
                user_manager.animalsInHabitat(Integer.parseInt(location_InputByHab.getText()));
                //TODO: call to results() page
            } else if (e.getSource() == location_searchByTemp) {
                //test_label.setText("temp search");
                user_manager.searchByTemperature(Integer.parseInt(location_inputTemp.getText()));
                //TODO: call to results() page
            } else if (e.getSource() == location_searchForHab) {
                //test_label.setText("forche for hab");
                user_manager.findHabitat(Integer.parseInt(location_InputSQFt.getText()),
                        Integer.parseInt(location_InputDepth.getText()),
                        location_InputBiome.getText());
                //TODO: call to results() page
            } else if (e.getSource() == location_seachForUse) {
                //test_label.setText("search for use");
                user_manager.sitesNotUsed();
                //TODO: call to results() page
            } else if (e.getSource() == animal_add) {
                //test_label.setText("add animal");
                user_manager.addAnimal(
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
                //TODO: call to results() page
            } else if (e.getSource() == animal_remove) {
                //test_label.setText("animalus deletus");
                user_manager.deleteAnimal(Integer.parseInt(animal_RinputID.getText()));
                //TODO: call to results() page
            } else if (e.getSource() == animal_updateInfo) {
                //test_label.setText("update animal info");
                user_manager.updateAnimal(
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
                //TODO: call to results() page
            } else if (e.getSource() == animal_searchSpecies) {
               // test_label.setText("search by species");
                user_manager.groupAnimalBySpecies();
                //TODO: call to results() page
            } else if (e.getSource() == animal_SspeciesDetail) {
                //test_label.setText("species details");
                user_manager.getSpeciesDetail(animal_SspeciesDetail.getText());
                //TODO: call to results() page
            } else if (e.getSource() == employee_add) {
                //test_label.setText("add employee");
                /*user_manager.addEmployee(employee_inputFname.getText(),
                        employee_inputLname.getText(),
                        Integer.parseInt(employee_inputwlkee.getText()),
                        Integer.parseInt(employee_inputID.getText()),
                        Integer.parseInt(employee_inputPay.getText()));
                */
                user_manager.addEmployee(employee_inputFname.getText(),
                        employee_inputLname.getText(),
                        Integer.parseInt(employee_inputwlkee.getText()),
                        Integer.parseInt(employee_inputID.getText()),
                        Integer.parseInt(employee_inputPay.getText()),
                        employee_inputZAddress.getSelectedItem().toString()
                        );

                //TODO: call to results() page
            } else if (e.getSource() == employee_remove) {
                //test_label.setText("remove employee");
                user_manager.removeEmployee(
                        Integer.parseInt(employee_RinputID.getText()),
                        employee_RinputFname.getText(),
                        employee_RinputLname.getText());
                //TODO: call to results() page
            } else if (e.getSource() == employee_updateInfo) {
                //test_label.setText("employee info update");
                user_manager.updateEmployeeInfo(employee_UinputFname.getText(),
                        employee_UinputLname.getText(),
                        Integer.parseInt(employee_UinputID.getText()),
                        Integer.parseInt(employee_UinputPay.getText()));
                //TODO: call to results() page
            } else if (e.getSource() == employee_search) {
                //test_label.setText("search employees");
                user_manager.searchEmployee(employee_SinputFname.getText(),
                        employee_SinputLname.getText());
                //TODO: call to results() page
            } else if (e.getSource() == employee_volunteer) {
                //test_label.setText("get voluntolds");
                user_manager.getVolunteer();
                //TODO: call to results() page
            }
        }
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
            employee_SlNameLabel.setVisible(bool);
            employee_SinputLname.setVisible(bool);

            employee_volunteer.setVisible(bool);
        } else if (name == ANIMAL) {
            animal_add.setVisible(bool);
            animal_IDLabel.setVisible(bool);
            animal_inputID.setVisible(bool);
            animal_nameLabel.setVisible(bool);
            animal_inputName.setVisible(bool);
            animal_ageLabel.setVisible(bool);
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
            employee_SinputSpeci.setVisible(bool);

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
}
