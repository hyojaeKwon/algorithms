select distinct d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from developers as d
         join skillcodes as s
              on d.skill_code & s.code != 0
where s.category = 'Front End'
order by 1