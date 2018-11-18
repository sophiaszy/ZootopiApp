import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by OwenTsai on 2018-11-09.
 */
public class Driver {
    private static Driver driver;
    private Connection con;
    private Statement stmt;


    /*
     * Constructor
     */
    private Driver() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
        }
        // connect to Oracle
        connect();
        dropTables();
        addTables();
        insertData();
    }

    public static Driver getInstance() {
        if (driver == null)
            driver = new Driver();
        return driver;
    }

    /*
     * connects to Oracle database named using username and password
     */
    private void connect() {
        String username = "ora_q8s0b";
        String password = "a14747159";
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug", username, password);
            System.out.println("\nConnected to Oracle");
            stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage() + "\nFailed to connect to Oracle");
        }
    }

    /*
     * execute any SQL statements alter the database (update, delete, insert)
     */
    public String executeAlter(String sqlstmt) {
        try {
            stmt.executeUpdate(sqlstmt);
            con.commit();
            return "1";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }


    /*
     * execute query statements
     */
    public ResultSet executeQuery(String sqlstmt) {
        try {
            return stmt.executeQuery(sqlstmt);
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage() + "\nUnable to execute: " + sqlstmt);
            return null;
        }
    }

    /*
     * disconnect from Oracle database
     */
    public void disconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("\nFailed to disconnect from Oracle");
        }
    }

    public void dropTables() {
        List<String> dropStatements = new ArrayList<String>();
        dropStatements.add("drop table performs");
        dropStatements.add("drop table caresfor");
        dropStatements.add("drop table trains");
        dropStatements.add("drop table trades");
        dropStatements.add("drop table eats");
        dropStatements.add("drop table show");
        dropStatements.add("drop table food");
        dropStatements.add("drop table keeper");
        dropStatements.add("drop table trainer");
        dropStatements.add("drop table employee");
        dropStatements.add("drop table employeecommunication");
        dropStatements.add("drop table animal");
        dropStatements.add("drop table habitat");
        dropStatements.add("drop table habitatbiome");
        dropStatements.add("drop table site");
        dropStatements.add("drop table zoo");
        int i;
        for (i = 0; i < dropStatements.size(); i++){
            executeAlter(dropStatements.get(i));

        }
    }

    private void addTables(){
        List<String> addTable = new ArrayList<String>();
        addTable.add("create table zoo( address varchar(40), name char(40) not null, phone int, city char(20), country char(20), primary key (address))");
        addTable.add("create table site( site_id int, location char(20), used_for char(20), zoo_address varchar(40), primary key (site_id), foreign key (zoo_address) references zoo ON DELETE CASCADE)");
        addTable.add("create table habitatbiome(biome char(20), temp int, humidity int,primary key (biome))");
        addTable.add("create table habitat( enclosure_id int, biome char(20), sq_ft int, depth int, site_id int not null, primary key (enclosure_id), foreign key (biome) references habitatbiome, foreign key (site_id) references site ON DELETE CASCADE)");
        addTable.add("create table animal(animal_id int, name char(20), age int, sex char(20), height int, weight int, species char(20), eat_freq_week int, eat_amount int, enclosure_id int, primary key (animal_id), foreign key (enclosure_id) references habitat ON DELETE SET NULL)");
        addTable.add("create table employeecommunication(f_name char(20), l_name char(20), walkeetalkeeno int, primary key (f_name, l_name))");
        addTable.add("create table employee(f_name char(20), l_name char(20), employee_id int, pay int, zoo_address varchar(40) not null, primary key (employee_id), foreign key (zoo_address) references zoo ON DELETE SET NULL, foreign key (f_name, l_name) references employeecommunication)");
        addTable.add("create table keeper(duty char(20), employee_id int, primary key (employee_id), foreign key (employee_id) references employee ON DELETE CASCADE)");
        addTable.add("create table trainer(speciality char(20), employee_id int, primary key (employee_id), foreign key (employee_id) references employee ON DELETE CASCADE)");
        addTable.add("create table food(food_id int, name char(20), stock_serving int, date_purchased date, date_expired date, site_id int not null, primary key (food_id), foreign key (site_id) references site ON DELETE CASCADE)");
        addTable.add("create table show(start_time char(8), duration int, name char(20), type char(20), site_id int not null, primary key (start_time, name), foreign key (site_id) references site ON DELETE CASCADE)");
        addTable.add("create table performs(start_time char(8), show_name char(20), employee_id int, animal_id int, role char(50), primary key (start_time, employee_id, animal_id), foreign key (start_time, show_name) references show, foreign key (employee_id) references employee, foreign key (animal_id) references animal)");
        addTable.add("create table caresfor(employee_id int, animal_id int, primary key (employee_id, animal_id), foreign key (employee_id) references employee, foreign key (animal_id) references animal)");
        addTable.add("create table trains(employee_id int, animal_id int, skills char(50), primary key (employee_id, animal_id), foreign key (employee_id) references employee, foreign key (animal_id) references animal)");
        addTable.add("create table trades(zoo_from_address varchar(40), zoo_to_address varchar(40), animal_id int, trade_date date, primary key (zoo_from_address, zoo_to_address, animal_id), foreign key (zoo_from_address) references zoo, foreign key (zoo_to_address) references zoo, foreign key (animal_id) references animal)");
        addTable.add("create table eats(animal_id int, food_id int, primary key (animal_id, food_id), foreign key (animal_id) references animal ON DELETE CASCADE, foreign key (food_id) references food)");
        int i;
        for (i = 0; i < addTable.size(); i++){
            executeAlter(addTable.get(i));
        }
    }

    private void insertData()  {
        List<String> populateTable = new ArrayList<String>();
        populateTable.add("insert into zoo values('15500 San Pasqual Valley Rd', 'San Diego Zoo Safari Park', 12345, 'Escondido', 'USA')");
        populateTable.add("insert into zoo values('2000 Meadowvale Rd', 'Toronto Zoo', 23456, 'Toronto', 'Canada')");
        populateTable.add("insert into zoo values('845 Avison Way', 'Vancouver Zoo', 523432, 'Vancouver', 'Canada')");
        populateTable.add("insert into zoo values('closet', 'Narnia Zoo', 34567, 'Narnia', 'Atlantis')");
        populateTable.add("insert into zoo values('80 Mandai Lake Rd', 'Singapore Zoo', 45678, 'Singapore', 'Singapore')");
        populateTable.add("insert into zoo values('London NW1 4RY', 'London Zoo', 56789, 'London', 'United Kingdom')");
        populateTable.add("insert into zoo values('137 Xizhimen Outer St', 'Beijing Zoo', 67890, 'Beijing', 'China')");
        populateTable.add("insert into zoo values('Hardenbergplatz 8', 'Berlin Zoological Garden', 78901, 'Berlin', 'Germany')");
        populateTable.add("insert into zoo values('Elliott Ave', 'Melbourne Zoo', 90123, 'Melbourne', 'Australia')");
        populateTable.add("insert into zoo values('U Trojského zámku 3/120', 'Prague Zoo', 1242, 'Prague', 'Czech Republic')");
        populateTable.add("insert into site values(101, 'Area 1', 'food', '2000 Meadowvale Rd')");
        populateTable.add("insert into site values(102, 'Area 2 North', 'habitat', '2000 Meadowvale Rd')");
        populateTable.add("insert into site values(103, 'Area 2 South', 'habitat', '2000 Meadowvale Rd')");
        populateTable.add("insert into site values(104, 'Area 4', 'show', '2000 Meadowvale Rd')");
        populateTable.add("insert into site values(105, 'Area 5', null, '2000 Meadowvale Rd')");
        populateTable.add("insert into site values(106, 'Area 6', null, '2000 Meadowvale Rd')");
        populateTable.add("insert into site values(201, 'Area 11 West', 'food', '80 Mandai Lake Rd')");
        populateTable.add("insert into site values(202, 'Area 11 East', 'habitat', '80 Mandai Lake Rd')");
        populateTable.add("insert into site values(203, 'Area 13', 'habitat', '80 Mandai Lake Rd')");
        populateTable.add("insert into site values(204, 'Area 14', 'show', '80 Mandai Lake Rd')");
        populateTable.add("insert into site values(205, 'Area 15', null, '80 Mandai Lake Rd')");
        populateTable.add("insert into site values(206, 'Area 16', null, '80 Mandai Lake Rd')");
        populateTable.add("insert into habitatbiome values('tropical rainforest', 25, 9)");
        populateTable.add("insert into habitatbiome values('grassland', 15, 4)");
        populateTable.add("insert into habitatbiome values('tundra', 5, 1)");
        populateTable.add("insert into habitatbiome values('dessert', 30, 0)");
        populateTable.add("insert into habitatbiome values('ocean', 10, 10)");
        populateTable.add("insert into habitat values(1001, 'tropical rainforest', 50, 10, 102)");
        populateTable.add("insert into habitat values(1002, 'grassland', 50, 10, 102)");
        populateTable.add("insert into habitat values(1003, 'tropical rainforest', 30, 10, 102)");
        populateTable.add("insert into habitat values(1004, 'grassland', 100, 10, 103)");
        populateTable.add("insert into habitat values(1005, 'grassland', 40, 10, 103)");
        populateTable.add("insert into habitat values(1006, 'grassland', 20, 20, 103)");
        populateTable.add("insert into habitat values(2001, 'ocean', 100, 20, 202)");
        populateTable.add("insert into habitat values(2002, 'ocean', 100, 20, 202)");
        populateTable.add("insert into habitat values(2003, 'dessert', 20, 40, 202)");
        populateTable.add("insert into habitat values(2004, 'dessert', 20, 20, 203)");
        populateTable.add("insert into habitat values(2005, 'grassland', 10, 20, 203)");
        populateTable.add("insert into habitat values(2006, 'tropical rainforest', 50, 10, 203)");
        populateTable.add("insert into animal values(101, 'Johnny', 5, 'M', 50, 10, 'duck',  20, 2, 1001)");
        populateTable.add("insert into animal values(201, 'Ruby', 4, 'F', 40, 8, 'duck', 20, 1, 2001)");
        populateTable.add("insert into animal values(102, 'Chandler', 8, 'M', 400, 300, 'giraffe', 10, 3, 1002)");
        populateTable.add("insert into animal values(202, 'Monica', 8, 'F', 300, 250, 'giraffe', 10, 4, 2002)");
        populateTable.add("insert into animal values(103, 'Jeremy', 7, 'M', 120, 300, 'tiger', 15, 5, 1003)");
        populateTable.add("insert into animal values(203, 'Gina', 6, 'F', 100, 300, 'tiger', 15, 8, 2003)");
        populateTable.add("insert into animal values(104, 'Kevin', 10, 'M', 150, 400, 'lion', 15, 6, 1004)");
        populateTable.add("insert into animal values(204, 'Clara', 12, 'F', 140, 350, 'lion', 15, 5, 2004)");
        populateTable.add("insert into animal values(105, 'Edward', 9, 'M', 80, 100, 'monkey', 20, 4, 1005)");
        populateTable.add("insert into animal values(205, 'Brittanie', 10, 'F', 60, 90, 'monkey', 20, 3, 2005)");
        populateTable.add("insert into animal values(106, 'Albert', 8, 'M', 200, 200, 'panda', 10, 5, 1006)");
        populateTable.add("insert into animal values(206, 'Jessica', 8, 'F', 180, 180, 'panda', 10, 4, 2006)");
        populateTable.add("insert into animal values(107, 'Mason', 3, 'M', 80, 30, 'fox', 14, 4, 1002)");
        populateTable.add("insert into animal values(207, 'Mary', 2, 'F', 70, 25, 'fox', 14, 4, 2002)");
        populateTable.add("insert into employeecommunication values ('newton','scamander',1)");
        populateTable.add("insert into employeecommunication values ('willy','wonka',2)");
        populateTable.add("insert into employeecommunication values ('jane','goodall',3)");
        populateTable.add("insert into employeecommunication values ('mary','poppins',4)");
        populateTable.add("insert into employeecommunication values ('Ivan','pavlov',5)");
        populateTable.add("insert into employeecommunication values ('cesar','milan',6)");
        populateTable.add("insert into employeecommunication values ('jane','kowalski',7)");
        populateTable.add("insert into employeecommunication values ('kermit','thefrog',8)");
        populateTable.add("insert into employeecommunication values ('tom','hanks',9)");
        populateTable.add("insert into employeecommunication values ('argus','filch',10)");
        populateTable.add("insert into employeecommunication values ('andrew','john',11)");
        populateTable.add("insert into employeecommunication values ('sweeper','bot',12)");
        populateTable.add("insert into employeecommunication values ('jake','suuli',13)");
        populateTable.add("insert into employee values ('newton', 'scamander', 1234567890, 0, '2000 Meadowvale Rd')");
        populateTable.add("insert into employee values ('willy', 'wonka', 1345678901, 100, '2000 Meadowvale Rd')");
        populateTable.add("insert into employee values ('jane','goodall', 1456789012, 0, '2000 Meadowvale Rd')");
        populateTable.add("insert into employee values ('mary','poppins', 1235823623, 100, '2000 Meadowvale Rd')");
        populateTable.add("insert into employee values ('Ivan','pavlov', 1376542234, 100, '2000 Meadowvale Rd')");
        populateTable.add("insert into employee values ('cesar','milan', 1234234236, 100, '2000 Meadowvale Rd')");
        populateTable.add("insert into employee values ('jane','kowalski', 1264245243, 75, '2000 Meadowvale Rd')");
        populateTable.add("insert into employee values ('kermit','thefrog', 1279765434, 75, '80 Mandai Lake Rd')");
        populateTable.add("insert into employee values ('tom','hanks', 1246545423, 75, '80 Mandai Lake Rd')");
        populateTable.add("insert into employee values ('argus','filch', 1367865421, 0, '80 Mandai Lake Rd')");
        populateTable.add("insert into employee values ('andrew','john', 1236789876, 50, '80 Mandai Lake Rd')");
        populateTable.add("insert into employee values ('sweeper','bot', 1341567688, 0, '80 Mandai Lake Rd')");
        populateTable.add("insert into employee values ('jake','suuli', 1345976543, 50, '80 Mandai Lake Rd')");
        populateTable.add("insert into keeper values ('clean', 1234567890)");
        populateTable.add("insert into keeper values ('clean and feed', 1345678901)");
        populateTable.add("insert into keeper values ('feed', 1456789012)");
        populateTable.add("insert into keeper values ('measure', 1235823623)");
        populateTable.add("insert into keeper values ('clean and feed', 1279765434)");
        populateTable.add("insert into keeper values ('feed/measure/clean', 1246545423)");
        populateTable.add("insert into keeper values ('feed', 1367865421)");
        populateTable.add("insert into keeper values ('feed and measure', 1236789876)");
        populateTable.add("insert into trainer values ('hoop jumping', 1376542234)");
        populateTable.add("insert into trainer values ('balancing', 1234234236)");
        populateTable.add("insert into trainer values ('general', 1264245243)");
        populateTable.add("insert into trainer values ('hoop jumping', 1341567688)");
        populateTable.add("insert into trainer values ('balancing', 1345976543);");
        populateTable.add("insert into food values (11, 'frozen chicken', 80, '2018-11-08', '2020-08-10', 101)");
        populateTable.add("insert into food values (12, 'bamboo', 69, '2018-10-21', '2018-12-10', 101)");
        populateTable.add("insert into food values (13, 'fish', 32, '2018-11-08', '2021-03-31', 101)");
        populateTable.add("insert into food values (14, 'eggs', 99, '2018-11-08', '2018-12-10', 101)");
        populateTable.add("insert into food values (15, 'frozen beef', 2, '2018-10-21', '2018-12-11', 101)");
        populateTable.add("insert into food values (16, 'banana', 30, '2018-11-08', '2018-12-10', 101)");
        populateTable.add("insert into food values (17, 'grain and seeds', 32, '2018-11-08', '2021-03-31', 101)");
        populateTable.add("insert into food values (21, 'frozen chicken', 90, '2018-11-08', '2018-12-21', 201)");
        populateTable.add("insert into food values (22, 'bamboo', 59, '2018-11-08', '2019-03-13', 201)");
        populateTable.add("insert into food values (23, 'fish', 60, '2018-06-03', '2020-05-03', 201)");
        populateTable.add("insert into food values (24, 'eggs', 234, '2018-10-21', '2018-11-21', 201)");
        populateTable.add("insert into food values (25, 'frozen beef', 11, '2018-11-08', '2020-07-21', 201)");
        populateTable.add("insert into food values (26, 'banana', 52, '2018-11-08', '2018-12-10', 201)");
        populateTable.add("insert into food values (27, 'grain and seeds', 5, '2018-11-08', '2021-03-31', 201)");
        populateTable.add("insert into show values ('18:30:00', 50, 'Play With Ducks', 'kids', 103)");
        populateTable.add("insert into show values ('17:30:00', 25, 'hoop-jumping tigers', 'entertainment', 103)");
        populateTable.add("insert into show values ('15:00:00', 10, 'monkey tricks', 'entertainment', 104)");
        populateTable.add("insert into show values ('12:00:00', 12, 'meet a panda', 'educational', 104)");
        populateTable.add("insert into show values ('9:30:00', 40, 'Play With Ducks', 'kids', 204)");
        populateTable.add("insert into show values ('10:15:00', 18, 'hoop-jumping tigers', 'entertainment', 204)");
        populateTable.add("insert into show values ('15:15:00', 10, 'monkey tricks', 'entertainment', 204)");
        populateTable.add("insert into show values ('12:15:00', 12, 'meet a panda', 'educational', 204)");
        populateTable.add("insert into performs values ('18:30:00', 'Play With Ducks', 1264245243, 101, 'watch over ducks')");
        populateTable.add("insert into performs values ('17:30:00', 'hoop-jumping tigers', 1376542234, 103, 'guide tigers')");
        populateTable.add("insert into performs values ('15:00:00', 'monkey tricks', 1376542234, 105, 'prompt monkeys')");
        populateTable.add("insert into performs values ('12:00:00', 'meet a panda', 1264245243, 106, 'watch over panda')");
        populateTable.add("insert into performs values ('9:30:00', 'Play With Ducks', 1345976543, 201, 'watch over ducks')");
        populateTable.add("insert into performs values ('10:15:00', 'hoop-jumping tigers', 1341567688, 203, 'guide tigers')");
        populateTable.add("insert into performs values ('15:15:00', 'monkey tricks', 1345976543, 205, 'prompt monkeys')");
        populateTable.add("insert into performs values ('12:15:00', 'meet a panda', 1341567688, 206, 'watch over panda')");
        populateTable.add("insert into caresfor values (1234567890, 101)");
        populateTable.add("insert into caresfor values (1367865421, 201)");
        populateTable.add("insert into caresfor values (1234567890, 102)");
        populateTable.add("insert into caresfor values (1236789876, 202)");
        populateTable.add("insert into caresfor values (1345678901, 103)");
        populateTable.add("insert into caresfor values (1367865421, 203)");
        populateTable.add("insert into caresfor values (1234567890, 104)");
        populateTable.add("insert into caresfor values (1246545423, 204)");
        populateTable.add("insert into caresfor values (1235823623, 105)");
        populateTable.add("insert into caresfor values (1236789876, 205)");
        populateTable.add("insert into caresfor values (1456789012, 106)");
        populateTable.add("insert into caresfor values (1246545423, 206)");
        populateTable.add("insert into caresfor values (1345678901, 107)");
        populateTable.add("insert into caresfor values (1279765434, 207)");
        populateTable.add("insert into trains values (1264245243,101,'understand trainer gestures')");
        populateTable.add("insert into trains values (1376542234,103,'jump through hoops when instructed')");
        populateTable.add("insert into trains values (1234234236,105,'juggle 3 balls')");
        populateTable.add("insert into trains values (1264245243,106,'wave at visitors')");
        populateTable.add("insert into trains values (1345976543,201,'understand trainer gestures')");
        populateTable.add("insert into trains values (1341567688,203,'jump through hoops when instructed')");
        populateTable.add("insert into trains values (1345976543,205,'juggle 3 balls')");
        populateTable.add("insert into trains values (1341567688,206,'wave at visitors')");
        populateTable.add("insert into trades values ('2000 Meadowvale Rd','80 Mandai Lake Rd',201, '2016-09-21')");
        populateTable.add("insert into trades values ('2000 Meadowvale Rd','80 Mandai Lake Rd',202, '2017-03-31')");
        populateTable.add("insert into trades values ('2000 Meadowvale Rd','80 Mandai Lake Rd',205, '2018-01-01')");
        populateTable.add("insert into trades values ('80 Mandai Lake Rd','2000 Meadowvale Rd',101, '2016-09-21')");
        populateTable.add("insert into trades values ('80 Mandai Lake Rd','2000 Meadowvale Rd',102, '2018-01-01')");
        populateTable.add("insert into trades values ('80 Mandai Lake Rd','2000 Meadowvale Rd',105, '2017-03-31')");
        populateTable.add("insert into eats values (101, 17)");
        populateTable.add("insert into eats values (102, 17)");
        populateTable.add("insert into eats values (103, 11)");
        populateTable.add("insert into eats values (103, 15)");
        populateTable.add("insert into eats values (104, 11)");
        populateTable.add("insert into eats values (104, 15)");
        populateTable.add("insert into eats values (105, 16)");
        populateTable.add("insert into eats values (106, 12)");
        populateTable.add("insert into eats values (107, 11)");
        populateTable.add("insert into eats values (201, 27)");
        populateTable.add("insert into eats values (202, 27)");
        populateTable.add("insert into eats values (203, 21)");
        populateTable.add("insert into eats values (203, 25)");
        populateTable.add("insert into eats values (204, 21)");
        populateTable.add("insert into eats values (204, 25)");
        populateTable.add("insert into eats values (205, 26)");
        populateTable.add("insert into eats values (206, 22)");
        populateTable.add("insert into eats values (207, 21)");
        int i;
        for (i = 0; i < populateTable.size(); i++){
            executeAlter(populateTable.get(i));
        }
    }

}
