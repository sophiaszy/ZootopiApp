import java.sql.ResultSet;

public class Trainer {

    private Driver jdbc;
    private int employee_id;

    public Trainer(int employee_id) {
        jdbc = Driver.getInstance();
        this.employee_id = employee_id;
    }

    // get the Trainer's view (animals + shows)
    // ordered by the shows' start time
    // should not ever throw an error
    // @ returns:
    //      Trainer: skill
    //      Animal: ID, name, species
    //      Show: start time, duration, name, trainer's role, location
    public ResultSet getTrainerView() {
        StringBuilder str = new StringBuilder();
        str.append("select t.skills, a.animal_id, a.name, a.species, p.role, s.start_time, s.duration, s.name, si.location " +
                        "from trainer tr, trains t, animal a, performs p, show s, site si " +
                        "where tr.employee_id = t.employee_id and t.animal_id = a.animal_id and a.animal_id = p.animal_id " +
                        "and p.start_time = s.start_time and p.show_name = s.name " +
                        "and s.site_id = si.site_id and tr.employee_id = ");
        str.append(employee_id);
        str.append(" order by s.start_time;");
        return jdbc.executeQuery(str.toString());
    }


}
