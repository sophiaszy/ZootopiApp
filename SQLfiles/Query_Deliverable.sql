-- 1. addEmployee (Deliverable 2)

insert into employeecommunication values ('john', 'smith', null);
insert into employee values ('john', 'smith', 3967496720, 10, '80 Mandai Lake Rd')

-- 2. removeEmployee (Deliverable 3)

delete from employee where employee_id = 3967496720;
delete from employeecommunication where f_name = 'john' AND l_name = 'smith';

-- 3. updateEmployee (Deliverable 1 and 4)

update employee set pay = 100 where pay = 75;

-- 4. searchEmployee (Deliverable 8 - 10)

select * from employee where f_name = 'andrew' AND l_name = 'john';

-- 5. getVolunteer (Deliverable 8 - 10)

select * from employee where pay = 0;

-- 6. animalInHabitat (Deliverable 6)

select animal_id 
from animal
where enclosure_id = 1002;

-- 7. findHabitat (Deliverable 8 - 10)

select *
from habitat
where biome = 'tropical rainforest' AND sq_ft = 50 AND depth = 10;

-- 8. searchByTemperature (Deliverable 8 - 10)

select * 
from habitat h, site s, habitatbiome hb 
where h.site_id = s.site_id and h.biome = hb.biome and temp = 25;

-- 9. siteNotUsed (Deliverable 8 - 10)

select site_id, location, zoo_address from site where used_for is null

-- 10. showAt (Deliverable 11)

create view showinfo as select sh.start_time, sh.duration, sh.name, sh.type, st.location
from show sh, site st where sh.site_id = st.site_id

-- 11. addAnimal (Deliverable 2)

insert into animal values (208, 'Kermit', 60, 'M', 50, 30, 'frog', 10, 11, 2001);

-- 12. deleteAnimal (Deliverable 3)

delete from animal where animal_id = 208;

-- 13. updateAnimal (Deliverable 1 and 4)

update animal
set age = 6
where animal_id = 101;

-- 14. groupAnimalBySpecies (Deliverable 7)

select animal_id, name, age, sex, species
from animal 
order by species;


-- 15. getSpeciesDetails (Deliverable 8 - 10)

select animal_id, name, weight, height
from animal 
where species = 'lion';

-- 16. getFoodDetails (Deliverable 8 - 10)

select s.site_id, s.location, f.food_id, f.name, f.stock_serving, f.date_purchased, f.date_expired
from site s, food f
where s.site_id = f.site_id 

-- 17. getFoodSoonExpires (Deliverable 8 - 10)

select food_id, name, date_expired 
from food 
where date_expired < '2018-12-31' order by date_expired

-- 18. filterZooByCountry (Deliverable 8 - 10)

select *
from zoo
where country = 'Canada';

-- 19. getKeeperView (Deliverable 5)

select k.duty, a.animal_id, a.species, sa.location, a.eat_freq_week, a.eat_amount, f.food_id, f.name, f.date_expired, sf.location
from keeper k, caresfor cf, animal a, habitat h, eats e, food f, site sa, site sf
where k.employee_id = cf.employee_id and cf.animal_id = a.animal_id and a.enclosure_id = h.enclosure_id and 
h.site_id = sa.site_id and a.animal_id = e.animal_id and e.food_id = f.food_id 
and f.site_id = sf.site_id and k.employee_id = 1234567890
order by sa.location;

-- 20. updateAnimal (Deliverable 1 and 4)

update animal
set weight = 20, height = 50
where animal_id = 101;

-- 21. getTrainerView (Deliverable 5)

select t.skills, a.animal_id, a.name, a.species, p.role, s.start_time, s.duration, s.name, si.location
from trainer tr, trains t, animal a, performs p, show s, site si
where tr.employee_id = t.employee_id and t.animal_id = a.animal_id and a.animal_id = p.animal_id 
and p.start_time = s.start_time and p.show_name = s.name 
and s.site_id = si.site_id and tr.employee_id = 1345976543
order by s.start_time;






