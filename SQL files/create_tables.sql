create table zoo(
    address varchar(40),
    name char(40) not null,
    phone int,
    city char(20),
    country char(20),
    primary key (address)
    );

create table site(
    site_id int,
    location char(20),
    used_for char(20),
    zoo_address varchar(40),
    primary key (site_id),
    foreign key (zoo_address) references zoo ON DELETE CASCADE
    );

create table habitatbiome(
    biome char(20),
    temp int,
    humidity int,
    primary key (biome)
    );

create table habitat(
    enclosure_id int,
    biome char(20),
    sq_ft int,
    depth int,
    site_id int not null,
    primary key (enclosure_id),
    foreign key (biome) references habitatbiome,
    foreign key (site_id) references site ON DELETE CASCADE
    );

create table animalfood(
    height int,
    weight int,
    species char(20),
    sex char(20),
    eat_freq_week int,
    eat_amount int,
    primary key (height, weight, species, sex)
    );

create table animal(
    animal_id int,
    name char(20),
    age int,
    sex char(20),
    height int,
    weight int,
    species char(20),
    enclosure_id int,
    primary key (animal_id),
    foreign key (enclosure_id) references habitat ON DELETE SET NULL,
    foreign key (height, weight, species, sex) references animalfood
    );

create table employeecommunication(
    f_name char(20),
    l_name char(20),
    walkeetalkeeno int,
    primary key (f_name, l_name)
    );

create table employee(
    f_name char(20),
    l_name char(20),
    employee_id int,
    pay int,
    zoo_address varchar(40) not null,
    primary key (employee_id),
    foreign key (zoo_address) references zoo ON DELETE SET NULL,
    foreign key (f_name, l_name) references employeecommunication
    );

create table keeper(
    duty char(20),
    employee_id int,
    primary key (employee_id),
    foreign key (employee_id) references employee ON DELETE CASCADE
    );

create table trainer(
    speciality char(20),
    employee_id int,
    primary key (employee_id),
    foreign key (employee_id) references employee ON DELETE CASCADE
    );


create table food(
    food_id int,
    name char(20),
    stock_serving int,
    date_purchased date,
    date_expired date,
    site_id int not null,
    primary key (food_id),
    foreign key (site_id) references site ON DELETE CASCADE
    );


create table show(
    start_time char(8),
    duration int,
    name char(20),
    type char(20),
    site_id int not null,
    primary key (start_time, name),
    foreign key (site_id) references site ON DELETE CASCADE
    );

create table performs(
    start_time char(8),
    show_name char(20),
    employee_id int,
    animal_id int,
    role char(50),
    primary key (start_time, employee_id, animal_id),
    foreign key (start_time, show_name) references show,
    foreign key (employee_id) references employee,
    foreign key (animal_id) references animal
    );

create table caresfor(
    employee_id int,
    animal_id int,
    primary key (employee_id, animal_id),
    foreign key (employee_id) references employee,
    foreign key (animal_id) references animal
    );

create table trains(
    employee_id int,
    animal_id int,
    skills char(50),
    primary key (employee_id, animal_id),
    foreign key (employee_id) references employee,
    foreign key (animal_id) references animal
    );

create table trades(
    zoo_from_address varchar(40),
    zoo_to_address varchar(40),
    animal_id int,
    trade_date date,
    primary key (zoo_from_address, zoo_to_address, animal_id),
    foreign key (zoo_from_address) references zoo,
    foreign key (zoo_to_address) references zoo,
    foreign key (animal_id) references animal
    );

create table eats(
    animal_id int,
    food_id int,
    primary key (animal_id, food_id),
    foreign key (animal_id) references animal ON DELETE CASCADE,
    foreign key (food_id) references food
    );