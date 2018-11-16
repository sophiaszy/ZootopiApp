import java.sql.ResultSet;

public class Employee {
    // attributes

    public int id;
    public String firstName;
    public String lastName;
    public int pay;
    public String zooAddress;
    private Driver driver;

    private boolean created= false;



    public Employee(int ID) {
        // TO DO
        id = ID;
        driver = Driver.getInstance();
    }

    // search employee based on id
    // return all info regarding that employee: f_name, l_name, employee_id, pay and zoo_address
    public ResultSet searchEmployeeID(int id) {
        StringBuilder strb = new StringBuilder();
        strb.append("select * from employee where employee_id = ");
        strb.append(id);
        String query = strb.toString();
        return driver.executeQuery(query);
    }




}
