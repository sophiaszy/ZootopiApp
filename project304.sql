create table zoo(
    address varchar(40),
    name char(20) not null,
    phone int,
    city char(20),
    country char(20),
    primary key (address));

create table animal(
    animal_id int,
    name char(20),
    ago int,
    height int,
    weight int,
    species char(20),
    sex char(20),
    employee_id int,
    zoo_address char(50),
    primary key (animal_id),
    foreign key (employee_id) references employee ON UPDATE CASCADE,
    foregin key (zoo_address) references zoo ON UPDATE CASCADE,
    foregin key (height, weight, species, sex) references animalfood ON UPDATE CASCADE);

create table animalfood(
    height int,
    weight int,
    species char(20),
    sex char(20),
    eat_freq_week int,
    eat_amount int,
    primary key (height, weight, species, sex));

create table employee(
    f_name char(20),
    l_name char(20),
    employee_id int,
    pay int,
    zoo_address char(50),
    primary key (employee_id),
    foreign key (zoo_address) references zoo ON DELETE CASCADE,
    foreign key (f_name, l_name) references employeecommunication ON UPDATE CASCADE);

create table employeecommunication(
    f_name char(20),
    l_name char(20),
    walkeetalkeeno int,
    primary key (f_name, l_name));

create table keeper(
    duty char(20),
    employee_id int,
    primary key (employee_id),
    foregin key (employee_id) references employee ON DELETE CASCADE);

create table trainer(
    start_time int,
    name nt,
    speciality char(20),
    employee_id int,
    primary key (employee_id),
    foreign key (employee_id) references employee ON DELETE CASCADE,
    foreign key (start_time, name) referecnes show ON UPDATE CASCADE);

create table building(
    building_id int,
    location char(20),
    used_for char(20),
    primary key (building_id));

create table food(
    food_id int,
    stock_serving int,
    date_purchased int,
    date_expired int,
    primary key (food_id));

create table supplement (
    food_id int,
    type char(20),
    primary key (food_id),
    foreign key (food_id) references food ON DELETE CASCADE);

create table habitat(
    enclosure_id int,
    biome char(20),
    location char(50),
    primary key (enclosure_id),
    foreign key (biome) references habitatbiome ON UPDATE CASCADE,
    foreign key (location) references habitatsize on UPDATE CASCADE);

create table habitatbiome(
    biome char(20),
    temp int,
    humidity int,
    primary key (biome));

create table habitatsize(
    location char(50),
    sq_ft int,
    depth int,
    primary key (location));

create table show(
    start_time int,
    duration int,
    name char(20),
    location char(20),
    primary key (stat_time, name),
    foreign key (location, start_time) references showtype on UPDATE CASCADE);

create table showtype(
    location char(20),
    start_time int,
    type char(20),
    primary key (location, start_time));
