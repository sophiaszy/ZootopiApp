
insert into zoo
values('15500 San Pasqual Valley Rd', 'San Diego Zoo Safari Park', 12345, 'Escondido', 'USA');
insert into zoo
values('2000 Meadowvale Rd', 'Toronto Zoo', 23456, 'Toronto', 'Canada');
insert into zoo
values('closet', 'Narnia Zoo', 34567, 'Narnia', 'Atlantis');
insert into zoo
values('80 Mandai Lake Rd', 'Singapore Zoo', 45678, 'Singapore', 'Singapore');
insert into zoo
values('London NW1 4RY', 'London Zoo', 56789, 'London', 'United Kingdom');
insert into zoo
values('137 Xizhimen Outer St', 'Beijing Zoo', 67890, 'Beijing', 'China');
insert into zoo
values('Hardenbergplatz 8', 'Berlin Zoological Garden', 78901, 'Berlin', 'Germany');
insert into zoo
values('Elliott Ave', 'Melbourne Zoo', 90123, 'Melbourne', 'Australia');
insert into zoo
values('U Trojského zámku 3/120', 'Prague Zoo', 1242, 'Prague', 'Czech Republic');


insert into site
values(101, 'Area 1', 'food', '2000 Meadowvale Rd');
insert into site
values(102, 'Area 2 North', 'habitat', '2000 Meadowvale Rd');
insert into site
values(103, 'Area 2 South', 'habitat', '2000 Meadowvale Rd');
insert into site
values(104, 'Area 4', 'show', '2000 Meadowvale Rd');
insert into site
values(201, 'Area 1 West', 'food', '80 Mandai Lake Rd');
insert into site
values(202, 'Area 1 East', 'habitat', '80 Mandai Lake Rd');
insert into site
values(203, 'Area 3', 'habitat', '80 Mandai Lake Rd');
insert into site
values(204, 'Area 4', 'show', '80 Mandai Lake Rd');


insert into habitatbiome
values('tropical rainforest', 25, 9);
insert into habitatbiome
values('grassland', 15, 4);
insert into habitatbiome
values('tundra', 5, 1);
insert into habitatbiome
values('dessert', 30, 0);
insert into habitatbiome
values('ocean', 10, 10);

insert into habitat
values(1001, 'tropical rainforest', 50, 10, 102);
insert into habitat
values(1002, 'grassland', 50, 10, 102);
insert into habitat
values(1003, 'tropical rainforest', 30, 10, 102);
insert into habitat
values(1004, 'grassland', 100, 10, 103);
insert into habitat
values(1005, 'grassland', 40, 10, 103);
insert into habitat
values(1006, 'grassland', 20, 20, 103);
insert into habitat
values(2001, 'ocean', 100, 20, 202);
insert into habitat
values(2002, 'ocean', 100, 20, 202);
insert into habitat
values(2003, 'dessert', 20, 40, 202);
insert into habitat
values(2004, 'dessert', 20, 20, 203);
insert into habitat
values(2005, 'grassland', 10, 20, 203);
insert into habitat
values(2006, 'tropical rainforest', 100, 10, 203);


insert into animalfood
values(50,10, 'duck', 'M', 20, 2);
insert into animalfood
values(40,8, 'duck', 'F', 20, 1);
insert into animalfood
values(400,300, 'giraffe', 'M', 10, 3);
insert into animalfood
values(300,250, 'giraffe', 'F', 10, 4);
insert into animalfood
values(120,300, 'tiger', 'M', 15, 5);
insert into animalfood
values(100,300, 'tiger', 'F', 15, 8);
insert into animalfood
values(150,400, 'lion', 'M', 15, 6);
insert into animalfood
values(140,350, 'lion', 'F', 15, 5);
insert into animalfood
values(80,100, 'monkey', 'M', 20, 4);
insert into animalfood
values(60,90, 'monkey', 'F', 20, 3);
insert into animalfood
values(200,200, 'panda', 'M', 10, 5);
insert into animalfood
values(180,180, 'panda', 'F', 10, 4);
insert into animalfood
values(80,30, 'fox', 'M', 14, 4);
insert into animalfood
values(70,25, 'fox', 'F', 14, 4);


insert into animal
values(100, 'Johnny', 5, 'M', 50, 10, 'duck', 1001);
insert into animal
values(201, 'Ruby', 4, 'F', 40, 8, 'duck', 2001);
insert into animal
values(102, 'Chandler', 8, 'M', 400, 300, 'giraffe', 1002);
insert into animal
values(202, 'Monica', 8, 'F', 300, 250, 'giraffe', 2002);
insert into animal
values(103, 'Jeremy', 7, 'M', 120, 300, 'tiger', 1003);
insert into animal
values(203, 'Gina', 6, 'F', 100, 300, 'tiger', 2003);
insert into animal
values(104, 'Kevin', 10, 'M', 150, 400, 'lion', 1004);
insert into animal
values(204, 'Clara', 12, 'F', 140, 350, 'lion', 2004);
insert into animal
values(105, 'Edward', 9, 'M', 80, 100, 'monkey', 1005);
insert into animal
values(205, 'Brittanie', 10, 'F', 60, 90, 'monkey', 2005);
insert into animal
values(106, 'Albert', 8, 'M', 200, 200, 'panda', 1006);
insert into animal
values(206, 'Jessica', 8, 'F', 180, 180, 'panda', 2006);
insert into animal
values(107, 'Mason', 3, 'M', 80, 30, 'fox', 1002);
insert into animal
values(207, 'Mary', 2, 'F', 70, 25, 'fox', 2002);

insert into employeecommunication
values ('newton','scamander',1);
insert into employeecommunication
values ('willy','wonka',2);
insert into employeecommunication
values ('jane','goodall',3);
insert into employeecommunication
values ('mary','poppins',4);
insert into employeecommunication
values ('Ivan','pavlov',5);
insert into employeecommunication
values ('cesar','milan',6);
insert into employeecommunication
values ('jacob','kowalski',7);
insert into employeecommunication
values ('kermit','thefrog',8);
insert into employeecommunication
values ('tom','hanks',9);
insert into employeecommunication
values ('argus','filch',10);
insert into employeecommunication
values ('andrew','john',11);
insert into employeecommunication
values ('sweeper','bot',12);
insert into employeecommunication
values ('jake','suuli',13);

insert into employee
values ('newton', 'scamander', 1234567890, 100, '2000 Meadowvale Rd');
insert into employee
values ('willy', 'wonka', 2345678901, 100, '2000 Meadowvale Rd');
insert into employee
values ('jane','goodall', 3456789012, 100, '2000 Meadowvale Rd');
insert into employee
values ('mary','poppins', 2235823623, 100, '2000 Meadowvale Rd');
insert into employee
values ('Ivan','pavlov', 2376542234, 100, '2000 Meadowvale Rd');
insert into employee
values ('cesar','milan', 7234234236, 100, '2000 Meadowvale Rd');
insert into employee
values ('jacob','kowalski', 1264245243, 75, '2000 Meadowvale Rd');
insert into employee
values ('kermit','thefrog', 1279765434, 75, '80 Mandai Lake Rd');
insert into employee
values ('tom','hanks', 1246545423, 75, '80 Mandai Lake Rd');
insert into employee
values ('argus','filch', 1367865421, 50, '80 Mandai Lake Rd');
insert into employee
values ('andrew','john', 1236789876, 50, '80 Mandai Lake Rd');
insert into employee
values ('sweeper','bot', 1341567688, 50, '80 Mandai Lake Rd');
insert into employee
values ('jake','suuli', 1345976543, 50, '80 Mandai Lake Rd');


insert into keeper 
values ('clean', 1234567890);
insert into keeper 
values ('clean and feed', 2345678901);
insert into keeper 
values ('feed', 3456789012);
insert into keeper 
values ('measure', 2235823623);
insert into keeper 
values ('clean and feed', 1279765434);
insert into keeper 
values ('clean', 1246545423);
insert into keeper 
values ('feed', 1367865421);
insert into keeper 
values ('feed and measure', 1236789876);

insert into trainer
values ('hoop jumping', 2376542234);
insert into trainer
values ('balancing', 7234234236);
insert into trainer
values ('climbing', 1264245243);
insert into trainer
values ('hoop jumping', 1341567688);
insert into trainer
values ('balancing', 1345976543);

# food can only be stored in 101 or 201

create table food(
    food_id int,
    stock_serving int,
    date_purchased date,
    date_expired date,
    site_id int not null,
    primary key (food_id),
    foreign key (site_id) references site ON DELETE CASCADE
    );




