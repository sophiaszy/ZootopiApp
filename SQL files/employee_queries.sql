# TRAINER VIEW - MY SHOWS

select t.skills, a.animal_id, a.name, a.species, p.role, s.start_time, s.duration, s.name, si.location
from trainer tr, trains t, animal a, performs p, show s, site si
where tr.employee_id = t.employee_id and t.animal_id = a.animal_id and a.animal_id = p.animal_id 
and p.start_time = s.start_time and p.show_name = s.name 
and s.site_id = si.site_id and tr.employee_id = 1345976543
order by s.start_time;

# should return two animals -> did! yay!!!



# KEEPER VIEW
# 1. UPDATE ANIMAL 

update animal
set weight = 20, height = 50
where animal_id = 101;


# 2. MY ANIMALS (+ food)
select k.duty, a.animal_id, a.species, sa.location, a.eat_freq_week, a.eat_amount, f.food_id, f.name, f.date_expired, sf.location
from keeper k, caresfor cf, animal a, habitat h, eats e, food f, site sa, site sf
where k.employee_id = cf.employee_id and cf.animal_id = a.animal_id and a.enclosure_id = h.enclosure_id and 
h.site_id = sa.site_id and a.animal_id = e.animal_id and e.food_id = f.food_id 
and f.site_id = sf.site_id and k.employee_id = 1234567890
order by sa.location;






