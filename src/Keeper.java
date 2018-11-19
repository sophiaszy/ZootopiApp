import java.sql.ResultSet;

public class Keeper extends Employee{

    private Driver         driver = Driver.getInstance();
    ;
    private int employee_id;

    public Keeper(int employee_id) {

        super(employee_id);
        this.employee_id = employee_id;
    }

    // get the Keeper's view (animals + location + food)
    // should not ever throw an error
    // @ returns:
    //      Keeper: duty
    //      Animal: ID, species, habitat location, eating frequency, eating amount
    //      Food (that animals eat): ID, name, expiry date, storage site
    //

    public ResultSet getKeeperView() {
        StringBuilder str = new StringBuilder();
        //        str.append("select k.duty as my_duty, a.animal_id, a.species, sa.location as animal_location,a.height, a.weight, f.food_id, f.name as food, sf.location as food_location " +
        str.append("select k.duty as my_duty, a.animal_id, a.species, sa.location as animal_location, a.eat_freq_week, a.eat_amount, f.food_id, f.name as food, sf.location as food_location " +
                "from keeper k, caresfor cf, animal a, habitat h, eats e, food f, site sa, site sf " +
                "where k.employee_id = cf.employee_id and cf.animal_id = a.animal_id and a.enclosure_id = h.enclosure_id and " +
                "h.site_id = sa.site_id and a.animal_id = e.animal_id and e.food_id = f.food_id " +
                "and f.site_id = sf.site_id and k.employee_id = ");
        str.append(employee_id);
        str.append(" order by sa.location, a.animal_id");
        return driver.executeQuery(str.toString());
    }


    // return "Success" or "Not Valid"
    // updates an animal (base on animal_id)'s weight and height if the animal grows
    public String updateAnimal(int animal_id, int weight, int height) {
        StringBuilder str = new StringBuilder();
        str.append("update animal set weight = ");
        str.append(weight);
        str.append(", height = ");
        str.append(height);
        str.append(" where animal_id = ");
        str.append(animal_id); str.append(";");
        String result = driver.executeAlter(str.toString());
        if (result == "1")
            return  "Success";
        else
            return  "Not Valid";
    }

    public ResultSet getKeeperAnimal(int id) {
        StringBuilder strb = new StringBuilder();
        strb.append("select * from caresfor where employee_id = ");
        strb.append(id);
        String query = strb.toString();
        return driver.executeQuery(query);

    }

}
