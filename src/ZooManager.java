import java.sql.ResultSet;
import java.sql.SQLException;


public class ZooManager {
    private Driver jdbc;

    public ZooManager() {
        jdbc = Driver.getInstance();
    }

    // ------------------------------------------------ EMPLOYEE ------------------------------------------------
    // add Employee to database
    // return:
    //      "Employee successfully added" if inputs are valid"
    //      "Not Valid" otherwise
    public String addEmployee(String f_name, String l_name, int walkeetalkee, int employee_id, int pay, String zooAddress){
        StringBuilder strb1 = new StringBuilder();
        strb1.append("insert into employeecommunication values ('");
        strb1.append(f_name);
        strb1.append("', '");
        strb1.append(l_name);
        strb1.append("', ");
        strb1.append(Integer.toString(walkeetalkee));
        strb1.append(")");
        String firstQuery = strb1.toString();
        String result1 = jdbc.executeAlter(firstQuery);
        if (result1 == "1") {
            StringBuilder strb2 = new StringBuilder();
            strb2.append("insert into employee values ('");
            strb2.append(f_name);
            strb2.append("', '");
            strb2.append(l_name);
            strb2.append("', ");
            strb2.append(employee_id);
            strb2.append(", ");
            strb2.append(pay);
            strb2.append(", '");
            strb2.append(zooAddress);
            strb2.append("')");
            String secondQuery = strb2.toString();
            String result2 = jdbc.executeAlter(secondQuery);
            if (result2 == "1") {
                return "Employee successfully added";
            } else {
                return "Not Valid";
            }
        } else {
            return "Not Valid";
        }
    }

    // remove Employee from database
    // return:
    //      "Employee successfully removed" if the delete is valid
    //      "Not Valid" otherwise
    public String removeEmployee(int employee_id, String f_name, String l_name) {
        // need to see if Employee is trainer or keeper
        StringBuilder sb = new StringBuilder();
        boolean isTrainer = false;
        boolean isKeeper = false;
        sb.append("select * from trainer where employee_id = ");
        sb.append(employee_id);
        try {
            isTrainer = jdbc.executeQuery(sb.toString()).next();
        }catch(SQLException e) {System.out.println("select trainer query failed");}
        sb = new StringBuilder();
        sb.append("select * from keeper where employee_id = ");
        sb.append(employee_id);
        try {
            isKeeper = jdbc.executeQuery(sb.toString()).next();
        }catch(SQLException e) {System.out.println("select keeper query failed");}
        if (!isTrainer && !isKeeper)
            return "Not Valid";

    // Delete from Trainer/Keeper + Employee
        if (isKeeper) {
            sb = new StringBuilder();
            sb.append("delete from caresfor where employee_id = "); sb.append(employee_id);
            jdbc.executeAlter(sb.toString());
            sb = new StringBuilder();
            sb.append("delete from keeper where employee_id = "); sb.append(employee_id);
            jdbc.executeAlter(sb.toString());
        }
        if (isTrainer) {
            sb = new StringBuilder();
            sb.append("delete from trains where employee_id = "); sb.append(employee_id);
            jdbc.executeAlter(sb.toString());
            sb = new StringBuilder();
            sb.append("delete from performs where employee_id = "); sb.append(employee_id);
            jdbc.executeAlter(sb.toString());
            sb = new StringBuilder();
            sb.append("delete from trainer where employee_id = "); sb.append(employee_id);
            jdbc.executeAlter(sb.toString());
        }
        StringBuilder strb1 = new StringBuilder();
        strb1.append("delete from employee where employee_id = ");
        strb1.append(employee_id);
        String firstQuery = strb1.toString();
        String result1 = jdbc.executeAlter(firstQuery);
        if (result1 == "1") {
            StringBuilder strb2 = new StringBuilder();
            strb2.append("delete from employeecommunication where f_name = '");
            strb2.append(f_name);
            strb2.append("' and l_name = '");
            strb2.append(l_name);
            strb2.append("'");
            String secondQuery = strb2.toString();
            String result2 = jdbc.executeAlter(secondQuery);
            if (result2 == "1") {
                return "Employee successfully removed";
            } else {
                System.out.println(result2);
                return "Not Valid";
            }
        } else {
            System.out.println(result1);
            return "Not Valid";
        }
    }

    // Update Employee info == update pay
    // return:
    //      "Employee successfully updated" if update is valid
    //      "Not Valid" otherwise
    public String updateEmployeeInfo(String f_name, String l_name, int employee_id, int pay) {
        StringBuilder strb = new StringBuilder();
        strb.append("update employee set f_name = '");
        strb.append(f_name);
        strb.append("', l_name = '");
        strb.append(l_name);
        strb.append("', pay = ");
        strb.append(pay);
        strb.append("where employee_id = ");
        strb.append(employee_id);
        String query = strb.toString();
        String result = jdbc.executeAlter(query);
        if (result == "1") {
            return "Employee successfully updated";
        } else {
            return "Not Valid";
        }
    }

    // search employee based on first name
    // return all info regarding that employee: f_name, l_name, employee_id, pay and zoo_address
    public ResultSet searchEmployee(String f_name) {
        StringBuilder strb = new StringBuilder();
        strb.append("select * from employee where f_name = '");
        strb.append(f_name);
        strb.append("'");
        String query = strb.toString();
        return jdbc.executeQuery(query);
    }

    // get volunteer info
    // return all info regarding that volunteer: f_name, l_name, employee_id, and zoo_address
    public ResultSet getVolunteer() {
        return jdbc.executeQuery("select f_name, l_name, employee_id, zoo_address from employee where pay = 0");
    }

    // ------------------------------------------------ LOCATION (HABITAT + SITE)  ------------------------------------------------
    // search all animals in a particular habitat
    // return info regarding the animals in a particular habitat: animal_id, name, and species
    public ResultSet animalsInHabitat(int enclosure_id) {
        StringBuilder strb = new StringBuilder();
        strb.append("select animal_id, name, species from animal where enclosure_id = ");
        strb.append(Integer.toString(enclosure_id));
        String query = strb.toString();
        return jdbc.executeQuery(query);
    }

    // search habitat based on the size and the biome
    // return all info regarding that habitat: enclosure_id, biome, sq_ft, depth, site_id
    public ResultSet findHabitat(int sq_ft, int depth, String biome) {
        StringBuilder strb = new StringBuilder();
        strb.append("select * from habitat where sq_ft = ");
        strb.append(sq_ft);
        strb.append("and depth = ");
        strb.append(depth);
        strb.append("and biome = '" + biome);
        strb.append("'");
        String query = strb.toString();
        return jdbc.executeQuery(query);
    }

    // search habitat based on temperature
    // return all the info regarding that habitat: enclosure_id, biome, sq_ft, depth, site_id, temp, humidity
    public ResultSet searchByTemperature(int temp){
        StringBuilder strb = new StringBuilder();
        strb.append("select * from habitat h, site s, habitatbiome hb " +
                "where h.site_id = s.site_id and h.biome = hb.biome and temp = ");
        strb.append(temp);
        String query = strb.toString();
        return jdbc.executeQuery(query);
    }

    // search sites that are not used
    // return info regarding that habitat: site_id, location, zoo_address
    public ResultSet sitesNotUsed() {
        return jdbc.executeQuery("select site_id, location, zoo_address from site where used_for is null");
    }

    // ------------------------------------------------ SHOW ------------------------------------------------

    // display shows
    // return info regarding the show: start_time, duration, name, type, location
    public ResultSet showAt() {
        return jdbc.executeQuery("select sh.start_time, sh.duration, sh.name, sh.type, st.location " +
                "from show sh, site st where sh.site_id = st.site_id");
    }


    // ------------------------------------------------ ANIMAL ------------------------------------------------

    // add animal
    // return "Success", "Unique Constraint violation" (that id already exist) or  "Not Valid" (for another reason)
    public String addAnimal(int id, String name, int age, String sex, int height, int weight, String species,
                          int eat_freq, int eat_amt, int habitat_id) {
        StringBuilder str = new StringBuilder();
        str.append("insert into animal values (");
        str.append(id); str.append(", '");
        str.append(name); str.append("' ,");
        str.append(age); str.append(", '");
        str.append(sex); str.append("', ");
        str.append(height); str.append(",");
        str.append(weight); str.append(", '");
        str.append(species); str.append("',");
        str.append(eat_freq); str.append(",");
        str.append(eat_amt); str.append(",");
        str.append(habitat_id);
        str.append(")");
        String query = str.toString();
        String result = jdbc.executeAlter(query);
        if (result.indexOf("unique constraint")!= -1)
            return "Unique Constraint violation";
        if (result == "1")
            return "Success";
        else
            return "Not Valid";
    }

    // delete animal
    // return "Success" or "Not Valid"
    // need to delete all relationships that animals are involved in before deleting animal
    // performs, caresfor, trains, eats, trades
    public String deleteAnimal(int id) {
        StringBuilder sb;
        sb = new StringBuilder(); sb.append("delete from performs where animal_id = "); sb.append(id);
        System.out.print(jdbc.executeQuery(sb.toString()));
        sb = new StringBuilder(); sb.append("delete from caresfor where animal_id = "); sb.append(id);
        System.out.print(jdbc.executeQuery(sb.toString()));
        sb = new StringBuilder(); sb.append("delete from trains where animal_id = "); sb.append(id);
        System.out.print(jdbc.executeQuery(sb.toString()));
        sb = new StringBuilder(); sb.append("delete from eats where animal_id = "); sb.append(id);
        System.out.print(jdbc.executeQuery(sb.toString()));
        sb = new StringBuilder(); sb.append("delete from trades where animal_id = "); sb.append(id);
        System.out.print(jdbc.executeQuery(sb.toString()));

        StringBuilder str = new StringBuilder();
        str.append("delete from animal where animal_id =");
        str.append(id);
        String query = str.toString();
        String result = jdbc.executeAlter(query);
        if (result == "1")
            return "Success";
        else
            return "Not Valid";
    }

    // update animal
    // return "Success" or "Not Valid"
    public String updateAnimal(int id, String name, int age, String sex, int height, int weight, String species,
                               int eat_freq, int eat_amt, int habitat_id) {
        StringBuilder str = new StringBuilder();
        str.append("update animal set name = '");
        str.append(name); str.append("', age =");
        str.append(age); str.append(", sex ='");
        str.append(sex); str.append("', height =");
        str.append(height); str.append(", weight =");
        str.append(weight); str.append(", species ='");
        str.append(species); str.append("', eat_freq_week =");
        str.append(eat_freq); str.append(", eat_amount =");
        str.append(eat_amt); str.append(", enclosure_id =");
        str.append(habitat_id); str.append("where animal_id = ");
        str.append(id);
        String query = str.toString();
        String result = jdbc.executeAlter(query);
        if (result == "1")
            return "Success";
        else
            System.out.println(result);
            return "Not Valid";
    }


    // Group Animal By Species
    // returns from animal: id, name, age, sex, species
    public ResultSet groupAnimalBySpecies() {
        StringBuilder str = new StringBuilder();
        str.append("select animal_id, name, age, sex, species from animal order by species");
        return jdbc.executeQuery(str.toString());
    }

    // Get animal detail by species (weight + height)
    // returns from animal: id, name, weight, height
    public ResultSet getSpeciesDetail(String species) {
        StringBuilder str = new StringBuilder();
        str.append("select animal_id, name, weight, height from animal where species = '");
        str.append(species); str.append("'");
        return jdbc.executeQuery(str.toString());
    }


    // ------------------------------------------------ FOOD ------------------------------------------------

    // Get food stored in each food site
    // @returns:
    // from site: id, location
    // from food: id,  name, stock serving, purchase date + expiry date
    public ResultSet getFoodDetails() {
        StringBuilder str = new StringBuilder();
        str.append("select s.site_id, s.location, f.food_id, f.name, f.stock_serving, f.date_purchased, f.date_expired ");
        str.append("from site s, food f where s.site_id = f.site_id");
        return jdbc.executeQuery(str.toString());
    }

    // Get food that is about to be expired
    // (get food that will expire before dec 01" since GETDATE() doesn't work)
    // returns from food: id, name, date_expiry
    public ResultSet getFoodSoonToExpires() {
        StringBuilder str = new StringBuilder();
        str.append("select food_id, name, date_expired from food where date_expired < '2018-12-31' order by date_expired");
        return jdbc.executeQuery(str.toString());
    }


    // ------------------------------------------------ ZOO ------------------------------------------------

    // takes in a country and return zoos located in that country
    // returns from zoo: all fields (address, name, phone, city, country)
    public ResultSet filterZooByCountry(String country) {
        StringBuilder str = new StringBuilder();
        str.append("select * from zoo where country = '");
        str.append(country); str.append("'");
        return jdbc.executeQuery(str.toString());
    }

}